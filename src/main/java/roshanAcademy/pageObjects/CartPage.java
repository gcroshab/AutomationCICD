package roshanAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import roshanAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cart h3")
	List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;

	public Boolean getCartProducts(String productName) {
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		return match;
	}

	public PlaceOrderPage clickOnCheckout() {
		// checkout
		checkoutButton.click();
		PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
		return placeOrderPage;
	}

}
