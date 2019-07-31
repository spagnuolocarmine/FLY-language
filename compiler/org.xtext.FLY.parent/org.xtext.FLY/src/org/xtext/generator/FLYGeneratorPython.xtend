package org.xtext.generator

import java.util.HashMap
import java.util.HashSet
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
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
import org.xtext.fLY.DatTableObject
import org.xtext.fLY.DeclarationObject
import org.xtext.fLY.Expression
import org.xtext.fLY.FloatLiteral
import org.xtext.fLY.ForExpression
import org.xtext.fLY.FunctionDefinition
import org.xtext.fLY.FunctionReturn
import org.xtext.fLY.IfExpression
import org.xtext.fLY.IndexObject
import org.xtext.fLY.LocalFunctionCall
import org.xtext.fLY.LocalFunctionInput
import org.xtext.fLY.MathFunction
import org.xtext.fLY.NameObject
import org.xtext.fLY.NameObjectDef
import org.xtext.fLY.NativeExpression
import org.xtext.fLY.NumberLiteral
import org.xtext.fLY.ParenthesizedExpression
import org.xtext.fLY.PrintExpression
import org.xtext.fLY.RangeLiteral
import org.xtext.fLY.RequireExpression
import org.xtext.fLY.SortExpression
import org.xtext.fLY.StringLiteral
import org.xtext.fLY.TimeFunction
import org.xtext.fLY.UnaryOperation
import org.xtext.fLY.VariableDeclaration
import org.xtext.fLY.VariableFunction
import org.xtext.fLY.VariableLiteral
import org.xtext.fLY.WhileExpression
import org.xtext.fLY.PostfixOperation
import org.xtext.fLY.ArrayDefinition
import org.xtext.fLY.FlyFunctionCall
import java.util.ArrayList
import java.util.Arrays
import org.xtext.fLY.EnvironemtLiteral

class FLYGeneratorPython extends AbstractGenerator {
	String name = null
	String env = null
	FunctionDefinition root = null
	var id_execution = null
	HashMap<String, HashMap<String, String>> typeSystem = null
	HashMap<String, FunctionDefinition> functionCalled = null
	String language
	int nthread
	int memory
	int timeout
	String user = null
	Resource resourceInput
	boolean isLocal
	boolean isAsync
	var list_environment = new ArrayList<String>(Arrays.asList("smp","aws","aws-debug","azure"));

