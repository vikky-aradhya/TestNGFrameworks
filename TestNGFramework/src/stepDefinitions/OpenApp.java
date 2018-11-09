package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class OpenApp extends BasePage {
	
	@BeforeTest
	@Parameters("Browser")
	public void user_opens_browser(String browser) throws Throwable { 
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			navigateToUrl();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	@AfterTest
	public void user_quits_the_browser() throws Throwable { 
		closeBrowser();
	}

}
