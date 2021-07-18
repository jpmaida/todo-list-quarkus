# ToDo List API using Quarkus

## Description
This branch holds the ToDo List API using in-memory database operations.

## Prerequisites
* JDK >= 11
* Maven >= 3.6.0
* Quarkus Maven Plugin version 2.0.0.Final (comes included with Maven)

## How this project was created ?
To generate a new Quarkus project:
```
mvn io.quarkus:quarkus-maven-plugin:create \ 
    -DprojectGroupId=com.github.jpmaida \
    -DprojectArtifactId=todo-list-backend \ 
    -DclassName="com.github.jpmaida.ToDoListResource" \ 
    -Dpath="/todolist"
```

Adding extensions to the project:
```
mvn quarkus:add-extension -Dextensions="quarkus-smallrye-openapi"
mvn quarkus:add-extension -Dextensions="quarkus-hibernate-orm-panache, jdbc-mysql, resteasy-jsonb"
```

## How to run ?
Run in development mode:
```
mvnw compile quarkus:dev
```

## Available endpoints:
* GET - /api/todolist
* POST - /api/todolist
* PUT - /api/todolist/{id}
* DELETE - /api/todolist/{id}
* GET - /api/todolist/envvars

## Extra!
To list all avaiable extensions:
```
mvn quarkus:list-extensions
```