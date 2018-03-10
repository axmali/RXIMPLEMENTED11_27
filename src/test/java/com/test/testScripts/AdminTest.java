package com.test.testScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.test.Utils.Functions;
import com.test.Utils.getData;
import com.test.pages.BillEntryPage;
import com.test.pages.ClientAdminPage;
import com.test.pages.LoginPage;

/**
 * Unit test for simple App.
 */
public class AdminTest 

{
	static WebDriver driver;
	static LoginPage loginPage;
	static BillEntryPage billEntryPage;
	String URL="http://52.37.60.147/decisions/Login.aspx";  			//QA
	//String URL="http://52.26.143.217/decisions/Login.aspx";				//Dev
	static String[][] data;


	@BeforeSuite
	public void setUp() throws IOException{
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		//driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		loginPage = new LoginPage(driver);
		billEntryPage = new BillEntryPage(driver);
		driver.get(URL);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		//Reader Header data Excel tab
		//		data = getData.readExcel("TestData3", "CMS");


	}

	@AfterSuite
	public void tearDown(){
		try {Thread.sleep(4000);} catch (InterruptedException e) {	}
		driver.quit();
	}


	
	@Test
	public void addNewClient() throws IOException, InterruptedException{
		navigateToUserPortal();
		navigateToClientAdminPage();
		ClientAdminPage clientPage=new ClientAdminPage(driver);
		clientPage.inputTextIntoClientID("Atest1");
	}
	
	@Test
	public void updateClient() throws IOException, InterruptedException{
		navigateToClientAdminPage();

	}


	public void navigateToUserPortal(){
		loginPage.inputTextIntoUserName("amalik@ekhealth.com");
		loginPage.inputTextIntoPassword("Summer!2017");
		loginPage.clickOnSubmitButton();
		loginPage.ClickOnUserPortalButton();
	}

	public void navigateToClientAdminPage(){
		driver.get("http://52.37.60.147/decisions/Primary/H/?FolderId=9cf2b85d-9544-11e6-ace6-00155d0fe70e&pageName=Clients%20Menu");  //QA
		//driver.get("http://52.26.143.217/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page");	//DEV

	}
}
