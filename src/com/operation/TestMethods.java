package com.operation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods {
    
	public static WebDriver driver;
	public static WebElement element;
	public static Point point;
	
	
	

	public String abrirNavegador(String inputData) {

		switch (inputData) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "Opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

			break;

		}
		driver.manage().window().maximize();
		return inputData;

	}
	


	/**
	 * Method to CLICK on an Object
	 * 
	 * @param driver
	 * @param identificador
	 * @param locator
	 * @throws FindFailed
	 */

	public String click(WebDriver driver, String identificador, String locator)  {
		String result;
		try {
			switch (identificador) {
			case "ID":
				element = driver.findElement(By.id(locator));
				break;
			case "Name":
				element = driver.findElement(By.name(locator));
				break;
			case "Class Name":
				element = driver.findElement(By.className(locator));
				break;
			case "XPath":
				element = driver.findElement(By.xpath(locator));                   
				break;
			case "CssSelector":
				element = driver.findElement(By.cssSelector(locator));
				break;
			case "LinkText":
				element = driver.findElement(By.linkText(locator));
				break;
			case "Partial Link Text":
				element = driver.findElement(By.partialLinkText(locator));
				break;
			case "Tag Name":
				element = driver.findElement(By.tagName(locator));

				break;

			}
			if (element != null) {
				element.click();
				result = "Pass :: Successfully clicked";
			} else {
				System.out.println("Element not available");
				result = "Fail :: Element not available";
			}
		} catch (NoSuchElementException e) {
			result = "Failed :: Element not available - " + e;
		}
		System.out.println("Click Methods result is " + result);
		return result;

	}
	
	public String  WaitForElement (String identificador , String locator, String inputData) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		switch (identificador) {
		case "ID":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));			
			break;
		case "Name":
			wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));
			break;
		case "Class Name":
			wait.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
			break;
		case "XPath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			break;
		case "CssSelector":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			break;
		case "LinkText":
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
			break;
		case "Partial Link Text":
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locator)));
			break;
		case "Tag Name":
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(locator)));
			break;
		}
		return locator;
		
	}

	public String clear (WebDriver driver, String identificador, String locator)  {
		String result;
		try {
			switch (identificador) {
			case "ID":
			   element = driver.findElement(By.id(locator));
				break;
			case "Name":
				element =driver.findElement(By.name(locator));
				break;
			case "Class Name":
				 element = driver.findElement(By.className(locator));
				break;
			case "XPath":
				element = driver.findElement(By.xpath(locator));                  
				break;
			case "CssSelector":
				element = driver.findElement(By.cssSelector(locator));
				break;
			case "LinkText":
				 element = driver.findElement(By.linkText(locator));
				break;
			case "Partial Link Text":
				 element = driver.findElement(By.partialLinkText(locator));
				break;
			case "Tag Name":
			     element = driver.findElement(By.tagName(locator));
				break;

			}
			if (element != null) {
				element.clear();
				result = "Pass :: Successfully clicked";
			} else {
				System.out.println("Element not available");
				result = "Fail :: Element not available";
			}
		} catch (NoSuchElementException e) {
			result = "Failed :: Element not available - " + e;
		}
		System.out.println("Click Methods result is " + result);
		return result;

	}
	
	public String scrollToElement (String identificador ,String locator) {
		WebElement element;
		JavascriptExecutor js = (JavascriptExecutor) driver;
			
		switch (identificador) {
		case "ID":
            element = driver.findElement(By.id(locator));
		    js.executeScript("arguments[0].scrollIntoView();", element);
			break;
		case "Name":
              element = driver.findElement(By.name(locator));			 
			  js.executeScript("arguments[0].scrollIntoView();", element);
			break;
		case "Class Name":
			  element = driver.findElement(By.className(locator));
			  js.executeScript("arguments[0].scrollIntoView();", element);
			break;
		case "XPath":
			  element = driver.findElement(By.xpath(locator));
			  js.executeScript("arguments[0].scrollIntoView();", element);
			break;
		case "CssSelector":
			element = driver.findElement(By.cssSelector(locator));
			  js.executeScript("arguments[0].scrollIntoView();", element);
			break;
		case "LinkText":
			element = driver.findElement(By.linkText(locator));
			  js.executeScript("arguments[0].scrollIntoView();", element);
			break;
		case "Partial Link Text":
			element = driver.findElement(By.partialLinkText(locator));
			  js.executeScript("arguments[0].scrollIntoView();", element);
			break;
		case "Tag Name":
		  	  element = driver.findElement(By.tagName(locator));
			  js.executeScript("arguments[0].scrollIntoView();",element);
			break;

		}
		
		
		return locator;
	}



	/**
	 * Method to launch AUT Site
	 * 
	 * @param driver
	 * @param URL
	 */
	public String openUrl(WebDriver driver, String URL) {
		driver.get(URL);
		return "Pass :: Successfully Launched URL " + URL;
	}

	/**
	 * Method to enter some data inside textbox. text area
	 * 
	 * @param driver
	 * @param identificador
	 * @param locator
	 * @param inputData
	 * @return
	 */
	public String enterText(WebDriver driver, String identificador, String locator, String inputData) {
		try {
			switch (identificador) {

			case "ID":				
				element = driver.findElement(By.id(locator));
				break;
			case "Name":
				element = driver.findElement(By.name(locator));
				break;
			case "Class Name":
				element = driver.findElement(By.className(locator));
				break;
			case "XPath":
				element = driver.findElement(By.xpath(locator));
			case "CssSelector":
				element =driver.findElement(By.cssSelector(locator));
				break;
			case "LinkText":
				element =driver.findElement(By.linkText(locator));
				break;
			case "Partial Link Text":
				element = driver.findElement(By.partialLinkText(locator));
				break;
			case "Tag Name":
				element = driver.findElement(By.tagName(locator));
				break;
			}

			if (element != null) {
				element.sendKeys(inputData);
				return "Pass :: Successfullly entered " + inputData + " text";
			} else {
				System.out.println("Element not available");
				return "Failed :: Element not available";

			}
		} catch (NoSuchElementException e) {
			return "Failed::" + e;

		}

//		try {
//			WebElement element = driver.findElement(By.xpath(locator));
//
//			if (element != null) {
//				element.sendKeys(inputData);
//				return "Pass :: Successfullly entered " + inputData + " text";
//			} else {
//				System.out.println("Element not available");
//				return "Failed :: Element not available";
//			} 
//		} catch (NoSuchElementException e) {
//			return "Failed::" + e;
//		}
	}

	/**
	 * Method to Verify if text is matching with expected text message
	 * 
	 * @param driver
	 * @param identificador
	 * @param locator
	 * @param textToVerify
	 * @return
	 */
	public String verifyText(WebDriver driver, String identificador, String locator, String textToVerify) {

		switch (identificador) {
		case "ID":
			element = driver.findElement(By.id(locator));
			break;
		case "Name":
			element = driver.findElement(By.name(locator));
			break;
		case "Class Name":
			element = driver.findElement(By.className(locator));
			break;
		case "XPath":
			element = driver.findElement(By.xpath(locator));
			break;
		case "CssSelector":
			element = driver.findElement(By.cssSelector(locator));
			break;
		case "LinkText":
			element = driver.findElement(By.linkText(locator));
			break;
		case "Partial Link Text":
			element = driver.findElement(By.partialLinkText(locator));
			break;
		case "Tag Name":
			element = driver.findElement(By.tagName(locator));
			break;

		}
		if (element != null) {
			if (textToVerify.equalsIgnoreCase(element.getText())) {
				System.out.println("Text is matching");
				return "Passed :: Text is matching";
			} else {
				System.out.println("Text is not matching");
				return "Failed :: Text is not matching";

			}
		} else {
			System.out.println("Element not available");
			return "Failed :: Element not available";
		}

	}



	
	



	

}
