package selenium.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import selenium.PageObjects.LoginPage;

public class BaseTest {
	
	protected WebDriver driver ;
	protected LoginPage loginpage;
	public BaseTest() {
		
	}
	
	
	public WebDriver initilizeDriver() throws IOException {
	
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\selenium\\resources\\GlobalData.properties");
		p.load(fis);
		//here we wriiten outsmart like first check through cmd is there any browser option given
		//else it will take from global properties
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):p.getProperty("browser");
		//String browserName=p.getProperty("browser");
		
		switch(browserName.toLowerCase()) {
		
		case "chrome": driver=new ChromeDriver();
		break;
		case "firefox": driver=new FirefoxDriver();
		break;
		case "edge": driver=new EdgeDriver();
		break;
		
		}
		
		return driver;
	}
	@BeforeMethod
	public LoginPage launchApp() throws IOException {
		driver=initilizeDriver();
		loginpage=new LoginPage(driver);
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return loginpage;
		
		
	}
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	
}
