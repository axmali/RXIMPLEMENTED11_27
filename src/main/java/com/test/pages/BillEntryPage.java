package com.test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.Utils.Functions;

public class BillEntryPage {
	WebDriver driver;

	//li[@folder-name="Bill Entry"]//a
	
	@FindBy(xpath="//input[contains(@id,'ItemSelectorText_')]")
	private List<WebElement> dropdownInputBoxes;

	@FindBy(xpath="//input[contains(@id,'SilverTextBox')]")
	private List<WebElement> silverInputBoxes;

	@FindBy(xpath="//input[@placeholder='<M/d/yyyy>']")
	private List<WebElement> dateInputBoxes;

	@FindBy(xpath="//div[contains(@id,'ItemSelectorArrowDiv_')]")
	private List<WebElement> itemSelectorArrow;

	@FindBy(xpath="//div[contains(@id,'ItemSelectorItemListDiv_')]")
	private List<WebElement> listUnderitemSelectorArrow;


	@FindBy(xpath="//button[contains(@id,'SilverButton_') and text()='Next']")
	private List<WebElement> nextButtonList;

	//Line Item page
	@FindBy(xpath="//input[contains(@id,'numBox')]")
	private List<WebElement> numBoxList;
	//numboxes = driver.findElements(By.xpath("//input[contains(@id,'numBox')]"));

	@FindBy(xpath="//img[@name='Image_Indicator_BillingTaxID_New' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAUoSURBVEhLtVVbbBRlFP5mdmZn/713u2z30nbb3d7SQkoorWmgtGChJIJGrBKQQIgIFAM0SlTsAwoBggn4oomJT1zCiyZGI4H4YtRYItYEUYKUWwqlLAKWLnuZ3Zmd8czuBm1K+2I4m7Pnn3P5v3PmP+cfPG3iinJG2vbyLLs/Yv200i++AgHczZvqV9f+Gt909OjEw6LL/6ODu6tODA/16cqjQV0eP6MPn9ugHxoIf100z0imopyWPtgVbp8z2/dRW8cAl07egZIdh6ukHKmJP+uj1abBH87Grxddn0h8UU5HHGPakUWLX+PlZAy8KMIkMcipe2hta4PTzh8mnxmTnNG4f3d4bXtr087q+pVQMndhL/HBbBGRnrgGUWQw6X+XRSv1se8G478WQ6bQtBX09oIxQTvYtmAd5OQoROYCx41SV4zC4o5CVZOY09wIh92899XlHmcxbApNC9BcXfVW15JnK3WYAS0Oq92Sl9CSsLnc4HiVvDgsbC/3ResdA4WoqfREgP7XvYEyL//O7LkrkJVvw+zw0143AbOH2EseI7B5m5HLpRGtrUCFz7Kzv88XKURPpicCeFzW/d09vXY5fZ9yVMAcPG6NlmFH/3n09Z3DxYt+WJw5aLkbSDw4jQXPpCSXxD4shk+iKQDv9Qfm1VQ51wcr50FV7oG5Kkg7hlgsg1TiAYaGBnHq1DeAegbOsmbouQl4vOOoDUurdm+t6Cjs8i9NAbCJwuHu5etMcvI6TKIEM8sBOiBnHuLYsRME8DNsVpEiGZidwVIyG2pOo7NIcBYbf4S2mHQ7TALYszO0at7cui672wtNS1D2QTpU4za4BeQuQFHSeb+yACM9geTGURJ6DjynUhPE0dIozh/YWrE+71SkxwCNjTDbbPqhhYtfRCY5AkFyQzRTp+QuA9kLqImWFD2BSDWtdYFWIgRRByvtgKZraG2NG719YOlS2Aqe/wHo7Qlv71jQWcMLGQpOweoKAcp5yvQqPTMEKq1oafHluS7iJj0BcFSFJtNZLAPPcxAtMjrb9WBLdejt4raFSX5zc8AbmIUvVr602SKnb9BQ+SGxGGX/O1npdfA0C7RXZWUEtXUhtC+kts0lyEZ6MnAmHjrnhpIeRjCUw/BlNj8S5I4PXZTj+QpsFn5vz/LV7kz2GmWrgjntlL0x/TRcRpacgPh9N7bv+Anv7zmLOyN0jgYo6QtV6LB7usALDDqvoHuJZrM72AFjb37b+rKmaLl9U6RhDjTlISRHGLz2I5mkQrCRulnE6W/HcPXKJYyNjeDLU3QuQiH7POeB0mCe1dApwZqGBOqqxbVb1njaeJcN+5a9sFGUk7/R+AtgVuM6oG7hjWACMaQqorMjAoczBEFwoburiXwMAMNObEj6EjFHOxUWRE7TsKxH5a2CdIgP+aUV/vIGasskBFYKNX2W7vwsstkUcZKuihQUYp/7EiZiG5GN70IkfIXe9wTZiTNxZNU41MwjGszbMFmfp7HREAzLCPvFRdzHe8PKG++eFOJ3PyOnCwTwB5XLU29TUvTHkTTY6DeOBi4vSZGfJlIYa+OBM9ZGEGeiMDMkC4fD+8xZU1OtNVJqT82talgJXbtMk1sBs7Wcuqic1kG6/4lZAGaJ2ErfA8lPXeYl6aO2LCVbKc1LCfmRFF2QJCfNhoRfvjdhcEg5yW3ohMVb7//E7+HWOJ1epmtG1lQkdYbxo2opUXomNjI29AU7VfB4TdJ4pLXhm5AzSuyO9nlMjW0xCn2KBPwDyIG4Q+o2D+AAAAAASUVORK5CYII=']")
	private WebElement warningIcon;

