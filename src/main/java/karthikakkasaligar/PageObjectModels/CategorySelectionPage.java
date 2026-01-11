package karthikakkasaligar.PageObjectModels;

import java.awt.print.PageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import karthikakkasaligar.ReUseableComponents.ReUseablePage;

public class CategorySelectionPage extends ReUseablePage {
	
	WebDriver driver;
	
	public CategorySelectionPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='btn btn-primary'])[1]")
	WebElement clickonshop;
	
	public ProductCatalougePage Categoryselection()
	{
		clickonshop.click();
		ProductCatalougePage productcatalouge= new ProductCatalougePage(driver);
		return productcatalouge;
	}

}
