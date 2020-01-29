package com.weather.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.demo.constants.Endpoints;


public class GetCityByPostCodeTest
{
	@Test
	public void testGetByPostCode(){
		String city = "Sydney";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		param("q", city).
		param("appid", appid).
		when().
		get(Endpoints.ENDPOINT_GET_CITY_BY_NAME)
		.then().statusCode(200)
		.body("coord.lon", is(151.21f),
				"coord.lat", is(-33.87f),
				"weather.main", hasItems("Clouds"),
				//"weather.description", containsInAnyOrder("broken clouds", "scattered clouds"),
				"sys.country", equalTo("AU"),
				"name", equalTo("Sydney"),
				"cod",  equalTo(200))
		.log().all();

	}
	
	@Test
	public void testGetByPostCode2(){
		String city = "Brisbane";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		param("q", city).
		param("appid", appid).
		when().
		get(Endpoints.ENDPOINT_GET_CITY_BY_NAME)
		.then().statusCode(200)
		.body("coord.lon", is(153.03f),
				"coord.lat", is(-27.47f),
				"sys.country", equalTo("AU"),
				"name", equalTo("Brisbane"),
				"cod",  equalTo(200))
		.log().all();

	}
}
