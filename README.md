phonebook
=========

# 1. Service description:

This application provides REST service for phone book.

The central entity of this service is contact. It consists from:

    id          - it is unique identifier for contact. It generates by DB;
    name        - name of contact;
    address     - contact address;
    localPhone  - local phone;
    intPhone    - international phone;

JSON is used as data-interchange format.

For example:

    {
        "id":"54647e2d325c8615bf3304de",
        "name":"Vasya",
        "address":"Dnepropetrovsk",
        "localPhone":"056",
        "intPhone":"380"
    }          

##1.1. There is five methods of phone book service: 
### 1.1.1. GET http request to url http://{contextPath}/rest/contacts
This method returns array of all contacts in phonebook
  
### 1.1.2. GET http request to url http://{contextPath}/rest/contacts/name/{name}
This method finds all contact with specified name {name}

### 1.1.3. PUT http request to url http://{contextPath}/rest/contacts with "Content-Type: application/json" in header 
This method store specified contact in DB.
Example of input contact:

    {
                "name":"Vasya",
                "address":"Adress",
                "localPhone":"056",
                "intPhone":"380"
    }

### 1.1.4. POST http request to url http://{contextPath}/rest/contacts with "Content-Type: application/json" in header 
Current method modifies specified contact by id in DB.

It's important: Input contact must contain id. If Contact with specified id will be found than appropriate record will be modified with new field values. Otherwise - there is no modifications in DB.

Example of input contact:

    {
      "id":"54647e2d325c8615bf3304de",
      "name":"newName",
      "address":"newAddress",
      "localPhone":"newLocalPhone",
      "intPhone":"newInternationalPhone"
    }

### 1.1.5. DELETE http request to url http://{contextPath}/rest/contacts/{contactId}
Specified method remove contact from DB by id ({contactId}).
If contact will be found in DB than it will be removed, otherwise - there is no modifications in DB.

# 2. Building and Deploying of phonebook project:

## 2.1 First off all you need to clone project from https://github.com/javadevia/phonebook.git.

## 2.2. MongoDB is used like storage. You have to install MongoDB http://docs.mongodb.org/manual/core/introduction/ or use remote MongoDB.

For connection to appropriate DB some properties have to be changed in file database.properties(default values):

    mongo.host=localhost
    mongo.port=27017
    mongo.db=phonebook
    mongo.username=
    mongo.password=

## 2.3. Building of phonebook:

Maven is used like build automation tool in this project.
You can use appropriate maven command to build this project and get war file as result.

After that you can deploy this war on servlet container(for example, Tomcat) or application server.

You can also use tomcat maven plugin to deploy and run this application locally or in remote server.

# 3. Uses:
##3.1 JAva 1.7
##3.2 Jersey 2.9 as REST Ftamework
##3.3 Spring 3.2.3.RELEASE Core, Web, Test
##3.4 Jersey-spring3 2.9 as bridge between Spring and Jersey
##3.5 Spring-data-mongodb 1.4.0.RELEASE
##3.6 Mongo-java-driver 2.12.4
##3.7 Dozer 5.5.1 as bean mapper.