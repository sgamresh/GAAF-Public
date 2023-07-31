package com.api.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.api.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginApiTest extends BaseTest{
	

	@Test
	public void LoginApiTestCases1() {
		 String BASE_URL;
		 Response res;
		try {
			BASE_URL = config.api_joke();
			 event.log("INFO", "BASE_URL"+BASE_URL);

			   res=  (Response) RestAssured.given().get(BASE_URL); // Assert the response status code is 200 (OK).log().all();
		
				 event.log("INFO",  res);

		} catch (Exception e) {
			e.printStackTrace();
		}  
		  
			

	}
	
 
}
