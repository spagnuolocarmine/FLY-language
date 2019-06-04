---
title: Data types
permalink: /docs/common/data_types/
---

## Variables 

A variable, in FLY, is a name associated to a value. For defining a new variable the user have to use the keyword __var__ and provide the variable name and assign a initial value to the variable. 

```
//Variable declarations

var x = 0

var z = 10.0

var y = "String"

var b = true 
```

In FLY variable names are case-sensitive, and have no semantic meaning (that is, the language will not treat variables differently based on their names).

```
// These are two different variables

var Xyz = 10

var XYz = 10 
```

In the declaration of the variables it is not necessary to declare the type. The type is inferred from the initial value associated with the variable and cannot change over time.
Variable names must begin with a letter (A-Z or a-z) or $ symbol. Subsequent characters may also include digits (0-9). The followyn is the regular expression used to validate the variables name:
```
(a..z|A..Z|$) (a..z|A..Z|$|_|0..9)*
```

## Data Types

FLY provide two set of types named __Basic__ and __Domain__ types.

FLY Basic types, inherited by Java, are shows in the following table together with their descriptions.

| Type name  | Type definition  												|
|:----------:|:----------------------------------------------------------------:|
| Integer 	 |   	(0..9)+														|
| Float  	 |   (0..9)+ '.' (0..9)+											|
| Boolean  	 |   	'true' or 'false'											|
| String  	 |   " ( \ . \| !( \ \| " ) " )* \| ’ ( \ . \| !( \| ’) ’ )*		|

Fly also uses arrays and matrices (2d and 3D), that are a collection of similar data types. 

```
//declare an array

//declare a 2D matrix

//declare a 3D matrix
```

FLY defines the notion of __Range__, which represents a range integers values in the natural numbers order. To u

Ranges are useful in loops and (parallel) FLY functions executions. 

```
//examples of Range

```

In addition to Basic types, FLY provides several domain types that enable the users to interact and communicate with the computing back-ends.

| Type name  | Type definition  													|
|:----------:|:----------------------------------------------------------------:	|
| Object 	 |   Heterogeneous collection of basic data type element				|
| Environment|   Abstraction of SMP (local) or FaaS back-ends						|
| Random  	 |   Generator of pseudo-random numbers.								|
| File  	 |   I/O operations on files, images and dataframe						|
| Channel  	 |   CSP structure for communicate between functions and main process	|

### Object Domain Type

The main domain type is the __object__ type.
A FLY object is a heterogeneous collection of basic types elements. Essentially a FLY object is a mixture between an array and map data structure, which stores data in key/value pair. The value of an element can be accessed in two different ways: by position (like arrays) or by key (like maps). When a new value is assigned to a given key/position a new element is created, otherwise the new value replaces the previous one. Moreover, the FLY object provides several features, which enable to use the object in a FIFO or LIFO behavior.

```
// FLY Object declaration and usage
```

### Environment Domain Type

The Environment type represents an abstraction of a execution environment. It provides the ability to interact with a a cloud provider or a SMP system. Different environments are treated in the same way by FLY, leaving the details relating to the specific use of each execution environment to the FLY compiler. 
Environments are declared using the word env followed by some parameters that characterize a back-end. In this preliminary version of the FLY compiler, the SMP and AWS back-ends are supported.
The simplest back-end is smp, and enables the user to exploit the local SMP architecture.
To following snippet of code show how to declare an smp back-end:

```
// Declare a smp backend
```
The other back-end types enable the user to exploit the computational power of Cloud infrastructure. The following table shows the supported Cloud Environment:

| Faas Cloud Computing Infrastructure | Supported          | Under development  | Future development |
|:-------------------------------------:|:--------------------:|:--------------------:|:--------------------:|
| Amazon AWS                          | :heavy_check_mark: |                    |                    |
| Microsoft Azure                     |                    | :heavy_check_mark: |                    |
| Google Function                     |                    |                    | :heavy_check_mark: |
| IBM Bluemix/Apache OpenWhisk        |                    |                    | :heavy_check_mark: |

To following snippet of code show how to declare an AWS back-end:

```
// Declare an AWS back-end

```

### Random Domain Type

Random type represents a pseudorandom number generator object, and it is defined using the keyword random, possibly with a integer value (the seed).

```
```


### File Domain Type

File object is the abstraction of file in FLY. 
The language supports four file formats: csv, json, img, and txt, defined by the parameter _format_. 
A new file object is defined using the keyword __file__. Moreover, the file object is described by the parameter path (the file system path) or
a reference to the file, and by the separator sep, that is an optional parameter defined for CSV files.
The language provides two methods to access files, which depend on where the file is stored: local or remote.

```
```

FLY has a specific focus on csv files managing them as a Dataframe (similar to R language dataframes). The memory is seen as a matrix structure, allowing the user to access to rows and columns, while it provides dedicated operations for querying, filtering, random access, etc. Dataframe operations are described in details in the language documentation. 

### Channel Domain Type

Channel type is a domain type that enables the synchronization and communication between FLY functions and/or the main program. Channels follow the
Communicating Sequential Processes (CSP) definition [24]. A new channel is defined on an environment, and can be used for the communication between functions executing on the same back-end or from the main program to a back-end and viceversa. Channels are blocking message queues, that is, when the main program or a function tries to receive a message from a channel, the execution is blocked until a new message arrives on the channel. Messages are sent on a channel using the character ‘!’ (e.g., the instruction ch!VAL sends a message V AL on the channel ch), while the character ‘?’ is used to receive messages, (e.g., the instruction x=ch? reads a message from the channel ch and assigns the obtained value to the variable x).
```
```
Channels use network infrastructures to communicate with the cloud environment and for this reason a serialization mechanism is required for sending/receiving messages. FLY defines the serialization for objects, files, images and basic types. It is not allowed to send messages containing Environments, channels, and random objects.

### Type Casting

FLY uses a dynamic type checking, that is variable types are automatically inferred at run time during the first assignment. Moreover, FLY typing is strong, the type of a variable cannot change during the execution time. FLY provides support for explicit types casting as in Java and C#.
Types casting is admitted on basic and domain types, but it is forbidden on environments and channels.
