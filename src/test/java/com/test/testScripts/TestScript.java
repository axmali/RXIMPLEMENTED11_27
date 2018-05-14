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
import com.test.pages.DiffLocatorDEBUG;
import com.test.pages.DiffLocatorQA;
import com.test.pages.LoginPage;

/**
 * Unit test for simple App.
 */
public class TestScript 

{
	static WebDriver driver;
	static LoginPage loginPage;
	static BillEntryPage billEntryPage;
	String QAURL="http://52.37.60.147/decisions/Login.aspx";  				//QA
	String DEVURL="http://52.26.143.217/decisions/Login.aspx";				//Dev
	String DEBUGURL="http://108.39.81.156/decisions";     					 //DEBUG	
	static String[][] data;
    public static String env="QA";

	@BeforeSuite
	public void setUp() throws IOException{
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		//driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		loginPage = new LoginPage(driver);
		billEntryPage = new BillEntryPage(driver);
		
		
		
		if(env.equalsIgnoreCase("DEV")){
			driver.get(DEVURL);
		}
		if(env.equalsIgnoreCase("QA")){
			new DiffLocatorQA(driver);
			driver.get(QAURL);
		}
		if(env.equalsIgnoreCase("DEBUG")){
			new DiffLocatorDEBUG(driver);
			driver.get(DEBUGURL);
		}
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		//Reader Header data Excel tab
		//		data = getData.readExcel("TestData3", "CMS");


	}

	@AfterSuite
	public void tearDown(){
		try {Thread.sleep(3000);} catch (InterruptedException e) {	}
		driver.quit();
	}


	static String type;
	@Test
	public void test1() throws IOException, InterruptedException{
		navigateToUserPortal();
		for(int rowCMS=27;rowCMS<=27;rowCMS++){
			navigateToBillEntryMainPage(env);
			fillValuesInBillEntryPage(rowCMS);
			String billType = getData.valueFromHeader("CMS","Bill_type",rowCMS);
			
			if(billType.equals("P")){
				type="CMS";
			}
			else if(billType.equals("F")){
				type="UB-04";
			}
			else if(billType.equals("H")){
				type="RX";
			}
			else if(billType.equals("N")){
				//billEntryPage.inputTextIntoeBillType("RX");
			}
			
			try {Thread.sleep(3000);} catch (InterruptedException e) {	}
			billEntryPage.clickOnNextButton();
			try {Thread.sleep(8000);} catch (InterruptedException e) {	}
			String relatedNumberFromCMS = getData.valueFromHeader("CMS","RelNO",rowCMS);

			List<Integer> lineItemsRowsForCMS= getData.rowNumberHavingSameRelatedNumber("LineitemCMS", "RelNO", relatedNumberFromCMS);
			for(int line=0; line<lineItemsRowsForCMS.size();line++){
				if(line!=0){
					try {Thread.sleep(2000);} catch (InterruptedException e) {	}
					//billEntryPage.tabOutFromDiag(line-1);
					try {Thread.sleep(2000);} catch (InterruptedException e) {	}
					//billEntryPage.tabOutFromDate(line);
				}
				fillValuesInLineItemsPage(type,  lineItemsRowsForCMS.get(line), line);
				
			}
			
//
			try {Thread.sleep(10000);} catch (InterruptedException e) {	}
			String tc=String.valueOf(TotalChargesSum);
			billEntryPage.inputTextIntoTotalCharges(tc);
			//billEntryPage.clickIntoPOS();
			try {Thread.sleep(3000);} catch (InterruptedException e) {	}
			TotalChargesSum=0;
			
			billEntryPage.clickOnCheckSumButton();
			System.out.println("CheckSum is Done......");  
			//try {Thread.sleep(5000);} catch (InterruptedException e) {	}
			try {Thread.sleep(3000);} catch (InterruptedException e) {	}
					
			billEntryPage.clickOnPriceButton();
			System.out.println("Pricing is Done......");            //, FeeScheduleDiscount is :" + ActFeeDisc);
			try {Thread.sleep(5000);} catch (InterruptedException e) {	}
			//try {Thread.sleep(5000);} catch (InterruptedException e) {	}

			for(int line=0; line<lineItemsRowsForCMS.size();line++){
		
				String ActFeeDisc = billEntryPage.getTextFromFeeScheduleDis(line);
				System.out.println("FeeScheduleDis: "+ActFeeDisc);
				getData.writeValueInExcelFile("LineitemCMS","ActualFeeDis",lineItemsRowsForCMS.get(line),ActFeeDisc);
				
				String ActMsgCode= billEntryPage.getTextFromMsgCodes(line);
				System.out.println("MessageCode: "+ActMsgCode);
				getData.writeValueInExcelFile("LineitemCMS","MessageCode",lineItemsRowsForCMS.get(line),ActMsgCode);
			}

	




			//			if(ActFeeDisc.equals(TotalChargesSum)){
			//				System.out.println("Actual Fee Schedule is Correct: " +TotalChargesSum+" , "+ActFeeDisc);
			//			}
			//			else {
			//				System.out.println("Acutal Fee Schedule is Incorrect: " +TotalChargesSum+" , "+ActFeeDisc);
			//}





			//		waitTime();
			//			GetLineItemDataCMS(); 
			//			readLineItemCMSFrmExl(iter);
			//			fillLineItemCMSValues();
		}

	}


