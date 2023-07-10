package com.api.utilities;

import org.testng.Assert;

import com.api.enums.StatusType;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

public class Event {
	
	public void log(String stats, String message) {

		StatusType status = StatusType.valueOf(stats);
		switch (status) {
		case FAIL: {
			System.err.println("[FAIL]: " + message);
			Allure.step(message, Status.FAILED);
			Assert.fail("Failed due to: " + message);
			break;
		}

		case PASS: {
			System.out.println("[PASS]: " + message);
			Allure.step(message, Status.PASSED);
			break;
		}

		case INFO: {
			System.out.println("[INFO]: " + message);
			Allure.step(message);
			break;
		}
		case SKIP: {
			System.out.println("[SKIP]: " + message);
			Allure.step(message, Status.SKIPPED);
			break;
		}
		case ERROR: {
			System.err.println("[ERROR]: " + message);
			Allure.step(message, Status.BROKEN);
			break;
		}
		case WARNING: {
			System.err.println("[WARNING]: " + message);
			Allure.step(message, Status.BROKEN);
			break;
		}
		case DEBUG: {
			System.err.println("[DEBUG]: " + message);
			Allure.step(message, Status.BROKEN);
			break;
		}
		default: {
			System.out.println("case not implemented for: " + status);
			break;
		}
		}

	}
	

}
