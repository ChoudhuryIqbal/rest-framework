package com.io.restAssured.rest_framework;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.apache.http.HttpStatus;
import org.junit.Test;

import io.restassured.http.ContentType;

public class TestQueryParameter extends BaseClass{
	
	@Test
	public void testQueryParam(){
		
	/**
	 * givern acept conten
	 * and id as 74
	 * lapato latitiude s series
	 * when i perform the get reques
	 * then status code 200 ok should be return sand the response content should have id as 75
	 * And Feature list should contain 1024 GB of ssd
	 * 
	 */
		given()
		.accept(ContentType.JSON)
		.param("id","75")
		.param("LaptopName", "Latitiude s series")
		.when()
		.get("/query")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.and()
		.assertThat()
		.body("Features.Feature", hasItem("1024 GB of SSD"));
		////.thenReturn()
		//.asString();
		//System.out.println(s);
		
		
		
		
	}
	
	
	

}
