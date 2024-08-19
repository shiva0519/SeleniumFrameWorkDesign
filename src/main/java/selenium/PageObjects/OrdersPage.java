package selenium.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Optional;

import seleniumAabstarctComponents.AbstarctComponents;

public class OrdersPage extends AbstarctComponents {
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> ordersList;
	
	
	
	public  void checkOrderIsThere(String product) {
		Optional<WebElement> order=ordersList.stream().filter(o->o.getText().equals(product)).findFirst();
		Assert.assertTrue(order.isPresent());
	}
}
