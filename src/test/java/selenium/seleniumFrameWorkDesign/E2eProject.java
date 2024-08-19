package selenium.seleniumFrameWorkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*
 we r desining this without framework design
 */
public class E2eProject {
	static WebElement productGot;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = "prac@gmail.com";
		String pass = "Prac@123";
		String product = "ADIDAS ORIGINAL";

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(pass);

		driver.findElement(By.xpath("//input[@id='login']")).click();

		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));

		
		for (int i = 0; i < items.size(); i++) {
			// System.out.println(items.get(i).getText());

			if (items.get(i).findElement(By.cssSelector("b")).getText().equals(product)) {
				System.out.println(items.get(i).getText());
				productGot = items.get(i);

			}
		}

		// System.out.println(items);

		 WebElement
		 productGot=items.stream().filter(item->item.findElement(By.cssSelector(" b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		 

		productGot.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".cartSection h3")).getText(), product);
		
		driver.findElement(By.cssSelector("[class*='subtotal'] button")).click();
		
		WebElement dropdown = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
		Actions a=new Actions(driver);
		
		a.moveToElement(dropdown).click().sendKeys("India").perform();
		//List<WebElement> searchList=driver.findElements(By.cssSelector("[class*='ta-result']"));
		WebElement sss=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='ta-result']")));
		Select s=new Select(sss);
		s.selectByValue("India");
		

	}

}
