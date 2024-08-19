package selenium.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAabstarctComponents.AbstarctComponents;

public class PaymentPage extends AbstarctComponents {
WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement dropdown;
	@FindBy(xpath="//section/button/span")
	List<WebElement> countryList;
	//@FindBy(css="//div[@class='actions']/a")
	@FindBy(css=".action__submit")
	WebElement placeOrderBtn;
	
	public void selectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.moveToElement(dropdown).click().sendKeys("India").perform();
		
		
	countryList.stream().filter(c->c.getText().equals(countryName)).findFirst().orElse(null).click();
//waitToBeVisible(placeOrderBtn);
//	waitToBeClickable(placeOrderBtn);
	//JavascriptExecutor je=(JavascriptExecutor)driver;
	//je.executeScript("arguments[0].scrollIntoView(true);", placeOrderBtn);
	Actions a1=new Actions(driver);
	//.click();
	//a1.moveToElement(placeOrderBtn).click().perform();
	//a1.scrollToElement(placeOrderBtn).click().perform();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", placeOrderBtn);
	    
	    // Adding a slight delay to ensure the element is in view
	    try {
	        Thread.sleep(500); // 500 milliseconds delay
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    placeOrderBtn.click();
		
	}
	
	
	


}
