package com.demo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
  WebDriver ldriver;
  
 public LoginPage(WebDriver rdriver)
 {
	 ldriver=rdriver;
	 PageFactory.initElements(rdriver, this);
 }
 
     @FindBy(name="uid")
     WebElement txtuname;
     
     @FindBy(name="password")
     WebElement txtpass;
     
     @FindBy(name="btnLogin")
     WebElement loginbtn;
     
     @FindBy(xpath="//a[contains(text(),'Log out')]")
     WebElement logoutbtn;
     
     
    public String setUserName(String uname)
    {
    	txtuname.sendKeys(uname);
		return uname;
    }
    
    public String setPassword(String pwd)
    {
    	txtpass.sendKeys(pwd);
		return pwd;
    }
    public void clickOnLoginButton()
    {
    	loginbtn.click();
    }
    public void ClickOnLogoutButton()
    {
    	logoutbtn.click();
    }
}

