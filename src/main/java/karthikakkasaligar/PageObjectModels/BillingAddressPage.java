package karthikakkasaligar.PageObjectModels;

import java.awt.print.PageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import karthikakkasaligar.ReUseableComponents.ReUseablePage;

public class BillingAddressPage extends ReUseablePage  {
	
	WebDriver driver;
	
	public BillingAddressPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement Firstname;

	@FindBy(id="lastname")
	WebElement Lastname;
	
	@FindBy(id="email")
	WebElement Emailid;
	
	@FindBy(id="phone")
	WebElement Phonenumber;
	
	@FindBy(id="address")
	WebElement Address;
	
	@FindBy(id="states")
	WebElement State;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="pincode")
	WebElement Pincode;
	
	@FindBy(id="continue")
	WebElement Continue;
	
	
	public ConfirmationPage  personaldetails(String firstname, String lastname,String emailid ,String phone , String address , String state , String city, String pincode)
	{
		Firstname.sendKeys(firstname);
		Lastname.sendKeys(lastname);
		Emailid.sendKeys(emailid);
		Phonenumber.sendKeys(phone);
		Address.sendKeys(address);
		State.sendKeys(state);
		City.sendKeys(city);
		Pincode.sendKeys(pincode);
		Continue.click();
		ConfirmationPage confirmpage = new ConfirmationPage(driver);
		return confirmpage;
	}
}
