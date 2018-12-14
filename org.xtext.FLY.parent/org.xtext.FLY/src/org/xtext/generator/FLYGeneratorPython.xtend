package org.xtext.generator

import java.util.HashMap
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.fLY.ArithmeticExpression
import org.xtext.fLY.Assignment
import org.xtext.fLY.BinaryOperation
import org.xtext.fLY.BlockExpression
import org.xtext.fLY.BooleanLiteral
import org.xtext.fLY.CastExpression
import org.xtext.fLY.ChannelReceive
import org.xtext.fLY.ChannelSend
import org.xtext.fLY.DatDeclaration
import org.xtext.fLY.DatTableObject
import org.xtext.fLY.DeclarationObject
import org.xtext.fLY.Expression
import org.xtext.fLY.FloatLiteral
import org.xtext.fLY.ForExpression
import org.xtext.fLY.FunctionDefinition
import org.xtext.fLY.IfExpression
import org.xtext.fLY.IndexObject
import org.xtext.fLY.MathFunction
import org.xtext.fLY.NameObject
import org.xtext.fLY.NameObjectDef
import org.xtext.fLY.NumberLiteral
import org.xtext.fLY.ParenthesizedExpression
import org.xtext.fLY.PostfixOperation
import org.xtext.fLY.PrintExpression
import org.xtext.fLY.RangeLiteral
import org.xtext.fLY.StringLiteral
import org.xtext.fLY.TimeFunction
import org.xtext.fLY.UnaryOperation
import org.xtext.fLY.VariableDeclaration
import org.xtext.fLY.VariableFunction
import org.xtext.fLY.VariableLiteral
import org.xtext.fLY.WhileExpression
import org.xtext.fLY.EnvironmentDeclaration

class FLYGeneratorPython extends AbstractGenerator {
	String name = null
	String env = null
	FunctionDefinition root = null
	var id_execution = null
	HashMap<String, HashMap<String, String>> typeSystem = null
	String language
	int nthread
	int memory
	int time

