package com.io.restAssured.rest_framework;
import static org.hamcrest.Matchers.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

@SuppressWarnings("deprecation")
public class TestGet extends BaseClass {

	@Test
	public void testGet() throws URISyntaxException {
		/*
		 * when I performed getRequest
		 * 
		 */

		// URI uri=new
		// URI("http://localhost:8087/laptop-bag/webapi/api/ping/hello");
		Response respons = given().accept(ContentType.JSON).when()
				.get(new URI("http://localhost:8087/laptop-bag/webapi/api/all"));

		System.out.println(respons.asString());

	}

	@Test
	public void testStatusCode() throws URISyntaxException {
		
		given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("http://localhost:8087/laptop-bag/webapi/api/all"))
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);
		
		//capusture status code thenreturn
		//validate use then()

	}
	
	@Test
	public void testGetWithId() throws URISyntaxException{
		/**
		 * Given Accetpin Json format
		 * Whene i givenperfomr the get Reuqest with 203 
		 * Then status code 200 ok should be returns
	
		 */
		given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/find/203") )
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);
		
	}
	@Test
	
	public void testGetWithNonExisted() throws URISyntaxException{
		//negative testing 
	String body=	given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/find/203") )
		.thenReturn()
		.body()
		.asString();
		System.out.println(body);
	}
	
	
	@Test
	public void testContent(){
		/****
		 * Given Accept the content in Json Format
		 * When I perform the  Get MethHod with id as 203 then the response should have Brand Name as Dell
		 * 
		 */
		
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/find/203")
		.then()
		.body("Features.Feature", hasItems("8GB RAM","1TB Hard Drive"));
		//.body("BrandName",equalToIgnoringCase("Dell"),"Id",equalTo(203),"LaptopName",equalToIgnoringCase("Latitude"));
		//.body("BrandName",equalToIgnoringCase("Dell"));
		//.body(path, matcher, additionalKeyMatcherPairs)
		//.body(matcher, additionalMatchers)
		
	}
	@Test
	public void testContentJsonPath(){
		String s=given()
		.accept(ContentType.JSON)
		.when()
		.get("/find/203")
		.thenReturn()
		.asString();
		System.out.print(s);
		
		
		JsonPath json=new JsonPath(s);
		Assert.assertEquals(75, json.getInt("Laptop.Id"));
		Assert.assertEquals("Dell", json.getString("BrandName"));
		//.body("Features.Feature", hasItems("8GB RAM","1TB Hard Drive"));
		//.body("BrandName",equalToIgnoringCase("Dell"),"Id",equalTo(203),"LaptopName",equalToIgnoringCase("Latitude"));
		//.body("BrandName",equalToIgnoringCase("Dell"));
		//.body(path, matcher, additionalKeyMatcherPairs)
		//.body(matcher, additionalMatchers)
		
	}
	@Test
	public void testContentXmlPath(){
	String s=	given()
		.accept(ContentType.XML)
		.when()
		.get("/find/203")
		.thenReturn()
		.asString();
	System.out.println(s);
	XmlPath xpath=new XmlPath(s);
		//.body("Features.Feature", hasItems("8GB RAM","1TB Hard Drive"));
		//.body("BrandName",equalToIgnoringCase("Dell"),"Id",equalTo(203),"LaptopName",equalToIgnoringCase("Latitude"));
		//.body("BrandName",equalToIgnoringCase("Dell"));
		//.body(path, matcher, additionalKeyMatcherPairs)
		//.body(matcher, additionalMatchers)
		
	}
	@Test
	public void testGetWithIdWithHeader() throws URISyntaxException{
		
		
		
		Map <String,String>  headers=new HashMap<String,String>();
		headers.put("Accept","application/json");
		/**
		 * Given Accetpin Json format
		 * Whene i givenperfomr the get Reuqest with 203 
		 * Then status code 200 ok should be returns
	
		 */
		given()
		.headers(headers)
		.when()
		.get(new URI("/find/203") )
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);
		
	}
	

}
