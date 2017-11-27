package com.test.testScripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.test.Utils.Functions;
import com.test.Utils.getData;
import com.test.pages.BillEntryPage;
import com.test.pages.LoginPage;

/**
 * Unit test for simple App.
 */
public class TestScript 

{
	static WebDriver driver;
	static LoginPage loginPage;
	static BillEntryPage billEntryPage;
	String URL="http://52.37.60.147/decisions/Login.aspx";
	static String[][] data;


	@BeforeSuite
	public void setUp() throws IOException{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		loginPage = new LoginPage(driver);
		billEntryPage = new BillEntryPage(driver);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		//Reader Header data Excel tab
		//		data = getData.readExcel("TestData3", "CMS");


	}

	@AfterSuite
	public void tearDown(){
		driver.quit();
	}


	@Test
	public void test1() throws IOException{
		navigateToUserPortal();
		for(int rowCMS=1;rowCMS<=1;rowCMS++){
			navigateToBillEntryMainPage();
			fillValuesInBillEntryPage(rowCMS);
			String type = getData.valueFromHeader("CMS","Type",rowCMS);
			try {Thread.sleep(3000);} catch (InterruptedException e) {	}
			if(type.equalsIgnoreCase("CMS") || type.equalsIgnoreCase("RX"))
				billEntryPage.clickOnNextButton();
			if(type.equalsIgnoreCase("UB-04"))
				billEntryPage.clickOnNextButtonUB04();

			try {Thread.sleep(10000);} catch (InterruptedException e) {	}
			String relatedNumberFromCMS = getData.valueFromHeader("CMS","RelNO",rowCMS);

			List<Integer> lineItemsRowsForCMS= getData.rowNumberHavingSameRelatedNumber("LineitemCMS", "RelNO", relatedNumberFromCMS);
			TotalChargesSum=0;
			for(int line=0; line<lineItemsRowsForCMS.size();line++){
				if(line!=0){
					billEntryPage.tabOutFromDiag(line-1);
					try {Thread.sleep(10000);} catch (InterruptedException e) {	}
				}
				fillValuesInLineItemsPage(type,  lineItemsRowsForCMS.get(line), line);
			}
			billEntryPage.inputTextIntoTotalCharges(String.valueOf(TotalChargesSum));

			billEntryPage.clickOnCheckSumButton();


			billEntryPage.clickOnPriceButton();
			System.out.println("Pricing is Done......");            //, FeeScheduleDiscount is :" + ActFeeDisc);
			try {Thread.sleep(10000);} catch (InterruptedException e) {	}
			
			for(int line=0; line<lineItemsRowsForCMS.size();line++){
				String ActFeeDisc = billEntryPage.getTextFromFeeScheduleDis(line);
				getData.writeValueInExcelFile("LineitemCMS","ActualFeeDis",lineItemsRowsForCMS.get(line),ActFeeDisc);
			}

			



//			if(ActFeeDisc.equals(TotalChargesSum)){
//				System.out.println("Actual Fee Schedule is Correct: " +TotalChargesSum+" , "+ActFeeDisc);
//			}
//			else {
//				System.out.println("Acutal Fee Schedule is Incorrect: " +TotalChargesSum+" , "+ActFeeDisc);
			//}
			
			



			//			waitTime();
			//			GetLineItemDataCMS(); 
			//			readLineItemCMSFrmExl(iter);
			//			fillLineItemCMSValues();
		}

	}


