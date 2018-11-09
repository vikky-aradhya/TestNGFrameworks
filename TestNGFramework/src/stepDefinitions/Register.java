package stepDefinitions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericFunction.Property;

public class Register extends BasePage {
	
	public Property registermap = new Property(System.getProperty("user.dir")+"\\src\\ObjectMapping\\register.properties");
	
	@DataProvider(name="Authentication")
	public static Object[][] credentials() {
		return new Object[][] {{"mercury","mercury","mercury"}};
	}
	
	@Test
	public void click_register() throws Throwable { 
		clickElement("register", registermap);
	}
	
	@Test(dependsOnMethods={"click_register"})
	public void set_contact_information() throws Throwable { 
		
		sendKeys("firstname", registermap, "mercury");
		sendKeys("lastname", registermap, "mercury");
		sendKeys("phonenumber", registermap, "132654789");
		sendKeys("email", registermap, "mercury@abc.com");
	}
	
	@Test(dependsOnMethods={"set_contact_information"})
	public void set_mailing_information() throws Throwable { 
		
		sendKeys("address", registermap, "main road");
		sendKeys("city", registermap, "Bengaluru");
		sendKeys("state", registermap, "Karnataka");
		sendKeys("postal", registermap, "132654");
		selectByText("countryname", registermap, "INDIA ");
	}
	
	@Test(dependsOnMethods={"set_mailing_information"}, dataProvider="Authentication")
	public void set_user_information(String user, String pass, String cPass) throws Throwable {
		
		sendKeys("username", registermap, user);
		sendKeys("password", registermap, pass);
		sendKeys("cpassword", registermap, cPass);
	}
	
	@Test(dependsOnMethods={"set_user_information"})
	public void click_submitregister() throws Throwable {
		
		clickElement("register_submit", registermap);
	}
}
