package com.weather.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.demo.constants.Endpoints;


public class GetCityByNameTest
{
	/**
	 *  Returns current weather observation - Given a Postal Code.
	 */
	
	@Test
	public void testGetByCityByName(){
		String city = "Sydney";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		log().all().
		param("q", city).
		param("appid", appid).
		when().
		get(Endpoints.ENDPOINT_GET_CITY_BY_NAME)
		.then().statusCode(200).log().all()
		.body("coord.lon", is(151.21f),
				"coord.lat", is(-33.87f),
			//	"weather.main", hasItems("Clouds"),
				//"weather.description", containsInAnyOrder("broken clouds", "scattered clouds"),
				"sys.country", equalTo("AU"),
				"name", equalTo("Sydney"),
				"cod",  equalTo(200))
		.log().all();

	}
	
	@Test
	public void testGetByCityByName2(){
		String city = "Melbourne";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		log().all().
		param("q", city).
		param("appid", appid).
		when().
		get(Endpoints.ENDPOINT_GET_CITY_BY_NAME)
		.then().statusCode(200).log().all()
		.body("coord.lon", is(-80.61f),
				"coord.lat", is(28.08f),
			//	"weather.main", hasItems("Clouds"),
				//"weather.description", containsInAnyOrder("broken clouds", "scattered clouds"),
				"sys.country", equalTo("US"),
				"name", equalTo("Melbourne"),
				"cod",  equalTo(200))
		.log().all();

	}
}
