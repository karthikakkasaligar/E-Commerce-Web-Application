package karthikakkasaligar.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModels.BillingAddressPage;
import karthikakkasaligar.PageObjectModels.CartPage;
import karthikakkasaligar.PageObjectModels.CategorySelectionPage;
import karthikakkasaligar.PageObjectModels.ConfirmationPage;
import karthikakkasaligar.PageObjectModels.OrderConfirmationPage;
import karthikakkasaligar.PageObjectModels.ProductCatalougePage;
import karthikakkasaligar.TestComponents.BaseTestPage;

public class MainTest  extends BaseTestPage{

	@Test
	public void EcommerceApplication() throws IOException
	{

		String Product = "Blue Pant";
		
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
		
		// Billing Address Page
		 ConfirmationPage confirmpage= billingaddress.personaldetails("demo", "demo", "demo@gmail.com", "9879879874", "#45, wellington heights, hubli", "Karnataka", "hubli", "576653");

		// confirmation page
		 String amount= confirmpage.getAmountVerificationtext();
		 confirmpage.Screeshot();
		 confirmpage.placeorder(amount);
		 
		// Order successful page
		 OrderConfirmationPage order= new OrderConfirmationPage(driver);
		Assert.assertEquals(order.getmessagetext(), "🎉 Thank You for Your Order!");
		

	}

}
