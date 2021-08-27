package com.project.twoendpoints;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.Matchers.*;

public class HelloWorldTest {

	@Test
	public void whenRequestingHelloWorldMustBeReturned() {
		RestAssured.get("/hello-world").then().statusCode(200).assertThat().body("message",
				equalTo("Hello, World"));
	}

	@Test
	public void whenRequestingHelloWorldWithNameMustBeReturned() {
		RestAssured.get("/hello-world/alexis").then().statusCode(200).assertThat().body("message",
				equalTo("Hello World, alexis"));
	}

	@Test
	public void whenRequestingHelloWorldWithTypoMustNotBeReturned() {
		RestAssured.get("/hello-world1").then().statusCode(404).assertThat().body("error",
				equalTo("Not Found"));
	}
}
