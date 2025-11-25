package roshanAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import roshanAcademy.pageObjects.CartPage;
import roshanAcademy.pageObjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartButton;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForElementToAppear1(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public CartPage goToCartPage() {
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrdersPage() {
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}

	public void waitForElementToDisappear() throws InterruptedException {

		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(element));

	}

}
