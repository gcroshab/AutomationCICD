package roshanAcademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import roshanAcademy.pageObjects.CartPage;
import roshanAcademy.pageObjects.ConfirmationPage;
import roshanAcademy.pageObjects.LandingPage;
import roshanAcademy.pageObjects.OrderPage;
import roshanAcademy.pageObjects.PlaceOrderPage;
import roshanAcademy.pageObjects.ProductCatalog;
import roshanAcademy.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";
	String countryName = "India";

	@Test (dataProvider ="getData", groups= {"purchaseOrder", "smoke"})
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

		ProductCatalog productCatalog = landingpage.loginApplication(input.get("email"),input.get( "password"));

		// ProductCatalog productCatalog = new ProductCatalog(driver);
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("productname"));
		CartPage cartPage = productCatalog.goToCartPage();

		// my cart // checkout
		AssertJUnit.assertTrue(cartPage.getCartProducts(input.get("productname")));
		PlaceOrderPage placeOrderPage = cartPage.clickOnCheckout();

		placeOrderPage.enterCountryValue(countryName);
		ConfirmationPage confPage = placeOrderPage.placeOrder();

		AssertJUnit.assertEquals(confPage.confirmMessage(), "THANKYOU FOR THE ORDER.");

	}

	// to verify zara coat 3 is displaying in the orders page.
	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {

		ProductCatalog productCatalog = landingpage.loginApplication("anc.grosh@gmail.com", "Kathmandu@1");
		OrderPage orderPage = productCatalog.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyProductDisplay(productName));

	}
	
	

	//Extent Reports
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "anc.grosh@gmail.com");
//		map.put("password", "Kathmandu@1");
//		map.put("product", "ZARA COAT 3");
//		
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "grosh@gmail.com");
//		map1.put("password", "Kathmndu@1");
//		map1.put("product", "ADIDAS ORIGINAL");
		
	List<HashMap<String, String>> data =	getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//roshanAcademy//data//purchaseOrder.json");
		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		

		//return new Object[][] { { "anc.grosh@gmail.com", "Kathmandu@1", "ZARA COAT 3" }, { "roshan@gmail.com", "Kathmandu@1", "ADIDAS ORIGINAL" } };

	}

}
