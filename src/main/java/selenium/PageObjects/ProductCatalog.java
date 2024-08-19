package selenium.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAabstarctComponents.AbstarctComponents;

public class ProductCatalog extends AbstarctComponents {
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> items;
	
	// driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

	//@FindBy(css = "[routerlink*='cart']")
	//WebElement cartButton;

	By locator = By.cssSelector(".mb-3");

	By addToCartButton = By.cssSelector(".card-body button:last-of-type");

	WebElement findItem(String name) {

		WebElement productGot = getProductList().stream()
				.filter(i -> i.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
		return productGot;

	}

	public void addToCart(String productName) {

		WebElement productGot = findItem(productName);
		productGot.findElement(addToCartButton).click();

		waitToBeVisible(By.cssSelector("#toast-container"));
		waitToBeDisappear(By.cssSelector(".ng-animating"));
		goToCartPage();

	}

	List<WebElement> getProductList() {
		waitToBeVisible(locator);
		return items;
	}

}
