package roshanAcademy.stepsDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import roshanAcademy.pageObjects.CartPage;
import roshanAcademy.pageObjects.ConfirmationPage;
import roshanAcademy.pageObjects.LandingPage;
import roshanAcademy.pageObjects.PlaceOrderPage;
import roshanAcademy.pageObjects.ProductCatalog;
import roshanAcademy.testComponents.BaseTest;

public class StepDefinitonImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public ConfirmationPage confPage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {
		productCatalog = landingpage.loginApplication(username, password);
	}

	@When("^I add product (.+) from cart$")
	public void i_add_product_from_cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void and_checkout_and_submit_the_order(String productName) {
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match = cartPage.getCartProducts(productName);
		AssertJUnit.assertTrue(match);
		PlaceOrderPage placeOrderPage = cartPage.clickOnCheckout();
		placeOrderPage.enterCountryValue("India");
		confPage = placeOrderPage.placeOrder();

	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_displayed_confirmationPage(String string) {
		AssertJUnit.assertEquals(confPage.confirmMessage(), string);
		
	}
	
	
   
    @Then ("{string} message is displayed")
    public void message_is_displayed(String string) {
    	
    	AssertJUnit.assertEquals(landingpage.getErrorMessage(), string);
		driver.close();
    }

	
}
