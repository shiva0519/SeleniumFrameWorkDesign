package seleniumAabstarctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstarctComponents {

	WebDriver driver;
	WebDriverWait wait;

	public AbstarctComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartButton;
	@FindBy(css = "[routerlink*='myorders']")
	WebElement ordersButton;

	public void waitToBeVisible(By locator) {

		// wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void waitToBeDisappear(By findby) {
		// wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));

	}
	public void waitToBeClickable(WebElement findBy) {
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}
	public void waitToBeVisible(WebElement findBy) {
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void goToCartPage() {
		cartButton.click();
	}
	public void goToOrdersPage() {
		waitToBeVisible(ordersButton);
		ordersButton.click();
	}
}
