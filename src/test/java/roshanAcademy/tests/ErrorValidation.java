package roshanAcademy.tests;

import org.testng.annotations.Test;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import roshanAcademy.pageObjects.CartPage;
import roshanAcademy.pageObjects.ConfirmationPage;
import roshanAcademy.pageObjects.PlaceOrderPage;
import roshanAcademy.pageObjects.ProductCatalog;
import roshanAcademy.testComponents.BaseTest;
import roshanAcademy.testComponents.Retry;

public class ErrorValidation extends BaseTest {

	@Test
	public void loginErrorValidation() {

		landingpage.loginApplication("anc.grosh@gmail.com", "Kahmandu@1");
		AssertJUnit.assertEquals(landingpage.getErrorMessage(), "Incorrect email or password....." );
	}

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class, priority=1)
	public void productErrorValidation() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3";
		String countryName = "India";

		ProductCatalog productCatalog = landingpage.loginApplication("anc.grosh@gmail.com", "Kathmandu@1");

		List<WebElement> products = productCatalog.getProductList();

		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();

		// my cart // checkout
		AssertJUnit.assertFalse(cartPage.getCartProducts("ZARA COAT 33"));
		
	}

}
