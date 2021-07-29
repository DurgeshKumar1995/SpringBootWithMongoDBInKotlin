# SpringBootWithMongoDBInKotlin

-> In this project using technologies:
* Spring Boot : Framework(2.4.8) and Dependency management(1.0.11.RELEASE)
* MongoDB (5.0.0)
* Kotlin (1.4.32)
* JAVA (1.8)
* Gradle (6.9)

-> System 
* MAC(iOS:10.14.6)

-> IDE
* Android Studio(4.1)

-> Packaging type: WAR

-> Configuration:<br>
  > spring.data.mongodb.host=localhost<br>
   spring.data.mongodb.port=27017<br>
   spring.data.mongodb.database=students<br>
   server.port=8099<br>

> <!--> # Avoid White level error-->
> server.error.whitelabel.enabled=false <br>
>  <!--#logging.level.ROOT=DEBUG--><br>



# [Spring boot](https://spring.io/projects/spring-boot)
Spring boot project bacic CURD operation.

> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".<br>
 We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need minimal Spring configuration.
 
 ## Features
 * Create stand-alone Spring applications
 * Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)
 * Provide opinionated 'starter' dependencies to simplify your build configuration
 * Automatically configure Spring and 3rd party libraries whenever possible
 * Provide production-ready features such as metrics, health checks, and externalized configuration
 * Absolutely no code generation and no requirement for XML configuration


# Database
 [MongoDB](https://docs.mongodb.com) 
  > MongoDB is a source-available cross-platform document-oriented database program. Classified as a NoSQL database program, MongoDB uses JSON-like documents with optional schemas. MongoDB is developed by MongoDB Inc. and licensed under the Server Side Public License

# Programming Language
* Kotlin
* JAVA

## [Kotlin](https://kotlinlang.org)
> Kotlin is a modern but already mature programming language aimed to make developers happier. It’s concise, safe, interoperable with Java and other languages, and provides many ways to reuse code between multiple platforms for productive programming.

## [JAVA](https://www.java.com/en/)
> Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.

# [Gradle](https://gradle.org)
> Gradle is a build automation tool for multi-language software development. It controls the development process in the tasks of compilation and packaging to testing, deployment, and publishing. Supported languages include Java, C/C++, and JavaScript.




##Request and Response<br>

BaseURL : http://localhost:8099

Request: http://localhost:8099/api/v1/create<br>
Body: row with json<br>
> {
    "name":"Dinesh Kumar",
    "gender":"Male",
    "dob":"25/01/1997",
    "country":"Nepal"
}


Response:<br>
> {
    "status": "OK",
    "message": "Request Successfully",
    "data": {
        "id": 10,
        "name": "Dinesh Kumar",
        "gender": "Male",
        "dob": "25/01/1997",
        "country": "Nepal"
    }
}

