# The WIND programming Language

WIND is an open source Domain Specific Language for scientific computing on the cloud.

## General Information

WIND is written using Xtext a framework for development of programming languages and domain-specific languages. WIND code is transformed in pure Java code that you can run on a Java Virtual Machine.

## Build Instructions

On Unix, Linux, BSD, macOS, and Cygwin:

    ./configure
    make
    make test
    sudo make install

## Getting Started

WIND is designed as a scripting language that use as run-time environment, the local machine or a cloud infrastructure, the script automates the execution of tasks that could alternatively be executed one-by-one by a human operator.
### Cloud infrastructure

- AWS


### Keywords
    
    
    bin simulation = {name:"hello",path="./sim.sh"} 
    aws env = {name="aws",accessKeyId="K",secretKey="S",instancetype="t2.micro",instancenumber="4"}
    opt myOpt = {name="ga",chromosome="[10,0.5]"}
    
    //WIND Language channal for inter-call communications
    channel c = {name="c"} //queue topic based 
    for i to 10
    async execute func(){ print <-c} on aws
    async execute func(){ for i to 10 {c <- random.int+""}} 
    
    //Function declaration 
    func eval(int x){
	    y = x*10
	    return y
    }
    //Execute function on local machine
    var result= execute func for [1,2,4,5]
    print result
    
    //Execute function on cloud
    var result = parallel execute eval for [1,2,3,5] on aws
    
    var a = [1,2,3,4,5]
    var result = parallel execute {func (int x){return x*10}} for a on aws
    
    
    var b = {name="test",value=4}
    var results1 = parallel execute {func (int x){return x*10}} for a on aws
    //result=[undefined,40]
    
    var tests = [10,100,40,40]
    var results2 = paralell execute myOpt for tests
    //execute on local machine the ga algorithms for 10 times, 100 times, and so on
    
    //Interation
    func z(){return random.int}
    int i=0
    while (i < 100)
        i = execute z on aws
    print "val of i" +i
    
    
    //Data object create matrix data from csv or json
    data d1 = {type="csv",name="file.csv",sep=",")
    data d2 = {type="json",name="file.json")
    
    func eval(x){return "orignal value:"+x+" absolute value"+abs(x)}
    var result3=async parallel execute myOpt for data on aws then func
    print result3
  
WIND Optimization via Simulation process  
    
    bin simulation = {name:"hello",path="./sim.sh"} 
    aws env = {name="aws",accessKeyId="K",secretKey="S",instancetype="t2.micro",instancenumber="4"}
    
    
    data initial_condition = {type="csv",name="init_opt.csv",sep=",")
    channel c = {name="evaluation"}
    func eval(x){ 
    	var result = execute sim for x on aws
	c <- result
    }
    opt myOpt = {name="ga",chromosome=initial_condition,evaluationfunction=eval}
  
    var population=execute myOpt for [100]
    func getOptResult(){
    	var new_population = []
	for i to 100
		new_population[i] <- c
	return new_population
    }
    var j = 0
    while j < 50
    {
    	new_population=getOptResult()
	execute myOpt for [100]
    }
    
    