	private void fillValuesInBillEntryPage(int rowData) throws IOException, InterruptedException {
		try {Thread.sleep(3000);} catch (InterruptedException e) {	}
		
		String clientName=getData.valueFromHeader("CMS","clientName",rowData);
		String claimNum=getData.valueFromHeader("CMS","claimNum",rowData);
		String state=getData.valueFromHeader("CMS","St",rowData);
		String payCode=getData.valueFromHeader("CMS","PayCode",rowData);
		String billID=getData.valueFromHeader("CMS","BillID",rowData);
		String billingTxnID=	getData.valueFromHeader("CMS","BillingTaxID",rowData);
		String billingNPI=	getData.valueFromHeader("CMS","BillingNPI",rowData);
		String renderNPI=	getData.valueFromHeader("CMS","renderNPI",rowData);
		String zipCode = getData.valueFromHeader("CMS","ZipCode",rowData);
		String DOSFrom = getData.valueFromHeader("CMS","DOSFrom",rowData);
		String DOSTo = getData.valueFromHeader("CMS","DOSTo",rowData);
		String patientID =getData.valueFromHeader("CMS","PatientID",rowData);
		String providerBillDate =getData.valueFromHeader("CMS","ProviderBillDate",rowData);
		String icdProcedureCode =getData.valueFromHeader("CMS","ICDProcedureCode",rowData);
		String clientRecievedDate= getData.valueFromHeader("CMS","ClientReceivedDate",rowData);
		String billRecievedDate=getData.valueFromHeader("CMS","BillReceivedDate",rowData);
		
		String typeOfBill=getData.valueFromHeader("CMS","TypeofBill",rowData);
		
		String medicareNum = getData.valueFromHeader("CMS","MedicareNumber",rowData);
		String operationProvNPI = getData.valueFromHeader("CMS","OperationProvNPI",rowData);
		String admitDate = getData.valueFromHeader("CMS","AdmitDate",rowData);
		String dischargeDate =getData.valueFromHeader("CMS","DischargeDate",rowData);
		String admissionHour  = getData.valueFromHeader("CMS","AdmissionHour",rowData);
		String admissionType  =getData.valueFromHeader("CMS","AdmissionType",rowData);
		String admissionSource  =getData.valueFromHeader("CMS","AdmissionSource",rowData);
		String dischargeHour   = getData.valueFromHeader("CMS","DischargeHour",rowData);
		String dischargeStatus   =getData.valueFromHeader("CMS","DischargeStatus",rowData);
		String admittingDiag   =getData.valueFromHeader("CMS","AdmittingDiagnosis",rowData);
		String PrinProcCodes   =getData.valueFromHeader("CMS","PrinProcCodes",rowData);
		String PrinProcDates   =getData.valueFromHeader("CMS","PrinProcDate",rowData);
		String DRG   =getData.valueFromHeader("CMS","DRG",rowData);
		String billType   =getData.valueFromHeader("CMS","Bill_type",rowData);
		
		billEntryPage.inputTextIntoClient(clientName);
		billEntryPage.inputTextIntoClaim(claimNum);
		billEntryPage.inputTextIntoState(state);
		//billEntryPage.inputTextIntoPaycode(payCode);
		billEntryPage.selectPaycode();
		if(billEntryPage.isEmptyBillID()){
			billEntryPage.inputTextIntoBillID(billID);
		}
		billEntryPage.inputTextIntoBillTaxID(billingTxnID);
		Functions.pressTabKey(billEntryPage.billTaxIDElement());

		try{
			
			String whichIcon=billEntryPage.checkWhichIcon("BillTxnID");
		
			
			if(whichIcon.equals("warning")){
				billEntryPage.clickOnBillTaxIdLabel();
				//try {Thread.sleep(10000);} catch (InterruptedException e) {	}
				billEntryPage.clickOnFirstRowSelectProvider();
				billEntryPage.clickOnSelectProviderButton();
			}
			
			else if(whichIcon.equals("valid")){
				System.out.println("tick icon for Billing Tax ID");
			}
			else if(whichIcon.equals("cross")){
				throw new NoSuchElementException("Cross mark is dispalyed for Billing tax ID");
			}
			else{
				//				System.out.println("Valid Tax ID: "+Tax ID);
			}
		}
		catch(Exception e){
			System.out.println("warning icon is not visible for billing txn id");
		}
		Thread.sleep(3000);
		billEntryPage.inputTextIntoBillNPI(billingNPI);
		
		billEntryPage.inputTextIntoRenderNPI(renderNPI);
		System.out.println("zip: "+zipCode);
		billEntryPage.inputTextIntoLoczip(zipCode);
		
		try{
			String whichIcon=billEntryPage.checkWhichIcon("Zip");
			
			 if(whichIcon.equals("warning")){
					billEntryPage.clickOnZipLabel();
					try {Thread.sleep(3000);} catch (InterruptedException e) {	}
					billEntryPage.clickOnFirstRowSelectProvider();
					billEntryPage.clickOnSelectServiceLocButton();
					Thread.sleep(7000);
				}
			
			else if(whichIcon.equals("valid")){
				System.out.println("tick icon for Zip");
			}
			else if(whichIcon.equals("cross")){
				
				billEntryPage.clickOnZipLabel();
				if(!billEntryPage.isDisplayedSelectServiceLocButton()){ //no address
					billEntryPage.inputTextIntoServiceLocNPI(renderNPI);
					billEntryPage.clickOnQueryNPIButton();
					billEntryPage.clickOnCreateNewAddressButton();
					billEntryPage.clickOKButtonForNewAddress();
				}
				
				billEntryPage.clickOnCreateLinks();
				billEntryPage.clickOnFirstRowSelectProvider();
				billEntryPage.clickOnSelectServiceLocButton();
				
			}
			 
			else{
				//				System.out.println("Valid Tax ID: "+Tax ID);
			}
		}
		catch(Exception e){
			
			System.out.println("warning icon is not visible for billing txn id");
		}
		
		if(billType.equals("P")){
			billEntryPage.inputTextIntoeBillType("CMS-1500");
		}
		else if(billType.equals("F")){
			billEntryPage.inputTextIntoeBillType("UB-04");
		}
		else if(billType.equals("H")){
			billEntryPage.inputTextIntoeBillType("RX");
		}
		else if(billType.equals("N")){
			//billEntryPage.inputTextIntoeBillType("RX");
		}
			
		//billEntryPage.inputTextIntoFacilityNPI(getData.valueFromHeader("CMS","ProvFacNPI",rowData));
		billEntryPage.inputTextDateIntoDOSFrm(DOSFrom);
		if(!DOSFrom.equalsIgnoreCase(DOSTo))
		{
			Thread.sleep(2000);
			billEntryPage.inputTextIntoDOSTO(DOSTo);
		}
		billEntryPage.inputTextIntoPatient(patientID);
		String billTypeTxt=billEntryPage.getAttributeBillTypeText();
		billEntryPage.inputTextDateIntoBillDate(providerBillDate);
		Thread.sleep(2000);
		if(!billTypeTxt.equalsIgnoreCase("RX"))
			billEntryPage.inputTextIntoProcedureCode(icdProcedureCode);
		Thread.sleep(2000);
		billEntryPage.inputTextDateIntoClientRecvdDate(clientRecievedDate);
		billEntryPage.inputTextDateIntoBillRecvdDate(billRecievedDate);

		

		//  UB-04 fields
		

		if(billTypeTxt.equalsIgnoreCase("UB-04")){
			//12X 18X 21x 22X28X 41X 85X  Inpatient all the fields
			//83
			

			//131 14X 18X 23X 32X 33X 34X 71x 72X 73X 74X 75X 76X 81X 82X  OUTPATIENT WHERE WE ONLY fill MedicareNumber and OpeationProvNPI		

			
			billEntryPage.inputTextIntoTypeofBill(typeOfBill);
			
			
			if(typeOfBill.startsWith("13") || typeOfBill.startsWith("14") 
					||typeOfBill.startsWith("18") ||typeOfBill.startsWith("23") ||typeOfBill.startsWith("32") 
					||typeOfBill.startsWith("33")||typeOfBill.startsWith("34") ||typeOfBill.startsWith("71")
					||typeOfBill.startsWith("72") ||typeOfBill.startsWith("73")||typeOfBill.startsWith("74")
					||typeOfBill.startsWith("75")||typeOfBill.startsWith("76") ||typeOfBill.startsWith("81")
					||typeOfBill.startsWith("82")) {					
				billEntryPage.inputTextIntoMedicareNO(medicareNum);
				billEntryPage.inputTextIntoOpProvNPI(operationProvNPI);

			}
			else if(typeOfBill.startsWith("83")){
				billEntryPage.inputTextIntoOpProvNPI(operationProvNPI);
			}
			else {
				billEntryPage.inputTextIntoMedicareNO(medicareNum);
				billEntryPage.inputTextDateIntoADmDt(admitDate);
				billEntryPage.inputTextDateIntoDschgDt(dischargeDate);
				billEntryPage.inputTextIntoAdmsnHr(admissionHour);
				
				//billEntryPage.inputTextIntoAdmissionType(admissionType);
				//billEntryPage.inputTextIntoAdmissionSrc(admissionSource);
				billEntryPage.selectAdmissionType();
				billEntryPage.selectAdmissionSrc();
				
				billEntryPage.inputTextIntoDischargeHr(dischargeHour);
				billEntryPage.inputTextIntoDischrgStatus(dischargeStatus);
				billEntryPage.inputTextIntoAdmittingDiag(admittingDiag);
				billEntryPage.inputTextIntoPrinProcCDs(PrinProcCodes);
				billEntryPage.inputTextIntoPrinProcDt(PrinProcDates);
				billEntryPage.inputTextIntoOpProvNPI(operationProvNPI);
				billEntryPage.inputTextIntoDrgcd(DRG);


			}

		}

	}

