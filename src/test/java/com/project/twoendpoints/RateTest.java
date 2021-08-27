package com.project.twoendpoints;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class RateTest {

	@Test
	public void whenRequestingRatesStatus200MustBeReturned() {
		RestAssured.get("/rates").then().assertThat().statusCode(200);
	}

	@Test
	public void whenRequestingRatesAllMustBeReturned() {
		RestAssured.get("/rates").then().statusCode(200).assertThat().body("size()", is(170));
	}

	@Test
	public void whenRequestingRateUSDMustBeReturned() {
		RestAssured.get("/rates/usd").then().statusCode(200).assertThat().body("name", equalTo("US Dollar"));
	}

	@Test
	public void whenRequestingRateNotFoundMustBeReturned() {
		RestAssured.get("/rates/alexis").then().statusCode(404).assertThat().body("message", equalTo("404: Not Found"));
	}
}
