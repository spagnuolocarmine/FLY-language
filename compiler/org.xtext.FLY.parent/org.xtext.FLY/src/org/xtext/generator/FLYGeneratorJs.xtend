package org.xtext.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.fLY.FunctionDefinition
import org.xtext.fLY.BlockExpression
import org.xtext.fLY.Expression
import java.util.List
import java.util.HashMap
import org.xtext.fLY.VariableDeclaration
import org.xtext.fLY.ChannelSend
import org.xtext.fLY.NameObjectDef
import org.xtext.fLY.ArithmeticExpression
import org.xtext.fLY.DeclarationObject
import org.xtext.fLY.IfExpression
import org.xtext.fLY.ForExpression
import org.xtext.fLY.WhileExpression
import org.xtext.fLY.Assignment
import org.xtext.fLY.PrintExpression
import org.xtext.fLY.CastExpression
import org.xtext.fLY.ChannelReceive
import org.xtext.fLY.NameObject
import org.xtext.fLY.IndexObject
import org.xtext.fLY.VariableLiteral
import org.xtext.fLY.RangeLiteral
import org.xtext.fLY.BinaryOperation
import org.xtext.fLY.UnaryOperation
import org.xtext.fLY.PostfixOperation
import org.xtext.fLY.ParenthesizedExpression
import org.xtext.fLY.NumberLiteral
import org.xtext.fLY.BooleanLiteral
import org.xtext.fLY.FloatLiteral
import org.xtext.fLY.StringLiteral
import org.xtext.fLY.VariableFunction
import org.xtext.fLY.TimeFunction
import org.xtext.fLY.MathFunction
import org.xtext.fLY.DatTableObject
import org.xtext.fLY.RequireExpression
import org.xtext.fLY.NativeExpression
import org.xtext.fLY.FlyFunctionCall
import org.xtext.fLY.ArrayDefinition
import org.xtext.fLY.ConstantDeclaration
import org.xtext.fLY.LocalFunctionCall
import org.xtext.fLY.ArrayInit
import org.xtext.fLY.ArrayValue
import org.eclipse.emf.common.util.EList
import org.eclipse.xtend.lib.macro.declaration.Declaration

class FLYGeneratorJs extends AbstractGenerator {
	
	String name= ""
	String env = ""
	String language = ""
	int memory = 0
	int nthread = 0
	int time = 0
	FunctionDefinition root = null
	var id_execution = null
	var user = ""
	HashMap<String, HashMap<String, String>> typeSystem = null
	boolean isLocal;
	boolean isAsync;
	
