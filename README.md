# dynamodb-client-web-gui
A simple web client to view documents from AWS DynamoDB or DynamoDB Local

## Getting Started

These instructions will help you how to make the dynamodb-client-web-gui web application running.

### Prerequisites

* Java 8 or newer
* [AWS Credentials File](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html) (if connecting to AWS DynamoDB) 
* DynamoDB Local Jar [Download & Setup](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html)

### Running the dynamodb-client-web-gui Web Application

#### 1.) Download the executable jar located in the dist folder.

Before running the dynamodb-client-web-gui web application you must choose which dynamodb you want to use or connect to.

* Using AWS DynamoDB
  
Your credential must be in place before running 

```
java -jar dynamodb-client-web-gui.jar
```

* Using DynamoDB Local

Your Dynamodb Local must be up and running

```
java -jar dynamodb-client-web-gui.jar --endpoint.url=[your dynamodb local endpoint]
```

#### 2.) Open up a browser then go to http://localhost:9100

Wait for the web server to start up before connecting

## TODO

* Create / Update / Delete records
* Filter records

## Built With

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Programming Language
* [Spring Boot](https://spring.io/guides/gs/spring-boot) - The web framework
* [AngularJS 1](https://angularjs.org/) - Dynamic UI 
* [AWS SDK](https://aws.amazon.com/documentation/dynamodb/) - API
* [ui-grid](http://ui-grid.info/) - Data display
* [angular-json-tree](https://github.com/awendland/angular-json-tree) - JSON Tree display
* [Bootstrap](http://getbootstrap.com/) - UI
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

TBD

## Versioning

TBD

## Authors

* **Quennie Teves** - *Initial work* - [simplymequeeny](https://github.com/simplymequeeny)

See also the list of [contributors](https://github.com/simplymequeeny/dynamodb-client-web-gu/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* [Darky Theme](https://bootswatch.com/darkly/) - Bootstrap Theme from [bootswatch](bootswatch.com)
