package selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAabstarctComponents.AbstarctComponents;

public class ConformPage extends AbstarctComponents{

	public ConformPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="h1")
	WebElement confirmMsg;
	
	public boolean confirm() {
		if(confirmMsg.getText().toUpperCase().equals("THANKYOU FOR THE ORDER.")) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