	@FindBy(xpath="//button[text()='Select Provider']")
	private WebElement selectProviderButton;

	@FindBy(xpath="//img[@name='Image_Indicator_BillingTaxID_New' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB3RJTUUH2AQPDQ0laSi7LQAAAAlwSFlzAAALEgAACxIB0t1+/AAAAARnQU1BAACxjwv8YQUAAALdSURBVHjabVPvS1NRGH7OvfPeuU03M9TEAsmVKIz+gBA0w4SKzWmyRSkk7IPf9U8JKvowwiACi74GQj9QcPghlXKacxk2U8Fwbvfuxz09VzYx6LDDOTvnfZ73ed73XBWVcRMYagcWrgLbG8AK/jNCwEgHkOgCvn87GzMAjEacTuv91JR85PHIIWCMx+Is+D4QiWma9bqvT8Z0XY4CD+1z1c58zuV6NTk9LXx1degOBLC5tBTsKBZTTPHFDiJbxKfrM7f7+4ViWbjU1IRfmUyo3bKS4gZwODU56W3ioXl0BKtYRCmfx2w8joxhjGtA4bymzQz29sI0TRSOj1FiTDGbxezGRkm9AmxuLi8Pd/v9ArwoM8BRKqHr8mXsJJNBl8MRDvX0QJTLkLkcLJILxixubSEr5cSJzzAlNjJLNByGJgREoQAHAbYie69wze/vw+BaoIoESXaA2HPgmWoTfGVF/eVyMr22Fu5ua4OTPh1Uo+7uQqTTUCjXVqWSdJEqdqWMPSWYUEutVnnFJmFR0qlUuNPng0qJGjPW1tRAdzhgUcnHw0NsW1bscQVs45SzrbL/KMyUW12FztWj66h3OuHRNNTYfZUStYDJraxiThXYrWoQYmaArWz2euEmyM3sbpLoqgqN60XGZfL54DUg9bnS4hOCCH/1BPfV1qLR5YKTkll9HNG7Qt91bjcKVFTmWSvjf5pmMECSBZKoQeCeD3h5XdeFl1lqFOXEc57Feru3hxX69lMJeGaQrMj7ZnYqUygE+QTWxV16uqWqWgNl2l5t3wq9zhH427LGncBBqxDv7rS0oEiiYxbTnjnDwJtcrqR28iH9kTJ8wc7MWWQL51j9A4JZ7fg8s9BzYiufj7ZRhcl7gwSfqDALPFDXgGVKSR1IGWqitHkycz/OPser1WbB1gNSJn4YRrSFMR/4Eg+lHHsCvDht4TAQHeG7j5x8eP9+iZUhJoBBTpMzWj38C2dRTZc15mQUAAAAAElFTkSuQmCC']")
	private WebElement crossIcon;

