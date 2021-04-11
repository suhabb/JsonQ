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
3. Go to eclipse JsonQRuntime Project -> Properties -> Java Build Path -> Classpath -> Project add `JsonLib` as its a dependent project.This should remove all the compilation errors in the JsonQRunTime Project.
4. Add ``json-20201115.jar`` as external jar file in JsonQRuntime project .
5.  In JsonQRuntime project, create a resource package under src folder and copy this file ``covid_vaccination.json`` available in JsonLib (src/resource) folder. See below for link:
      - The ``covid_vaccination.json`` file is available in JsonLib project.
        - https://github.com/suhabb/JsonQ/tree/main/JsonLib/src/resource
      - src/resource
        - covid_vaccination.json
  6. Run the JSONQueryMain.java file from the src package
  
## JsonLib
  - JsonLib is the library project to run RuntimeJsonQEclipse( ``JsonQRuntime``).This project takes json query parameters and returns the search results in Java Swing Executables files
  - There is a file called ``covid_vaccination.json`` under src/resource package.This file is used as database source.
 
## JsonQRuntime
  - This project is Runtime Isntance of the JsonDSL project.
  - https://github.com/suhabb/JsonDSL.git
     
## Running the Project

1. In runtime eclipse, create a new file with extension ``<filename>.jq`` under ``/src`` package.
    ```
    Example: JsonQ.jq
    ```
3. Open ```JsonQ.jq``` file and write a query like below :
    - Use ``ctrl + space`` for suggestion.
    - Use `quick fix` for errors.
    ```
      - GET DATA WHERE isVaccinated "Yes"
      - GET DATA WHERE firstName "Ami" AND gender "Female"
      - GET COUNT WHERE isVaccinated "Yes" AND gender "Male"
      - GET AVG "income" WHERE isVaccinated "No" AND gender "Female"
    ```
    
  4.  After writing the query save the file, and you see that ```JSONQueryMain.java``` file gets created under ``/src-gen`` folder. Right click on this file and       run as main program. A java swing executable console displaying results open for each query.
      ``Note: You may need to drag the console as they will be hidden behind each other.``
  5. This is the sample json database stored in `src/resource` directory againist which the query's are excuted.If the query matches the data then it returns the results in Java Swing console: 
  ```
      {
        "id": 1,
        "firstName": "Ami",
        "lastName": "Canlin",
        "gender": "Female",
        "countryCode": "BR",
        "cityName": "Cachoeiras de Macacu",
        "isVaccinated": "Yes",
        "income": "77142"
    },
    {
        "id": 2,
        "firstName": "Welby",
        "lastName": "Cogle",
        "gender": "Male",
        "countryCode": "CN",
        "cityName": "Qinglung",
        "isVaccinated": "Yes",
        "income": "77048"
    } ...
  ```
    

## Running the tests

Explain how to run the automated tests for this system


## Built With

* Eclipse 

## Contributing

 - Poonam Sarode
 - Suhail Mir


## Authors

* Poonam Sarode
* Suhail mir

## Acknowledgments

* Dr. Steffen Zschaler

