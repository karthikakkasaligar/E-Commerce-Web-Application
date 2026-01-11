package karthikakkasaligar.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import karthikakkasaligar.ReUseableComponents.ReUseablePage;

public class CartPage extends ReUseablePage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
  
	
	@FindBy(xpath="//tbody/tr/td[1]")
	WebElement cartitem;
	
	@FindBy(id="totalPrice")
	WebElement price;
	
	@FindBy(id="checkoutBtn")
	WebElement checkout;
	
	public String getproducttext()
	{
	 return cartitem.getText().trim();
	}
	
	public String getTotacartprice()
	{ 
		return  price.getText().trim();
	}
	
 public BillingAddressPage CartItemVerification(String Cartproduct, String Product, String TotalPrice)
 {
	 if (!Cartproduct.equals(Product)) {
			Assert.fail("item not matching with item added to cart");
		}
	 System.out.println(TotalPrice);
	 checkout.click();
	 BillingAddressPage billingaddress= new BillingAddressPage(driver);
	 return billingaddress;
	 
 }
	
}



//driver.findElement(By.id("checkoutBtn")).click();