package karthikakkasaligar.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import karthikakkasaligar.ReUseableComponents.ReUseablePage;

public class OrderConfirmationPage extends ReUseablePage {
	
	WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//String Message = driver.findElement(By.xpath("//div/h1")).getText().trim();
	@FindBy(xpath="//div/h1")
	WebElement msg;
	
	public String getmessagetext()
	{
		return msg.getText().trim();
	}


}
