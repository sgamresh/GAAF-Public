package com.api.utilities;

import java.util.Map;

import org.testng.Assert;

import com.api.base.BaseTest;
import com.api.enums.StatusType;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.restassured.response.Response;

public class Event extends BaseTest {


	public void log(String stats, String message) {

		StatusType status = StatusType.valueOf(stats);
		switch (status) {
		case FAIL: {
			System.err.println("[FAIL]: " + message);
			test.fail(MarkupHelper.createLabel(message, ExtentColor.RED));
			Allure.step(message, Status.FAILED);
			Assert.fail("Failed due to: " + message);
			break;
		}

		case PASS: {
			System.out.println("[PASS]: " + message);
			test.pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
			Allure.step(message, Status.PASSED);
			break;
		}

		case INFO: {
			System.out.println("[INFO]: " + message);
			test.info(MarkupHelper.createLabel(message, ExtentColor.WHITE));

			Allure.step(message);
			break;
		}
		case SKIP: {
			System.out.println("[SKIP]: " + message);
			test.skip(MarkupHelper.createLabel(message, ExtentColor.WHITE));
			Allure.step(message, Status.SKIPPED);
			break;
		}
		case ERROR: {
			test.warning(MarkupHelper.createLabel(message, ExtentColor.ORANGE));
			System.err.println("[ERROR]: " + message);
			Allure.step(message, Status.BROKEN);
			break;
		}
		case WARNING: {
			System.err.println("[WARNING]: " + message);
			test.warning(MarkupHelper.createLabel(message, ExtentColor.ORANGE));

			Allure.step(message, Status.BROKEN);
			break;
		}
		case DEBUG: {
			System.err.println("[DEBUG]: " + message);
			test.info(MarkupHelper.createLabel(message, ExtentColor.WHITE));
			Allure.step(message, Status.BROKEN);
			break;
		}
		default: {
			System.out.println("case not implemented for: " + status);
			break;
		}
		}

	}

	public void log(String status, Map<String, String> map) {
		String mapstr = map.toString();
		switch (status.toLowerCase()) {
		case "pass": {
			test.pass(MarkupHelper.createCodeBlock(mapstr));
 			break;
		}
		case "skip": {
			test.skip(MarkupHelper.createCodeBlock(mapstr));
			break;
		}
		case "fail": {
			test.fail(MarkupHelper.createCodeBlock(mapstr));
			break;

		}

		}

	}

	public void log(String status, Response json) {
		String jsonString = json.prettyPrint().toString();
		switch (status.toLowerCase()) {
		case "pass": {
			test.pass(MarkupHelper.createCodeBlock(jsonString));

			break;
		}
		case "info": {
			test.pass(MarkupHelper.createCodeBlock(jsonString));

			break;
		}
		case "skip": {
			test.skip(MarkupHelper.createCodeBlock(jsonString));
			break;
		}
		case "fail": {
			test.fail(MarkupHelper.createCodeBlock(jsonString));
			break;

		}

		}

	}

}
