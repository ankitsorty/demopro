package com.demo.pageObject;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.demo.utilities.ReadConfig;


public class BaseClass 
{
  ReadConfig readconfig= new ReadConfig();
  public String baseURL= readconfig.getApplicationURL();
  public String username= readconfig.getUserName();
  public String password= readconfig.getPassword();
  public String title= readconfig.getPageTitle();
  public static WebDriver driver;
  public static Logger logger;
  
  
@SuppressWarnings("deprecation")
@Parameters("browser")
@BeforeClass
  public void setup(String br) throws Exception 
  {
	  freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_NONE);
	  logger= Logger.getLogger("demopro");
	  PropertyConfigurator.configure("log4j.properties");
	 
	  if(br.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
		  driver=new ChromeDriver(); 
	  }else if(br.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriverPath());
		  driver=new FirefoxDriver();
	  }else if(br.equals("ie"))
	  {
		  System.setProperty("webdriver.ie.driver", readconfig.getIEDriverPath());
		  driver=new InternetExplorerDriver();
	  }
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseURL);
      logger.info("URL is Launched");
	  driver.manage().window().maximize();
	  logger.info("Window is maximized");
	  driver.manage().deleteAllCookies();
	  logger.info("Deleted cookies");
	  
	 
  }
  @AfterClass
  public void tearDown()
  {
	  driver.quit();
  }

  public void captureScreenshot(WebDriver drive, String tname) throws IOException
  {
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File source= ts.getScreenshotAs(OutputType.FILE);
	  File target= new File(System.getProperty("user.dir")+"\\Screenshots\\"+ tname+".png");
	  FileUtils.copyFile(source, target);
	  System.out.println("Screenshot taken Successfully");
	  
  }
  public String randomString() {
		String rndmstr = RandomStringUtils.randomAlphabetic(8);
		return (rndmstr);
	}
	public static String randomNum() {
		String rndmnum = RandomStringUtils.randomNumeric(6);
		return (rndmnum);
  }
  
}


