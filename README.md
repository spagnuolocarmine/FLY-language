# FLY programming language

FLY is an open source Domain Specific Language for scientific computing on the cloud exploiting FaaS.

## General Information

FLY is designed as a scripting language that use as run-time environment, the local machine or a cloud infrastructure, the script automates the execution of tasks that could alternatively be executed one-by-one by a human operator. 
The goal of  FLY is to provide a portable, scalable and easy-to-use programming environment for scientific computing. FLY perceives a cloud computing infrastructure as a parallel computing architecture on which it is possible to execute some parts of its execution flow in parallel. FLY enables the users (domain experts with limited knowledge about complex parallel and distributed systems) to design their applications exploiting data and task parallelism on any FaaS architecture. 
This is achieved by a rich language that provides domain-specific constructs, that enables the users to easily interact, using an environment abstraction,  with different FaaS backends.

FLY is written using Xtext a framework for development of programming languages and domain-specific languages. FLY code is transformed in pure Java code that you can run on a Java Virtual Machine.

(under costruction)

## Getting Started

FLY is a parallel work-flow scripting imperative language inspired by functional languages peculiarities. FLY has a statically checked type system; variable declaration does not require their type, types are automatically inferred when a variable is firstly assigned, thereafter that variable cannot change its type during the program execution.
 FLY enables run-time type casts as in Java or C\#; programmers do not have to take care about variable types except for some particular cases. FLY supports inter-process (and inter-FLY-functions) communications using channels according to  communicating sequential processes (CSP) definition. The FLY syntax and concepts are inspired by different languages such as Java, JavaScript, Python, and R. This ensures familiarity with most powerful and famous general purposes/data science languages. 

FLY provides standard scripting language constructs: expressions, relational expressions, boolean operations as well as code comments as in Java. Moreover, FLY  provides several domain specific constructs for parallel/distributed task/data based parallelism.

The following listing shows a simple example of a FLY program, which computes a PI estimation through the Montecarlo Method on an Amazon AWS Lambda backend. Briefly, the PI Monte Carlo estimation algorithm generates a set of random points on a two dimensional Cartesian systems, and counts the number of points that are inside the positive quadrant of a circle of diameter 1.0 centered in the origin point. Given the sum of points, it computes the estimation of PI as S*4.0/NN, where S is the number of points inside the positive quadrant of the circle and N is the total number of generated random points. 

```
 env aws = [type:"aws",access_key:"amazon_aws_access_key", secret_key:"amazon_aws_secret_key", region:"us-east-2"]   
  channel ch on aws              
  func hit(){                   
     random r          
     var x = r.nextDouble()
     var y = r.nextDouble()  
     var msg=0  
     if( (x*x)+(y*y) < 1.0 ){ msg=1 }
     ch!msg  
  }
  func estimation(){ 
     var sum = 0
     var crt = 0
     for i in [0:10000] {
   	  sum += ch? as Integer 
   	  crt += 1  
     }
     println "PI approximation is "+ (sum*4.0)/crt 
  }
  fly hit in [0:10000] on aws thenall estimation
```

(under costruction)

## FLY Compiler 
-----------------------------------------------------------------------------------------------------------

### Requirements

- Jaava 8 (or grater)
- Eclipse IDE
- Xtext (www.eclipse.org/Xtext)

### Build Instructions

?????????????????????????????????????

## FLY Programming
-------------------------------------------------------------------------------------------------------------

### Requirements

- Ubuntu or OSX OS
- Java 8 (or greater)
- Apache Maven 3 or greater)
- Amazon AWS CLI and SDK

### Compile your FLY program

### K-nearest neighbors FLY example

?????????????????????????????????????????????????


