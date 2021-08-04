### README

The following is a summary of the steps that need to be followed in order to test the project:

*Quick Summary
This is a simple application that translate sentences based on the dictionary provided in the resource folder.
The application takes in a sentence and returns a translated one.
The application also gets a list of words that were translated with the number of times they were translated.

### How to run the application
This application can be run locally for testing purposes. Make sure you have mongodb running locally. To run mongodb locally, 
you can use the simple docker run as follows: 
```
docker run -d -p 27017:27017 -v ~/data:/data/db mongo

```
The application can be started locally as follows:
```
mvn clean spring-boot:run                                 


```

The following are examples of the URL that calls the rest endpoints:
```
localhost:8080/translator?sentence=Ala ma kota    
localhost:8080/translator/quotes?sentence=Ala ma kota
localhost:8080/ranking/list
```