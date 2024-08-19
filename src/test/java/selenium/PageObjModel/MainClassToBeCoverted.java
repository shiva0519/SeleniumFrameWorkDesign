package selenium.PageObjModel;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.PageObjects.CartPage;
import selenium.PageObjects.ConformPage;
import selenium.PageObjects.OrdersPage;
import selenium.PageObjects.PaymentPage;
import selenium.PageObjects.ProductCatalog;
import selenium.testComponents.BaseTest;

public class MainClassToBeCoverted extends BaseTest {

	static WebElement productGot;
	String product = "ADIDAS ORIGINAL";
	String email = "prac@gmail.com";
	String pass = "Prac@123";

	@Test(dataProvider = "data")
	public void submitOrder(HashMap<String, String> input) throws IOException {

		// LoginPage loginpage=launchApp();

		loginpage.login(input.get("email"), input.get("password"));

		ProductCatalog p = new ProductCatalog(driver);

		p.addToCart(input.get("product"));

		CartPage ct = new CartPage(driver);
		// ct.checkProductAdded(product);

		ct.checkout(input.get("product"));
		PaymentPage pg = new PaymentPage(driver);
		pg.selectCountry("India");

		ConformPage cf = new ConformPage(driver);
		Assert.assertTrue(cf.confirm());

	}

	@Test(dependsOnMethods = { "submitOrder" }, dataProvider = "data")
	public void checkInOrders(HashMap<String, String> input) {
		OrdersPage or = new OrdersPage(driver);
		loginpage.login(input.get("email"), input.get("password"));

		or.goToOrdersPage();
		or.checkOrderIsThere(input.get("product"));

	}

	@DataProvider
	public Object[][] data() {
		HashMap<Object, Object> hs = new HashMap<Object, Object>();
		hs.put("email", "prac@gmail.com");
		hs.put("password", "Prac@123");
		hs.put("product", "ADIDAS ORIGINAL");
		HashMap<Object, Object> hs1 = new HashMap<Object, Object>();
		hs1.put("email", "demo65@gmail.com");
		hs1.put("password", "Shiva@123");
		hs1.put("product", "ZARA COAT 3");

		return new Object[][] { { hs }, { hs1 } };
	}

}
