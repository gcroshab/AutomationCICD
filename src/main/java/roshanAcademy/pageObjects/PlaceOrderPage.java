package roshanAcademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import roshanAcademy.AbstractComponents.AbstractComponent;

public class PlaceOrderPage extends AbstractComponent {

	WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder = 'Select Country']")
	WebElement selectCountry;

	@FindBy(xpath = "(//button[contains(@class, 'ta-item')])[2]")
	WebElement selectCountryFromDropdown;

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement placeOrderButton;

	@FindBy(css = ".hero-primary")
	WebElement message;
	
	By results = By.cssSelector(".ta-item");

	public void enterCountryValue(String countryName) {
		Actions a = new Actions(driver);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));

		a.sendKeys(selectCountry, countryName).build().perform();
		selectCountryFromDropdown.click();

	}

	public ConfirmationPage placeOrder() {
		placeOrderButton.click();
		ConfirmationPage confPage = new ConfirmationPage(driver);
		return confPage;

	}

	
}
