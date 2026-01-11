package karthikakkasaligar.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import karthikakkasaligar.ReUseableComponents.ReUseablePage;

public class LoginPage extends ReUseablePage {
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//p[@class='help-block'])[1]")
	WebElement EmailText;
	
	@FindBy(xpath="(//p[@class='help-block'])[2]")
	WebElement PasswordText;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="loginBtn")
	WebElement login;
	
	@FindBy(id="errorMsg")
	WebElement errormsg;
	
	public void URLlunch()
	{
		driver.get("https://shop.qaautomationlabs.com/index.php");
	}
	
	public String getEmailText()
	{
	  return EmailText.getText().split(":")[1].trim();
	}
	
	public String getPasswordText()
	{
		return PasswordText.getText().split(":")[1].trim();
	}
	
	public String errormessagetext()
	{
		return errormsg.getText().trim();
	}
	
	public CategorySelectionPage Login(String email, String password)
	{
		Email.sendKeys(email);
		Password.sendKeys(password);
		login.click();
		CategorySelectionPage selection = new CategorySelectionPage(driver);
		return selection;
	}
	
	
	
	

}