package com.io.restAssured.rest_framework;

import org.junit.BeforeClass;
import static io.restassured.RestAssured.*;

public class BaseClass {
	
	@BeforeClass
	public static void setUp(){
		baseURI="http://localhost";
		port=8087;
		basePath="/laptop-bag/webapi/api";
		
		
	}

}
