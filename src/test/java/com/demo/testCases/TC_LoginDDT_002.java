package com.demo.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.pageObject.BaseClass;
import com.demo.pageObject.LoginPage;
import com.demo.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
   @Test(dataProvider="LoginData")
   public void loginDDT(String user, String pwd) throws InterruptedException, IOException
   {
	  LoginPage lp= new LoginPage(driver); 
	  lp.setUserName(user);
	  logger.info("User name provided");
	  lp.setPassword(pwd);
	  logger.info("Password provided");
	  lp.clickOnLoginButton();
	  logger.info("Clicked on Login button");
	  Thread.sleep(5000);
	  
	  if(isAlertPresent()==true)
	  {   
		  
		  driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
		  captureScreenshot(driver,"loginDDT");
          logger.info("Login to application is failed");
      	  Assert.assertTrue(false);
      	
	  }
	  else
	  {
		  Assert.assertTrue(true);
		  logger.info("Login Successful");
		  lp.ClickOnLogoutButton();
		  logger.info("Clicked on Logout button");
		  Thread.sleep(5000);
		  driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
		  logger.info("Logged out Successfully");
      }
		  
   }
   
   public boolean isAlertPresent()
   {
	   try {
		driver.switchTo().alert();
		   return true;
	       } 
	      catch (NoAlertPresentException e) 
	       {
		   return false;
	       }
   }
   @DataProvider(name= "LoginData")
   String[][] getData() throws IOException
   {
	   String path= System.getProperty("user.dir")+"/src/test/java/com/demo/testData/LoginData.xlsx";
	   int rownum=XLUtils.getRowCount(path, "Sheet1");
	   int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	   
	   String logindata[][]= new String[rownum][colcount];
	   for(int i=1; i<=rownum; i++)
	   {
		   for(int j=0; j<colcount; j++)
		   {
			 logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);  
		   }
	   }
	   return logindata;
   }
}
