package stepDefinitions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import genericFunction.Property;

public class BasePage {
	public static WebDriver driver;
	
	
	public static void navigateToUrl() throws Exception {
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void clickElement(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		try {
			driver.findElement(locator.getLocator(element)).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void sendKeys(String element, Property locator, String value) throws Exception {
		Thread.sleep(3000);
		
		try {
			driver.findElement(locator.getLocator(element)).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			//failedScreenshot("Element_not_entered");
		}
	}
	
	public static void selectByText(String element, Property locator, String value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectByValue(String element, Property locator, String value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectByIndex(String element, Property locator, int value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByIndex(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void acceptAlert() throws Exception {
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
	}
	
	public static void dismissAlert() throws Exception {
		Thread.sleep(2000);
		
		driver.switchTo().alert().dismiss();
	}
	
	public static void switchToFrame(String frameID) throws Exception {
		Thread.sleep(2000);
		
		try {
			driver.switchTo().frame(frameID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dragAndDrop(String source, String destination, Property locator) throws Exception{
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		WebElement sourceValue = driver.findElement(locator.getLocator(source));
		WebElement target = driver.findElement(locator.getLocator(destination));
		try {
			action.dragAndDrop(sourceValue, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mouseHover(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		try {
			action.moveToElement(driver.findElement(locator.getLocator(element))).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void rightClick(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		try {
			action.contextClick(driver.findElement(locator.getLocator(element))).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void doubleClick(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		try {
			action.doubleClick(driver.findElement(locator.getLocator(element))).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void uploadFile(String location) throws Exception {
		Thread.sleep(3000);
		
		try {
			Runtime.getRuntime().exec(location);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String getText(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		String text = null;
		try {
			text = driver.findElement(locator.getLocator(element)).getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return text;
	}
	
	public static boolean isElementDisplayed(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		if(!(driver.findElement(locator.getLocator(element)).isDisplayed())) {
				return false;
		}
		
		return true;
		
	}
	
	public static boolean isElementSelected(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		if(!(driver.findElement(locator.getLocator(element)).isSelected())) {
				return false;
		}
		
		return true;
		
	}
	
	public static void takeScreenshot() throws Exception {
		Thread.sleep(3000);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//Screenshot//sc.png"));
	}
	
	public static void failedScreenshot(String testMethodName) throws Exception {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//FailedScreenshots//"+testMethodName+".png"));
	}
	
	public static void closeBrowser() {
		driver.quit();
	}

}
