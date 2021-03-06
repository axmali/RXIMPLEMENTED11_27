package com.test.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {

	public static void clickElement(WebDriver driver, WebElement element) {
		dynamicWait(driver, element);
		
//		element.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}

	public static void inputText(WebDriver driver, WebElement element, String text) {
		dynamicWait(driver, element);
//		element.click();
		element.clear();
		if(!text.equalsIgnoreCase("NA"))
		{
			element.sendKeys(text+Keys.TAB);
		}
		//try {Thread.sleep(500);} catch (InterruptedException e) {	}
		
	}

	public static void switchToFrame(WebDriver driver) {
		driver.switchTo().frame(0);
	}

	public static void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static String titleOfWebpage(WebDriver driver) {
		return driver.getTitle();
	}

	public static String getText(WebElement element) {
		return element.getText();
	}

	public static boolean isElementPresent(WebDriver driver, WebElement element) {
		dynamicWait(driver, element);
		return element.isDisplayed();
	}

	public static boolean isEmpty(WebElement element) {
		System.out.println("attribute val:"+element.getAttribute("value"));
		return element.getAttribute("value").isEmpty();
	}

	public static void launchURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public static String getAttribute(WebElement webElement, String string) {
		// TODO Auto-generated method stub
		return webElement.getAttribute(string);
	}
	
	public static void pressTabKey(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	public static void dynamicWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static int newLocator(int locator, int position, int incrementorVal ){
		return locator+ position*incrementorVal;
	}
	
	public static void tabOut(WebElement element){
		element.sendKeys(Keys.TAB);
	}
	
	public static boolean isDisplayedMatch(WebElement element){
		try{
			return element.isDisplayed();
		}
		catch(Exception e){
			return false;
		}
		
	}
	
	

}
