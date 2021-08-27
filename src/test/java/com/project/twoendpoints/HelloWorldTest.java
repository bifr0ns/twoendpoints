package com.project.twoendpoints;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class HelloWorldTest {

	@Test
	public void whenRequestingHelloWorldMustBeReturned() {
		RestAssured.get("/hello-world").then().statusCode(200).assertThat().body("message", equalTo("Hello, World"));
	}

	@Test
	public void whenRequestingHelloWorldWithNameMustBeReturned() {
		RestAssured.get("/hello-world/alexis").then().statusCode(200).assertThat().body("message",
				equalTo("Hello World, alexis"));
	}

	@Test
	public void whenRequestingHelloWorldWithTypoMustNotBeReturned() {
		RestAssured.get("/hello-world1").then().statusCode(404).assertThat().body("error", equalTo("Not Found"));
	}
}
