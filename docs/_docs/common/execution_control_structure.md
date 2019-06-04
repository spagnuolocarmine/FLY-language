---
title: Execution control structure
permalink: /docs/common/execution_control_structure/
---
### Functions 

FLY functions are quite different from other scripting languages and follow a functional programming inspired definition. A FLY function represents a task or independent job of the main program and it is defined as a code block that can be executed concurrently. FLY functions are declared using the keyword func. Each FLY function can have a set of input parameters and may return a value usingthe word return.

```
```

FLY functions have a private scoping, that is only function parameters and local variable are visible in the body of the function. The input parameters are passed by copy, and they are considered as immutable. However, functions can avoid this limitations using channels. A channel declared in the main program or in a function running on the same environment can be directly used by a function. This also applies to environment objects. Notice that, the FLY language does not ensure that operations are admitted: if a function is executing on a backend B, the function can use only channels and objects available on the back-end B. FLY functions can be executed, like for standard languages, using their ID and parameters (in this
case functions are executed sequentially). In order to execute functions concurrently, FLY provides the fly statement that will be described in the following. The fly statement is not admitted in the body of a function (i.e., recursion is not allowed).

### FLY function execution

The definition of FLY functions is the consequence of the explicit parallel execution model of FLY. The language provides the keyword fly that enables
the user to execute concurrently a set of functions (the number of concurrent functions will depend on the back-end used and the user needs). The fly statement is similar to the for statement but the fly statement allows to specify the back-end environment (using the keyword on) and, possibly, callback functions (using the keywords then and thenall). In order to use the fly statement, functions must take only one input parameter (the iteration value) that is implicitly passed to the function execution.

```
```

The fly statement supports two kinds of function callbacks, declared using the keywords then and thenall. The then callback is executed after each FLY function execution, instead the thenall callback is executed after all FLY function executions. Then and thenall functions have to take only one input
parameter that, for then corresponds to the return value of a function execution, while for thenall is a FLY object containing all the return values obtained by all the function executions. FLY explores synchronous and asynchronous execution models. The previous construct defines the synchronous mode, in which the main program waits all functions termination. It is possible to execute functions asynchronously using the keyword async before the fly construct.
The async statement returns a special FLY object, named async-object, that enables the user to control and interact with the asynchronous execution. The async FLY constructor invocation immediately returns the control to the main program and the execution can continue. The user can control the status of the asynchronous functions invoking the method status() on the async-object and can wait the termination of all functions using the method waitall() or wait the termination of the first function by invoking the method wait().

```
``` 