	def generatePython(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context, String name_file,
		FunctionDefinition func, EnvironmentDeclaration environment, HashMap<String, HashMap<String, String>> scoping,
		long id) {
		name = name_file
		root = func
		typeSystem = scoping
		id_execution = id
		env = (environment.right as DeclarationObject).features.get(0).value_s
		language = (environment.right as DeclarationObject).features.get(4).value_s
		nthread = (environment.right as DeclarationObject).features.get(5).value_t
		memory = (environment.right as DeclarationObject).features.get(6).value_t
		time = (environment.right as DeclarationObject).features.get(7).value_t
		doGenerate(input, fsa, context)
	}

	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fsa.generateFile(name + "_deploy.sh", input.compileScript(root.name, env));
		fsa.generateFile(name + "_undeploy.sh", input.compileScript(root.name, env));
	}

	def CharSequence compilePy(Resource resource, FunctionDefinition definition, String string) '''
'''

	def CharSequence compileScript(Resource resource, String string, String string2) '''
'''

	def generateBodyPy(BlockExpression exps, List<Expression> parameters, String name, String env) {
		'''
			«IF env == "aws"»
				var AWS = require('aws-sdk');
				var sqs = new AWS.SQS();
			«ENDIF»
			var __dataframe = require('dataframe-js').DataFrame;
			let __params;
			let __data;
			
			exports.handler = async (event,context) => {
				
				«FOR exp : parameters»
					«IF typeSystem.get(name).get((exp as VariableDeclaration).name).equals("Table")»
						var __«(exp as VariableDeclaration).name» = await new __dataframe(JSON.parse(event.Records[0].body));
						var «(exp as VariableDeclaration).name» = __«(exp as VariableDeclaration).name».toArray()
					«ELSE»
						var «(exp as VariableDeclaration).name» = event.Records[0].body;
					«ENDIF»
				«ENDFOR»
				«FOR exp : exps.expressions»
					«generatePyExpression(exp,name)»
				«ENDFOR»
			}
		'''
	}

	def generatePyExpression(Expression exp, String scope) {
		var s = ''''''
		if (exp instanceof ChannelSend) {
			s += '''	
				__data = await sqs.getQueueUrl({ QueueName: "«exp.target.name»_«name»_«id_execution»"}).promise();
				
				__params = {
					MessageBody : JSON.stringify(«generatePyArithmeticExpression(exp.expression)»),
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
							s = s + '''«f.feature»:«generatePyArithmeticExpression(f.value)»'''
						} else {
							typeSystem.get(scope).put(exp.name + "[" + i + "]",
								valuateArithmeticExpression(f.value, scope))
							s = s + '''«i»:«generatePyArithmeticExpression(f.value)»'''
							i++
						}
						if (f != (exp.right as NameObjectDef).features.last) {
							s += ''','''
						}
					}
					s += '''}'''

				} else {
					s += '''
						var «exp.name» = «generatePyArithmeticExpression(exp.right as ArithmeticExpression)»;
					'''
				}

			} else if (exp.typeobject.equals("dat")) {
				typeSystem.get(scope).put(exp.name, "Table")
				var path = (exp.right as DeclarationObject).features.get(1).value_s
				s += '''
					var __«exp.name» = await __dataframe.fromCSV(«IF (exp as DatDeclaration).onCloud && ! (path.contains("https://")) » "https://s3.us-east-2.amazonaws.com/bucket-«name.replaceAll("_","-")»-«id_execution»/«path»" «ELSE»«path»«ENDIF»)
					var «exp.name» = __«exp.name».toArray()
				'''
			}
		} else if (exp instanceof IfExpression) {
			s += '''
				if(«generatePyArithmeticExpression(exp.cond)»)
					«generatePyExpression(exp.then,scope)» 
				«IF exp.^else != null»
					else
						«generatePyExpression(exp.^else,scope)»
				«ENDIF»
			'''
		} else if (exp instanceof ForExpression) {
			s += '''
				«generatePyForExpression(exp,scope)»
			'''
		} else if (exp instanceof WhileExpression) {
			s += '''
				«generatePyWhileExpression(exp,scope)»
			'''
		} else if (exp instanceof BlockExpression) {
			s += '''
				«generatePyBlockExpression(exp,scope)»
			'''
		} else if (exp instanceof Assignment) {
			s += '''
				«generatePyAssignmentExpression(exp,scope)»
			'''
		} else if (exp instanceof PrintExpression) {
			s += '''
				console.log(«generatePyArithmeticExpression(exp.print)») 
			'''
		}
		return s
	}

	def generatePyAssignmentExpression(Assignment assignment, String scope) {
		if (assignment.feature != null) {
			if (assignment.value instanceof CastExpression &&
				((assignment.value as CastExpression).target instanceof ChannelReceive)) {
				if ((((assignment.value as CastExpression).target as ChannelReceive).target.environment.
					right as DeclarationObject).features.get(0).value_s.equals("aws")) { // aws environment
					if ((assignment.value as CastExpression).type.equals("Integer")) {
						return '''
							
						'''
					} else if ((assignment.value as CastExpression).type.equals("Double")) {
						return '''
							
						'''
					}
				} else { // other environment
					if ((assignment.value as CastExpression).type.equals("Integer")) {
						return '''
							
						'''
					} else if ((assignment.value as CastExpression).type.equals("Double")) {
						return '''
							
						'''
					}

				}

			} else if (assignment.value instanceof ChannelReceive) {
				if (((assignment.value as ChannelReceive).target.environment.right as DeclarationObject).features.
					get(0).value_s.equals("aws")) { // aws environment
					return '''
					'''
				} else { // other environment
					return '''
						
					'''
				}
			} else {
				return '''
					«generatePyArithmeticExpression(assignment.feature)» «assignment.op» «generatePyArithmeticExpression(assignment.value)» 
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
					«((assignment.feature_obj as NameObject).name as VariableDeclaration).name»["«(assignment.feature_obj as NameObject).value»"] = «generatePyArithmeticExpression(assignment.value)» 
				'''
			}
			if (assignment.feature_obj instanceof IndexObject) {
				if ((assignment.feature_obj as IndexObject).value != null) {
					typeSystem.get(scope).put(
						((assignment.feature_obj as IndexObject).name as VariableDeclaration).name + "[" +
							(assignment.feature_obj as IndexObject).value.name + "]",
						valuateArithmeticExpression(assignment.value, scope))
					return '''
						«((assignment.feature_obj as IndexObject).name as VariableDeclaration).name»[«(assignment.feature_obj as IndexObject).value.name»] = «generatePyArithmeticExpression(assignment.value)» 
					'''
				} else {
					typeSystem.get(scope).put(
						((assignment.feature_obj as IndexObject).name as VariableDeclaration).name + "[" +
							(assignment.feature_obj as IndexObject).valuet + "]",
						valuateArithmeticExpression(assignment.value, scope))
					return '''
						«((assignment.feature_obj as IndexObject).name as VariableDeclaration).name»[«(assignment.feature_obj as IndexObject).valuet»] = «generatePyArithmeticExpression(assignment.value)» 
					'''
				}
			}
		}
	}

	def generatePyWhileExpression(WhileExpression exp, String scope) {
		'''
			while(«generatePyArithmeticExpression(exp.cond)»)
				«generatePyExpression(exp.body,scope)»
		'''
	}

	def generatePyForExpression(ForExpression exp, String scope) {
		if (exp.object instanceof CastExpression) {
			if ((exp.object as CastExpression).type.equals("Dat")) {
				return '''
				for(var __«(exp.index as VariableDeclaration).name» in «((exp.object as CastExpression).target as VariableLiteral).variable.name»»){
					
					
ar «(exp.index as VariableDeclaration).name» = «(exp.index as VariableDeclaration).name»[__«(exp.index as VariableDeclaration).name»];
				
				«IF exp.body instanceof BlockExpression»
					
				«FOR e: (exp.body as BlockExpression).expressions»
						
				«generatePyExpression(e,scope)»
								
				«ENDFOR»
					
				«ELSE»
					
				«generatePyExpression(exp.body,scope)»
								
				«ENDIF»
				}
				«««				for(__«(exp.index as VariableDeclaration).name» in «((exp.object as CastExpression).target as VariableLiteral).variable.name» ){
«««					var «(exp.index as VariableDeclaration).name» = «((exp.object as CastExpression).target as VariableLiteral).variable.name»[__«(exp.index as VariableDeclaration).name»]
«««					«IF exp.body instanceof BlockExpression»
«««						«FOR e: (exp.body as BlockExpression).expressions»
«««							«generatePyExpression(e,scope)»
«««						«ENDFOR»
«««					«ELSE»
«««						«generatePyExpression(exp.body,scope)»
«««					«ENDIF»
«««					}
				'''
			} else if ((exp.object as CastExpression).type.equals("Object")) {
				return '''
					for(__key in «((exp.object as CastExpression).target as VariableLiteral).variable.name» ){
						var «(exp.index as VariableDeclaration).name» = {k:__key, v:«((exp.object as CastExpression).target as VariableLiteral).variable.name»[__key]} 
						«IF exp.body instanceof BlockExpression»
							«FOR e: (exp.body as BlockExpression).expressions»
								«generatePyExpression(e,scope)»
							«ENDFOR»
						«ELSE»
							«generatePyExpression(exp.body,scope)»	
						«ENDIF»
					}
				'''
			}
		} else if (exp.object instanceof RangeLiteral) {
			return '''
				var «(exp.index as VariableDeclaration).name»;
				for(«(exp.index as VariableDeclaration).name» = «(exp.object as RangeLiteral).value1» ;«(exp.index as VariableDeclaration).name» < «(exp.object as RangeLiteral).value2»; «(exp.index as VariableDeclaration).name»++)
				«IF exp.body instanceof BlockExpression»
					«generatePyBlockExpression(exp.body as BlockExpression,scope)»
				«ELSE»
					«generatePyExpression(exp.body,scope)»
				«ENDIF»
			'''
		} else if (exp.object instanceof VariableLiteral) {
			if (((exp.object as VariableLiteral).variable.typeobject.equals('var') &&
				((exp.object as VariableLiteral).variable.right instanceof NameObjectDef) ) ||
				typeSystem.get(scope).get((exp.object as VariableLiteral).variable.name).equals("HashMap")) {
				return '''
					for(__key in «(exp.object as VariableLiteral).variable.name» ){
						var «(exp.index as VariableDeclaration).name» = {k:__key, v:«(exp.object as VariableLiteral).variable.name»[__key]}
						«IF exp.body instanceof BlockExpression»
							«FOR e: (exp.body as BlockExpression).expressions»
								«generatePyExpression(e,scope)»
							«ENDFOR»
						«ELSE»
							«generatePyExpression(exp.body,scope)»	
						«ENDIF»
					}
				'''
			} else if ((exp.object as VariableLiteral).variable.typeobject.equals('dat') ||
				typeSystem.get(scope).get((exp.object as VariableLiteral).variable.name).equals("Table")) {
				return '''
				for(var __«(exp.index as VariableDeclaration).name» in «(exp.object as VariableLiteral).variable.name» ){
					var «(exp.index as VariableDeclaration).name» = «(exp.object as VariableLiteral).variable.name»[__«(exp.index as VariableDeclaration).name»]
					«IF exp.body instanceof BlockExpression»
						«FOR e: (exp.body as BlockExpression).expressions»
							«generatePyExpression(e,scope)»
						«ENDFOR»
					«ELSE»
						«generatePyExpression(exp.body,scope)»
					«ENDIF»
				}
				«««					for(__«(exp.index as VariableDeclaration).name» in «(exp.object as VariableLiteral).variable.name»){
«««						var «(exp.index as VariableDeclaration).name» = «(exp.object as VariableLiteral).variable.name»[__«(exp.index as VariableDeclaration).name»]
«««						«IF exp.body instanceof BlockExpression»
«««							«FOR e: (exp.body as BlockExpression).expressions»
«««								«generatePyExpression(e,scope)»
«««							«ENDFOR»
«««						«ELSE»
«««							«generatePyExpression(exp.body,scope)»
«««						«ENDIF»
«««					}
				'''
			}
		}
	}

	def generatePyBlockExpression(BlockExpression block, String scope) {
		'''{
		«FOR exp : block.expressions»
			«generatePyExpression(exp,scope)»
		«ENDFOR»
		}'''
	}

	def generatePyArithmeticExpression(ArithmeticExpression exp) {
		if (exp instanceof BinaryOperation) {
			if (exp.feature.equals("and"))
				return '''«generatePyArithmeticExpression(exp.left)» && «generatePyArithmeticExpression(exp.right)»'''
			else if (exp.feature.equals("or"))
				return '''«generatePyArithmeticExpression(exp.left)» || «generatePyArithmeticExpression(exp.right)»'''
			else
				return '''«generatePyArithmeticExpression(exp.left)» «exp.feature» «generatePyArithmeticExpression(exp.right)»'''
		} else if (exp instanceof UnaryOperation) {
			return '''«exp.feature»«generatePyArithmeticExpression(exp.operand)»'''
		} else if (exp instanceof PostfixOperation) {
			return '''«generatePyArithmeticExpression(exp.operand)»«exp.feature»'''
		} else if (exp instanceof ParenthesizedExpression) {
			return '''(«generatePyArithmeticExpression(exp.expression)»)'''
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
			if (exp.target.typeobject.equals("random")) {
				return '''Math.random()'''
			}
		} else if (exp instanceof TimeFunction) {
			if (exp.value != null) {
				return '''(process.hrtime(«exp.value.name»))'''
			} else {
				return '''(process.hrtime())'''
			}
		} else if (exp instanceof NameObject) {
			return '''«(exp.name as VariableDeclaration).name».«exp.value»'''
		} else if (exp instanceof IndexObject) {
			if (exp.value !== null) {
				return '''«(exp.name as VariableDeclaration).name»[«(exp.value.name)»]'''
			} else {
				return '''«(exp.name as VariableDeclaration).name»[«exp.valuet»]'''
			}
		} else if (exp instanceof CastExpression) {
			return '''«generatePyArithmeticExpression(exp.target)»'''
		} else if (exp instanceof MathFunction) {
			return '''Math.«exp.feature»(«FOR par : exp.expressions» «generatePyArithmeticExpression(par)» «IF !par.equals(exp.expressions.last)»,«ENDIF»«ENDFOR»)'''
		} else {
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
				} else {
					return typeSystem.get(scope).get(variable.name) // if it's a parameter of a FunctionDefinition
				}
			}
			return "variable"
		} else if (exp instanceof NameObject) {
			return typeSystem.get(scope).get(exp.name.name + "." + exp.value)
		} else if (exp instanceof IndexObject) {
			if (exp.value != null)
				return typeSystem.get(scope).get(exp.name.name + "[" + exp.value + "]")
			else
				return typeSystem.get(scope).get(exp.name.name + "[" + exp.valuet + "]")
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
		} else if (exp instanceof PostfixOperation) {
			return valuateArithmeticExpression(exp.operand, scope)
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
		} else if (exp instanceof TimeFunction) {
			return "Long"
		} else if (exp instanceof VariableFunction) {
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

}
