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
import com.test.testScripts.TestScript;

public class BillEntryPage extends CommonLocator {
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


	@FindBy(xpath="//button[contains(@id,'SilverButton_') and text()='Next']/../../../section[not(contains(@style,'display: none;'))]")  ////button[contains(@id,'SilverButton_') and text()='Next']
	private WebElement nextButtonList;

	private WebElement admissionTypeDropDownArrow;

	private WebElement itemsDropdownSecondOption;

	//Line Item page
	;


	////------------------------------------New Xpaths......................................................







	////-----------------------------------------------------------------------------------------------------


	public BillEntryPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void inputTextIntoClient(String client){
		WebElement clientInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			clientInputBox=DiffLocatorQA.clientInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			clientInputBox=DiffLocatorDEBUG.clientInputBox;

		}
		Functions.inputText(driver,clientInputBox, client);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Functions.pressTabKey(clientInputBox);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void inputTextIntoClaim(String claim){
		WebElement claimInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			claimInputBox=DiffLocatorQA.claimInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			claimInputBox=DiffLocatorDEBUG.claimInputBox;

		}

		Functions.inputText(driver, claimInputBox, claim);
	}

	public void inputTextIntoState(String state){
		WebElement stateInputBox = null;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(TestScript.env.equalsIgnoreCase("QA")){
			stateInputBox=DiffLocatorQA.stateInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			stateInputBox=DiffLocatorDEBUG.stateInputBox;

		}
		System.out.println("value: "+Functions.isEmpty(stateInputBox));
		if(Functions.isEmpty(stateInputBox))
			Functions.inputText(driver,stateInputBox, state);
	}

	public void inputTextIntoPaycode(String paycode){
		WebElement paycodeInputBox = null;

		if(Functions.isEmpty(paycodeInputBox))
			if(TestScript.env.equalsIgnoreCase("QA")){
				paycodeInputBox=DiffLocatorQA.paycodeInputBox;
			}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			paycodeInputBox=DiffLocatorDEBUG.paycodeInputBox;

		}
		Functions.inputText(driver, paycodeInputBox, paycode);
	}

	public void selectPaycode(){
		WebElement Paycode;
		if(TestScript.env.equalsIgnoreCase("QA")){
			Functions.clickElement(driver, DiffLocatorQA.paycodeDropDownArrow);
			Functions.clickElement(driver,DiffLocatorQA.itemsDropdownSecondOption);
		}
	if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			Functions.clickElement(driver, DiffLocatorDEBUG.paycodeDropDownArrow);
			Functions.clickElement(driver,DiffLocatorDEBUG.itemsDropdownSecondOption);
		}

	}

	public boolean isEmptyBillID(){
		return Functions.isEmpty(DiffLocatorQA.billIDInputBox);
	}

	public void inputTextIntoBillID(String billid){
		WebElement billIDInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			billIDInputBox=DiffLocatorQA.billIDInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			billIDInputBox=DiffLocatorDEBUG.billIDInputBox;
		}
			Functions.inputText(driver, billIDInputBox, billid);
		
	}

	public void inputTextIntoBillTaxID(String billtaxid){
		WebElement billTaxIDInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			billTaxIDInputBox=DiffLocatorQA.billTaxIDInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			billTaxIDInputBox=DiffLocatorDEBUG.billTaxIDInputBox;
		}
		Functions.inputText(driver,billTaxIDInputBox, billtaxid);
	}


	public WebElement billTaxIDElement(){/////////////////
		return DiffLocatorQA.billTaxIDInputBox;
	}

	public void inputTextIntoBillNPI(String billNPI){
		WebElement billNPIInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			billNPIInputBox=DiffLocatorQA.billNPIInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			billNPIInputBox=DiffLocatorDEBUG.billNPIInputBox;
		}

		Functions.inputText(driver, billNPIInputBox, billNPI);
	}

	public void inputTextIntoRenderNPI(String renderNPI){
		WebElement renderNPIInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			renderNPIInputBox=DiffLocatorQA.renderingNPIInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			renderNPIInputBox=DiffLocatorDEBUG.renderingNPIInputBox;

		}
		Functions.inputText(driver, renderNPIInputBox, renderNPI);
	}


	public void inputTextIntoLoczip(String loczip){
		WebElement locationZIPIInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			locationZIPIInputBox=DiffLocatorQA.locationZIPIInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			locationZIPIInputBox=DiffLocatorDEBUG.locationZIPIInputBox;

		}

		Functions.inputText(driver, locationZIPIInputBox, loczip);
	}


	public void inputTextIntoFacilityNPI(String FacilityNPI){
		WebElement facilityNPIInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			facilityNPIInputBox=DiffLocatorQA.facilityNPIInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			facilityNPIInputBox=DiffLocatorDEBUG.facilityNPIInputBox;


		}
		Functions.inputText(driver,facilityNPIInputBox , FacilityNPI);
	}



	public String getAttributeBillTypeText(){
		WebElement billTypeInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			billTypeInputBox=DiffLocatorQA.billTypeInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			billTypeInputBox=DiffLocatorDEBUG.billTypeInputBox;

		}
		return Functions.getAttribute(billTypeInputBox, "value");
	}

	public void inputTextIntoeBillType(String billtype){
		WebElement billTypeInputBox = null, billTypeDeleteIcon = null;
		
		if(TestScript.env.equalsIgnoreCase("QA")){
			billTypeInputBox=DiffLocatorQA.billTypeInputBox;
			billTypeDeleteIcon=DiffLocatorQA.billTypeDeleteIcon;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			billTypeInputBox=DiffLocatorDEBUG.billTypeInputBox;
			billTypeDeleteIcon=DiffLocatorDEBUG.billTypeDeleteIcon;
		}
		Functions.clickElement(driver, billTypeInputBox );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Functions.clickElement(driver, billTypeDeleteIcon);

		Functions.inputText(driver, billTypeInputBox, billtype);
		//Functions.tabOut(billTypeInputBox);
	}

	public String getAttributeSpecialtyText(){
		WebElement specialtyInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			specialtyInputBox=DiffLocatorQA.specialtyeInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			specialtyInputBox=DiffLocatorDEBUG.specialtyeInputBox;

		}
		return Functions.getAttribute(DiffLocatorDEBUG.specialtyeInputBox, "value");
	}


	public void inputTextDateIntoDOSFrm(String DOSFrm){
		Functions.inputText(driver, dateInputBoxes.get(1), DOSFrm);  	 //Date
	}

	public void inputTextIntoDOSTO(String DOSTO){    
		Functions.inputText(driver,dateInputBoxes.get(2), DOSTO);		//Date
	}



	public void inputTextIntoPatient(String Patient){
		WebElement PatientInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			PatientInputBox=DiffLocatorQA.patientIDInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			PatientInputBox=DiffLocatorDEBUG.patientIDInputBox;

		}
		Functions.inputText(driver, PatientInputBox, Patient);
	}

	public void inputTextDateIntoBillDate(String BillDate){   		//Provider Bill Date
		Functions.inputText(driver, dateInputBoxes.get(3), BillDate);
	}

	public void inputTextIntoProcedureCode(String ProcedureCode){
		WebElement ProcedureCodeInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			ProcedureCodeInputBox=DiffLocatorQA.procedureCodeInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			ProcedureCodeInputBox=DiffLocatorDEBUG.procedureCodeInputBox;

		}
		Functions.inputText(driver, ProcedureCodeInputBox, ProcedureCode);
		Functions.pressTabKey(ProcedureCodeInputBox);
	}

	public void inputTextDateIntoClientRecvdDate(String ClientRecvdDate){		//Date
		Functions.inputText(driver, dateInputBoxes.get(4), ClientRecvdDate);
	}

	public void inputTextDateIntoBillRecvdDate(String BillRecvdDate){  			//Date
		Functions.inputText(driver, dateInputBoxes.get(5), BillRecvdDate);
	}

	//  UB-04 Header fields

	public void inputTextIntoTypeofBill(String TypeofBill){
		WebElement TypeofBillInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			TypeofBillInputBox=DiffLocatorQA.typeOfBillInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			TypeofBillInputBox=DiffLocatorDEBUG.typeOfBillInputBox;

		}
		Functions.inputText(driver, TypeofBillInputBox, TypeofBill);
	}

	public void inputTextIntoMedicareNO(String MedicareNO){
		WebElement MedicareNOInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			MedicareNOInputBox=DiffLocatorQA.medicareNoInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			MedicareNOInputBox=DiffLocatorDEBUG.medicareNoInputBox;

		}

		Functions.inputText(driver, MedicareNOInputBox, MedicareNO);
	}

	public void inputTextDateIntoADmDt(String ADmDt){							//Date
		Functions.inputText(driver, dateInputBoxes.get(7), ADmDt);	
	}

	public void inputTextDateIntoDschgDt(String DschgDt){						//Date
		Functions.inputText(driver, dateInputBoxes.get(8), DschgDt);
	}

	public void inputTextIntoAdmsnHr(String AdmsnHr){
		WebElement AdmsnHrInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			AdmsnHrInputBox=DiffLocatorQA.admissionHourInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			AdmsnHrInputBox=DiffLocatorDEBUG.admissionHourInputBox;
		}
		Functions.inputText(driver, AdmsnHrInputBox, AdmsnHr);
	}

	public void inputTextIntoAdmissionType(String AdmissionType){
		WebElement AdmsnTypeInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			AdmsnTypeInputBox=DiffLocatorQA.admissionTypeInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			AdmsnTypeInputBox=DiffLocatorDEBUG.admissionTypeInputBox;
		}

		Functions.inputText(driver, AdmsnTypeInputBox, AdmissionType);
	}

	public void selectAdmissionType(){
		WebElement SelectAdmissionType = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			SelectAdmissionType = DiffLocatorQA.admissionTypeDropDownArrow;
			Functions.clickElement(driver, admissionTypeDropDownArrow);
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			SelectAdmissionType=DiffLocatorDEBUG.admissionTypeDropDownArrow;
			Functions.clickElement(driver, admissionTypeDropDownArrow);
		}

		Functions.clickElement(driver, itemsDropdownSecondOption);
	}

	public void inputTextIntoAdmissionSrc(String AdmissionSrc){
		WebElement AdmsnSrceInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			AdmsnSrceInputBox=DiffLocatorQA.admissionSrcDropDownArrow;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			AdmsnSrceInputBox=DiffLocatorDEBUG.admissionSrcDropDownArrow;
		}
		Functions.inputText(driver, AdmsnSrceInputBox, AdmissionSrc);
	}

	public void selectAdmissionSrc(){
		WebElement AdmissionSrcInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			AdmissionSrcInputBox=DiffLocatorQA.admissionSrcDropDownArrow;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			AdmissionSrcInputBox=DiffLocatorDEBUG.admissionSrcDropDownArrow;
		}
		Functions.clickElement(driver, AdmissionSrcInputBox);
		Functions.clickElement(driver, itemsDropdownSecondOption);
	}

	public void inputTextIntoDischargeHr(String DischargeHr){
		WebElement DischargeHrInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			DischargeHrInputBox=DiffLocatorQA.dischargenHourInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			DischargeHrInputBox=DiffLocatorDEBUG.dischargenHourInputBox;
		}
		Functions.inputText(driver, DischargeHrInputBox, DischargeHr);
	}

	public void inputTextIntoDischrgStatus(String DischrgStatus){
		WebElement DischargeStatusInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			DischargeStatusInputBox=DiffLocatorQA.dischargenStatusInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			DischargeStatusInputBox=DiffLocatorDEBUG.dischargenStatusInputBox;
		}
		Functions.inputText(driver, DischargeStatusInputBox, DischrgStatus);
	}

	public void inputTextIntoAdmittingDiag(String AdmittingDiag){
		WebElement AdmitDaigInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			AdmitDaigInputBox=DiffLocatorQA.admittingDiagnosisInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			AdmitDaigInputBox=DiffLocatorDEBUG.admittingDiagnosisInputBox;
		}
		Functions.inputText(driver, AdmitDaigInputBox, AdmittingDiag);
	}

	public void inputTextIntoPrinProcCDs(String PrinProcCDs){
		WebElement PrinProcCdsInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			PrinProcCdsInputBox=DiffLocatorQA.principalProcCodesInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			PrinProcCdsInputBox=DiffLocatorDEBUG.principalProcCodesInputBox;
		}
		Functions.inputText(driver, PrinProcCdsInputBox, PrinProcCDs);
	}

	public void inputTextIntoPrinProcDt(String PrinProcDt){							//Date
		Functions.inputText(driver, dateInputBoxes.get(9), PrinProcDt);
	}

	public void inputTextIntoOpProvNPI(String OpProvNPI){
		WebElement OperatingProviderInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			OperatingProviderInputBox=DiffLocatorQA.operatingProvNPIInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			OperatingProviderInputBox=DiffLocatorDEBUG.operatingProvNPIInputBox;
		}
		Functions.inputText(driver, OperatingProviderInputBox, OpProvNPI);
	}

	public void inputTextIntoDrgcd(String Drgcd){
		WebElement DrgCdInputBox = null;
		if(TestScript.env.equalsIgnoreCase("QA")){
			DrgCdInputBox=DiffLocatorQA.DRGInputBox;
		}
		if(TestScript.env.equalsIgnoreCase("DEBUG")|| TestScript.env.equalsIgnoreCase("DEV")){
			DrgCdInputBox=DiffLocatorDEBUG.DRGInputBox;
		}
		Functions.inputText(driver, DrgCdInputBox, Drgcd);
	}


	//Next buttons	

	public void clickOnNextButton() {
		CommonLocator.nextButtonList.click();
	}





	//Line Items   CMS
	//Line 1

	int dif = 10;
	int numdif = 9;

	public void inputTextIntoPOS(String POS, int position){
		int locator=Functions.newLocator(2, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), POS);
	}
	public void clickIntoPOS(){
		Functions.clickElement(driver, silverInputBoxes.get(2));
	}

	public void inputTextIntoTOS(String TOS, int position){
		int locator=Functions.newLocator(3, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), TOS);
	}

	public void inputTextIntoBilledCd(String BilledCd, int position){
		int locator=Functions.newLocator(5, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), BilledCd);
	}

	public void inputTextIntoBilledMd(String BilledMd, int position){
		int locator=Functions.newLocator(6, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), BilledMd);
	}

	public void inputTextIntoReviewCd(String ReviewCd, int position){
		int locator=Functions.newLocator(7, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), ReviewCd);
	}

	public void tabOutFromReviewCd(int position){
		int locator=Functions.newLocator(7, position, dif);
		Functions.tabOut(silverInputBoxes.get(locator));
	}

	public void inputTextIntoReviewMd(String ReviewMd, int position){
		int locator=Functions.newLocator(8, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), ReviewMd);
	}

	public void tabOutFromReviewMd(int position){
		int locator=Functions.newLocator(8, position, dif);
		Functions.tabOut(silverInputBoxes.get(locator));
	}


	public void inputTextIntoCMSDaysUnits(String CMSDaysUnits, int position){
		int locator=Functions.newLocator(3, position, numdif);
		Functions.inputText(driver, numBoxList.get(locator), CMSDaysUnits);
	}

	public void inputTextIntoChrgs(String  Chrgs, int position){
		int locator=Functions.newLocator(6, position, numdif);
		Functions.inputText(driver, numBoxList.get(locator), Chrgs);
	}

	public void inputTextIntoTotalCharges(String TotalCharges){
		//numBoxList.get(0).clear();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1];", numBoxList.get(0),TotalCharges);
		//Functions.tabOut(numBoxList.get(0));
		//numBoxList.get(0).clear();
		//numBoxList.get(0).sendKeys(TotalCharges);
		numBoxList.get(0).sendKeys(Keys.TAB);
		//if(!numBoxList.get(0).getAttribute("value").equals(TotalCharges)){
		//	numBoxList.get(0).clear();
		//	numBoxList.get(0).sendKeys(TotalCharges);
		//}
		//Functions.inputText(driver, numBoxList.get(0), TotalCharges);
	}

	//public void tabOutFromTotalCharges(TotalCharges){
	//	Functions.tabOut(numBoxList.get(0),TotalCharges);
	//	}

	public void inputTextIntoDiag(String Diag, int position){
		int locator=Functions.newLocator(10, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), Diag);
	}

	public void tabOutFromDiag(int position){
		int locator=Functions.newLocator(10, position, dif);
		Functions.tabOut(silverInputBoxes.get(locator));
	}

	//Line Items   UB-04
	//Line 1

	public void inputTextIntoRevenueCd(String RevenueCd, int position){
		int locator=Functions.newLocator(4, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator),RevenueCd);
	}
	//
	//	public void inputTextIntoReviewedCd(String ReviewedCd, int position){   // why do we need this, cant use from CMS line
	//		Functions.inputText(driver, silverInputBoxes.get(7), ReviewedCd);
	//	}
	////	
	//	public void tabOutFromReviewedCd(int position){
	//		int locator=Functions.newLocator(7, position, 10);
	//		Functions.tabOut(silverInputBoxes.get(locator));
	//	}
	//	
	//	//public void inputTextIntoMod(String Mod, int position){       // / why do we need this, cant use from CMS line
	//		int locator=Functions.newLocator(6, position, 10);
	//		Functions.inputText(driver, silverInputBoxes.get(locator), Mod);
	//	}
	//
	public void inputTextIntoUB04Days(String Days, int position){     //***days    
		int locator=Functions.newLocator(3, position, numdif);
		Functions.inputText(driver, numBoxList.get(locator), Days);
	}


	//Line Items   RX
	//Line 1

	public void inputTextIntoBillNDCCd(String BillNDCCd, int position){
		int locator=Functions.newLocator(5, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), BillNDCCd);
	}

	public void inputTextIntoRewNDCCd(String RewNDCCd, int position){
		int locator=Functions.newLocator(7, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), RewNDCCd);
	}

	public void inputTextIntoRXNo(String RXNo, int position){
		int locator=Functions.newLocator(9, position, dif);
		Functions.inputText(driver, silverInputBoxes.get(locator), RXNo);
	}

	public void inputTextIntoQuantity(String Quantity, int position){
		int locator=Functions.newLocator(3, position, numdif);
		Functions.inputText(driver, numBoxList.get(locator), Quantity);
	}

	public void inputTextIntoRXDaysSupply(String DaysSupply, int position) {
		int locator=Functions.newLocator(4, position, numdif);
		Functions.inputText(driver, numBoxList.get(locator), DaysSupply);

	}
