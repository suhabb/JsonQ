# JsonQ

## Prerequisites

What things you need to install the software and how to install them

```
- Eclipse
- JDK1.8
- Plugins
  - xText
  - xTend
  - xSemantics - 1.19.0   
```
## Getting Started JsonQ DSL

1. Open eclipse and ensure Text file encoding is set to UTF-8 from Windows->Preferences->General->Workspace.
2. Import project by using below git uri.
      https://github.com/suhabb/JsonDSL.git
2. Go to project ``uk.ac.kcl.course.JsonDSL`` and Run ->Eclipse Runtime instance.
3. This should open new runtime instance of eclipse.

## Getting Started Runtime

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

1. In the runtime eclipse, ensure Text file encoding is set to UTF-8 from Windows->Preferences->General->Workspace.
2. Import the project by cloning the git uri
      - https://github.com/suhabb/JsonQ.git
2. Add below jars as jar file(availabe in lib_jars folder of the JsonLib Project) in JsonLib Project.
    - json-20201115.jar (https://mvnrepository.com/artifact/org.json/json/20201115)
    - junit-4.0.jar (https://mvnrepository.com/artifact/junit/junit/4.0
3. Go to eclipse JsonQRuntime Project -> Properties -> Java Build Path -> Project -> Classpath add `JsonLib` as its a dependent project.This should remove all the compilation errors in the JsonQRunTime Project.
4. Add ``json-20201115.jar`` as jar file in JsonQRuntime project (Project -> Properties -> Java Build Path -> Project -> Libraries -> Classpath -> add JARs...) .
5. In JsonQRuntime project, create a resource package under src folder and copy this file ``covid_vaccination.json`` available in JsonLib (src/resource) folder if not already present. See below for link:
      - The ``covid_vaccination.json`` file is available in JsonLib project.
        - https://github.com/suhabb/JsonQ/tree/main/JsonLib/src/resource
      - src/resource
        - covid_vaccination.json
7. You can edit/add queries in JsonQ.jq file and save it which will update file in src-gen folder.
8. Add src-gen in build path and Run the application as Java application to see the result set.
```
Note: Ensure src and src-gen folders are in build path. 
```
  
## JsonLib
  - JsonLib is the library project to run RuntimeJsonQEclipse( ``JsonQRuntime``).This project takes json query parameters and returns the search results in Java Swing Executables files
  - There is a file called ``covid_vaccination.json`` under src/resource package.This file is used as database source.
 
## JsonQRuntime
  - This project is Runtime Instance of the JsonDSL project which contain ``.jq`` extension file for writing queries.
     
## Running the Project

1. In runtime eclipse, if the JsonQ.jq file does not exist, then create a new file with extension ``<filename>.jq`` under ``/src`` package.
    ```
    Example: JsonQ.jq
    ```
3. Open ```JsonQ.jq``` file and write a query like below :
    - Use ``ctrl + space`` for suggestion.
    - Use `quick fix` for errors.
    ```
      - GET DATA WHERE isVaccinated "Yes" END
      - GET DATA WHERE firstName "Ami" AND gender "Female" END
      - GET COUNT WHERE isVaccinated "Yes" AND gender "Male" END
      - GET AVG "income" WHERE isVaccinated "No" AND gender "Female" END
    ```
    
  4.  After writing the query save the file, and you see that ```JSONQueryMain.java``` file gets created under ``/src-gen`` folder. Right click on this file and run as Java application. A java swing executable console displaying results open for each query.
      ``Note: You may need to drag the console as they will be hidden behind each other.``
  5. This is the sample json database stored in `src/resource` directory againist which the query's are executed.If the query matches the data then it returns the results in Java Swing console: 
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

## Diagnostics

1. What to do when you get FileNotFoundException while Running the file ``JSONQueryMain.java`` (Runs As Main application)?
    - Check the file `covid_vaccination.json` is available in `src/resource` package of Runtime eclipse .If not copy the same file `covid_vaccination.json` from JsonLib `src/resource`(https://github.com/suhabb/JsonQ/blob/main/JsonLib/src/resource/covid_vaccination.json)  and add it in `src/resource` package of Runtime eclipse.

2. When you get compilation errors in JsonLib Project?
      - Add `jar files` from the ``lib_jars`` folder to the classpath(add as jar files) of the project.

3. When you get compilation errors in JsonQRuntime Project?
      - Add ``JsonLib`` project as external dependency project in the classpath.
      - Add ``json-20201115.jar`` in the classpath of JsonQRuntime Project.
       
## Contributing

 - Poonam Sarode
 - Suhail Mir

## Authors

* Poonam Sarode
* Suhail Mir

## Acknowledgments

* Dr. Steffen Zschaler

