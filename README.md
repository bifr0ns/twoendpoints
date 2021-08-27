# Two endpoints

A simple project regarding two endpoints. With one endpoint we get the classic Hello World message, and with the other endpoint we can get the rates regarding the value of a Bitcoin (**BTC**).

## Technologies

This project runs with Java 11, Spring and Maven. In order to run the project we need to install [Java](https://www.oracle.com/mx/java/technologies/javase-jdk11-downloads.html) and [Maven](https://maven.apache.org/install.html).

## Build and run the project

First we need to build the project with maven

    mvn clean install -DskipTests=true

Then we can **run** the project using the next command

    mvn spring-boot:run

## Functionality

The project contains two endpoints _/hello-world/{name}_ and _/rates/{currency}_

We can hit the endpoints with the following link http://localhost:8080/hello-world

### Hello World endpoint

There are two ways that we can hit _/hello-world_, one without a name param and the other one with a param _/hello-world/Alexis_ . Both will return a message with Hello World, if you wrote a name it will return your name as well.

    {
    	"message":  "Hello World, Alexis"
    }

### Rates endpoint

With the rates endpoint we are using the [bitpay API](https://bitpay.com/api/) and we can get the rates regarding the value of a Bitcoin (**BTC**). We can hit _/rates/{currency}_ with currency or no currency, just like _/rates/_ . When hitting URL rates with no currency we get a list of all the currencies available in the API, which are 170. When we use a currency we'll get that currency value regarding the Bitcoin.

For example with /rates/mxn we get

    {
    	"name":  "Mexican Peso",
    	"code":  "MXN",
    	"rate":  975160.66
    }

## Tests

In order to run the tests we need to run the project first, because we are going to be hitting our endpoints. Once we have the project up and running we can use the command

    mvn test
