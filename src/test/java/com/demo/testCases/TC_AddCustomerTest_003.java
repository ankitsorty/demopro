package com.demo.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.pageObject.AddCustomerPage;
import com.demo.pageObject.BaseClass;
import com.demo.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
    @Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickOnLoginButton();
		logger.info("Clicked on login button");
		Thread.sleep(3000);

		AddCustomerPage addcust1 = new AddCustomerPage(driver);

		addcust1.clickAddNewCustLink();
		
		logger.info("Providing customer details------->>>>>>");
		addcust1.addCustName("Ankit Sorty");
		addcust1.addCustGender("male");
		addcust1.addCustDob("11", "29", "1993");
		Thread.sleep(3000);
		addcust1.addCustAddress("BRC Sri hemadurga Sivahills");
		addcust1.addCustCity("Hyderabad");
		addcust1.addCustState("Telengana");
		addcust1.addCustPin("500089");
		addcust1.addCustPhone("8381026234");
		String email = randomString()+"@gmail.com";
		addcust1.addCustemailId(email);
		addcust1.addCustPass("AnkuSorty");
		addcust1.clickOnSubmit();
		Thread.sleep(3000);
		logger.info("Verifying customer added or not");
	    boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
        if(res==true)
        {
        	Assert.assertTrue(true);
        	logger.info(" TC is Passed........");
        }else
        {
        	captureScreenshot(driver, "addNewCustomer");
    	    Assert.assertTrue(false);
    	    logger.info(" TC is Failed");
        }
	}

	
}
