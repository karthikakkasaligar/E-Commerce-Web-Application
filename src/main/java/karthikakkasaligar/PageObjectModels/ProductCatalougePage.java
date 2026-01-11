package karthikakkasaligar.PageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import karthikakkasaligar.ReUseableComponents.ReUseablePage;

public class ProductCatalougePage extends ReUseablePage{
	
	WebDriver driver;
	
	public ProductCatalougePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 By waitforelement=By.cssSelector("[class='img-fluid w-100']");
	 
	 @FindBy(css="[class*='text-truncate']")
	 List<WebElement> Products;
	 
	 @FindBy(id="cartCount")
	 WebElement Carticon;
	 
	 
	 public void AddProducttoCart(String Product)
	 {
		
		 WaitforElementtoAppear(waitforelement);
		 boolean itemfound = false; 
		 for (int i = 0; i < Products.size(); i++) {
				String iterationitems = Products.get(i).getText().trim();
				if (iterationitems.equalsIgnoreCase(Product)) {
					driver.findElements(By.cssSelector("[class*='addToCart']")).get(i).click();
					itemfound=true;
					break;
				}
			}
				if (!itemfound) {
				    Assert.fail("No item Found!!");
				    return;
				}
				
				Carticon.click();
				
	 }
}
	 



 
		  
		