	private void fillValuesInBillEntryPage(int rowData) throws IOException {
		try {Thread.sleep(3000);} catch (InterruptedException e) {	}
		billEntryPage.inputTextIntoClient(getData.valueFromHeader("CMS","clientName",rowData));
		billEntryPage.inputTextIntoClaim(getData.valueFromHeader("CMS","claimNum",rowData));
		billEntryPage.inputTextIntoState(getData.valueFromHeader("CMS","St",rowData));
		billEntryPage.inputTextIntoPaycode(getData.valueFromHeader("CMS","PayCode",rowData));
		if(billEntryPage.isEmptyBillID()){
			billEntryPage.inputTextIntoBillID(getData.valueFromHeader("CMS","BillID",rowData));
		}
		billEntryPage.inputTextIntoBillTaxID(getData.valueFromHeader("CMS","BillingTaxID",rowData));
		Functions.pressTabKey(billEntryPage.billTaxIDElement());

		try{
			if(billEntryPage.isDisplayedWarningIcon()){
				billEntryPage.clickOnBillTaxIdLabel();
				billEntryPage.clickOnFirstRowSelectProvider();
				billEntryPage.clickOnSelectProviderButton();
			}
			else if(billEntryPage.isDisplayedCrossIcon()){
				throw new NoSuchElementException("Cross mark is dispalyed for Billing tax ID");
			}
			else{
				//				System.out.println("Valid Tax ID: "+Tax ID);
			}
		}
		catch(Exception e){
			System.out.println("warning icon is not visible for billing txn id");
		}


		billEntryPage.inputTextIntoBillNPI(getData.valueFromHeader("CMS","BillingNPI",rowData));
		billEntryPage.inputTextIntoRenderNPI(getData.valueFromHeader("CMS","renderNPI",rowData));
		System.out.println("zip: "+getData.valueFromHeader("CMS","ZipCode",rowData));
		billEntryPage.inputTextIntoLoczip(getData.valueFromHeader("CMS","ZipCode",rowData));
		billEntryPage.inputTextIntoFacilityNPI(getData.valueFromHeader("CMS","ProvFacNPI",rowData));
		billEntryPage.inputTextDateIntoDOSFrm(getData.valueFromHeader("CMS","DOSFrom",rowData));
		billEntryPage.inputTextIntoPatient(getData.valueFromHeader("CMS","PatientID",rowData));
		billEntryPage.inputTextDateIntoBillDate(getData.valueFromHeader("CMS","ProviderBillDate",rowData));
		billEntryPage.inputTextIntoProcedureCode(getData.valueFromHeader("CMS","ICDProcedureCode",rowData));
		billEntryPage.inputTextDateIntoClientRecvdDate(getData.valueFromHeader("CMS","ClientReceivedDate",rowData));
		billEntryPage.inputTextDateIntoBillRecvdDate(getData.valueFromHeader("CMS","BillReceivedDate",rowData));





		//  UB-04 fields
		String billTypeTxt=billEntryPage.getAttributeBillTypeText();

		if(billTypeTxt.equalsIgnoreCase("UB-04")){

			billEntryPage.inputTextIntoTypeofBill(getData.valueFromHeader("CMS","TypeofBill",rowData));
			billEntryPage.inputTextIntoMedicareNO(getData.valueFromHeader("CMS","MedicareNumber",rowData));

			billEntryPage.inputTextDateIntoADmDt(getData.valueFromHeader("CMS","AdmitDate",rowData));
			billEntryPage.inputTextDateIntoDschgDt(getData.valueFromHeader("CMS","DischargeDate",rowData));
			billEntryPage.inputTextIntoAdmsnHr(getData.valueFromHeader("CMS","AdmissionHour",rowData));
			billEntryPage.inputTextIntoAdmissionType(getData.valueFromHeader("CMS","AdmissionType",rowData));
			billEntryPage.inputTextIntoAdmissionSrc(getData.valueFromHeader("CMS","AdmissionSource",rowData));
			billEntryPage.inputTextIntoDischargeHr(getData.valueFromHeader("CMS","DischargeHour",rowData));
			billEntryPage.inputTextIntoDischrgStatus(getData.valueFromHeader("CMS","DischargeStatus",rowData));
			billEntryPage.inputTextIntoAdmittingDiag(getData.valueFromHeader("CMS","AdmittingDiagnosis",rowData));
			billEntryPage.inputTextIntoPrinProcCDs(getData.valueFromHeader("CMS","PrinProcCodes",rowData));
			billEntryPage.inputTextIntoPrinProcDt(getData.valueFromHeader("CMS","PrinProcDate",rowData));
			billEntryPage.inputTextIntoOpProvNPI(getData.valueFromHeader("CMS","OperationProvNPI",rowData));
			billEntryPage.inputTextIntoDrgcd(getData.valueFromHeader("CMS","DRG",rowData));


		}



	}