	def generatePython(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context, String name_file,
		FunctionDefinition func, VariableDeclaration environment, HashMap<String, HashMap<String, String>> scoping,
		long id, boolean local, boolean async) {
		name = name_file
		root = func
		typeSystem = scoping
		id_execution = id
		if (!local) {
			env = (environment.right as DeclarationObject).features.get(0).value_s
			user = (environment.right as DeclarationObject).features.get(1).value_s
			language = (environment.right as DeclarationObject).features.get(5).value_s
			nthread = (environment.right as DeclarationObject).features.get(6).value_t
			memory = (environment.right as DeclarationObject).features.get(7).value_t
			timeout = (environment.right as DeclarationObject).features.get(8).value_t					
		} else {
			env = "smp"
			language = (environment.right as DeclarationObject).features.get(2).value_s
			nthread = (environment.right as DeclarationObject).features.get(1).value_t
		}

		resourceInput = input
		functionCalled = new HashMap<String, FunctionDefinition>();
		for (element : input.allContents.toIterable.filter(FunctionDefinition)
			.filter[it.name != root.name]
			.filter[it.body.expressions.toList.filter(NativeExpression).length>0]) {

			functionCalled.put(element.name,element)
		}
		this.isAsync = async
		this.isLocal = local;
		doGenerate(input, fsa, context)
	}

	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var allReqs = input.allContents
			.filter(RequireExpression)
			.filter[(it.environment.right as DeclarationObject).features.get(0).value_s != 'smp']
			.map[it.lib]
			.toList
		allReqs.add("numpy")
		allReqs.add("pandas")
		allReqs.add("pytz")
		allReqs.add("ortools")
		if(env.equals("azure"))
			allReqs.add("azure-storage-queue")
		saveToRequirements(allReqs, fsa)
		println(root.name)
		if (isLocal) {
			fsa.generateFile(root.name + ".py", input.compilePython(root.name, true))	
		}else {
			if(env.equals("aws-debug"))
				fsa.generateFile("docker-compose-script.sh",input.compileDockerCompose())
			fsa.generateFile(root.name +"_"+ env +"_deploy.sh", input.compileScriptDeploy(root.name, false))
			fsa.generateFile(root.name +"_"+ env + "_undeploy.sh", input.compileScriptUndeploy(root.name, false))
		}
	}
	
	def channelsNames(BlockExpression exps) {

		var names = new HashSet<String>();		
		val chRecvs = resourceInput.allContents
				.filter[it instanceof ChannelReceive]
				.filter[functionContainer(it) === root.name]
				.filter[((it as ChannelReceive).target.environment.right as DeclarationObject).features.get(0).value_s.contains("aws")] 
				.map[it as ChannelReceive]
				.map[it.target as VariableDeclaration]
				
				.map[it.name]
		val chSends = resourceInput.allContents
				.filter[it instanceof ChannelSend]
				.filter[functionContainer(it) === root.name]
				.filter[((it as ChannelSend).target.environment.right as DeclarationObject).features.get(0).value_s.contains("aws")] 
				.map[it as ChannelSend]
				.map[it.target as VariableDeclaration]
				.map[it.name]
				
		while(chRecvs.hasNext()) {
			names.add(chRecvs.next())
		}
		while(chSends.hasNext()) {
			names.add(chSends.next())
		}
		
		return names.toArray()
	}
	
		
	def functionContainer(EObject e) {
		var parent = e.eContainer
		if (parent === null) {
			return ""
		} else if (parent instanceof FunctionDefinition) {
			return (parent as FunctionDefinition).name
		} else {
			return functionContainer(parent)
		}
	}
	
	def saveToRequirements(String[] requirements, IFileSystemAccess fsa) {
		var res = "";
		for (s: requirements) {
			res += s + "\n"
		}
		fsa.generateFile("requirements.txt", res)
	} 


	def generateBodyPyLocal(BlockExpression exps, List<Expression> parameters, String name, String env, boolean local) {
		val channelNames = channelsNames(exps)
		println(typeSystem)
		return '''
		import random
		import time
		import math 
		import pandas as pd
		import json
		
		import socket
		import sys
		
		
		__sock_loc = socket.socket() # TODO
		__sock_loc.connect(('', 9090))			
			
		«FOR chName : channelNames»
			«chName» = __sock_loc.makefile('rwb')
		«ENDFOR»
		
		«FOR fd:functionCalled.values()»
			«generatePyExpression(fd, name, local)»
			
		«ENDFOR»	
				
		def main(event):
			«FOR exp : parameters»
				«IF typeSystem.get(name).get((exp as VariableDeclaration).name).equals("Table") »
					__columns=json.loads(event)[0].keys()
					«(exp as VariableDeclaration).name» = pd.read_json(event)
					«(exp as VariableDeclaration).name» = «(exp as VariableDeclaration).name»[__columns]
				«ELSE»
					«(exp as VariableDeclaration).name» = json.loads(event)
				«ENDIF»
			«ENDFOR»
			«FOR exp : exps.expressions»
				«generatePyExpression(exp,name, local)»
			«ENDFOR»
			__sock_loc.close()
		
		if __name__ == "__main__":
		
			__sock_data = socket.socket()
			__sock_data.connect(('', 9091))
			__sock_data_fh = __sock_data.makefile('rb')
			main(__sock_data_fh.readline())
		'''
	}

	def generateBodyPy(BlockExpression exps, List<Expression> parameters, String name, String env, boolean local) {
		//println("generaty python body "+name)
		//println(typeSystem.get(name))
		val channelNames = channelsNames(exps)
		'''
			# python
			import random
			import time
			import math 
			import pandas as pd
			import json
			
			«IF env.contains("aws")»				
			import boto3
			«IF env.equals("aws")»
				sqs = boto3.resource('sqs')
			«ELSE»
				sqs = boto3.resource('sqs',endpoint_url='http://192.168.0.1:4576')
			«ENDIF»

			«FOR chName : channelNames»
				«chName» = sqs.get_queue_by_name(QueueName='«chName»-"${id}"')
			«ENDFOR»
			«ELSEIF env == "azure"»
			import azure.functions as func
			from azure.storage.queue import QueueService 
			from azure.storage.queue.models import QueueMessageFormat
			«ENDIF»
			
			«IF env.contains("aws") »			
			def handler(event,context):
				__environment = 'aws'
				id_func=event['id']
				data = event['data']
			«ELSEIF env == "azure"»
			def main(req: func.HttpRequest):
				__environment = 'azure'
				__queue_service = QueueService(account_name='"${storageName}"', account_key='"${storageKey}"')
				__queue_service.encode_function = QueueMessageFormat.text_base64encode
				__event = req.get_json()
				id_func= __event['id']
				data = __event['data']
			«ENDIF»
				«FOR exp : parameters»
					«IF typeSystem.get(name).get((exp as VariableDeclaration).name).equals("Table") || typeSystem.get(name).get((exp as VariableDeclaration).name).equals("File")»
						__columns = data[0].keys()
						«(exp as VariableDeclaration).name» = pd.read_json(json.dumps(data))
						«(exp as VariableDeclaration).name» = «(exp as VariableDeclaration).name»[__columns]
					«ELSE»
						«(exp as VariableDeclaration).name» = data # TODO check
					«ENDIF»
				«ENDFOR»
				«FOR exp : exps.expressions»
					«generatePyExpression(exp,name, local)»
				«ENDFOR»
				«IF env.contains("aws") »			
					__syncTermination = sqs.get_queue_by_name(QueueName='termination-"${function}"-"${id}"-'+str(id_func))
					__syncTermination.send_message(MessageBody=json.dumps('terminate'))
				«ELSEIF env == "azure"»
					__queue_service.put_message('termination-"${function}"-"${id}"-'+str(id_func), 'terminate')
				«ENDIF»
		'''
	}

	def generatePyExpression(Expression exp, String scope, boolean local) {
		var s = ''''''
		if (exp instanceof ChannelSend) {
			var env = (exp.target.environment.right as DeclarationObject).features.get(0).value_s ;//(exp.target as DeclarationObject).features.get(0).value_s;
			s += '''			
			«IF local»
				«exp.target.name».write(json.dumps(«generatePyArithmeticExpression(exp.expression, scope, local)»).encode('utf8'))
			«ELSEIF (env.contains("aws"))»
			«exp.target.name».send_message(
				MessageBody=json.dumps(«generatePyArithmeticExpression(exp.expression, scope, local)»)
			)
			«ELSEIF env=="azure"»
			__queue_service.put_message('«exp.target.name»-"${id}"', json.dumps(«generatePyArithmeticExpression(exp.expression, scope, local)»))
			«ENDIF»

			'''
		} else if (exp instanceof VariableDeclaration) {
			if (exp.typeobject.equals("var") || exp.typeobject.equals("const")) {
				if (exp.right instanceof NameObjectDef) {  // it is a nameobjectdef
					typeSystem.get(scope).put(exp.name, "HashMap")
					s += '''«exp.name» = {'''
					var i = 0;
					for (f : (exp.right as NameObjectDef).features) {
						if (f.feature !== null) {
							typeSystem.get(scope).put(exp.name + "." + f.feature,
								valuateArithmeticExpression(f.value, scope, local))
							s = s + ''' '«f.feature»' : «generatePyArithmeticExpression(f.value, scope, local)»'''
						} else {
							typeSystem.get(scope).put(exp.name + "[" + i + "]",
								valuateArithmeticExpression(f.value, scope, local))
							s = s + ''' '«i»' :«generatePyArithmeticExpression(f.value, scope, local)»'''
							i++
						}
						if (f != (exp.right as NameObjectDef).features.last) {
							s += ''','''
						}
					}
					s += '''}'''

				} else if (exp.right instanceof ArrayDefinition) {
					typeSystem.get(scope).put(exp.name, "Array")
					val len = (exp.right as ArrayDefinition).indexes.get(0).value
					val type = (exp.right as ArrayDefinition).type
					s += '''
					«exp.name» = [None] * «generatePyArithmeticExpression(len, scope, local)»
					'''
				} 
				else if(exp.right instanceof DeclarationObject){
					var type = (exp.right as DeclarationObject).features.get(0).value_s
					switch (type) {
						case "dataframe": {
							typeSystem.get(scope).put(exp.name, "Table")
							var path = (exp.right as DeclarationObject).features.get(1).value_s
							var fileType = (exp.right as DeclarationObject).features.get(2).value_s
							var sep = (exp.right as DeclarationObject).features.get(3).value_s
							path = path.replaceAll('"', '');
							var uri = '''«IF (exp as VariableDeclaration).onCloud && ! (path.contains("https://")) »«IF env == "aws"»https://s3.us-east-2.amazonaws.com«ELSEIF env=="aws-debug"»http//192.168.0.1:4572«ENDIF»/bucket-"${id}"/«path»«ELSE»«path»«ENDIF»'''
							switch (fileType) {
								case 'csv': {
									s += '''
										«exp.name» = pd.read_csv('«uri»', sep='«sep»')
									'''	
								}
								default:  {
									s += '''
										«exp.name» = pd.read_csv('«uri»', sep='«sep»')
									'''		
								}
							}
						}
						case "File":{
							typeSystem.get(scope).put(exp.name, "File")
							return ''''''
						}
						default: {
							return ''''''
						}
					}
				} else { 
					typeSystem.get(scope).put(exp.name, valuateArithmeticExpression(exp.right as ArithmeticExpression,scope,local))
					s += '''
						«exp.name» = «generatePyArithmeticExpression(exp.right as ArithmeticExpression, scope, local)»
					'''
				}

			} 
		} else if (exp instanceof LocalFunctionCall) {
			val fc = (exp as LocalFunctionCall)
			val fd = (fc.target as FunctionDefinition)
			val inputs = (fc.input as LocalFunctionInput).inputs
			//functionCalled.put(fd.name, fd)
			s += '''«((exp as LocalFunctionCall).target).name»(«FOR par : inputs»«generatePyArithmeticExpression(par, scope, local)»«IF !par.equals(inputs.last)», «ENDIF»«ENDFOR»)'''
		} else if (exp instanceof FunctionDefinition) {
			val fd = (exp as FunctionDefinition)
			val name = fd.name
			val params = fd.parameters.map[it as VariableDeclaration].map[it.name]
			val body = fd.body as BlockExpression
			
			s += '''
				def «name»(«String.join(", ", params)»):
					«generatePyBlockExpression(body, scope, local)»
			'''
		} else if (exp instanceof IfExpression) {
			s += '''
				if «generatePyArithmeticExpression(exp.cond, scope, local)»:
					«generatePyExpression(exp.then,scope, local)»
				«IF exp.^else !== null»
					else:
						«generatePyExpression(exp.^else,scope, local)»
				«ENDIF»
			'''
		} else if (exp instanceof ForExpression) {
			s += '''
				«generatePyForExpression(exp,scope, local)»
			'''
		} else if (exp instanceof WhileExpression) {
			s += '''
				«generatePyWhileExpression(exp,scope, local)»
			'''
		} else if (exp instanceof BlockExpression) {
			s += '''
				«generatePyBlockExpression(exp,scope, local)»
			'''
		} else if (exp instanceof Assignment) {
			s += '''
				«generatePyAssignmentExpression(exp,scope,local)»
			'''
		} else if (exp instanceof PrintExpression) {
			s += '''
				print(«generatePyArithmeticExpression(exp.print, scope, local)»)
			'''
		} else if (exp instanceof SortExpression) {
			var isAscending = 'False'
			if (exp.type === 'asc') {
				isAscending = 'True'
			}
			s += '''
				«exp.target».sort_values(by=['«exp.taget»'], ascending=«isAscending»)
			'''
//		} else if (exp instanceof NativeExpression) {
//			s+='''
//				«generateJsNativeExpression(exp)»
//			'''
		} else if (exp instanceof FunctionReturn) {
			val fr = (exp as FunctionReturn)
			s += '''return «generatePyArithmeticExpression(fr.expression, scope, local)»'''
		} else if (exp instanceof PostfixOperation) {
			var postfixOp = ""
			switch(exp.feature) { 
				case "++": postfixOp = "+=1"
				case "--": postfixOp = "-=1"
			}
			s +='''«generatePyArithmeticExpression(exp.variable, scope, local)»«postfixOp»'''
			
		} else if (exp instanceof NativeExpression){
			s +='''«generateNativeEpression(exp,scope,local)»'''
		}
			
		return s
	}
	
	def generateNativeEpression(NativeExpression expression, String string, boolean b) {
		var code_lst = expression.code;
		var code_lst_split = code_lst.split("\n");
		var first_line = code_lst_split.get(1)
		var first_line_split = first_line.split("\t")
		var tabs= 0
		for(w : first_line_split){
			if (w.equals(""))
				tabs=tabs+1
		}
		var s=''''''
		var str = new StringBuilder();
		for(var  i=1;i<code_lst_split.size-1;i++){
			var line = code_lst_split.get(i)
			if(line.equals(""))
					str.append("")
				else
					str.append(line.substring(tabs))
				str.append("\n")
		}
		var ret_str = str.toString.replace("\"","'")
		return ret_str
	}
	

	def generatePyAssignmentExpression(Assignment assignment, String scope, boolean local) {
		if (assignment.feature !== null) {
			if (assignment.value instanceof CastExpression &&
				((assignment.value as CastExpression).target instanceof ChannelReceive)) {
				// If it is a CastExpression of a channel receive
				val channel = (((assignment.value as CastExpression).target as ChannelReceive).target) as VariableDeclaration
				if ((((assignment.value as CastExpression).target as ChannelReceive).target.environment.
					right as DeclarationObject).features.get(0).value_s.equals("aws")) { // aws environment2
					// And we are on AWS
					//TODO controllare receive_message
					if ((assignment.value as CastExpression).type.equals("Integer")) {
						// And we are trying to read an integer
						return '''
						«IF local»
						«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» int(«channel.name».readline())
						«ELSE»
						«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» int(«channel.name».receive_messages()[0]) 
						«ENDIF»
						'''
					} else if ((assignment.value as CastExpression).type.equals("Double")) {
						// And we are trying to read a double
						return '''
						«IF local»
						«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» float(«channel.name».readline())
						«ELSE»
						«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» float(«channel.name».receive_messages()[0])							
						«ENDIF»
						'''
					}
				} else if ((((assignment.value as CastExpression).target as ChannelReceive).target.environment.
					right as DeclarationObject).features.get(0).value_s.equals("azure")) { 
					// And we are on other environments
					if ((assignment.value as CastExpression).type.equals("Integer")) {
						return '''
						«IF local»
						«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» int(«channel.name».readline())
						«ELSE»
						__msg =__queue_service.get_messages('«channel.name»-"${id}"')[0]
						«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» int(__msg.content)
						__queue_service.delete_message('«channel.name»-"${id}"',__msg.id, __msg.pop_receipt)
						«ENDIF»
						'''
					} else if ((assignment.value as CastExpression).type.equals("Double")) {
						return '''
						«IF local»
						«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» float(«channel.name».readline())
						«ELSE»
						__msg =__queue_service.get_messages('«channel.name»-"${id}"')[0]
						«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» float(__msg.content)
						__queue_service.delete_message('«channel.name»-"${id}"',__msg.id, __msg.pop_receipt)
						«ENDIF»
						'''
					}
				} else { // other environments
					return '''
					raise Exception('not now')
					'''
				}

			} else if (assignment.value instanceof ChannelReceive) {
				val channel = (((assignment.value as CastExpression).target as ChannelReceive).target) as VariableDeclaration
				// If it is an assignment of type Channel receive
				if (((assignment.value as ChannelReceive).target.environment.right as DeclarationObject).features.
					get(0).value_s.equals("aws")) { 
					// And we are on AWS
					return '''
					«IF local»
					«channel.name».readline()
					«ELSE»
					«channel.name».receive_messages()[0]
					«ENDIF»
					'''
				} else if (((assignment.value as ChannelReceive).target.environment.right as DeclarationObject).features.
					get(0).value_s.equals("azure")) {
					return '''
					«IF local»
					«channel.name».readline()
					«ELSE»
					__msg =__queue_service.get_messages('«channel.name»-"${id}"')[0]
					«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» __msg.content
					__queue_service.delete_message('«channel.name»-"${id}"',__msg.id, __msg.pop_receipt)
					«ENDIF»
					'''	
					}
				else { // other environments
					return '''
					raise Exception('not now')
					'''
				}
			} else {
				return '''
					«generatePyArithmeticExpression(assignment.feature, scope, local)» «assignment.op» «generatePyArithmeticExpression(assignment.value, scope, local)» 
				'''
			}
		}
		
		if (assignment.feature_obj !== null) {
			if (assignment.feature_obj instanceof NameObject) {
				typeSystem.get(scope).put(
					((assignment.feature_obj as NameObject).name as VariableDeclaration).name + "." +
						(assignment.feature_obj as NameObject).value,
					valuateArithmeticExpression(assignment.value, scope, local))
				return '''
					«((assignment.feature_obj as NameObject).name as VariableDeclaration).name»['«(assignment.feature_obj as NameObject).value»'] = «generatePyArithmeticExpression(assignment.value, scope, local)» 
				'''
			}
			if (assignment.feature_obj instanceof IndexObject) {
				if (typeSystem.get(scope).get((assignment.feature_obj as IndexObject).name.name).contains("Array")) {
					return '''
					«(assignment.feature_obj as IndexObject).name.name»[«generatePyArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(0).value, scope, local)»] = «generatePyArithmeticExpression((assignment.value), scope, local)»
					'''
				} else if (typeSystem.get(scope).get((assignment.feature_obj as IndexObject).name.name).contains("Matrix")) {
					if ((assignment.feature_obj as IndexObject).indexes.length == 2) {
						var i = generatePyArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(0).value ,scope, local);
						var j = generatePyArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(1).value ,scope, local);
						var col = typeSystem.get(scope).get((assignment.feature_obj as IndexObject).name.name).split("_").get(2)
						return '''
							«(assignment.feature_obj as IndexObject).name.name»[«i»*«col»+«j»] = «generatePyArithmeticExpression(assignment.value, scope, local)»
						'''
					}
				} else {
					return '''
					«(assignment.feature_obj as IndexObject).name.name»[«generatePyArithmeticExpression((assignment.feature_obj as IndexObject).indexes.get(0).value, scope, local)»] = «generatePyArithmeticExpression(assignment.value, scope, local)»
					'''
				}
			}
		}
	}

	def generatePyWhileExpression(WhileExpression exp, String scope, boolean local) {
		'''
			while «generatePyArithmeticExpression(exp.cond, scope, local)»:
				«generatePyExpression(exp.body,scope, local)»
		'''
	}

	def generatePyForExpression(ForExpression exp, String scope, boolean local) {
		if(exp.index.indices.length == 1){
			if (exp.object instanceof CastExpression) {
			if ((exp.object as CastExpression).type.equals("Dat")) {
				return '''
				for «(exp.index.indices.get(0) as VariableDeclaration).name» in «(exp.object as VariableLiteral).variable.name».itertuples(index=False):
					«IF exp.body instanceof BlockExpression»
					«FOR e: (exp.body as BlockExpression).expressions»
					«generatePyExpression(e,scope, local)»
					«ENDFOR»
					«ELSE»
					«generatePyExpression(exp.body,scope, local)»
					«ENDIF»
				'''
			} else if ((exp.object as CastExpression).type.equals("Object")) {
				val variableName = (exp.index.indices.get(0) as VariableDeclaration).name
				return '''
					for «variableName»k, «variableName»v in «((exp.object as CastExpression).target as VariableLiteral).variable.name».items():
						«(exp.index.indices.get(0) as VariableDeclaration).name» = {'k': «variableName»k, 'v': «variableName»v} 
						«IF exp.body instanceof BlockExpression»
						«FOR e: (exp.body as BlockExpression).expressions»
							«generatePyExpression(e,scope, local)»
						«ENDFOR»
						«ELSE»
							«generatePyExpression(exp.body,scope, local)»	
						«ENDIF»
				'''
			}
		} else if (exp.object instanceof RangeLiteral) {
			val lRange = (exp.object as RangeLiteral).value1
			val rRange = (exp.object as RangeLiteral).value2
			return '''
				for «(exp.index.indices.get(0) as VariableDeclaration).name» in range(«lRange», «rRange»):
					«IF exp.body instanceof BlockExpression»
						«generatePyBlockExpression(exp.body as BlockExpression,scope, local)»
					«ELSE»
						«generatePyExpression(exp.body,scope, local)»
					«ENDIF»
			'''
		} else if (exp.object instanceof VariableLiteral) {
			println("Variable: "+ (exp.object as VariableLiteral).variable.name +" type: "+ typeSystem.get(scope).get((exp.object as VariableLiteral).variable.name)) 
			if (((exp.object as VariableLiteral).variable.typeobject.equals('var') &&
				((exp.object as VariableLiteral).variable.right instanceof NameObjectDef) ) ||
				typeSystem.get(scope).get((exp.object as VariableLiteral).variable.name).equals("HashMap")) {
				val variableName = (exp.index.indices.get(0) as VariableDeclaration).name
				return '''
					for «variableName»k, «variableName»v in «(exp.object as VariableLiteral).variable.name».items():
						«(exp.index.indices.get(0) as VariableDeclaration).name» = {'k': «variableName»k, 'v': «variableName»v}
						«IF exp.body instanceof BlockExpression»
							«FOR e: (exp.body as BlockExpression).expressions»
								«generatePyExpression(e,scope, local)»
							«ENDFOR»
						«ELSE»
								«generatePyExpression(exp.body,scope, local)»	
						«ENDIF»
					
				'''
			} else if ((exp.object as VariableLiteral).variable.typeobject.equals('dat') || 
				typeSystem.get(scope).get((exp.object as VariableLiteral).variable.name).equals("Table") ||
				typeSystem.get(scope).get((exp.object as VariableLiteral).variable.name).equals("File") ) {
				return '''
				for «(exp.index.indices.get(0) as VariableDeclaration).name» in «(exp.object as VariableLiteral).variable.name».itertuples(index=False):
					«IF exp.body instanceof BlockExpression»
					«FOR e: (exp.body as BlockExpression).expressions»
					«generatePyExpression(e,scope, local)»
					«ENDFOR»
					«ELSE»
					«generatePyExpression(exp.body,scope, local)»
					«ENDIF»
				'''
			}
		}
		}
		
	}

	def generatePyBlockExpression(BlockExpression block, String scope, boolean local) {
		'''
		«FOR exp : block.expressions»
			«generatePyExpression(exp,scope, local)»
		«ENDFOR»
		'''
	}

	def generatePyArithmeticExpression(ArithmeticExpression exp, String scope, boolean local) {
		if (exp instanceof BinaryOperation) {
			if (exp.feature.equals("and"))
				return '''«generatePyArithmeticExpression(exp.left, scope, local)» and «generatePyArithmeticExpression(exp.right, scope, local)»'''
			else if (exp.feature.equals("or"))
				return '''«generatePyArithmeticExpression(exp.left, scope, local)» or «generatePyArithmeticExpression(exp.right, scope, local)»'''
			else if (exp.feature.equals("+")) {
				val leftTypeString = valuateArithmeticExpression(exp.left, scope, local).equals("String");
				val rightTypeString = valuateArithmeticExpression(exp.right, scope, local).equals("String");
				if ((leftTypeString && rightTypeString) || (!leftTypeString && !rightTypeString)) {
					return '''«generatePyArithmeticExpression(exp.left, scope, local)» «exp.feature» «generatePyArithmeticExpression(exp.right, scope, local)»'''
				} else if (leftTypeString) {
					return '''«generatePyArithmeticExpression(exp.left, scope, local)» «exp.feature» str(«generatePyArithmeticExpression(exp.right, scope, local)»)'''
				} else {
					return '''str(«generatePyArithmeticExpression(exp.left, scope, local)») «exp.feature» «generatePyArithmeticExpression(exp.right, scope, local)»'''					
				}
			} else 
				return '''«generatePyArithmeticExpression(exp.left, scope, local)» «exp.feature» «generatePyArithmeticExpression(exp.right, scope, local)»'''
		} else if (exp instanceof UnaryOperation) {
			return '''«exp.feature» «generatePyArithmeticExpression(exp.operand, scope, local)» '''
		} else if (exp instanceof PostfixOperation) {
			var postfixOp = ""
			switch(exp.feature) { // TODO mai?
				case "++": postfixOp = "+=1"
				case "--": postfixOp = "-=1"
			}
			return '''«generatePyArithmeticExpression(exp.variable, scope, local)»«postfixOp»'''
		} else if (exp instanceof ParenthesizedExpression) {
			return '''(«generatePyArithmeticExpression(exp.expression, scope, local)»)'''
		} else if (exp instanceof NumberLiteral) {
			return '''«exp.value»'''
		} else if (exp instanceof BooleanLiteral) {
			return '''«exp.value.toFirstUpper»'''
		} else if (exp instanceof FloatLiteral) {
			return '''«exp.value»'''
		} else if(exp instanceof EnvironemtLiteral){
			return '''__environment'''
		}
		if (exp instanceof StringLiteral) {
			return ''' '«exp.value»' '''
		} else if (exp instanceof VariableLiteral) {
			return '''«exp.variable.name»'''
		} else if (exp instanceof VariableFunction) {
			if ((exp.target.right instanceof DeclarationObject)  && (exp.target.right as DeclarationObject).features.get(0).value_s.equals("random") ) {
				return '''random.random()'''
			}else if(exp.feature.equals("length")){
				return '''len(«exp.target.name»)'''
			}
		} else if (exp instanceof TimeFunction) {
			if (exp.value !== null) {
				return '''int(time.time() * 1000) - «exp.value.name»'''
			} else {
				return '''int(time.time() * 1000)'''
			}
		} else if (exp instanceof NameObject) {
			if ((exp.name.right instanceof DeclarationObject) && list_environment.contains((exp.name.right as DeclarationObject).features.get(0).value_s)){
				return '''__environment'''
			}else{
				return '''«(exp.name as VariableDeclaration).name»['«exp.value»']'''
			}
			
		} else if (exp instanceof IndexObject) {
			if (exp.indexes.length == 1) {
				return '''«(exp.name as VariableDeclaration).name»[«generatePyArithmeticExpression(exp.indexes.get(0).value, scope, local)»]'''
			} else if(exp.indexes.length == 2) {
				var i = generatePyArithmeticExpression(exp.indexes.get(0).value ,scope, local);
				var j = generatePyArithmeticExpression(exp.indexes.get(1).value ,scope, local);
				var col = typeSystem.get(scope).get((exp.name as VariableDeclaration).name).split("_").get(2)
				return '''
					«(exp.name as VariableDeclaration).name»[(«i»*«col»)+«j»]
				'''
			} else {
				
			}
		} else if (exp instanceof CastExpression) {
			return '''«generatePyCast(exp, scope, local)»'''
		} else if (exp instanceof MathFunction) {
			// TODO mapping
			if (exp.feature.equals('abs')) {
				return '''abs(«FOR par : exp.expressions»«generatePyArithmeticExpression(par, scope, local)»«IF !par.equals(exp.expressions.last)», «ENDIF»«ENDFOR»)'''
			}
			return '''math.«exp.feature»(«FOR par : exp.expressions»«generatePyArithmeticExpression(par, scope, local)»«IF !par.equals(exp.expressions.last)», «ENDIF»«ENDFOR»)'''
		} else if (exp instanceof ChannelReceive) {
			val channelName = (((exp as ChannelReceive).target) as VariableDeclaration).name
			if (local) {
				return '''«channelName».readline()'''
			}
			var env = ((exp.target.environment as VariableDeclaration).right as DeclarationObject).features.get(0).value_s
			if(env.equals("aws")){ //TODO cancellare messaggio, controllare se non viene mai invocata
				return '''«channelName».receive_messages()[0]'''
			}else if(env.equals("azure")){
				return '''__queue_service.receive_messages('«channelName»-"${id}"')[0]'''
			}else{
				return'''
				'''
			}
			
		} else if (exp instanceof LocalFunctionCall) {
			return generatePyExpression(exp as LocalFunctionCall, scope, local)
		} else {
			return '''# ???'''
		}
	}
	
	def generatePyCast(CastExpression cast, String scope, boolean local) {
		switch(cast.type) { // 'String' | 'Integer' | 'Date' | 'Dat' | 'Object'  | 'Double'
			case "String": return '''str(«generatePyArithmeticExpression(cast.target, scope, local)»)'''
			case "Integer": return '''int(«generatePyArithmeticExpression(cast.target, scope, local)»)'''
			case "Dat": return '''pd.read_json(«generatePyArithmeticExpression(cast.target, scope, local)»)'''
			case "Object": return '''«generatePyArithmeticExpression(cast.target, scope, local)»'''
			case "Double": return '''float(«generatePyArithmeticExpression(cast.target, scope, local)»)'''
		}	
	}

	def String valuateArithmeticExpression(ArithmeticExpression exp, String scope, boolean local) {
		if (exp instanceof NumberLiteral) {
			return "Integer"
		} else if (exp instanceof BooleanLiteral) {
			return "Boolean"
		} else if (exp instanceof StringLiteral) {
			return "String"
		} else if (exp instanceof FloatLiteral) {
			return "Double"
		} else if (exp instanceof VariableLiteral) { // TODO  fix with the current grammar
			val variable = exp.variable
			if (variable.typeobject.equals("dat")) {
				return "Table"
			} else if (variable.typeobject.equals("channel")) {
				return "Channel"
			} else if (variable.typeobject.equals("var")) {
				if (variable.right instanceof NameObjectDef) {
					return "HashMap"
				} else if (variable.right instanceof ArithmeticExpression) {
					return valuateArithmeticExpression(variable.right as ArithmeticExpression, scope, local)
				} else {
					return typeSystem.get(scope).get(variable.name) // if it's a parameter of a FunctionDefinition
				}
			}
			return "variable"
		} else if (exp instanceof NameObject) {
			return typeSystem.get(scope).get(exp.name.name + "." + exp.value)
		} else if (exp instanceof IndexObject) {
			println(typeSystem.get(scope))
			println(exp.name.name)
			if (typeSystem.get(scope).get(exp.name.name).contains("Array") || typeSystem.get(scope).get(exp.name.name).contains("Matrix") ) {
				return typeSystem.get(scope).get(exp.name.name).split("_").get(1);
			} else {
				return typeSystem.get(scope).get(exp.name.name + "[" + generatePyArithmeticExpression(exp.indexes.get(0).value, scope, local) + "]");
			}
			
			
		} else if (exp instanceof DatTableObject) {
			return "Table"
		}
		if (exp instanceof UnaryOperation) {
			if (exp.feature.equals("!"))
				return "Boolean"
			return valuateArithmeticExpression(exp.operand, scope, local)
		}
		if (exp instanceof BinaryOperation) {
			var left = valuateArithmeticExpression(exp.left, scope, local)
			var right = valuateArithmeticExpression(exp.right, scope, local)
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
			return valuateArithmeticExpression((exp as PostfixOperation).variable, scope, local)
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
			return valuateArithmeticExpression(exp.expression, scope, local)
		}
		if (exp instanceof MathFunction) {
			if (exp.feature.equals("round")) {
				return "Integer"
			} else {
				for (el : exp.expressions) {
					if (valuateArithmeticExpression(el, scope, local).equals("Double")) {
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
	
	def CharSequence compilePython(Resource resource, String name, boolean local) '''
		«generateBodyPyLocal(root.body,root.parameters,name,env, local)»
	'''
	
	def CharSequence compileScriptDeploy(Resource resource, String name, boolean local){
		switch this.env {
		   case "aws": AWSDeploy(resource,name,local,false)
		   case "aws-debug": AWSDebugDeploy(resource,name,local,true)
		   case "azure": AzureDeploy(resource,name,local)
		   default: this.env+" not supported"
  		}
	} 	
	
	def CharSequence AWSDeploy(Resource resource, String name, boolean local, boolean debug)
	'''
	#!/bin/bash
	
	if [ $# -eq 0 ]
	  then
	    echo "No arguments supplied. ./aws_deploy.sh <user_profile> <function_name> <id_function_execution>"
	    exit 1
	fi
	
	echo "Checking that aws-cli is installed"
	which aws
	if [ $? -eq 0 ]; then
	      echo "aws-cli is installed, continuing..."
	else
	      echo "You need aws-cli to deploy this lambda. Google 'aws-cli install'"
	      exit 1
	fi
	
	echo "Checking wheter virtualenv is installed"
	which virtualenv
	if [ $? -eq 0 ]; then
		echo "virtualenv is installed, continuing..."
	else
	     echo "You need to install virtualenv. Google 'virtualenv install'"
	     exit 1
	fi
	
	
	user=$1
	function=$2
	id=$3
	
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
	
	
	echo "Installing requirements"
	
	virtualenv venv -p «language»
	
	source venv/bin/activate
	
	
	echo "Checking wheter pip3 is installed"
	which pip3
	if [ $? -eq 0 ]; then
		echo "pip3 is installed, continuing..."
	else
	     echo "You need to install pip3. Google 'pip3 install'"
	     exit 1
	fi
	
	PIPVER="$(pip3 -V | grep -Eo "(\d+\.)+\d+" | grep -Eo "\d+" | head -1)"
	if [ ${PIPVER} -lt 19 ]; then
		echo "pip version is too old. installing new one"
		curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
		python get-pip.py
	fi
		
	pip3 install pytz
	if [ $? -eq 0 ]; then
	    echo "..."
	else
	    echo "pip install pytz failed"
	    exit 1
	fi
	
	
	pip3 install ortools
	if [ $? -eq 0 ]; then
	    echo "..."
	else
	    echo "pip install ortools failed"
	    exit 1
	fi
	
	pip3 install -r ./src-gen/requirements.txt
	
			
	echo ""
	echo "add precompliled libraries"
	
	cd venv/lib/python3.6/site-packages/
	echo "installing ortools"
	rm -rf ortools*
	wget https://files.pythonhosted.org/packages/64/13/8c8d0fe23da0767ec0f8d00ad14619a20bc6d55ca49a3bd13700e629a1be/ortools-6.10.6025-cp36-cp36m-manylinux1\_x86\_64.whl
	unzip ortools-6.10.6025-cp36-cp36m-manylinux1\_x86\_64.whl
	rm ortools-6.10.6025-cp36-cp36m-manylinux1\_x86\_64.whl
	echo "ortools installed"
	
	echo "installing pandas"
	rm -rf pandas*
	wget https://files.pythonhosted.org/packages/f9/e1/4a63ed31e1b1362d40ce845a5735c717a959bda992669468dae3420af2cd/pandas-0.24.0-cp36-cp36m-manylinux1\_x86\_64.whl
	unzip pandas-0.24.0-cp36-cp36m-manylinux1\_x86\_64.whl
	rm pandas-0.24.0-cp36-cp36m-manylinux1\_x86\_64.whl 
	echo "pandas installed"
	
	echo "installing numpy"
	rm -rf numpy*
	wget https://files.pythonhosted.org/packages/7b/74/54c5f9bb9bd4dae27a61ec1b39076a39d359b3fb7ba15da79ef23858a9d8/numpy-1.16.0-cp36-cp36m-manylinux1\_x86\_64.whl
	unzip numpy-1.16.0-cp36-cp36m-manylinux1\_x86\_64.whl
	rm numpy-1.16.0-cp36-cp36m-manylinux1\_x86\_64.whl
	echo "numpy installed"
	
	echo "creating zip package"
	zip -q -r9 ../../../../${id}\_lambda.zip .
	echo "zip created"
	
	cd ../../../../
	
	
	echo "«generateBodyPy(root.body,root.parameters,name,env, local)»
	
	«FOR fd:functionCalled.values()»
		
	«generatePyExpression(fd, name, local)»
	
	«ENDFOR»
	" > ${function}.py
	
	
	zip -g ${id}_lambda.zip ${function}.py
	
	deactivate
	
		
	#create the lambda function
	echo "creation of the lambda function"
	
	echo "zip file too big, uploading it using s3"
	echo "creating bucket for s3"
	aws s3 --profile ${user} mb s3://${function}${id}bucket
	echo "s3 bucket created. uploading file"
	aws s3 --profile ${user} cp ${id}_lambda.zip s3://${function}${id}bucket --grants read=uri=http://acs.amazonaws.com/groups/global/AllUsers
	echo "file uploaded, creating function"
	aws lambda --profile ${user} create-function --function-name ${function}_${id} --code S3Bucket=""${function}""${id}"bucket",S3Key=""${id}"_lambda.zip" --handler ${function}.handler --runtime «language» --role ${role_arn//\"} --memory-size «memory» --timeout «timeout»
	echo "lambda function created"
	
	
	# clear 
	rm -r venv/
	rm ${function}.py
	rm ${id}_lambda.zip
	rm rolePolicyDocument.json
	rm policyDocument.json
	'''
	
	def CharSequence AWSDebugDeploy(Resource resource, String name, boolean local, boolean debug)
	'''
	#!/bin/bash
	
	if [ $# -eq 0 ]
	  then
	    echo "No arguments supplied. ./aws_deploy.sh <user_profile> <function_name> <id_function_execution>"
	    exit 1
	fi
	
	echo "Checking that aws-cli is installed"
	which aws
	if [ $? -eq 0 ]; then
	      echo "aws-cli is installed, continuing..."
	else
	      echo "You need aws-cli to deploy this lambda. Google 'aws-cli install'"
	      exit 1
	fi
	
	echo "Checking wheter virtualenv is installed"
	which virtualenv
	if [ $? -eq 0 ]; then
		echo "virtualenv is installed, continuing..."
	else
	     echo "You need to install virtualenv. Google 'virtualenv install'"
	     exit 1
	fi
	
	aws configure list --profile dummy_fly_debug
	if [ $? -eq 0 ]; then
		echo "dummy user found, continuing..."
	else
	     echo "creating dummy user..."
	     aws configure set aws_access_key_id dummy --profile dummy_fly_debug
	     aws configure set aws_secret_access_key dummy --profile dummy_fly_debug
	     aws configure set region us-east-1 --profile dummy_fly_debug
	     aws configure set output json --profile dummy_fly_debug
	     echo "dummy user created"
	fi
	
	user=$1
	function=$2
	id=$3
	
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
	
	role_arn=$(aws --endpoint-url=http://localhost:4593 iam --profile dummy_fly_debug get-role --role-name lambda-sqs-execution --query 'Role.Arn')
	
	if [ $? -eq 255 ]; then 
		role_arn=$(aws --endpoint-url=http://localhost:4593 iam --profile dummy_fly_debug create-role --role-name lambda-sqs-execution --assume-role-policy-document file://rolePolicyDocument.json --output json --query 'Role.Arn')
	fi
	
	echo "role lambda-sqs-execution created at ARN "$role_arn
	
	aws iam --endpoint-url=http://localhost:4593 --profile dummy_fly_debug put-role-policy --role-name lambda-sqs-execution --policy-name lambda-sqs-policy --policy-document file://policyDocument.json
	
	
	echo "Installing requirements"
	
	virtualenv venv -p «language»
	
	source venv/bin/activate
	
	
	echo "Checking wheter pip3 is installed"
	which pip3
	if [ $? -eq 0 ]; then
		echo "pip3 is installed, continuing..."
	else
	     echo "You need to install pip3. Google 'pip3 install'"
	     exit 1
	fi
	
	PIPVER="$(pip3 -V | grep -Eo "(\d+\.)+\d+" | grep -Eo "\d+" | head -1)"
	if [ ${PIPVER} -lt 19 ]; then
		echo "pip version is too old. installing new one"
		curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
		python get-pip.py
	fi
		
	pip3 install pytz
	if [ $? -eq 0 ]; then
	    echo "..."
	else
	    echo "pip install pytz failed"
	    exit 1
	fi
	
	
	pip3 install ortools
	if [ $? -eq 0 ]; then
	    echo "..."
	else
	    echo "pip install ortools failed"
	    exit 1
	fi
	
	pip3 install -r ./src-gen/requirements.txt
	
			
	echo ""
	echo "add precompliled libraries"
	
	cd venv/lib/python3.6/site-packages/
	echo "installing ortools"
	rm -rf ortools*
	wget https://files.pythonhosted.org/packages/64/13/8c8d0fe23da0767ec0f8d00ad14619a20bc6d55ca49a3bd13700e629a1be/ortools-6.10.6025-cp36-cp36m-manylinux1\_x86\_64.whl
	unzip ortools-6.10.6025-cp36-cp36m-manylinux1\_x86\_64.whl
	rm ortools-6.10.6025-cp36-cp36m-manylinux1\_x86\_64.whl
	echo "ortools installed"
	
	echo "installing pandas"
	rm -rf pandas*
	wget https://files.pythonhosted.org/packages/f9/e1/4a63ed31e1b1362d40ce845a5735c717a959bda992669468dae3420af2cd/pandas-0.24.0-cp36-cp36m-manylinux1\_x86\_64.whl
	unzip pandas-0.24.0-cp36-cp36m-manylinux1\_x86\_64.whl
	rm pandas-0.24.0-cp36-cp36m-manylinux1\_x86\_64.whl 
	echo "pandas installed"
	
	echo "installing numpy"
	rm -rf numpy*
	wget https://files.pythonhosted.org/packages/7b/74/54c5f9bb9bd4dae27a61ec1b39076a39d359b3fb7ba15da79ef23858a9d8/numpy-1.16.0-cp36-cp36m-manylinux1\_x86\_64.whl
	unzip numpy-1.16.0-cp36-cp36m-manylinux1\_x86\_64.whl
	rm numpy-1.16.0-cp36-cp36m-manylinux1\_x86\_64.whl
	echo "numpy installed"
	
	echo "creating zip package"
	zip -q -r9 ../../../../${id}\_lambda.zip .
	echo "zip created"
	
	cd ../../../../
	
	
	echo "«generateBodyPy(root.body,root.parameters,name,env, local)»
	
	«FOR fd:functionCalled.values()»
		
	«generatePyExpression(fd, name, local)»
	
	«ENDFOR»
	" > ${function}.py
	
	
	zip -g ${id}_lambda.zip ${function}.py
	
	deactivate
	
		
	#create the lambda function
	echo "creation of the lambda function"
	
	echo "zip file too big, uploading it using s3"
	echo "creating bucket for s3"
	aws --endpoint-url=http://localhost:4572 s3 --profile dummy_fly_debug mb s3://${function}${id}bucket
	echo "s3 bucket created. uploading file"
	aws --endpoint-url=http://localhost:4572 s3 --profile dummy_fly_debug cp ${id}_lambda.zip s3://${function}${id}bucket --grants read=uri=http://acs.amazonaws.com/groups/global/AllUsers
	echo "file uploaded, creating function"
	aws --endpoint-url=http://localhost:4574 lambda --profile dummy_fly_debug create-function --function-name ${function}_${id} --code S3Bucket=""${function}""${id}"bucket",S3Key=""${id}"_lambda.zip" --handler ${function}.handler --runtime «language» --role ${role_arn//\"} --memory-size «memory» --timeout «timeout»
	echo "lambda function created"
	
	
	# clear 
	rm -r venv/
	rm ${function}.py
	rm ${id}_lambda.zip
	rm rolePolicyDocument.json
	rm policyDocument.json
	'''
	
	def CharSequence compileDockerCompose(Resource resource)'''
	docker network create -d bridge --subnet 192.168.0.0/24 --gateway 192.168.0.1 mynet
	echo "
	version: '2.1'
	
	services:
	 localstack:
	   image: localstack/localstack:latest
	   ports:
	     - '4567-4593:4567-4593'
	     - '\${PORT_WEB_UI-8080}:\${PORT_WEB_UI-8080}'
	   environment:
	     - SERVICES=\${SERVICES- s3, sqs, lambda, iam, cloud watch, cloud watch logs}
	     - DEBUG=\${DEBUG- 1}
	     - DATA_DIR=\${DATA_DIR- }
	     - PORT_WEB_UI=\${PORT_WEB_UI- }
	     - LAMBDA_EXECUTOR=\${LAMBDA_EXECUTOR- docker}
	     - KINESIS_ERROR_PROBABILITY=\${KINESIS_ERROR_PROBABILITY- }
	     - DOCKER_HOST=unix:///var/run/docker.sock
	     - HOSTNAME=192.168.0.1
	     - HOSTNAME_EXTERNAL=192.168.0.1
	     - LOCALSTACK_HOSTNAME=192.168.0.1
	   volumes:
	     - '\${TMPDIR:-/tmp/localstack}:/tmp/localstack'
	     - '/var/run/docker.sock:/var/run/docker.sock' "> docker-compose.yml
	     
	docker-compose up
	'''
	
	
	def CharSequence AzureDeploy(Resource resource, String name, boolean local)
	'''
		#!/bin/bash
		
«««		#Check if script is running as sudo
«««		if [[ $# -ne 6 ]]; then
«««			echo "Error in number of parameters, run with:"
«««			echo "<app-name> <function-name> <executionId> <clientId> <tenantId> <secret> <subscriptionId> <timeout> <storageName> <storageKey>"
«««			exit 1
«««		fi
		
					
		if [ $# -ne 9 ]
		  then
		    echo "No arguments supplied. ./azure_deploy.sh <app-name> <function-name> <executionId> <clientId> <tenantId> <secret> <subscriptionId>  <storageName> <storageKey>"
		    exit 1
		fi
		
		app=$1
		function=$2
		id=$3
		user=$4
		tenant=$5
		secret=$6
		subscription=$7
		storageName=$8
		storageKey=$9
		
		az login --service-principal -u ${user} -t ${tenant} -p ${secret} --subscription ${subscription}
		
		#Check if python is installed
		if !(command -v python3 &>/dev/null) then
			echo "Script require python 3.6"
			exit 1;
		fi
		
		#Check if Azure Functions Core Tools is installed
		if !(command -v az &>/dev/null) then
			echo "Script require Azure Functions Core Tools"
			exit 1;
		fi
		
		#Virtual environment
		echo "Creating the virtual environment"
		
		if [ ! -d .env ]; then
		
			python3.6 -m venv .env
		fi
		
		source .env/bin/activate
		echo "Virtual environment has been created"
		
		#Local function's local project
		echo "Creating function's local project"
		
		if [ ! -d ${app}${id} ]; then
			func init ${app}${id} --worker-runtime=python --no-source-control -n
					
			cp ./src-gen/requirements.txt ./${app}${id}
			
			cd ${app}${id}
			
			
			rm -f host.json
			echo '{
				"version": "2.0",
				"functionTimeout": "«String.format("%02d:%02d:%02d",0,timeout/60,timeout%60)»"
			}' > host.json;
			
			
		else
			cd ${app}${id}
		fi
		
		echo "Function's local project has been created"
		
		mkdir ${function}
		cd ${function}
		
		echo "Creating Function's files..."
		
		echo '{
		  "scriptFile": "function.py",
		  "bindings": [
		    {
		      "authLevel": "system",
		      "type": "httpTrigger",
		      "direction": "in",
		      "name": "req",
		      "methods": [
		        "post"
		      ]
		    }
		  ]
		}' > function.json
		echo "Function.json created"
		
		#Creating function's source file
		echo "«generateBodyPy(root.body,root.parameters,name,env, local)»
			
			«FOR fd:functionCalled.values()»
				
			«generatePyExpression(fd, name, local)»
			
			«ENDFOR»
			" > function.py
		echo "Function.py created"
		
		echo "Function's files have been created"
		
		#Routine to deploy on Azure
		cd ..
		
		echo "Deploying the function"
		func azure functionapp publish ${app}${id} --build-native-deps
				
		az  logout
		deactivate
	'''
	
	def CharSequence AzureUndeploy(Resource resource, String string, boolean local)'''
	'''
	
	def CharSequence AWSUndeploy(Resource resource, String string, boolean local,boolean debug)'''
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
			«FOR res: resource.allContents.toIterable.filter(VariableDeclaration).filter[right instanceof DeclarationObject].filter[(it.right as DeclarationObject).features.get(0).value_s.equals("channel")]
			.filter[((it.environment as VariableDeclaration).right as DeclarationObject).features.get(0).value_s.equals("aws")] »
				#get «res.name»_${id} queue-url
				
				echo "get «res.name»-${id} queue-url"
				queue_url=$(aws sqs --profile ${user} get-queue-url --queue-name «res.name»-${id} --query 'QueueUrl')
				echo ${queue_url//\"}
				
				echo "delete queue at url ${queue_url//\"} "
				aws sqs --profile ${user} delete-queue --queue-url ${queue_url//\"}
				
			«ENDFOR»
	
			«FOR  res: resource.allContents.toIterable.filter(FlyFunctionCall).filter[((it.environment as VariableDeclaration).right as DeclarationObject).features.get(0).value_s.equals("aws")]»
				#delete lambda function: «res.target.name»_${id}
				echo "delete lambda function: «res.target.name»_${id}"
				aws lambda --profile ${user} delete-function --function-name «res.target.name»_${id}
				
			«ENDFOR»
	'''
	
	def CharSequence AWSDebugUndeploy(Resource resource, String string, boolean local,boolean debug)'''
	#!/bin/bash
	
	docker-compose down				
«««			if [ $# -eq 0 ]
«««			  then
«««			    echo "No arguments supplied. ./aws_deploy.sh <user_profile> <function_name> <id_function_execution>"
«««			    exit 1
«««			fi
«««			
«««			user=$1
«««			function=$2
«««			id=$3
«««			
«««			# delete user queue
«««			«FOR res: resource.allContents.toIterable.filter(VariableDeclaration).filter[right instanceof DeclarationObject].filter[(it.right as DeclarationObject).features.get(0).value_s.equals("channel")]
«««			.filter[((it.environment as VariableDeclaration).right as DeclarationObject).features.get(0).value_s.equals("aws")] »
«««				#get «res.name»_${id} queue-url
«««				
«««				echo "get «res.name»-${id} queue-url"
«««				queue_url=$(aws --endpoint-url=http://localhost:4576 sqs --profile ${user} get-queue-url --queue-name «res.name»-${id} --query 'QueueUrl')
«««				echo ${queue_url//\"}
«««				
«««				echo "delete queue at url ${queue_url//\"} "
«««				aws --endpoint-url=http://localhost:4576 sqs --profile ${user} delete-queue --queue-url ${queue_url//\"}
«««				
«««			«ENDFOR»
«««	
«««			«FOR  res: resource.allContents.toIterable.filter(FlyFunctionCall).filter[((it.environment as VariableDeclaration).right as DeclarationObject).features.get(0).value_s.equals("aws")]»
«««				#delete lambda function: «res.target.name»_${id}
«««				echo "delete lambda function: «res.target.name»_${id}"
«««				aws --endpoint-url=http://localhost:4574 lambda --profile ${user} delete-function --function-name «res.target.name»_${id}
«««				
«««			«ENDFOR»
	'''

	def CharSequence compileScriptUndeploy(Resource resource, String name, boolean local){
		switch this.env {
			   case "aws": AWSUndeploy(resource,name,local,false)
			   case "aws-debug": AWSDebugUndeploy(resource,name,local,true)
			   case "azure": AzureUndeploy(resource,name,local)
			   default: this.env+" not supported"
	  		}
	} 
	
	

}