	@FindBy(xpath="//input[@value='Billing Tax ID:']")
	private WebElement billTaxIdLabel;

	@FindBy(css=".jqgfirstrow+tr")
	private WebElement firstRowSelectProvider;

	@FindBy(xpath="//button[contains(@id,'SilverEventButton_') and text()='Checksum']")
	private WebElement checksumButton;

	@FindBy(xpath="//button[contains(text(),'Price') and @class='buttonControl FullHeightAndWidth EnableControl']")
	private WebElement priceButton;


	public BillEntryPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void inputTextIntoClient(String client){
		Functions.inputText(driver, dropdownInputBoxes.get(0), client);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Functions.pressTabKey(dropdownInputBoxes.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void inputTextIntoPaycode(String paycode){
		Functions.inputText(driver, dropdownInputBoxes.get(2), paycode);
	}

	public String getAttributeBillTypeText(){
		return Functions.getAttribute(dropdownInputBoxes.get(3), "value");
	}

	public void inputTextIntoAdmissionType(String AdmissionType){
		Functions.inputText(driver, dropdownInputBoxes.get(5), AdmissionType);
	}

	public void inputTextIntoClaim(String claim){
		Functions.inputText(driver, silverInputBoxes.get(3), claim);
	}

	public void inputTextIntoState(String state){
		if(Functions.isEmpty(silverInputBoxes.get(5)))
			Functions.inputText(driver, silverInputBoxes.get(5), state);
	}

	public void inputTextIntoBillTaxID(String billtaxid){
		Functions.inputText(driver, silverInputBoxes.get(9), billtaxid);
	}

	public boolean isEmptyBillID(){
		return Functions.isEmpty(silverInputBoxes.get(7));
	}


	public void inputTextIntoBillID(String billid){
		Functions.inputText(driver, silverInputBoxes.get(7), billid);
	}


	public WebElement billTaxIDElement(){
		return silverInputBoxes.get(9);
	}


	public void inputTextIntoBillNPI(String billNPI){
		Functions.inputText(driver, silverInputBoxes.get(12), billNPI);
	}

	public void inputTextIntoRenderNPI(String renderNPI){
		Functions.inputText(driver, silverInputBoxes.get(13), renderNPI);
	}

	public void inputTextIntoLoczip(String loczip){
		Functions.inputText(driver, silverInputBoxes.get(16), loczip);
	}

	public void inputTextIntoFacilityNPI(String FacilityNPI){
		Functions.inputText(driver, silverInputBoxes.get(18), FacilityNPI);
	}

	public void inputTextDateIntoDOSFrm(String DOSFrm){
		Functions.inputText(driver, dateInputBoxes.get(1), DOSFrm);
	}

	//public void inputTextIntoDOSTO(String DOSTO){    //IF UB-04
	//	Functions.inputText(dateInputBoxes.get(3), DOSTO);
	//}

	public void inputTextIntoPatient(String Patient){
		Functions.inputText(driver, silverInputBoxes.get(21), Patient);
	}

	public void inputTextDateIntoBillDate(String BillDate){
		Functions.inputText(driver, dateInputBoxes.get(3), BillDate);
	}

	public void inputTextIntoProcedureCode(String ProcedureCode){
		Functions.inputText(driver, silverInputBoxes.get(22), ProcedureCode);
		Functions.pressTabKey(silverInputBoxes.get(22));
	}

	public void inputTextDateIntoClientRecvdDate(String ClientRecvdDate){
		Functions.inputText(driver, dateInputBoxes.get(4), ClientRecvdDate);
	}

	public void inputTextDateIntoBillRecvdDate(String BillRecvdDate){
		Functions.inputText(driver, dateInputBoxes.get(5), BillRecvdDate);
	}

	//  UB-04 Header fields

	public void inputTextIntoTypeofBill(String TypeofBill){
		Functions.inputText(driver, silverInputBoxes.get(25), TypeofBill);
	}

	public void inputTextIntoMedicareNO(String MedicareNO){
		Functions.inputText(driver, silverInputBoxes.get(26), MedicareNO);
	}

	public void inputTextDateIntoADmDt(String ADmDt){
		Functions.inputText(driver, dateInputBoxes.get(7), ADmDt);
	}

	public void inputTextDateIntoDschgDt(String DschgDt){
		Functions.inputText(driver, dateInputBoxes.get(8), DschgDt);
	}

	public void inputTextIntoAdmsnHr(String AdmsnHr){
		Functions.inputText(driver, silverInputBoxes.get(27), AdmsnHr);
	}

	public void inputTextIntoAdmissionSrc(String AdmissionSrc){
		Functions.inputText(driver, silverInputBoxes.get(28), AdmissionSrc);
	}

	public void inputTextIntoDischargeHr(String DischargeHr){
		Functions.inputText(driver, silverInputBoxes.get(29), DischargeHr);
	}

	public void inputTextIntoDischrgStatus(String DischrgStatus){
		Functions.inputText(driver, silverInputBoxes.get(30), DischrgStatus);
	}

	public void inputTextIntoAdmittingDiag(String AdmittingDiag){
		Functions.inputText(driver, silverInputBoxes.get(31), AdmittingDiag);
	}

	public void inputTextIntoPrinProcCDs(String PrinProcCDs){
		Functions.inputText(driver, silverInputBoxes.get(32), PrinProcCDs);
	}

	public void inputTextIntoPrinProcDt(String PrinProcDt){
		Functions.inputText(driver, dateInputBoxes.get(9), PrinProcDt);
	}

	public void inputTextIntoOpProvNPI(String OpProvNPI){
		Functions.inputText(driver, silverInputBoxes.get(34), OpProvNPI);
	}

	public void inputTextIntoDrgcd(String Drgcd){
		Functions.inputText(driver, silverInputBoxes.get(35), Drgcd);
	}

	
	//Next buttons	
	
	public void clickOnNextButton() {
	Functions.clickElement(driver, nextButtonList.get(0));
	}
	
	public void clickOnNextButtonUB04() {
	Functions.clickElement(driver, nextButtonList.get(1));
	}

	
	
	//Line Items   CMS
	//Line 1
	
	public void inputTextIntoPOS(String POS, int position){
		//POS 16 31 46 61
		//TOS 2 17 32 47 62
		// Billed Code 9 24 39 54 69 
		//Billed Mod  10 25 40 55 70
		//Reviewed Code 11 26 41 56 71
		//Daig  13 28 43 58 73
		
		//Numboxes
		//Days 5 16 27 38 49 60
		//Charges  6 17 28 39 50 61 
		//Fee Schedule Discount   7 18 29 40 51 62
		//Allowed  11 22 33 44 55 66
		
		int locator=Functions.newLocator(1, position, 15);
		
		Functions.inputText(driver, silverInputBoxes.get(locator), POS);
	}

	public void inputTextIntoTOS(String TOS, int position){
		int locator=Functions.newLocator(2, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), TOS);
	}

	public void inputTextIntoBillCd(String BillCd, int position){
		int locator=Functions.newLocator(9, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), BillCd);
	}

