# JsonQ

### Prerequisites

What things you need to install the software and how to install them

```
- Eclipse
- JDK1.8
- Plugins
  - xText
  - xTend
  - xSemantics    
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

1. In eclipse,import the project by cloning the git uri
      - https://github.com/suhabb/JsonQ.git
2. Add below jars as external jar file(availabe in lib_jars folder of the JsonLib Project) in JsonLib Project.
    - json-20201115.jar (https://mvnrepository.com/artifact/org.json/json/20201115)
    - junit-4.0.jar (https://mvnrepository.com/artifact/junit/junit/4.0
3. Go to eclipse JsonQRuntime Project -> Properties -> Java Build Path ->Classpath -> Project add `JsonLib` as its a dependent project.This should remove all the compilation errors in the JsonQRunTime Project.
4. Add json-20201115.jar as external jar file in JsonQRuntime project .
5.  In JasonQRuntime project, create a resource package under src folder and copy this file ``covid_vaccination.json`` available in JsonLib (src/resource) folder. See below for link:
 ``  
   - The ``covid_vaccination.json`` file is available in JsonLib project.
      - https://github.com/suhabb/JsonQ/tree/main/JsonLib/src/resource
  ``
  - src/resource
      - covid_vaccination.json
  
## JsonLib
  - JsonLib is the library project to run RuntimeJsonQEclipse( ``JsonQRuntime``).
  - This project takes json query parameters and returns the search results in Java Swing Executables files
  - Import jar file's from "lib_jars" folder to eclipse ``Import External Jars section``.
  - There is a database file called ``covid_vaccination.json`` under src/resource package.This file is used against returning the search result of the query.
 
## JsonQRuntime
  - This project is Runtime Isntance of the JsonDSL project.
  - https://github.com/suhabb/JsonDSL.git
     
### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system


## Built With

* Eclipse 

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.
 - Poonam Sarode
 - Suhail Mir


## Authors

* Poonam Sarode
* Suhail mir

## Acknowledgments

* Stefan Schzelar

