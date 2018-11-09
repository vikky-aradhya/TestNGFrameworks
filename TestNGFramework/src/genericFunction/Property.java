package genericFunction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Property {
	
	//declaring a variable
	Properties properties;
	
	//Creating a constructor for Property class
	public Property(String mapFile) {
		//creating an object
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(mapFile);
			properties.load(in);
			in.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public By getLocator(String logicalElementName) throws Exception{
		String locator = properties.getProperty(logicalElementName);
		
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		
		if(locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if(locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if(locatorType.toLowerCase().equals("classname"))
			return By.className(locatorValue);
		else if(locatorType.toLowerCase().equals("linktext"))
			return By.linkText(locatorValue);
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if(locatorType.toLowerCase().equals("css"))
			return By.cssSelector(locatorValue);
		else if(locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("Locator type '"+ locatorType + "' not defined");
	}

}
