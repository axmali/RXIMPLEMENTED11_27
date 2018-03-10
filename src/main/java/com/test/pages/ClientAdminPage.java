package com.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.Utils.Functions;

public class ClientAdminPage {
	WebDriver driver;
	
	public ClientAdminPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='ClientID:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement clientIDInput;
	
	public void inputTextIntoClientID(String clientID){
		Functions.inputText(driver, clientIDInput, clientID);
	}
	
	@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td[2]//div[text()='Company Name:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	private WebElement companyInput;
	
	public void inputTextIntoCompanyInput(String clientID){
		Functions.inputText(driver, companyInput, clientID);
	}
	
	
	
	
}
