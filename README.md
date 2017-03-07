[![Build Status](https://travis-ci.org/simplymequeeny/dynamodb-client-web-gui.svg?branch=master)](https://travis-ci.org/simplymequeeny/dynamodb-client-web-gui)
[![codecov](https://codecov.io/gh/simplymequeeny/dynamodb-client-web-gui/branch/master/graph/badge.svg)](https://codecov.io/gh/simplymequeeny/dynamodb-client-web-gui)

# dynamodb-client-web-gui
A simple web client to view documents from AWS DynamoDB or DynamoDB Local

## Getting Started

These instructions will help you how to make the dynamodb-client-web-gui web application running.

### Prerequisites

* Java 8 or newer
* [AWS Credentials File](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html) (if connecting to AWS DynamoDB) 
* DynamoDB Local Jar [Download & Setup](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html)

### Running the dynamodb-client-web-gui Web Application

#### 1.) Download the latest release [executable jar](https://github.com/simplymequeeny/dynamodb-client-web-gui/releases/latest).

Before running the dynamodb-client-web-gui web application make sure that your AWS credentials file is in place.

* **Using AWS DynamoDB**

```
java -jar dynamodb-client-web-gui-1.0.0.jar
```

* **Using DynamoDB Local**

Your Dynamodb Local must be up and running

```
java -jar dynamodb-client-web-gui-1.0.0.jar --endpoint.url=[your dynamodb local endpoint]
```

#### 2.) Open up a browser then go to http://localhost:9100

Wait for the web server to start up before connecting

#### 3.) Check [Wiki](https://github.com/simplymequeeny/dynamodb-client-web-gui/wiki) on how to use it

## TODO

- [ ] Creating records
- [ ] Updating records
- [ ] Deleting records
- [ ] Filtering records
- [ ] Importing data from AWS DynamoDB]

## Built With

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Programming Language
* [Spring Boot](https://spring.io/guides/gs/spring-boot) - The web framework
* [Mockito](http://site.mockito.org/) - Unit testing
* [AngularJS 1](https://angularjs.org/) - Dynamic UI 
* [AWS SDK](https://aws.amazon.com/documentation/dynamodb/) - API
* [ui-grid](http://ui-grid.info/) - Grid data display
* [angular-json-tree](https://github.com/awendland/angular-json-tree) - JSON Tree display
* [Bootstrap](http://getbootstrap.com/) - UI
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

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
mvn clean spring-boot:run -Drun.arguments="--endpoint.url=<your dynamodb url>[,--profile=<profile>]"
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

## Authors

* **Quennie Teves** - *Initial work* - [simplymequeeny](https://github.com/simplymequeeny)

See also the list of [contributors](https://github.com/simplymequeeny/dynamodb-client-web-gu/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE](/LICENSE) file for details

## Acknowledgments

* [Darky Theme](https://bootswatch.com/darkly/) - Bootstrap Theme from [bootswatch](bootswatch.com)