	public void inputTextIntoBillMd(String BillMd, int position){
		int locator=Functions.newLocator(10, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), BillMd);
	}

	public void inputTextIntoRevCd(String RevCd, int position){
		int locator=Functions.newLocator(11, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), RevCd);
	}
	
	public void tabOutFromRevCd(int position){
		int locator=Functions.newLocator(11, position, 15);
		Functions.tabOut(silverInputBoxes.get(locator));
	}

	public void inputTextIntoRevMd(String RevMd, int position){
		int locator=Functions.newLocator(12, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), RevMd);
	}

	public void tabOutFromRevMd(int position){
		int locator=Functions.newLocator(12, position, 15);
		Functions.tabOut(silverInputBoxes.get(locator));
	}
	public void inputTextIntoCMSDays(String Days, int position){
		int locator=Functions.newLocator(5, position, 13);
		Functions.inputText(driver, numBoxList.get(locator), Days);
	}

	public void inputTextIntoChrgs(String  Chrgs, int position){
		int locator=Functions.newLocator(6, position, 13);
		Functions.inputText(driver, numBoxList.get(locator), Chrgs);
	}

	public void inputTextIntoTotalCharges(String TotalCharges){
		Functions.inputText(driver, numBoxList.get(0), TotalCharges);
	}

	public void inputTextIntoDiag(String Diag, int position){
		int locator=Functions.newLocator(13, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), Diag);
	}

	public void tabOutFromDiag(int position){
		int locator=Functions.newLocator(13, position, 15);
		Functions.tabOut(silverInputBoxes.get(locator));
	}

	//Line Items   UB-04
	//Line 1

	public void inputTextIntoBillRevenueCd(String BillRevenueCd, int position){
		int locator=Functions.newLocator(6, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), BillRevenueCd);
	}

	public void inputTextIntoReviewedCd(String ReviewedCd, int position){
		Functions.inputText(driver, silverInputBoxes.get(7), ReviewedCd);
	}
	
	public void tabOutFromReviewedCd(int position){
		int locator=Functions.newLocator(7, position, 15);
		Functions.tabOut(silverInputBoxes.get(locator));
	}

	public void inputTextIntoMod(String Mod, int position){
		int locator=Functions.newLocator(8, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), Mod);
	}

	public void inputTextIntoUB04Days(String Days, int position){
		int locator=Functions.newLocator(4, position, 13);
		Functions.inputText(driver, numBoxList.get(locator), Days);
	}


	//Line Items   RX
	//Line 1

	public void inputTextIntoBillNDCCd(String BillNDCCd, int position){
		int locator=Functions.newLocator(2, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), BillNDCCd);
	}

	public void inputTextIntoRewNDCCd(String RewNDCCd, int position){
		int locator=Functions.newLocator(3, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), RewNDCCd);
	}

	public void inputTextIntoQuantity(String Quantity, int position){
		int locator=Functions.newLocator(1, position, 13);
		Functions.inputText(driver, numBoxList.get(locator), Quantity);
	}

	public void inputTextIntoDaysupply(String Daysupply, int position){
		int locator=Functions.newLocator(2, position, 13);
		Functions.inputText(driver, numBoxList.get(locator), Daysupply);
	}

	public void inputTextIntoDAW(String DAW, int position){
		int locator=Functions.newLocator(3, position, 13);
		Functions.inputText(driver, numBoxList.get(locator), DAW);
	}

	public void inputTextIntoRXNo(String RXNo, int position){
		int locator=Functions.newLocator(4, position, 15);
		Functions.inputText(driver, silverInputBoxes.get(locator), RXNo);
	}

