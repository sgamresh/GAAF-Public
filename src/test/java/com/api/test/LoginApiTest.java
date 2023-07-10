package com.api.test;

import org.testng.annotations.Test;

import com.api.base.BaseTest;

public class LoginApiTest extends BaseTest{
	
	
	@Test
	public void LoginApiTestCases() {
		
		System.out.println("I am printing from @Test Method in LoginApiTest Class");
		event.log("PASS", "I am printing from @Test Method in LoginApiTest Class");
	}
	

}