	def generateJS(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context,String name_file, FunctionDefinition func, 
		VariableDeclaration environment, HashMap<String, HashMap<String, String>> scoping, long id,boolean local,boolean async){
		this.name=name_file
		this.root = func
		this.typeSystem=scoping
		this.id_execution = id
		if(!local){
			this.env = (environment.right as DeclarationObject).features.get(0).value_s
			this.user = (environment.right as DeclarationObject).features.get(1).value_s
			this.language = (environment.right as DeclarationObject).features.get(5).value_s
			this.nthread = (environment.right as DeclarationObject).features.get(6).value_t
			this.memory = (environment.right as DeclarationObject).features.get(7).value_t
			this.time = (environment.right as DeclarationObject).features.get(8).value_t
		}else{
			this.env="smp"
			this.nthread = (environment.right as DeclarationObject).features.get(1).value_t
			this.language = (environment.right as DeclarationObject).features.get(2).value_s
		}
		this.isAsync = async
		this.isLocal = local 
		doGenerate(input,fsa,context) 
	}
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		//fsa.generateFile(name + ".js", input.compileJS(root, env));
		fsa.generateFile(root.name+"_deploy.sh",input.compileDeploy(root.name));
		fsa.generateFile(root.name+"_undeploy.sh",input.compileUndeploy(root.name));
		if (this.isLocal) {
			fsa.generateFile(root.name + ".js", input.compileJavaScript(root.name, true))	
		} 
	}
	
	def CharSequence compileJavaScript(Resource resource, String string, boolean local)
	'''
		«generateLocalBodyJs(root.body,root.parameters,name,env, local)»
	'''
	
	def generateLocalBodyJs(BlockExpression expression, EList<Expression> list, String string, String string2, boolean b) {
		'''
			var __dataframe = require("dataframe-js").DataFrame;
			export.main = async => {
				
			}
		'''
	}
	
	def CharSequence compileJS(Resource resource, FunctionDefinition func, String env) '''
		«generateBodyJs(resource,func.body,func.parameters,func.name,env)»
	'''

	def generateBodyJs(Resource resource,BlockExpression exps,List<Expression> parameters, String name, String env) {
		'''
			«IF env == "aws"»
				var AWS = require("aws-sdk");
				var sqs = new AWS.SQS();
			«ENDIF»
			var __dataframe = require("dataframe-js").DataFrame;
			«FOR req: exps.expressions.filter(RequireExpression)»
			
			«ENDFOR»
			let __params;
			let __data;
			
			«FOR exp : resource.allContents.toIterable.filter(ConstantDeclaration)»
				«generateConstantDefinition(exp,name)»
			«ENDFOR»
			
			exports.handler = async (event,context) => {
				
				«FOR exp : parameters»
				«IF typeSystem.get(name).get((exp as VariableDeclaration).name).equals("Table")»
						var __«(exp as VariableDeclaration).name» = await new __dataframe(JSON.parse(event));
						var «(exp as VariableDeclaration).name» = __«(exp as VariableDeclaration).name».toArray()
					«ELSE»
						var «(exp as VariableDeclaration).name» = event;
					«ENDIF»
				«ENDFOR»
				«FOR exp : exps.expressions»
					«generateJsExpression(exp,name)»
				«ENDFOR»
				«IF !this.isAsync»
					__data = await sqs.getQueueUrl({ QueueName: "__syncTermination_'${function}'_'${id}'"}).promise();
								
					__params = {
						MessageBody : JSON.stringify("terminate"),
						QueueUrl : __data.QueueUrl
					}
								
					__data = await sqs.sendMessage(__params).promise();
				«ENDIF»
			}
		'''
	}
	
	def generateConstantDefinition(ConstantDeclaration exp,String scope) {
		var s = ''''''
		if (exp.right instanceof NameObjectDef) {
			typeSystem.get(scope).put(exp.name, "HashMap")
			s += '''const «exp.name» = {'''
			var i = 0;
			for (f : (exp.right as NameObjectDef).features) {
				if (f.feature != null) {
					typeSystem.get(scope).put(exp.name + "." + f.feature,
						valuateArithmeticExpression(f.value, scope))
					s = s + '''«f.feature»:«generateJsArithmeticExpression(f.value,scope)»'''
				} else {
					typeSystem.get(scope).put(exp.name + "[" + i + "]",
						valuateArithmeticExpression(f.value, scope))
					s = s + '''«i»:«generateJsArithmeticExpression(f.value,scope)»'''
					i++
				}
				if (f != (exp.right as NameObjectDef).features.last) {
					s += ''','''
				}
			}
			s += '''}'''

		} else if(exp.right instanceof ArrayDefinition ){ 
			var type_decl =(exp.right as ArrayDefinition).type
			if((exp.right as ArrayDefinition).indexes.length==1){ //mono-dimensional
				typeSystem.get(scope).put(exp.name, "Array_"+type_decl)
			}else if((exp.right as ArrayDefinition).indexes.length==2){ //bi-dimensional
				var col = generateJsArithmeticExpression((exp.right as ArrayDefinition).indexes.get(1).value,scope)
				typeSystem.get(scope).put(exp.name, "Matrix_"+type_decl+"_"+col)
			}else if((exp.right as ArrayDefinition).indexes.length==3){ // three-dimentional
			var col = generateJsArithmeticExpression((exp.right as ArrayDefinition).indexes.get(1).value,scope)
			var dep = generateJsArithmeticExpression((exp.right as ArrayDefinition).indexes.get(2).value,scope)
				typeSystem.get(scope).put(exp.name, "Matrix_"+type_decl+"_"+col+"_"+dep)
			}
			s+='''
				const «exp.name» = [];
			'''					
		} else if(exp.right instanceof ArrayInit){
			if(((exp.right as ArrayInit).values.get(0) instanceof NumberLiteral) ||
					((exp.right as ArrayInit).values.get(0) instanceof StringLiteral) ||
					((exp.right as ArrayInit).values.get(0) instanceof FloatLiteral)
				){ //array init
					var real_type = valuateArithmeticExpression((exp.right as ArrayInit).values.get(0) as ArithmeticExpression,scope)

					typeSystem.get(scope).put(exp.name,"Array_"+real_type)
					return '''
						const «exp.name» = [«FOR e: (exp.right as ArrayInit).values»«generateJsArithmeticExpression(e as ArithmeticExpression,scope)»«IF e != (exp.right as ArrayInit).values.last »,«ENDIF»«ENDFOR»]
					'''
				} else if ((exp.right as ArrayInit).values.get(0) instanceof ArrayValue){ //matrix 2d
					if(((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) instanceof NumberLiteral ||
						((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) instanceof StringLiteral ||
						((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) instanceof FloatLiteral){
						var real_type = valuateArithmeticExpression(((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArithmeticExpression,scope)
						var col = (((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.length
						typeSystem.get(scope).put(exp.name,"Matrix_"+real_type+"_"+col)
						var ret = '''const «exp.name» = ['''
						for (e : (exp.right as ArrayInit).values){
							ret+='''['''
							for(e1: (e as ArrayValue).values){
								ret+=generateJsArithmeticExpression(e1 as ArithmeticExpression,scope)
								if(e1!= (e as ArrayValue).values.last){
									ret+=''','''
								}
							}
							ret+=''']'''
							if (e !=  (exp.right as ArrayInit).values.last){
								ret+=''','''
							}
						}
						ret+=''']'''
						return ret
					}else if (((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) instanceof ArrayValue){ //matrix 3d
						if ((((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) instanceof NumberLiteral ||
							(((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) instanceof StringLiteral ||
							(((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) instanceof FloatLiteral ){
							var real_type = valuateArithmeticExpression((((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) as ArithmeticExpression,scope)
							var col = (((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.length
							var dep = ((((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.length
							typeSystem.get(scope).put(exp.name,"Matrix_"+real_type+"_"+col+"_"+dep)
							var ret = '''const «exp.name» = ['''
							for (e : (exp.right as ArrayInit).values){
								ret+='''['''
								for(e1: (e as ArrayValue).values){
									ret+='''['''
									for(e2: ((e1 as ArrayValue).values)){
										ret+=generateJsArithmeticExpression(e2 as ArithmeticExpression,scope)
										if(e2!= (e1 as ArrayValue).values.last){
											ret+=''','''
										}
									}
									ret+=''']'''
									if(e1!= (e as ArrayValue).values.last){
										ret+=''','''
									}
								}
								ret+=''']'''
								if (e !=  (exp.right as ArrayInit).values.last){
									ret+=''','''
								}
							}
							ret+=''']'''
							return ret	
						}
					}
					
				}
		} else {
			s += '''
				const «exp.name» = «generateJsArithmeticExpression(exp.right as ArithmeticExpression,scope)»;
			'''
		}
		return s
	}

	def generateJsExpression(Expression exp, String scope) {
		var s = ''''''
		if (exp instanceof ChannelSend) {
			s += '''	
				__data = await sqs.getQueueUrl({ QueueName: "«exp.target.name»_'${id}'"}).promise();
				
				__params = {
					MessageBody : JSON.stringify(«generateJsArithmeticExpression(exp.expression,scope)»),
					QueueUrl : __data.QueueUrl
				}
				
				__data = await sqs.sendMessage(__params).promise();
			'''
		} else if (exp instanceof VariableDeclaration) {
			if (exp.typeobject.equals("var")) {
				if (exp.right instanceof NameObjectDef) {
					typeSystem.get(scope).put(exp.name, "HashMap")
					s += '''var «exp.name» = {'''
					var i = 0;
					for (f : (exp.right as NameObjectDef).features) {
						if (f.feature != null) {
							typeSystem.get(scope).put(exp.name + "." + f.feature,
								valuateArithmeticExpression(f.value, scope))
							s = s + '''«f.feature»:«generateJsArithmeticExpression(f.value,scope)»'''
						} else {
							typeSystem.get(scope).put(exp.name + "[" + i + "]",
								valuateArithmeticExpression(f.value, scope))
							s = s + '''«i»:«generateJsArithmeticExpression(f.value,scope)»'''
							i++
						}
						if (f != (exp.right as NameObjectDef).features.last) {
							s += ''','''
						}
					}
					s += '''}'''

				} else if(exp.right instanceof ArrayDefinition ){  // DA MODIFICARE AGGIUNGERE MATRICE 2 E 3 DIMENSIONALE
					var type_decl =(exp.right as ArrayDefinition).type
					if((exp.right as ArrayDefinition).indexes.length==1){ //mono-dimensional
						typeSystem.get(scope).put(exp.name, "Array_"+type_decl)
					}else if((exp.right as ArrayDefinition).indexes.length==2){ //bi-dimensional
						var col = generateJsArithmeticExpression((exp.right as ArrayDefinition).indexes.get(1).value,scope)
						typeSystem.get(scope).put(exp.name, "Matrix_"+type_decl+"_"+col)
					}else if((exp.right as ArrayDefinition).indexes.length==3){ // three-dimentional
					var col = generateJsArithmeticExpression((exp.right as ArrayDefinition).indexes.get(1).value,scope)
					var dep = generateJsArithmeticExpression((exp.right as ArrayDefinition).indexes.get(2).value,scope)
						typeSystem.get(scope).put(exp.name, "Matrix_"+type_decl+"_"+col+"_"+dep)
					}
					s+='''
						var «exp.name» = [];
					'''					
				}else if(exp.right instanceof ArrayInit){
						if(((exp.right as ArrayInit).values.get(0) instanceof NumberLiteral) ||
					((exp.right as ArrayInit).values.get(0) instanceof StringLiteral) ||
					((exp.right as ArrayInit).values.get(0) instanceof FloatLiteral)){ //array init
						var real_type = valuateArithmeticExpression((exp.right as ArrayInit).values.get(0) as ArithmeticExpression,scope)
	
						typeSystem.get(scope).put(exp.name,"Array_"+real_type)
						return '''
							var «exp.name» = [«FOR e: (exp.right as ArrayInit).values»«generateJsArithmeticExpression(e as ArithmeticExpression,scope)»«IF e != (exp.right as ArrayInit).values.last »,«ENDIF»«ENDFOR»]
						'''
					} else if ((exp.right as ArrayInit).values.get(0) instanceof ArrayValue){ //matrix 2d
						if(((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) instanceof NumberLiteral ||
							((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) instanceof StringLiteral ||
							((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) instanceof FloatLiteral){
							var real_type = valuateArithmeticExpression(((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArithmeticExpression,scope)
							var col = (((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.length
							typeSystem.get(scope).put(exp.name,"Matrix_"+real_type+"_"+col)
							var ret = '''var «exp.name» = ['''
							for (e : (exp.right as ArrayInit).values){
								ret+='''['''
								for(e1: (e as ArrayValue).values){
									ret+=generateJsArithmeticExpression(e1 as ArithmeticExpression,scope)
									if(e1!= (e as ArrayValue).values.last){
										ret+=''','''
									}
								}
								ret+=''']'''
								if (e !=  (exp.right as ArrayInit).values.last){
									ret+=''','''
								}
							}
							ret+=''']'''
							return ret
						}else if (((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) instanceof ArrayValue){ //matrix 3d
							if ((((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) instanceof NumberLiteral ||
								(((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) instanceof StringLiteral ||
								(((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) instanceof FloatLiteral ){
								var real_type = valuateArithmeticExpression((((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) as ArithmeticExpression,scope)
								var col = (((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.length
								var dep = ((((exp.right as ArrayInit).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.get(0) as ArrayValue).values.length
								typeSystem.get(scope).put(exp.name,"Matrix_"+real_type+"_"+col+"_"+dep)
								var ret = '''var «exp.name» = ['''
								for (e : (exp.right as ArrayInit).values){
									ret+='''['''
									for(e1: (e as ArrayValue).values){
										ret+='''['''
										for(e2: ((e1 as ArrayValue).values)){
											ret+=generateJsArithmeticExpression(e2 as ArithmeticExpression,scope)
											if(e2!= (e1 as ArrayValue).values.last){
												ret+=''','''
											}
										}
										ret+=''']'''
										if(e1!= (e as ArrayValue).values.last){
											ret+=''','''
										}
									}
									ret+=''']'''
									if (e !=  (exp.right as ArrayInit).values.last){
										ret+=''','''
									}
								}
								ret+=''']'''
								return ret	
							}
						}
						
					}	
				} else if(exp.right instanceof DeclarationObject){
					var type = (exp.right as DeclarationObject).features.get(0).value_s
					switch (type) {
						case "DataFrame": {
							typeSystem.get(scope).put(exp.name, "Table")
							var path = (exp.right as DeclarationObject).features.get(1).value_s
							s += '''
								var __«exp.name» = await __dataframe.fromCSV(«IF (exp as VariableDeclaration).onCloud && ! (path.contains("https://")) » "https://s3.us-east-2.amazonaws.com/bucket-'${id}'/«path»" «ELSE»«path»«ENDIF»)
								var «exp.name» = __«exp.name».toArray()
							'''
						}
						
						default: {
							
						}
					}
					
				} else {
					s += '''
						var «exp.name» = «generateJsArithmeticExpression(exp.right as ArithmeticExpression,scope)»;
					'''
				}

			} 
		} else if (exp instanceof IfExpression) {
			s += '''
				if(«generateJsArithmeticExpression(exp.cond,scope)»)
					«generateJsExpression(exp.then,scope)» 
				«IF exp.^else != null»
				else
					«generateJsExpression(exp.^else,scope)»
				«ENDIF»
			'''
		} else if (exp instanceof ForExpression) {
			s += '''
				«generateJsForExpression(exp,scope)»
			'''
		} else if (exp instanceof WhileExpression) {
			s += '''
				«generateJsWhileExpression(exp,scope)»
			'''
		} else if (exp instanceof BlockExpression) {
			s += '''
				«generateJsBlockExpression(exp,scope)»
			'''
		} else if (exp instanceof Assignment) {
			s += '''
				«generateJsAssignmentExpression(exp,scope)»
			'''
		} else if (exp instanceof PrintExpression) {
			s += '''
				console.log(«generateJsArithmeticExpression(exp.print,scope)») 
			'''
		} else if(exp instanceof NativeExpression){
			s+='''
				«generateJsNativeExpression(exp)»
			'''
		} else if(exp instanceof PostfixOperation){
			s+='''
				«generateJsArithmeticExpression(exp.variable,scope)»«exp.feature»
			'''
		} else if(exp instanceof LocalFunctionCall){
			s += exp.target.name + "("
			if (exp.input != null) {
				for (input : exp.input.inputs) {
					s += generateJsArithmeticExpression(input, scope)
					if (input != exp.input.inputs.last) {
						s += ","
					}
				}
			}
			s += ")"
			}
		return s
	}
	
	def generateJsNativeExpression(NativeExpression expression) { 
		var i=0;
		var lines = expression.code.split("\n");
		var num_tabs = 0 
		while(lines.get(1).charAt(i).equals(lines.get(1).charAt(0))){
			num_tabs++; 
			i++;
		}
		i=0
		var ret = new StringBuilder()
		for (i=1; i< lines.length-1;i++){
			ret.append('''«lines.get(i).substring(num_tabs)»''')
			ret.append("\n")
		}
		return ret.toString
	}

	def generateJsAssignmentExpression(Assignment assignment, String scope) {
		if (assignment.feature != null) {
			if (assignment.value instanceof CastExpression &&
				((assignment.value as CastExpression).target instanceof ChannelReceive)) {
				if ((((assignment.value as CastExpression).target as ChannelReceive).target.environment.
					right as DeclarationObject).features.get(0).value_s.equals("aws")) { // aws environment
						return '''
							__data = await sqs.getQueueUrl({ QueueName: "«((assignment.value as CastExpression).target as ChannelReceive).target.name»_'${id}'}").promise();
							__data = await sqs.sendMessage({QueueUrl : __data.QueueUrl }).promise();
							«generateJsArithmeticExpression(assignment.feature,scope)» «assignment.op» __data.Messages[0].Body
						'''
				} else { // other environment

				}

			} else if (assignment.value instanceof ChannelReceive) {
				if (((assignment.value as ChannelReceive).target.environment.right as DeclarationObject).features.
					get(0).value_s.equals("aws")) { // aws environment
					return '''
					__data = await sqs.getQueueUrl({ QueueName: "«((assignment.value as CastExpression).target as ChannelReceive).target.name»_'${id}'"}).promise();
					__data = await sqs.sendMessage({QueueUrl : __data.QueueUrl }).promise();
					«generateJsArithmeticExpression(assignment.feature,scope)» «assignment.op» __data.Messages[0].Body
					'''
				} else { // other environment
					return '''
						
					'''
				}
			} else {
				return '''
					«generateJsArithmeticExpression(assignment.feature,scope)» «assignment.op» «generateJsArithmeticExpression(assignment.value,scope)» 
				'''
			}
		}
		if (assignment.feature_obj !== null) {
			if (assignment.feature_obj instanceof NameObject) {
				typeSystem.get(scope).put(
					((assignment.feature_obj as NameObject).name as VariableDeclaration).name + "." +
						(assignment.feature_obj as NameObject).value,
					valuateArithmeticExpression(assignment.value, scope))
				return '''
					«((assignment.feature_obj as NameObject).name as VariableDeclaration).name»["«(assignment.feature_obj as NameObject).value»"] = «generateJsArithmeticExpression(assignment.value,scope)» 
				'''
			}
			if (assignment.feature_obj instanceof IndexObject) {
				if(typeSystem.get(scope).get((assignment.feature_obj as IndexObject).name.name).contains("Array")){
					return '''
						«(assignment.feature_obj as IndexObject).name.name»[«generateJsArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(0).value,scope)»] = «generateJsArithmeticExpression(assignment.value,scope)»
					'''
				} else if(typeSystem.get(scope).get((assignment.feature_obj as IndexObject).name.name).contains("Matrix")){
					if((assignment.feature_obj as IndexObject).indexes.length==2){
						var i = generateJsArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(0).value,scope)
						var j = generateJsArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(1).value,scope)
						var col = typeSystem.get(scope).get((assignment.feature_obj as IndexObject).name.name).split("_").get(2)
						return '''
							«(assignment.feature_obj as IndexObject).name.name»[(«i»*«col»)+«j»] = «generateJsArithmeticExpression(assignment.value,scope)»
						'''
					}else {
						return '''
							«(assignment.feature_obj as IndexObject).name.name»[«generateJsArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(0).value,scope)»,«generateJsArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(1).value,scope)»,«generateJsArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(2).value,scope)»] = «generateJsArithmeticExpression(assignment.value,scope)»
						'''
					}
				}else{
					typeSystem.get(scope).put(
						((assignment.feature_obj as IndexObject).name as VariableDeclaration).name + "[" +
							generateJsArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(0).value,scope) + "]",
						valuateArithmeticExpression(assignment.value, scope))
					return '''
						«((assignment.feature_obj as IndexObject).name as VariableDeclaration).name»[«generateJsArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(0).value,scope)»] = «generateJsArithmeticExpression(assignment.value,scope)» 
					'''
						
				}
			}
		}
	}

	def generateJsWhileExpression(WhileExpression exp, String scope) {
		'''
			while(«generateJsArithmeticExpression(exp.cond,scope)»)
				«generateJsExpression(exp.body,scope)»
		'''
	}

	def generateJsForExpression(ForExpression exp, String scope) {
		if (exp.object instanceof CastExpression) {
			if ((exp.object as CastExpression).type.equals("Dat")) {
				if(exp.index.indices.length==1){
					return '''
						for(var __«(exp.index.indices.get(0) as VariableDeclaration).name» in «((exp.object as CastExpression).target as VariableLiteral).variable.name»»){
							
							var «(exp.index.indices.get(0) as VariableDeclaration).name» = «(exp.index.indices.get(0) as VariableDeclaration).name»[__«(exp.index.indices.get(0) as VariableDeclaration).name»];
							«IF exp.body instanceof BlockExpression»
								«FOR e: (exp.body as BlockExpression).expressions»
									«generateJsExpression(e,scope)»
								«ENDFOR»
							«ELSE»
								«generateJsExpression(exp.body,scope)»
							«ENDIF»
						}
					'''
				}else{
					return ''''''
				}	
			} else if ((exp.object as CastExpression).type.equals("Object")) {
				if(exp.index.indices.length==1){
					return '''
					for(__key in «((exp.object as CastExpression).target as VariableLiteral).variable.name» ){
						var «(exp.index.indices.get(0) as VariableDeclaration).name» = {k:__key, v:«((exp.object as CastExpression).target as VariableLiteral).variable.name»[__key]} 
						«IF exp.body instanceof BlockExpression»
							«FOR e: (exp.body as BlockExpression).expressions»
								«generateJsExpression(e,scope)»
							«ENDFOR»
						«ELSE»
							«generateJsExpression(exp.body,scope)»	
						«ENDIF»
					}
				'''
				}else{
					return ''''''
				}	
			}
		} else if (exp.object instanceof RangeLiteral) {
			if(exp.index.indices.length==1){
				return '''
				var «(exp.index.indices.get(0) as VariableDeclaration).name»;
				for(«(exp.index.indices.get(0) as VariableDeclaration).name» = «IF (exp.object as RangeLiteral).value_l1 == null» «(exp.object as RangeLiteral).value1»«ELSE»«(exp.object as RangeLiteral).value_l1.name»«ENDIF» ;«(exp.index.indices.get(0) as VariableDeclaration).name» < «IF (exp.object as RangeLiteral).value_l2 == null» «(exp.object as RangeLiteral).value2»«ELSE»«(exp.object as RangeLiteral).value_l2.name»«ENDIF»; «(exp.index.indices.get(0)as VariableDeclaration).name»++)
				«IF exp.body instanceof BlockExpression»
					«generateJsBlockExpression(exp.body as BlockExpression,scope)»
				«ELSE»
					«generateJsExpression(exp.body,scope)»
				«ENDIF»
			'''
			}else{
				return ''''''
			}
		} else if (exp.object instanceof VariableLiteral) {
			if (((exp.object as VariableLiteral).variable.typeobject.equals('var') &&
				((exp.object as VariableLiteral).variable.right instanceof NameObjectDef) ) ||
				typeSystem.get(scope).get((exp.object as VariableLiteral).variable.name).equals("HashMap")) {
				if(exp.index.indices.length==1){
					return '''
						for(__key in «(exp.object as VariableLiteral).variable.name» ){
							var «(exp.index.indices.get(0) as VariableDeclaration).name» = {k:__key, v:«(exp.object as VariableLiteral).variable.name»[__key]}
							«IF exp.body instanceof BlockExpression»
								«FOR e: (exp.body as BlockExpression).expressions»
									«generateJsExpression(e,scope)»
								«ENDFOR»
							«ELSE»
								«generateJsExpression(exp.body,scope)»	
							«ENDIF»
						}
					'''
				}else{
					return ''''''
				}	
			} else if ((exp.object as VariableLiteral).variable.typeobject.equals('dat') ||
				typeSystem.get(scope).get((exp.object as VariableLiteral).variable.name).equals("Table")) {
				if(exp.index.indices.length==1){
					return '''
						for(var __«(exp.index.indices.get(0) as VariableDeclaration).name» in «(exp.object as VariableLiteral).variable.name» ){
							var «(exp.index.indices.get(0) as VariableDeclaration).name» = «(exp.object as VariableLiteral).variable.name»[__«(exp.index.indices.get(0) as VariableDeclaration).name»]
							«IF exp.body instanceof BlockExpression»
								«FOR e: (exp.body as BlockExpression).expressions»
									«generateJsExpression(e,scope)»
								«ENDFOR»
							«ELSE»
								«generateJsExpression(exp.body,scope)»
							«ENDIF»
						}
					'''
				}else{
					return ''''''
				}
			}
		} 
	}

	def generateJsBlockExpression(BlockExpression block, String scope) {
		return '''
			{
				«FOR exp : block.expressions»
					«generateJsExpression(exp,scope)»
				«ENDFOR»
			}
		'''
	}

	def generateJsArithmeticExpression(ArithmeticExpression exp,String scope) {
		if (exp instanceof BinaryOperation) {
			if (exp.feature.equals("and"))
				return '''«generateJsArithmeticExpression(exp.left,scope)» && «generateJsArithmeticExpression(exp.right,scope)»'''
			else if (exp.feature.equals("or"))
				return '''«generateJsArithmeticExpression(exp.left,scope)» || «generateJsArithmeticExpression(exp.right,scope)»'''
			else
				return '''«generateJsArithmeticExpression(exp.left,scope)» «exp.feature» «generateJsArithmeticExpression(exp.right,scope)»'''
		} else if (exp instanceof UnaryOperation) {
			return '''«exp.feature»«generateJsArithmeticExpression(exp.operand,scope)»'''
		} else if (exp instanceof ParenthesizedExpression) {
			return '''(«generateJsArithmeticExpression(exp.expression,scope)»)'''
		} else if (exp instanceof NumberLiteral) {
			return '''«exp.value»'''
		} else if (exp instanceof BooleanLiteral) {
			return '''«exp.value»'''
		} else if (exp instanceof FloatLiteral) {
			return '''«exp.value»'''
		}
		if (exp instanceof StringLiteral) {
			return '''"«exp.value»"'''
		} else if (exp instanceof VariableLiteral) {
			return '''«exp.variable.name»'''
		} else if (exp instanceof VariableFunction) {
			if ((exp.target.right as DeclarationObject).features.get(0).value_s.equals("random")) {
				return '''Math.random()'''
			}else{
				var s = exp.target.name + "." + exp.feature + "("
			for (e : exp.expressions) {
				s += generateJsArithmeticExpression(e, scope)
				if (e != exp.expressions.last()) {
					s += ","
				}
			}
			s += ")"
			return s
			}
			
		} else if (exp instanceof TimeFunction){
			if(exp.value != null){
				return '''(process.hrtime(«exp.value.name»))'''
			}else{
				return '''(process.hrtime())'''	
			}
		} else if (exp instanceof NameObject) {
			return '''«(exp.name as VariableDeclaration).name».«exp.value»'''
		} else if (exp instanceof IndexObject) {
			if( exp.indexes.length == 1 ){
				return '''«(exp.name as VariableDeclaration).name»[«generateJsArithmeticExpression(exp.indexes.get(0).value,scope)»]'''
			} else if(exp.indexes.length == 2){
				var i = generateJsArithmeticExpression(exp.indexes.get(0).value,scope)
				var j = generateJsArithmeticExpression(exp.indexes.get(1).value,scope)
				var col = typeSystem.get(scope).get((exp.name as VariableDeclaration).name).split("_").get(2)
				return '''«(exp.name as VariableDeclaration).name»[(«i»*«col»)+«j»]'''
			}else{
				//return '''«(exp.name as VariableDeclaration).name»[«generateJsArithmeticExpression(exp.indexes.get(0).value)»,«generateJsArithmeticExpression(exp.indexes.get(1).value)»,«generateJsArithmeticExpression(exp.indexes.get(2).value)»]'''
			}
		} else if (exp instanceof CastExpression) {
			return '''«generateJsArithmeticExpression(exp.target,scope)»'''
		} else if (exp instanceof MathFunction) {
			return '''Math.«exp.feature»(«FOR par: exp.expressions» «generateJsArithmeticExpression(par,scope)» «IF !par.equals(exp.expressions.last)»,«ENDIF»«ENDFOR»)'''
		}else if(exp instanceof LocalFunctionCall){
			var s=''''''
			s += exp.target.name + "("
			if (exp.input != null) {
				for (input : exp.input.inputs) {
					s += generateJsArithmeticExpression(input, scope)
					if (input != exp.input.inputs.last) {
						s += ","
					}
				}
			}
			s += ")"
			return s
		}else{
			return ''''''
		}
	}
	
	def String valuateArithmeticExpression(ArithmeticExpression exp, String scope) {
		if (exp instanceof NumberLiteral) {
			return "Integer"
		} else if (exp instanceof BooleanLiteral) {
			return "Boolean"
		} else if (exp instanceof StringLiteral) {
			return "String"
		} else if (exp instanceof FloatLiteral) {
			return "Double"
		} else if (exp instanceof VariableLiteral) {
			val variable = exp.variable
			if (variable.typeobject.equals("dat")) {
				return "Table"
			} else if (variable.typeobject.equals("channel")) {
				return "Channel"
			} else if (variable.typeobject.equals("var")) {
				if (variable.right instanceof NameObjectDef) {
					return "HashMap"
				} else if (variable.right instanceof ArithmeticExpression) {
					return valuateArithmeticExpression(variable.right as ArithmeticExpression, scope)
				}else{
					return typeSystem.get(scope).get(variable.name) // if it's a parameter of a FunctionDefinition
				}
			}
			return "variable"
		} else if (exp instanceof NameObject) {
			return typeSystem.get(scope).get(exp.name.name + "." + exp.value)
		} else if (exp instanceof IndexObject) {
			if(typeSystem.get(scope).get(exp.name.name).contains("Array") ||typeSystem.get(scope).get(exp.name.name).contains("Matrix")){
				return typeSystem.get(scope).get(exp.name.name).split("_").get(1)
			}
			else{
				return typeSystem.get(scope).get(exp.name.name + "[" + generateJsArithmeticExpression(exp.indexes.get(0).value,scope) + "]")
			}
		} else if (exp instanceof DatTableObject) {
			return "Table"
		}
		if (exp instanceof UnaryOperation) {
			if (exp.feature.equals("!"))
				return "Boolean"
			return valuateArithmeticExpression(exp.operand, scope)
		}
		if (exp instanceof BinaryOperation) {
			var left = valuateArithmeticExpression(exp.left, scope)
			var right = valuateArithmeticExpression(exp.right, scope)
			if (exp.feature.equals("+") || exp.feature.equals("-") || exp.feature.equals("*") ||
				exp.feature.equals("/")) {
				if (left.equals("String") || right.equals("String"))
					return "String"
				else if (left.equals("Double") || right.equals("Double"))
					return "Double"
				else
					return "Integer"
			} else
				return "Boolean"
		} else if (exp instanceof CastExpression) {
			if (exp.type.equals("Object")) {
				return "HashMap"
			}
			if (exp.type.equals("String")) {
				return "String"
			}
			if (exp.type.equals("Integer")) {
				return "Integer"
			}
			if (exp.type.equals("Float")) {
				return "Double"
			}
			if (exp.type.equals("Dat")) {
				return "Table"
			}
			if (exp.type.equals("Date")) {
				return "LocalDate"
			}
		} else if (exp instanceof ParenthesizedExpression) {
			return valuateArithmeticExpression(exp.expression, scope)
		}
		if (exp instanceof MathFunction) {
			if (exp.feature.equals("round")) {
				return "Integer"
			} else {
				for (el : exp.expressions) {
					if (valuateArithmeticExpression(el, scope).equals("Double")) {
						return "Double"
					}
				}
				return "Integer"
			}
		} else if (exp instanceof TimeFunction){
			return "Long"
		}else if (exp instanceof VariableFunction) {
			if (exp.target.typeobject.equals("var")) {
				if (exp.feature.equals("split")) {
					return "HashMap"
				} else if (exp.feature.contains("indexOf") || exp.feature.equals("length")) {
					return "Integer"
				} else if (exp.feature.equals("concat") || exp.feature.equals("substring") ||
					exp.feature.equals("toLowerCase") || exp.feature.equals("toUpperCase")) {
					return "String"
				} else {
					return "Boolean"
				}
			} else if (exp.target.typeobject.equals("random")) {
				if (exp.feature.equals("nextBoolean")) {
					return "Boolean"
				} else if (exp.feature.equals("nextDouble")) {
					return "Double"
				} else if (exp.feature.equals("nextInt")) {
					return "Integer"
				}
			}
		} else {
			return "Object"
		}
	}
	
	
	def CharSequence compileDeploy(Resource resource, String name)'''
	#!/bin/bash
		
		if [ $# -eq 0 ]
		  then
		    echo "No arguments supplied. ./aws_deploy.sh <user profile> <function_name> <id_function_execution>"
		    exit 1
		fi
		
		user=$1
		function=$2
		id=$3
		
		echo "Checking that aws-cli is installed"
		which aws
		if [ $? -eq 0 ]; then
		      echo "aws-cli is installed, continuing..."
		else
		      echo "You need aws-cli to deploy this lambda. Google 'aws-cli install'"
		      exit 1
		fi
		
		echo '{
				"Version": "2012-10-17",
				"Statement": [
					{
						"Effect": "Allow",
						"Action": [
							"sqs:DeleteMessage",
							"sqs:GetQueueAttributes",
							"sqs:ReceiveMessage",
							"sqs:SendMessage",
							"sqs:*"
						],
						"Resource": "*" 
					},
					{
					"Effect": "Allow",
					"Action": [
						"s3:*"
					],
					"Resource": "*" 
										},
					{
						"Effect":"Allow",
						"Action": [
							"logs:CreateLogGroup",
							"logs:CreateLogStream",
							"logs:PutLogEvents"
						],
						"Resource": "*"
					}
				]
			}' > policyDocument.json
		
		echo '{
					"Version": "2012-10-17",
					"Statement": [
						{
							"Effect": "Allow",
							"Principal": {
								"Service": "lambda.amazonaws.com"
							},
							"Action": "sts:AssumeRole" 
						}
					]
				}' > rolePolicyDocument.json
		
		#create role policy
		
		echo "creation of role lambda-sqs-execution ..."
		
		role_arn=$(aws iam --profile ${user} get-role --role-name lambda-sqs-execution --query 'Role.Arn')
		
		if [ $? -eq 255 ]; then 
			role_arn=$(aws iam --profile ${user} create-role --role-name lambda-sqs-execution --assume-role-policy-document file://rolePolicyDocument.json --output json --query 'Role.Arn')
		fi
		
		echo "role lambda-sqs-execution created at ARN "$role_arn
		
		aws iam --profile ${user} put-role-policy --role-name lambda-sqs-execution --policy-name lambda-sqs-policy --policy-document file://policyDocument.json
		
		mkdir ${function}_lambda
				
		cd ${function}_lambda
		
		echo '«generateBodyJs(resource,root.body,root.parameters,name,env)»' > ${function}.js
		
		echo "npm init..."
		npm init -y
		if [ $? -eq 0 ]; then
		    echo "..."
		else
		    echo "npm init failed"
		    exit 1
		fi
		
		echo " npm instal aws-sdk "
		npm install aws-sdk
		if [ $? -eq 0 ]; then
		    echo "..."
		else
		    echo "npm install aws-sdk failed"
		    exit 1
		fi
		
		echo "npm install async"
		npm install async
		if [ $? -eq 0 ]; then
		    echo "..."
		else
		    echo "npm install async failed"
		    exit 1
		fi
		
		echo "npm install dataframe-js"
		npm install dataframe-js
		if [ $? -eq 0 ]; then
		    echo "..."
		else
		    echo "npm install dataframe-js failed"
		    exit 1
		fi
		
	«FOR req : resource.allContents.toIterable.filter(RequireExpression).filter[(environment.right as DeclarationObject).features.get(4).value_s.equals(language)]»
		echo "npm install «req.lib»"
		npm install «req.lib»"
		if [ $? -eq 0 ]; then
		    echo "..."
		else
		    echo "npm install «req.lib» failed"
		    exit 1
		fi
	«ENDFOR»
				
		echo ""
		echo "creating .zip file"
		
		zip -r -q -9 ../${function}_lambda.zip . 
		
		cd .. 
			
		#create the lambda function
		echo "creation of the lambda function"
		aws lambda --profile ${user} create-function --function-name ${function}_${id} --zip-file fileb://${function}_lambda.zip --handler ${function}.handler --runtime «language» --role ${role_arn//\"} --memory-size «memory» --timeout «time»
		
		while [ $? -ne 0 ]; do
			aws lambda --profile ${user} create-function --function-name ${function}_${id} --zip-file fileb://${function}_lambda.zip --handler ${function}.handler --runtime «language» --role ${role_arn//\"} --memory-size «memory» --timeout «time»
		done
		
		echo "lambda function created"
		
		# clear 
		rm -r ${function}_lambda/
		rm ${function}_lambda.zip
		rm rolePolicyDocument.json
		rm policyDocument.json
	
	'''
	
	def CharSequence compileUndeploy(Resource resource, String name)'''
		#!/bin/bash
			
		if [ $# -eq 0 ]
		  then
		    echo "No arguments supplied. ./aws_deploy.sh <user_profile> <function_name> <id_function_execution>"
		    exit 1
		fi
		
		user=$1
		function=$2
		id=$3
		
		# delete user queue
		«FOR res: resource.allContents.toIterable.filter(VariableDeclaration).filter[right instanceof DeclarationObject].filter[(right as DeclarationObject).features.get(0).value_s.equals("channel")]»
			«IF (res.environment.right as DeclarationObject).features.get(0).value_s.equals("aws")»
				#get «res.name»_${id} queue-url
				
				echo "get «res.name»_${id} queue-url"
				queue_url=$(aws sqs --profile ${user} get-queue-url --queue-name «res.name»_${id} --query 'QueueUrl')
				echo ${queue_url//\"}
				
				echo "delete queue at url ${queue_url//\"} "
				aws sqs --profile ${user} delete-queue --queue-url ${queue_url//\"}
			«ENDIF»
		«ENDFOR»

		«FOR  res: resource.allContents.toIterable.filter(FlyFunctionCall)»
			«IF (res.environment.right as DeclarationObject).features.get(0).value_s.equals("aws")»
				#delete «res.target.name»_${id} lambda function
				echo "delete «res.target.name»_${id} lambda function"
				aws lambda --profile ${user} delete-function --function-name «res.target.name»_${id}
			«ENDIF»
		«ENDFOR»
		
		
		
	'''
	
}