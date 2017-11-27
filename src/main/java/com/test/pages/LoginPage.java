package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.Utils.Functions;

public class LoginPage {
	WebDriver driver;

	@FindBy(id="txt_login_username")
	private WebElement usernameInputBox;

	@FindBy(id="txt_login_password")
	private WebElement passwordInputBox;

	@FindBy(id="btn_login_submit")
	private WebElement submitButton;
	
	@FindBy(id="btn_user_portal")
	private WebElement userPortalButton;

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void inputTextIntoUserName(String username){
		Functions.inputText(driver, usernameInputBox, username);
	}

	public void inputTextIntoPassword(String password){
		Functions.inputText(driver, passwordInputBox, password);
	}

	public void clickOnSubmitButton(){
		Functions.clickElement(driver, submitButton);
	}

	public void ClickOnUserPortalButton(){
		userPortalButton.click();
//		Functions.launchURL("http://52.37.60.147/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page")
	}
	
	
}
