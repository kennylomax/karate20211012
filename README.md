mvn spring-boot:run
    http://localhost:8080/swagger-ui/index.html?configUrl=/crowdsourcing/swagger-config
    http://localhost:8080/h2-console
    http://localhost:8080/api/material/materials
mvn test -Dtest=KarateTestsFromCommandLineWithAppForTestCoverage 



https://howtodoinjava.com/swagger2/swagger-spring-mvc-rest-example/
https://www.baeldung.com/spring-rest-openapi-documentation
https://www.baeldung.com/spring-boot-h2-database
https://spring.io/guides/gs/accessing-data-jpa/
https://medium.com/fullstacked/restful-api-cheat-sheet-3f96fab970b8
https://devhints.io/rest-api


/**

mvn test : Normal Unit Tests with jacoco and gutter coverage 
mvn test -Dtest=KarateTestsFromCommandLineWithAppForTestCoverage 
mvn test -Dtest=KarateTestsFromCommandLineWithAppForTestCoverageParallalized
mvn test -Dtest=KarateTestsFromCommandLineRequiresRunningApp

Coverage @ target/site/jacoco/com.example.karatea.controllers/GreetingController.html
Karate @ target/karate-reports/karate-summary.html
*/
# karate20211012
