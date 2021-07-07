# todo-list-quarkus

Prerequisites:
* JDK >= 11
* Maven >= 3.6.0
* Quarkus Maven Plugin version 2.0.0.Final (comes included with Maven)

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
```

Run in development mode:
```
mvnw compile quarkus:dev
```

To list all avaiable extensions:
```
mvn quarkus:list-extensions
```

