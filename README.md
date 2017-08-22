[![Build Status](https://travis-ci.org/simplymequeeny/dynamodb-client-web-gui.svg?branch=master)](https://travis-ci.org/simplymequeeny/dynamodb-client-web-gui)
[![codecov](https://codecov.io/gh/simplymequeeny/dynamodb-client-web-gui/branch/master/graph/badge.svg)](https://codecov.io/gh/simplymequeeny/dynamodb-client-web-gui)
[![Dependency Status](https://www.versioneye.com/user/projects/59650c19368b080016f705dc/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/59650c19368b080016f705dc)

# dynamodb-client-web-gui
A simple web client to view documents from AWS DynamoDB or DynamoDB Local

## Getting Started
These instructions will help you how to make the dynamodb-client-web-gui web application running.

### Prerequisites
* Java 8 or newer
* DynamoDB Local Jar [Download & Setup](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html)
* [AWS Credentials File](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html) (if connecting to AWS DynamoDB) 

### Running the dynamodb-client-web-gui Web Application
#### 1.) Download the latest release [executable jar](https://github.com/simplymequeeny/dynamodb-client-web-gui/releases/latest).

* **Using DynamoDB Local**
Your Dynamodb Local must be up and running

```
java -jar dynamodb-client-web-gui-1.0.0.jar --endpoint.url=[your dynamodb local endpoint]
```

* **Using AWS DynamoDB**
Before running the dynamodb-client-web-gui web application make sure that your AWS credentials file is in place.

```
java -jar dynamodb-client-web-gui-1.0.0.jar [--profile=<aws profile>]
```

#### 2.) Open up a browser then go to http://localhost:9100
Wait for the web server to start up before connecting

#### 3.) Check [Wiki](https://github.com/simplymequeeny/dynamodb-client-web-gui/wiki) on how to use it

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

See [Guidlines](CONTRIBUTING.md)

## Author

* **Quennie Teves** - *Initial work* - [simplymequeeny](https://github.com/simplymequeeny)

See also the list of [contributors](https://github.com/simplymequeeny/dynamodb-client-web-gu/contributors) who participated in this project.

## Motivation
I started this web application because I use DynamoDBLocal during the development and testing stages of the ReST WS project that I am involved with.

## License

This project is licensed under the MIT License - see the [LICENSE](/LICENSE) file for details

## Acknowledgments

* [Darky Theme](https://bootswatch.com/darkly/) - Bootstrap Theme from [bootswatch](bootswatch.com)
