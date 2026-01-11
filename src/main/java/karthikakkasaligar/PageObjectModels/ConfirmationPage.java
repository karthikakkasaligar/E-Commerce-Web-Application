package karthikakkasaligar.PageObjectModels;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import karthikakkasaligar.ReUseableComponents.ReUseablePage;

public class ConfirmationPage extends ReUseablePage {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[class='row']")
	WebElement AmountVerification;
	
	@FindBy(css="[class*='btn-block btn-primary']")
	WebElement Placeorder;
	
	public String getAmountVerificationtext()
	{
		return AmountVerification.getText().trim();
	}
	
	public void Screeshot() throws IOException
	{
		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Timestamp = String.valueOf(System.currentTimeMillis());
		File Destination = new File("D:\\" + Timestamp + ".png");
		FileUtils.copyFile(Source, Destination);
	}
	
	public void placeorder(String amount)
	{
		System.out.println(amount);
		Placeorder.click();
		
		
	}
}



//driver.findElement(By.cssSelector("[class*='btn-block btn-primary']")).click();