	static float TotalChargesSum;
	//static float TotalChargesSum= 0.00;
	private void fillValuesInLineItemsPage(String valueFromHeader, int rowData, int position) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		try {Thread.sleep(5000);} catch (InterruptedException e) {	}
		billEntryPage.inputTextIntoPOS(getData.valueFromHeader("LineitemCMS","POS",rowData), position);
		try {Thread.sleep(5000);} catch (InterruptedException e) {	}
		billEntryPage.inputTextIntoTOS(getData.valueFromHeader("LineitemCMS","TOS",rowData), position);
		///try {Thread.sleep(1000);} catch (InterruptedException e) {	}
		
		if(valueFromHeader.equalsIgnoreCase("CMS")){
			billEntryPage.inputTextIntoBilledCd(getData.valueFromHeader("LineitemCMS","Billed Code",rowData), position);
			///try {Thread.sleep(500);} catch (InterruptedException e) {	}
			billEntryPage.inputTextIntoBilledMd(getData.valueFromHeader("LineitemCMS","Billed Mod",rowData), position);
			try {Thread.sleep(500);} catch (InterruptedException e) {	}
			//billEntryPage.inputTextIntoRevCd(getData.valueFromHeader("LineitemCMS","ReviewedCd",rowData));
			//billEntryPage.inputTextIntoRevMd(getData.valueFromHeader("LineitemCMS","ReviewedMd",rowData));
			billEntryPage.tabOutFromReviewCd(position);
			///try {Thread.sleep(500);} catch (InterruptedException e) {	}
			billEntryPage.tabOutFromReviewMd(position);
			//try {Thread.sleep(500);} catch (InterruptedException e) {	}
			billEntryPage.inputTextIntoCMSDaysUnits(getData.valueFromHeader("LineitemCMS","DaysUnits",rowData), position);
			//Thread.sleep(3000);
			billEntryPage.inputTextIntoChrgs(getData.valueFromHeader("LineitemCMS","Charges",rowData), position);
			///try {Thread.sleep(500);} catch (InterruptedException e) {	}
			//billEntryPage.inputTextIntoDiag(getData.valueFromHeader("LineitemCMS","Diag",rowData), position);
			billEntryPage.tabOutFromDiag(position);
			//try {Thread.sleep(500);} catch (InterruptedException e) {	}
			///billEntryPage.inputTextIntoTotalCharges(getData.valueFromHeader("LineitemCMS","TotalCharges",rowData));

		}
		else if(valueFromHeader.equalsIgnoreCase("UB-04")){

			billEntryPage.inputTextIntoRevenueCd(getData.valueFromHeader("LineitemCMS","Rev Code",rowData), position);
			///try {Thread.sleep(500);} catch (InterruptedException e) {	}
			if(!getData.valueFromHeader("LineitemCMS","Rev Code",rowData).equalsIgnoreCase(getData.valueFromHeader("LineitemCMS","Billed Code",rowData)))
				billEntryPage.inputTextIntoBilledCd(getData.valueFromHeader("LineitemCMS","Billed Code",rowData), position);
			///try {Thread.sleep(500);} catch (InterruptedException e) {	}
			billEntryPage.inputTextIntoBilledMd(getData.valueFromHeader("LineitemCMS","Billed Mod",rowData), position);
			///try {Thread.sleep(500);} catch (InterruptedException e) {	}
			billEntryPage.tabOutFromReviewCd(position);
			///try {Thread.sleep(500);} catch (InterruptedException e) {	}
			billEntryPage.inputTextIntoUB04Days(getData.valueFromHeader("LineitemCMS","DaysUnits",rowData), position);
			billEntryPage.inputTextIntoChrgs(getData.valueFromHeader("LineitemCMS","Charges",rowData), position);
			//billEntryPage.inputTextIntoDiag(getData.valueFromHeader("LineitemCMS","Diag",rowData), position);
			billEntryPage.tabOutFromDiag(position);
		}
		else if(valueFromHeader.equalsIgnoreCase("RX")){
			billEntryPage.inputTextIntoBillNDCCd(getData.valueFromHeader("LineitemCMS","Billed Code",rowData), position);
			///try {Thread.sleep(500);} catch (InterruptedException e) {	}
			billEntryPage.tabOutFromReviewCd(position);
			
			billEntryPage.inputTextIntoQuantity(getData.valueFromHeader("LineitemCMS","Quantity",rowData), position);
			
			billEntryPage.inputTextIntoRXDaysSupply(getData.valueFromHeader("LineitemCMS","DaysUnits",rowData),position);
			billEntryPage.inputTextIntoChrgs(getData.valueFromHeader("LineitemCMS","Charges",rowData), position);
			//billEntryPage.inputTextIntoDiag(getData.valueFromHeader("LineitemCMS","Diag",rowData), position);
			billEntryPage.tabOutFromDiag(position);
			//billEntryPage.inputTextIntoTotalCharges(getData.valueFromHeader("LineitemCMS","TotalCharges",rowData));

		}

		TotalChargesSum = TotalChargesSum + Float.parseFloat(getData.valueFromHeader("LineitemCMS","Charges",rowData));
		System.out.println("charges: "+TotalChargesSum );

	}	

	
	public void navigateToUserPortal(){
		loginPage.inputTextIntoUserName("amalik@ekhealth.com");
		loginPage.inputTextIntoPassword("8mM89008");                             //("Summer!2017");
		loginPage.clickOnSubmitButton();
		//loginPage.ClickOnUserPortalButton();
	}

	public void navigateToBillEntryMainPage(String environment){
		if(env.equalsIgnoreCase("DEV")){
			driver.get("http://52.26.143.217/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page");  //DEV
		}
		if(env.equalsIgnoreCase("QA")){
		driver.get("http://52.37.60.147/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page");  //QA
		
		}
		
		if(env.equalsIgnoreCase("DEBUG")){
			driver.get("http://108.39.81.156/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page");  //DEBUG
			
			}
		

	}
}
