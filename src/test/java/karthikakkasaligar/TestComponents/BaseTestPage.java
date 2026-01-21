package karthikakkasaligar.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import karthikakkasaligar.PageObjectModels.LoginPage;

public class BaseTestPage {
	
	public WebDriver driver;
	public LoginPage loginpage;
	
	public WebDriver Intilizedriver() throws IOException
	{
		
		Properties property=new Properties();
		FileInputStream fis =new FileInputStream(
				System.getProperty("user.dir") +"\\src\\main\\java\\karthikakkasaligar\\Resources\\Globaldata.properties");
		property.load(fis);
	    String browsername=	property.getProperty("browser");
		
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		 driver = new ChromeDriver();
	}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			 driver = new FirefoxDriver(options);
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--incognito");
			 driver = new EdgeDriver(options);
		}
		
		driver.manage().window().maximize();
		return driver;
}
	
	@BeforeMethod
	public LoginPage LunchApplication() throws IOException
	{
		driver= Intilizedriver();
	    loginpage = new LoginPage(driver);
		loginpage.URLlunch();
		return loginpage;	
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	
}
