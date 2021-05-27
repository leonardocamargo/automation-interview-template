# HOW TO USE THIS REPOSITORY
## Getting started

### Installing necessary software

* Install [git](http://git-scm.com/downloads), or [GitHub for Windows](http://windows.github.com/) if you want a GUI.

*  **(Linux/Mac OS X only)** Generate your [ssh keys](https://help.github.com/articles/generating-ssh-keys/).

* Install [Java OpenJDK 8](https://adoptopenjdk.net/)

* Clone the project using SHH or HTTPS

### Develop scenarios

#### For Cucumber
- Create your step definitions inside the package `com.tiendanube.testharness.interview.cucumber.stepdefinitions`
- Create your feature files inside the folder `src/test/resources/features`

#### For TestNG
- Create your test methods in the class InterviewTest located in the package `com.tiendanube.testharness.interview.testng`


### Running the scenarios
Make sure to build the project first
 
 `$ ./gradlew build` (Linux/Mac OS)
 
 `> gradlew build` (Windows)

#### Cucumber

`$ ./gradlew runCucumber` (Linux/Mac OS)

`> gradlew runCucumber` (Windows)

#### TestNG

`$ ./gradlew runTestng` (Linux/Mac OS)

`> gradlew runTestng` (Windows)
