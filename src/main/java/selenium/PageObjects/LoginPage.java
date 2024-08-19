package selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.xpath("//input[@id='userEmail']"))
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorToast;
	
	
	public void login(String username, String password) {
		
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		loginButton.click();
		
	}
	public String getErrorMsg() {
		return errorToast.getText();
	}
	
	
	
	
	

}
