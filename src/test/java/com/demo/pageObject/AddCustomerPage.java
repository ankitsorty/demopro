package com.demo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement linkaddnewcusromer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement custname;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement custgender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement custdob;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement custaddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement custcity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement custstate;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement custpin;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement custteleno;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement custemailid;
	
	@FindBy(how= How.NAME, using = "password")
	@CacheLookup
	WebElement custpass;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement custsubmit;
	
	
	public void clickAddNewCustLink()
	{
		linkaddnewcusromer.click();
	}
	public void addCustName(String cname)
	{
		custname.sendKeys(cname);
	}
	public void addCustGender(String cgender)
	{
		custgender.sendKeys(cgender);
	}
	public void addCustDob(String mm, String dd, String yy)
	{
		custdob.sendKeys(mm);
		custdob.sendKeys(dd);
		custdob.sendKeys(yy);
	}
	public void addCustAddress(String caddress)
	{
		custaddress.sendKeys(caddress);
	}
	public void addCustCity(String ccity)
	{
		custcity.sendKeys(ccity);
	}
	public void addCustState(String cstate)
	{
		custstate.sendKeys(cstate);
	}
	public void addCustPin(String cpin)
	{
		custpin.sendKeys(String.valueOf(cpin));
	}
	public void addCustPhone(String cphone)
	{
		custteleno.sendKeys(cphone);
	}
	public void addCustemailId(String cemail)
	{
		custemailid.sendKeys(cemail);
	}
	public void addCustPass(String cpass)
	{
		custpass.sendKeys(cpass);
	}
	public void clickOnSubmit()
	{
		custsubmit.click();
	}
	
}