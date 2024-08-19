package selenium.PageObjModel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.testComponents.BaseTest;

public class ErrorValidations extends BaseTest{
	
	
	@Test
	public void checkLoginError() throws IOException {
		
		
		loginpage.login("ravi@email", "ravi");
		
		Assert.assertEquals("Incorrect email or password.", loginpage.getErrorMsg());
	}

}
