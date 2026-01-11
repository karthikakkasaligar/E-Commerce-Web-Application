package karthikakkasaligar.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModels.BillingAddressPage;
import karthikakkasaligar.PageObjectModels.CartPage;
import karthikakkasaligar.PageObjectModels.CategorySelectionPage;
import karthikakkasaligar.PageObjectModels.ProductCatalougePage;
import karthikakkasaligar.TestComponents.BaseTestPage;

public class ErrorValidationTest extends BaseTestPage {
	
	
	String Product = "Blue Pant";

	@Test
	public void LoginTextVerification() throws IOException {

		

		// login
		String email = loginpage.getEmailText();
		// String password=loginpage.getPasswordText();
		CategorySelectionPage selection = loginpage.Login(email, "Karthik");
		Assert.assertEquals("Invalid email or password!", loginpage.errormessagetext());
	}
	
	@Test
	public void CartValidationTest() throws IOException
	{

		
		
		//login
		String email=loginpage.getEmailText();
		String password=loginpage.getPasswordText();
		CategorySelectionPage selection=loginpage.Login(email, password);
		
		// Category selection
		ProductCatalougePage productcatalouge=	selection.Categoryselection();
		
		// product catalogue
		productcatalouge.AddProducttoCart(Product);
		CartPage  cartpage = new CartPage(driver);
		String Cartproduct =cartpage.getproducttext();
		String TotalPrice =cartpage.getTotacartprice();
		 BillingAddressPage billingaddress= cartpage.CartItemVerification(Cartproduct, Product, TotalPrice);
		 
	}
		

}
