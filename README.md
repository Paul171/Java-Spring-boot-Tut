## 3 ways to create java spring boot project ##
1. create java spring boot project via sping initializr website
2. Spring Boot CI
3. Spring Tool Suite -> Select spring starter project

## Configure spring boot project ##

1. Create a file named as "application.properties" under src/main/resources

2. you can refer the key from [Common configuration properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

## Connect to DB ##

1. Add @Entity to model class and specified the primary key field with @Id
2. Implements interface extends CrudRepository
3. Specify the CrudRepository<(class to manipulate), (data type of primary key)>
4. if implement self-defined method, should follow the CrudRepository syntax
    1. e.g. search by properties: findBy<PropertyName>
    2. if the property is an object, you have to specifiy which property under this object that you would like to search.
        1. > findByTopicId

## Deploy a independent jar file ##
1. cd yo current project directory
2. compile program with `mvn clean install` to confirm everything is fine and able to compile
3. `java -jar target/<project jar file name>` to start the spring boot application

Besides, you can deploy it as a war to external web container
1. change `<packaging>jar</packaging>` to `<packaging>war</packaging>` in the `pom.xml`
2. run `mvn clean install`, the war file will be generated in the target folder

## Application monitoring ##
1. add `spring-boot-starter-actuator` to `pom.xml` as a dependency.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
2. browse the json response status from `/health` url 

3. you can change the port by modifying `application.properties` file with `management.port` key

**_ you can refer the document of [spring boot actuator](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready) _**