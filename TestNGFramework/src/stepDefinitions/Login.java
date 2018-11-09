package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericFunction.Property;

public class Login extends BasePage {
	
	public Property loginmap = new Property(System.getProperty("user.dir")+"\\src\\ObjectMapping\\login.properties");
	
	
	@Test(priority = 5)
	public void click_login() throws Throwable {
		clickElement("login", loginmap);
		Reporter.log("Sign-in clicked successfully");
	}
	
	@Test(priority = 6)
	@Parameters({"username"})
	public void user_enters_the_username(String user) throws Throwable { 
		sendKeys("username", loginmap, user);
		Reporter.log("username entered successfully");
		
	}
	
	@Test(priority = 7)
	@Parameters({"password"})
	public void user_enters_the_password(String pwd) throws Throwable { 
		sendKeys("password", loginmap, pwd);
		Reporter.log("password entered successfully");
		Assert.assertTrue(driver.findElement(By.name("user")).isDisplayed());
	}
	
	@Test(priority = 8)
	public void user_clicks_on_Login() throws Throwable { 
		clickElement("signin", loginmap);
		takeScreenshot();
	}
	
	@Test(priority = 9, enabled = false)
	public void the_verify_the_title() throws Throwable { 
		String expected = "Find a Flight: Mercury Tours:";
		Assert.assertEquals(driver.getTitle(), expected);
	}
	
}
