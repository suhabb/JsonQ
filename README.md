# JsonQ



## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
1. Install Eclipse 
2. Install JDK1.8
3. Import the project by cloning the git uri
      - https://github.com/suhabb/JsonQ.git
4. Add JsonLib project in JsonQRuntime Project 
5. Add json  jar as external jar(avaialbe in lib_jars folder of the Json_lib Project)
    - json-20201115.jar (https://mvnrepository.com/artifact/org.json/json/20201115)

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


## JsonLib
  - JsonLib is the helper project to run RuntimeJsonQEclipse( ``JsonQRuntime``).
  - This project takes json query patameters and return the search results in Java Swing Executables files
  - Import jar file from "lib_jars" folder to eclipse ``Import External Jars section``.
  - There is a database file called ``covid_vaccination.json`` under src/resource package.This file is used against returning the search result of the query.
 

 #### Jars Required
    - json-20201115.jar (https://mvnrepository.com/artifact/org.json/json/20201115)
    - junit-4.0.jar (https://mvnrepository.com/artifact/junit/junit/4.0
 
 
## JsonQRuntime
  - Create a resource package under src folder and copy this file ``covid_vaccination.json`` to resource package
  ``
  - src/resource
      - covid_vaccination.json
   ``  
   - The ``covid_vaccination.json`` file is available in JsonLib project.
      - https://github.com/suhabb/JsonQ/tree/main/JsonLib/src/resource
     





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

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* Eclipse 

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.
 - Poonam Sarode
 - Suhail Mir

## Versioning


## Authors

* Poonam Sarode
* Suhail mir

## Acknowledgments

* Stefan Schzelar

