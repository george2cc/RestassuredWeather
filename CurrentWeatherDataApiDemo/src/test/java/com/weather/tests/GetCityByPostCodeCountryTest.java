package com.weather.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.demo.constants.Endpoints;


public class GetCityByPostCodeCountryTest
{
	@Test
	public void testGetByPostCode(){
		String city = "Sydney";
		String country = "AU";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		param("q", city).
		param("country", country).
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
		String country = "AU";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		log().all().
		param("q", city).
		param("country", country).
		param("appid", appid).
		when().
		get(Endpoints.ENDPOINT_GET_CITY_BY_NAME)
		.then().statusCode(200).
		log().all()
		.body("coord.lon", is(153.03f),
				"coord.lat", is(-27.47f),
			//	"weather.main", hasItems("Clouds"),
				"sys.country", equalTo("AU"),
				"name", equalTo("Brisbane"),
				"cod",  equalTo(200))
		.log().all();

	}
	
	@Test
	public void testGetByPostCode3(){
		String city = "Melbourne";
		String country = "AU";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		log().all().
		param("q", city).
		param("country", country).
		param("appid", appid).
		when().
		get(Endpoints.ENDPOINT_GET_CITY_BY_NAME)
		.then().statusCode(200).
		log().all()
		.body("coord.lon", is(-80.61f),
				"coord.lat", is(28.08f),
				"weather.main", hasItems("Clouds"),
				"sys.country", equalTo("US"),
				"name", equalTo("Melbourne"),
				"cod",  equalTo(200))
		.log().all();

	}
	
	@Test
	public void testGetByPostCode4(){
		String city = "London";
		String country = "AU";
		String appid = "7a5da9ad8e5006285c47c711be34140a";

		given().
		log().all().
		param("q", city).
		param("country", country).
		param("appid", appid).
		when().
		get(Endpoints.ENDPOINT_GET_CITY_BY_NAME)
		.then().statusCode(200).
		log().all()
		.body("coord.lon", is(-0.13f),
				"coord.lat", is(51.51f),
			//	"weather.main", hasItems("Clouds"),
				"sys.country", equalTo("GB"),
				"name", equalTo("London"),
				"cod",  equalTo(200))
		.log().all();

	}
}
