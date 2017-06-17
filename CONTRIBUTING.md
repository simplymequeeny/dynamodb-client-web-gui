If you would like to contribute please see the instructions below.

### Setup
* Download the [DynamoDB](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html) Local jar or create an account in AWS to create tables in DymamoDB (Please visit AWS for more info)
* Install JDK 8
* Install Maven 3+ (I'm using v3.3.9)
* Get your favorite Java IDE (I'm using IntelliJ Community Edition)
* Forked this repository
* Create a branch for your changes

### Coding Guidelines
* Make sure that your changes has a corresponding test/s.  Can be in a separate test file or modify the existing file
* No need for comments as long as the codes are readable

### Testing
##### Start the web application
* if using AWS DynamoDB, make sure that your AWS credentials is in place.  The command line argument profile is optional.
```$xslt
mvn clean spring-boot:run [-Drun.arguments="---profile=<profile>"]
```
* if using DynamoDB Local, start your DynamoDB server first
```$xslt
mvn clean spring-boot:run -Drun.arguments="--endpoint.url=<your dynamodb url>"
``````
##### Open up a browser and navigate to http://localhost:9100
##### Execute all tests with code coverage
```$xslt
mvn cobertura:cobertura
```

### Submitting Your Changes
* Please make sure you run all the tests
* Push your branch in Github 
* Make a pull request.  In pull request please do not forget to add comment regarding the changes you want to submit.
* Monitor the pull request to make sure the Travis build succeeds. If it fails simply make the necessary changes to your branch and push it. Travis will re-test the changes.

Thanks!
