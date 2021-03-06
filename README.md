# greet-in-java  [![Build Status](https://travis-ci.org/incrediblejagur/greet-in-java.svg?branch=master)](https://travis-ci.org/incrediblejagur/greet-in-java)

Simple app that greets a user in different languages.

Features included is as follows:

- Ability to greet a person in a choice of language.
- Ability to view all users greeted.
- Ability to view how many times a certain user was greeted.
- Ability to see how many unique users were greeted.
- Ability to clear/remove a specific user that was greeted.
- Ability to remove all users greeted.

  

## Getting Started
 
Clone this [respository](https://github.com/incrediblejagur/greet-in-java) to your machine from GitHub,
or download the jar file [greet-in-java.jar](https://github.com/incrediblejagur/greet-in-java/raw/master/greet-in-java.jar)
  

#### Cloning

  

- Go to the terminal and and copy and paste the following code:

  

```
$ git clone https://github.com/incrediblejagur/greet-in-java
```

  

### Prerequisites

  

What things you need to install the software and how to install them?

- Java
- You can check by running **'java -version'** in terminal/cmd


  

### Running app locally
- Open the terminal/cmd
- 'navigate to folder' e.g C:\Users\incrediblejagur\Desktop\greet-in-java, wherever you cloned it, or if you downloaded the jar file
  navigate to the folder that its in.
#### Using Windows
```
$ java -cp target/* net.main
```
#### Using Linux/MacOS
```
$ java -cp .:target/*: net.main
```
#### Run tests locally
- Install [maven](https://maven.apache.org/).
- Then run the below command.
```
$ mvn test
```
## Author
- [incrediblejagur](github.com/incrediblejagur)
