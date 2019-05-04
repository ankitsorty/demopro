package com.demo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.pageObject.BaseClass;
import com.demo.pageObject.LoginPage;
import com.demo.utilities.ReadConfig;

public class TC_LoginTest_001 extends BaseClass
  {
	ReadConfig readconfig= new ReadConfig();
    @Test
    public void loginTest() throws IOException
     {
        LoginPage lp= new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Username Entered");
  
        lp.setPassword(password);
        logger.info("Password Entered");
        
        lp.clickOnLoginButton();
        logger.info("Clicked on login button");
        
        if(driver.getTitle().equals(readconfig.getPageTitle()))
        {
        	Assert.assertTrue(true);
        	logger.info("Logged in Successfully");
        }else
        {
        	captureScreenshot(driver,"loginTest");
        	logger.info("Login to application is failed");
        	Assert.assertTrue(false);
        	
        	
        }
       
     }
  }
