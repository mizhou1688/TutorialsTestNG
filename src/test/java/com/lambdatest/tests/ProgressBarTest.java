package com.lambdatest.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lambdatest.pages.BootstrapProgressBarPage;

public class ProgressBarTest extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();
	
	@Test
	public void testProgressBarPercentage() {
		progressBarPage = homePage.clickBootstrapPrpogressBar();
		progressBarPage.clickStartDownloadButton();
		String actualMessage = progressBarPage.getCompletedMessage();
		String actualPercentage = progressBarPage.getProgressBarPercentage();
		
		String expectedMessage = "Download completed!";
		String expectedPercentage = "100%";
		softAssert.assertEquals(actualMessage, expectedMessage);
		softAssert.assertEquals(actualPercentage, expectedPercentage);
		softAssert.assertAll();
	}
}
