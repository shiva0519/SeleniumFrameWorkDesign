package selenium.PageObjects;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import seleniumAabstarctComponents.AbstarctComponents;

public class CartPage extends AbstarctComponents {
	

	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
//	driver.findElement(By.cssSelector("[class*='subtotal'] button")).click();
	@FindBy(css="[class*='subtotal'] button")
	WebElement checkOutbtn;
	
 
	public boolean checkProductAdded(String product) {
    	
  
		Optional<WebElement> cast=
				cartItems.stream().filter(s->s.getText().equals(product)).findFirst();
    	if(cast.isEmpty()) {
    		Assert.assertTrue(false);
    		return false;
   	}
   	
   	Assert.assertTrue(true);
   	return true;
// Assert.assertTrue(cartItems.stream().filter(s->s.getText().equals(product)).findFirst().isPresent());
   }
	public void checkout(String product) {
		if(checkProductAdded(product)) {
			 checkOutbtn.click();
		}
	}
	
	

}