	static float TotalChargesSum=0;
	private void fillValuesInLineItemsPage(String valueFromHeader, int rowData, int position) throws IOException {
		// TODO Auto-generated method stub
		billEntryPage.inputTextIntoPOS(getData.valueFromHeader("LineitemCMS","POS",rowData), position);
		billEntryPage.inputTextIntoTOS(getData.valueFromHeader("LineitemCMS","TOS",rowData), position);

		if(valueFromHeader.equalsIgnoreCase("CMS")){
			billEntryPage.inputTextIntoBillCd(getData.valueFromHeader("LineitemCMS","Billed Code",rowData), position);
			billEntryPage.inputTextIntoBillMd(getData.valueFromHeader("LineitemCMS","Billed Mod",rowData), position);
			//billEntryPage.inputTextIntoRevCd(getData.valueFromHeader("LineitemCMS","ReviewedCd",rowData));
			//billEntryPage.inputTextIntoRevMd(getData.valueFromHeader("LineitemCMS","ReviewedMd",rowData));
			billEntryPage.tabOutFromRevCd(position);
			billEntryPage.tabOutFromRevMd(position);
			billEntryPage.inputTextIntoCMSDays(getData.valueFromHeader("LineitemCMS","Days",rowData), position);
			billEntryPage.inputTextIntoChrgs(getData.valueFromHeader("LineitemCMS","Charges",rowData), position);
			billEntryPage.inputTextIntoDiag(getData.valueFromHeader("LineitemCMS","Diag",rowData), position);
			//billEntryPage.inputTextIntoTotalCharges(getData.valueFromHeader("LineitemCMS","TotalCharges",rowData));

		}
		else if(valueFromHeader.equalsIgnoreCase("UB-04")){

			billEntryPage.inputTextIntoBillRevenueCd(getData.valueFromHeader("LineitemCMS","Billed Code",rowData), position);
			billEntryPage.tabOutFromReviewedCd(position);
			billEntryPage.inputTextIntoMod(getData.valueFromHeader("LineitemCMS","Billed Mod",rowData), position);
			billEntryPage.inputTextIntoUB04Days(getData.valueFromHeader("LineitemCMS","Days",rowData), position);
			billEntryPage.inputTextIntoChrgs(getData.valueFromHeader("LineitemCMS","Charges",rowData), position);
			billEntryPage.inputTextIntoDiag(getData.valueFromHeader("LineitemCMS","Diag",rowData), position);
		}
		else if(valueFromHeader.equalsIgnoreCase("RX")){
			billEntryPage.inputTextIntoBillCd(getData.valueFromHeader("LineitemCMS","Billed Code",rowData), position);
			//Tab
			//billEntryPage.inputTextIntoBillMd(getData.valueFromHeader("LineitemCMS","Billed Mod",rowData), position);
			//billEntryPage.inputTextIntoRevCd(getData.valueFromHeader("LineitemCMS","ReviewedCd",rowData));
			//billEntryPage.inputTextIntoRevMd(getData.valueFromHeader("LineitemCMS","ReviewedMd",rowData));
			billEntryPage.inputTextIntoRXDaysSupply(getData.valueFromHeader("LineitemCMS","Days",rowData));
			billEntryPage.inputTextIntoChrgs(getData.valueFromHeader("LineitemCMS","Charges",rowData), position);
			billEntryPage.inputTextIntoDiag(getData.valueFromHeader("LineitemCMS","Diag",rowData), position);
			//billEntryPage.inputTextIntoTotalCharges(getData.valueFromHeader("LineitemCMS","TotalCharges",rowData));

		}

		TotalChargesSum = TotalChargesSum + Float.parseFloat(getData.valueFromHeader("LineitemCMS","Charges",rowData));

	}	



	public void navigateToUserPortal(){
		loginPage.inputTextIntoUserName("amalik@ekhealth.com");
		loginPage.inputTextIntoPassword("Summer!2017");
		loginPage.clickOnSubmitButton();
		loginPage.ClickOnUserPortalButton();
	}

	public void navigateToBillEntryMainPage(){
		driver.get("http://52.37.60.147/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page");

	}
}
