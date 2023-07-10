package com.api.base;

import java.io.File;
import java.io.IOException;

 import org.testng.annotations.BeforeSuite;

import com.api.utilities.Event;

public class BaseTest {
	
	protected   Event event = new Event();
	@BeforeSuite
	private void StartService() {
		
 
		System.out.println("I am printing from @BeforeSuite StartService Method in BaseTest Class");

	}
	
	 
	
	
	
	
	 
	
	

}
