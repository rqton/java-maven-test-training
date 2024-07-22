# Java Maven Test Training

This project is a simple test training to learn how to write tests in Java using JUnit, Mockito, AssertJ and Maven.
The directory structure is organized as follows:

- `src/main/java/com/training`: Contains basic files with a record, service, repository and enum.
- `src/main/test/com/training`: Contains tests files. 
- `pom.xml`: Describes the project and its configuration details used by Maven to build the project.

## Getting Started

The main goal is to write unit test for class `UserService` in `src/test/java/com/training/TODOUserServiceTest.java`

There is two different solutions provided in the same folder :
- `OKUserServiceTest` : Tests are written without using mockito junit extension
- `OKWithAnnotationsUserServiceTest` : Tests are written using mockito junit extension

### Prerequisites

- Java 21 or higher
- Maven (no need if you use project maven wrapper `./mvnw`)

### Installing

1. Clone the repository
2. Compile the project using maven : `./mvnw compile`

### Useful commands
- Run all the tests using maven : `./mvnw test`
- Run all the test of a specific class : `./mvnw -Dtest=TODOUserServiceTest test`
- Run a specific test of a specific class : `./mvnw -Dtest=TODOUserServiceTest#exercise_01_shouldGetUserFullName test`