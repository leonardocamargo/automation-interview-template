#HOW TO USE THIS REPOSITORY
## Getting started

### Installing necessary software

* Install [git](http://git-scm.com/downloads), or [GitHub for Windows](http://windows.github.com/) if you want a GUI.

*  **(Linux/Mac OS X only)** Generate your [ssh keys](https://help.github.com/articles/generating-ssh-keys/).

* Install [Java 8 JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

* Install [gradle](https://gradle.org/install/)

* Clone the project using SHH or HTTPS

### Develop scenarios

#### Cucumber
- Create your step definitions inside the package `com.tiendanube.qe.e2e.interview.stepdefinitions`
- Create your feature files inside the folder `src/test/resources/features`

#### TestNG
- Create your test methods in the class InterviewTest located in the package `com.tiendanube.qe.e2e.interview.tests`


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