//	public void inputTextIntoDaysupply(String Daysupply, int position){
//		int locator=Functions.newLocator(4, position, numdif);
//		Functions.inputText(driver, numBoxList.get(locator), Daysupply);
//	}

	public void inputTextIntoDAW(String DAW, int position){
		int locator=Functions.newLocator(5, position, numdif);
		Functions.inputText(driver, numBoxList.get(locator), DAW);
	}


	//end of lines

	public boolean isDisplayedCrossIcon() {
		try {
			Thread.sleep(3000);
			return crossIcon.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (NoSuchElementException e1) {
			return  false;
		}
		return false;
	}

	public boolean isDisplayedWarningIcon() {
		try {
			Thread.sleep(3000);
			return warningIcon.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (NoSuchElementException e1) {
			return  false;
		}
		return false;
	}


	public void clickOnWarningIcon() {
		Functions.clickElement(driver, warningIcon);
	}

	public void clickOnCrossIcon() {
		Functions.clickElement(driver, crossIcon);
	}

	public boolean isDisplayedCrossIconZip() {
		try {
			Thread.sleep(3000);
			return  zipcrossIcon.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e1) {
			return  false;
		}
		return false;


	}

	public boolean isDisplayedValidIconBillTxnID() {
		try {
			Thread.sleep(3000);
			return tickIconBillingTxID.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e1) {
			return  false;
		}
		return false;
	}

	public boolean isDisplayedValidIconZip() {
		try {
			Thread.sleep(3000);
			return tickIconZip.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e1) {
			return  false;
		}
		return false;


	}


	public boolean isDisplayedWarningIconZip() {
		try {
			Thread.sleep(3000);
			return zipwarningIcon.isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e1) {
			return  false;
		}
		return false;
	}


	public void clickOnWarningIconZip() {
		Functions.clickElement(driver, zipwarningIcon);
	}

	public void clickOnCrossIconZip() {
		Functions.clickElement(driver, zipcrossIcon);
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

	public void clickOnSelectServiceLocButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Functions.clickElement(driver, selectServiceLocButton);
	}

	public void clickOnBillTaxIdLabel() {
		Functions.clickElement(driver, billTaxIdLabel);
	}

	public void clickOnZipLabel() {
		Functions.clickElement(driver, zipLabel);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void clickOnCheckSumButton() {
		Functions.clickElement(driver, checksumButton);
	}

	public void clickOnPriceButton() {
		Functions.clickElement(driver, priceButton);
	}

	public String getTextFromFeeScheduleDis(int position){
		int locator=Functions.newLocator(7, position, 9);
		return Functions.getAttribute(numBoxList.get(locator),"value");
	}

	public String getTextFromMsgCodes(int position){
		int locator=Functions.newLocator(11, position, dif);
		return Functions.getAttribute(silverInputBoxes.get(locator),"value");
	}


	public void clickOnCreateLinks() {
		WebElement firstCreateLink=createLinkButtons.get(0);
		WebElement secondCreateLink=createLinkButtons.get(1);
		if(firstCreateLink.isDisplayed())
		{
			Functions.clickElement(driver, firstCreateLink);
		}
		if(secondCreateLink.isDisplayed())
		{
			Functions.clickElement(driver, secondCreateLink);
		}

	}

	public boolean isDisplayedSelectServiceLocButton() {
		if(selectServiceLocButton.isDisplayed())
			return true;
		else
			return false;
	}

	public void inputTextIntoServiceLocNPI(String npi){
		Functions.inputText(driver, silverInputBoxes.get(40), npi);
	}


	public void clickOnQueryNPIButton() {
		Functions.clickElement(driver, queryNPIButton);
	}
	public void clickOnCreateNewAddressButton() {
		Functions.clickElement(driver, createNewAddressButton);
	}
	public void clickOKButtonForNewAddress() {
		Functions.clickElement(driver, okButtonForNewAddress);
	}

	public String checkWhichIcon(String str) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(str.equals("BillTxnID")){
			if(Functions.isDisplayedMatch(tickIconBillingTxID)){
				return "valid";
			}
			if(Functions.isDisplayedMatch(warningIcon)){
				return "warning";
			}
			if(Functions.isDisplayedMatch(crossIcon)){
				return "cross";
			}
		}
		if(str.equals("Zip")){
			if(Functions.isDisplayedMatch(tickIconZip)){
				return "valid";
			}
			if(Functions.isDisplayedMatch(zipwarningIcon)){
				return "warning";
			}
			if(Functions.isDisplayedMatch(zipcrossIcon)){
				return "cross";
			}
		}
		return "";
	}


	//	public void tabOutFromDate(int position){   //Provider Bill Date
	//		int locator=Functions.newLocator(0, position, 1);
	//		Functions.pressTabKey(dateInputBoxes.get(locator));
	//	}



	//	public void clickOnNextButton(){
	//		Functions.clickElement(submitButton);
	//	}


}