//end of lines

	public boolean isDisplayedCrossIcon() {
		return Functions.isElementPresent(driver, crossIcon);
	}

	public boolean isDisplayedWarningIcon() {
		return Functions.isElementPresent(driver, warningIcon);
	}


	public void clickOnWarningIcon() {
		Functions.clickElement(driver, warningIcon);
	}

	public void clickOnCrossIcon() {
		Functions.clickElement(driver, crossIcon);
	}

	public void clickOnFirstRowSelectProvider() {
		Functions.clickElement(driver, firstRowSelectProvider);
	}


	public void clickOnSelectProviderButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Functions.clickElement(driver, selectProviderButton);
	}

	public void clickOnBillTaxIdLabel() {
		Functions.clickElement(driver, billTaxIdLabel);
	}


	public void clickOnCheckSumButton() {
		Functions.clickElement(driver, checksumButton);
	}

	public void clickOnPriceButton() {
		Functions.clickElement(driver, priceButton);
	}

	public String getTextFromFeeScheduleDis(int position){
		int locator=Functions.newLocator(7, position, 13);
		return Functions.getAttribute(numBoxList.get(locator),"value");
	}

	public void inputTextIntoRXDaysSupply(String Days) {
		Functions.inputText(driver, numBoxList.get(2), Days);

		
	}


	//	public void clickOnNextButton(){
	//		Functions.clickElement(submitButton);
	//	}


}
