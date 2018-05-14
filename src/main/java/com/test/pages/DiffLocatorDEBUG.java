package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiffLocatorDEBUG {
	@FindBy(xpath="//input[@type='text'][@placeholder='Select']")
	public static WebElement clientInputBox;
	
	WebDriver driver;
	public DiffLocatorDEBUG(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	//@FindBy(xpath="//table[@class='SilverGrid validation-Holder  ']/tbody/tr/td//input[@value='Claim #:']/../../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	//public static WebElement claimInputBox;
	
	
	//@FindBy(xpath="//input[@type='text'][@placeholder='Select']")
	//public static WebElement clientInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td//input[@value='Claim #:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement claimInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Reviewed State:']/../../../../../../../../td[3]//input")
	public static WebElement stateInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Pay Code:']/../../../../../../../../td[3]//input")
	public static WebElement paycodeInputBox;
	
	
	@FindBy(xpath="//div[@componentname='ddl_PayCode']//span[@class='arrow-down ']")
	public static WebElement paycodeDropDownArrow;
	
	@FindBy(xpath="//div[contains(@class,'dp-popup-layer dp-popup-layer__combobox Commonscroll ')]/div/div[2]/span")
	public static WebElement itemsDropdownSecondOption;
	
	
	
	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Bill ID:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement billIDInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td//input[@value='Billing Tax ID:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement billTaxIDInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Billing NPI:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement billNPIInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td//input[@value='Rendering NPI:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement renderingNPIInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td//input[@value='Service Location ZIP:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement locationZIPIInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Provider Facility NPI:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement facilityNPIInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Bill Type:']/../../../../../../../../td[3]//input")
	public static WebElement billTypeInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Bill Type:']/../../../../../../../../td[3]//span[contains(@class,'dp-delete-icon')]")
	public static WebElement billTypeDeleteIcon;
	
	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Specialty:']/../../../../../../../../td[3]//input")
	public static WebElement specialtyeInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Patient ID:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement patientIDInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td//input[@value='ICD Procedure Codes:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement procedureCodeInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Type of Bill:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement typeOfBillInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//input[@value='Medicare Number:']/../../../../../../../../td[8]//input")
	public static WebElement medicareNoInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Admission Hour:']/../../../../../../../../td//input[contains(@id,'SilverTextBox')]")
	public static WebElement admissionHourInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Admission Type:']/../../../../../../../../td//input")
	public static WebElement admissionTypeInputBox;

	
	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Admission Source:']/../../../../../../../../td//input")
	public static WebElement admissionSrcInputBox;
	
	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Admission Type:']/../../../../../../../../td//span[contains(@class,'arrow-down')]")
	public static WebElement admissionTypeDropDownArrow;

	
	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Admission Source:']/../../../../../../../../td//span[contains(@class,'arrow-down')]")
	public static WebElement admissionSrcDropDownArrow;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Discharge Hour:']/../../../../../../../../td[8]//input[contains(@id,'SilverTextBox')]")
	public static WebElement dischargenHourInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Discharge Status:']/../../../../../../../../td[13]//input[contains(@id,'SilverTextBox')]")
	public static WebElement dischargenStatusInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Admitting Diagnosis:']/../../../../../../../../td//input[contains(@id,'SilverTextBox')]")
	public static WebElement admittingDiagnosisInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td//input[@value='Principal Proc Codes:']/../../../../../../../../td[8]//input[contains(@id,'SilverTextBox')]")
	public static WebElement principalProcCodesInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='Operating Prov NPI:']/../../../../../../../../td[3]//input[contains(@id,'SilverTextBox')]")
	public static WebElement operatingProvNPIInputBox;

	@FindBy(xpath="//table[@class='dp-grid']/tbody/tr/td[2]//div[text()='DRG:']/../../../../../../../../td[8]//input[contains(@id,'SilverTextBox')]")
	public static WebElement DRGInputBox;


	
	
	
	
}
