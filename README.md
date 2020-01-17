
|Resources| |
|:-----------------:|:-:|
|  Gitter chat 		| [![Join the chat at https://gitter.im/isislab-unisa/fly-language](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/isislab-unisa/fly-language?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)  |
|  Building status 	| [![Build Status](https://travis-ci.org/spagnuolocarmine/FLY-language.svg?branch=master)](https://travis-ci.org/spagnuolocarmine/FLY-language) |
<!--|  Coverage status 	| [![Coverage Status](https://coveralls.io/repos/github/spagnuolocarmine/FLY-language/badge.svg?branch=master)](https://coveralls.io/github/spagnuolocarmine/FLY-language?branch=master)  |
|  Documentation    | [https://spagnuolocarmine.github.io/FLY-language/](https://spagnuolocarmine.github.io/FLY-language/) |-->


# FLY a Domain Specific Language for scientific computing on the Multi Cloud 

FLY is a parallel work-flow scripting imperative language inspired by functional languages peculiarities.
FLY uses two type of run-time environment: the local machine and/or cloud infrastructure. FLY perceives a cloud computing infrastructure as a parallel computing architecture on which it is possible to execute some parts of its execution flow in parallel.

FLY main goals are:
* ___expressiveness___, in deploying scientific large-scale computing work-flows;
* ___programming usability___, writing .fly program should be straightforward for domain experts, while the interaction with the cloud environment should be completely transparent; the users do not need to know the cloud providers APIs;
* ___scalability___ either on symmetric multiprocessing (SMP) architectures or cloud computing infrastructures supporting FaaS. 

FLY is compiled in native code (Java code) and it is able to automatically exploits the computing resources available that better fit its computation requirements. The innovative aspect of FLY is constituted by the concept of ___FLY function___. A FLY function can be seen as an independent block of code, that can be executed concurrently.

| Faas Cloud Computing Infrastructure | Supported          | Under development  | Future development |
|:-------------------------------------:|:--------------------:|:--------------------:|:--------------------:|
| Amazon AWS                          | :heavy_check_mark: |                    |                    |
| Microsoft Azure                     | :heavy_check_mark: |                    |                    |
| [LocalStack](https://localstack.cloud/)| :heavy_check_mark: |                 |                    |
| Google Function                     |                    | :heavy_check_mark: |  |
| IBM Bluemix/Apache OpenWhisk        |                    |                    | :heavy_check_mark: |

Supported Languages:

|Faas Cloud Computing Infrastructure |Python | Javascript|
|:-------------------------------------:|:--------------------:|:--------------------:|
| Amazon AWS                               | :heavy_check_mark: |:heavy_check_mark:   |
| Microsoft Azure                          | :heavy_check_mark: |:heavy_check_mark:   |
| [LocalStack](https://localstack.cloud/)  | :heavy_check_mark: |:heavy_check_mark:   |

### Requirements

- Ubuntu or OSX OS
- Java 8 (or greater)
- Apache Maven 3 (or greater)
- Amazon AWS CLI and SDK
- Python 3
- Node.js 8.10

## Standalone FLY compiler

Download the tar.gz at the following link:  


Unpack the __fly-compiler-ALPHA-01.tar.gz__ 
```
tar -xvzf fly-compiler-ALPHA-01.tar.gz
```

To compile and run a .fly program:
```
cd <path-to-compiler> 

./fly-cc <name-example>.fly
```


The Standalone compiler are tested on several platform:

| Platform / Architecture     | x86 | x86_64 |
|-----------------------------|-----|--------|
| Windows (7, 8, 10, ...)     | x   | x      |
| Ubuntu (18.04 or later)     | ✓   | ✓      |
| OSX (10.12 Sierra or later) | ✓   | ✓      |

## License

Copyright ISISLab, 2019 Università degli Studi di Salerno.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

