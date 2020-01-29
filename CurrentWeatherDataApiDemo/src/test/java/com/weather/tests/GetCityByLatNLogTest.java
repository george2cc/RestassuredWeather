package com.weather.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.demo.constants.Endpoints;


public class GetCityByLatNLogTest
{
	@Test
	public void testGetByPostCode(){
		String lon = "151.21";
		String lat = "-33.87";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		log().all().
		param("lon", lon).
		param("lat", lat).
		param("appid", appid).
		when().
		get(Endpoints.ENDPOINT_GET_CITY_BY_NAME)
		.then().statusCode(200).
		log().all()
		.body("coord.lon", is(151.21f),
				"coord.lat", is(-33.87f),
				//"weather.main", hasItems("Clouds"),
				"sys.country", equalTo("AU"),
				"id", is(6619279),
				"name", equalTo("Sydney"),
				"cod",  equalTo(200))
		.log().all();

	}
}
