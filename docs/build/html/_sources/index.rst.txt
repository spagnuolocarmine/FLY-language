.. butterfly-lang documentation master file, created by
   sphinx-quickstart on Wed Jan 31 14:53:12 2018.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Welcome to Butterfly Language's documentation!
==========================================

Butterfly language is a Parallel programming Domain Specific Language 
for scientific programming on a cloud computing infrastructure. 
Butterfly is a scripting language influenced by JavaScript (memory management), R (dataframe) and Java (flow control structure). 
A butterfly program is a script program that allows to execute automatically 
butterfly function (you have your butterflys swarm). 
A butterfly function is similar to functions in a functional programming. 
Each butterfly is executed on cloud infrastructure or local machine, 
and may communicate with the main programming flow and other 
butterfly function using communication channel.

Butterfly is untyped language ..

Features and philosophy
---------------

Butterfly born to fill the gap the programming complexity of the different APIs,
provided by the cloud computing vendors, and the scientific computing 
libraries support of the programming languages (such as R and Python).
Butterfly provides binding for Amazon AWS and is planned to release 
the support for Microsoft Azure in the 2.0 version.

Scientific programming library 
---------------

Butterfly could be seen as an holistic scientific programming library presented as form of DSL for scalable computing on the cloud.

Butterfly core provides algorithms for:

- Optimization
   * linear programming
   * quadratic programming
   * quadratically constrained quadratic 
   * second order cone programming
   * semidefinite programming
   * geometric programming
   * linear fractional programming
   * convex-concave fractional 
   * constraint-propagation
- Graph Algorithms
   * Travel Salesman
   * Vehicle Routing
   * Clique
   * Coloring
   * Matching
   * Scoring
   * Shortestpath
   * Spanning
   * Tour
   * Isomorphism
- Data structure sorting
- Genetic Algorithms
- Searching
- Machine Learning

.. toctree::
   :maxdepth: 2
   :caption: Contents:
    syntaxandsemantics
    libraries
    implementations
    tutorial
   

Indices and tables
==================

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`
