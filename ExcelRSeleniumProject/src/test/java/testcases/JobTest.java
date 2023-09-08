package testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AddEmployeeObject;
import pageObjects.AttachmentObject;
import pageObjects.JobObject;
import pageObjects.LoginObject;
import reusablemethods.Base;

/*
 * Application : OrangeHRM
 * Main Module: PIM tab
 * Sub module: Job tab under PIM
 * @author: Veena K
 * This test case will cover all the functionalities of Job tab
 * Add job details
 * Add attachments etc
 */

public class JobTest extends Base {
	
	public static final String filePath = "C:\\Users\\achun\\OneDrive\\Desktop\\Veena-Selenium\\Selenium workspace\\ExcelRSeleniumProject\\src\\test\\java\\testdata\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameLogin = "Orane HRM Login";
	public static final String sheetNameEmployee = "AddEmployee";
	public static final String sheetNameJob = "Job";

	public WebDriver driver;
	
	// Import page object class
	LoginObject page = new LoginObject(Base.driver);
	AddEmployeeObject page2 = new AddEmployeeObject(Base.driver);
	JobObject page3 = new JobObject(Base.driver);
	AttachmentObject page4 = new AttachmentObject(Base.driver);
	
	@BeforeTest
	public void setup() throws Exception {
		launchApp(readDataFromExcel(1, 1,filePath, sheetName));
		login();
		addNewEmployee();
		Thread.sleep(3000);
	}
	

	@Test(priority = 1, description =  "TC27 = Change job details")
	public void changeJobDetails() throws Exception {
		/*
		 * Add employee
		 * Change job details		
		 */
		page3.jobTab_link.click();
		
		WebElement actualJobText = page3.jobTab_link;
		String expectedJobText = "Job";
		innerTextEquals(actualJobText, expectedJobText);
		elementAvailable(actualJobText, true);
		elementEnabled(actualJobText, true);
		
		Thread.sleep(4000);
		
		// Enter Job details
		page3.joinedDate.sendKeys(readDataFromExcel(3, 4,filePath, sheetNameJob));
		page3.jobTitle_drpDown.click();
		page3.jobTitle_drpDown.sendKeys(Keys.ARROW_DOWN);
		page3.jobTitle_drpDown.sendKeys(Keys.ENTER);
		
		page3.jobCategory_drpDown.click();
		page3.jobCategory_drpDown.sendKeys(Keys.ARROW_DOWN);
		page3.jobCategory_drpDown.sendKeys(Keys.ENTER);
		
		page3.subUnit_drpDown.click();
		page3.subUnit_drpDown.sendKeys(Keys.ARROW_DOWN);
		page3.subUnit_drpDown.sendKeys(Keys.ENTER);
		
		page3.location_drpDown.click();
		page3.location_drpDown.sendKeys(Keys.ARROW_DOWN);
		page3.location_drpDown.sendKeys(Keys.ENTER);
		
		page3.empStatus_drpDown.click();
		page3.empStatus_drpDown.sendKeys(Keys.ARROW_DOWN);
		page3.empStatus_drpDown.sendKeys(Keys.ENTER);
		
		page3.contractSave_Btn.click();
	}
	
	@Test(priority = 2, description =  "TC28 = Add Employment Contract Details under Job")
	public void addEmploymentContractDetailsUnderJob() throws Exception {
		/*
		 * Add employee
		 * Add employment contract details	
		 */
		
		Thread.sleep(4000);
		page3.empContract_rdBtn.click();
		page3.contractStartDate.sendKeys(readDataFromExcel(4, 11,filePath, sheetNameJob));
		page3.contractEndDate.sendKeys(readDataFromExcel(4, 12,filePath, sheetNameJob));
		page3.contractFileUpload_Btn.sendKeys(readDataFromExcel(2, 1,filePath, sheetName));
		page3.contractSave_Btn.click();	
		
	}
	
	@Test(priority = 3, description =  "TC29 = Add Employment Contract when Contract Start Date greater than Contract End Date")
	public void addEmploymentContractDetailsWhenContractStartDateGreaterThanEndDate() throws Exception {
		/*
		 * Add employee
		 * Add employment contract details when contract start date greater than contract end date
		 * It should throw field validation error message for Contract end date
		 */
		Thread.sleep(4000);
		page3.contractStartDate.sendKeys(readDataFromExcel(5, 11,filePath, sheetNameJob));
		page3.contractEndDate.sendKeys(readDataFromExcel(5, 12,filePath, sheetNameJob));
		page3.contractSave_Btn.click();	
		
		WebElement actualError = page3.endDateErrorMsg;
		String expectedError = "End date should be after Start date";
		innerTextEquals(actualError, expectedError);
		
	}
	
	@Test(priority = 4, description =  "TC30 = Replace existing Employment Contract Details Attachment")
	public void replaceExistingEmploymentContractDetailsFile() throws Exception {
		/*
		 * Add employee
		 * Add employment contract details 
		 * Replace existing contract file with new file
		 */
		Thread.sleep(4000);
		page3.replaceContract_rdBtn.click();
		
		WebElement replaceBtnText = page3.replaceContractText;
		String expectedReplaceText = "Replace Current";
		innerTextEquals(replaceBtnText, expectedReplaceText);
		
		page3.contractFileUpload_Btn.sendKeys(readDataFromExcel(3, 1,filePath, sheetName));
		page3.contractSave_Btn.click();
		
	}
	
	@Test(priority = 5, description =  "TC31 = Delete existing Employment Contract Details Attachment")
	public void deleteExistingEmploymentContractDetailsFile() throws Exception {
		/*
		 * Add employee
		 * Add employment contract details 
		 * Delete existing contract file 
		 */
		Thread.sleep(4000);
		page3.deleteContract_rdBtn.click();
		
		WebElement deleteBtnText = page3.deleteContractText;
		String expectedDeleteText = "Delete Current";
		innerTextEquals(deleteBtnText, expectedDeleteText);
		
		page3.contractSave_Btn.click();
	}
	
	@Test(priority = 6, description =  "TC32 = Terminate Exployment")
	public void terminateEmployment() throws Exception {
		/*
		 * Add employee
		 * Click on Job tab
		 * Click on Terminate employment
		 * Provide mandatory fields and save 
		 */
		
		Thread.sleep(4000);
		page3.terminateEmp_Btn.click();
		
		WebElement terminateBtnText = page3.terminateEmp_Btn;
		String expectedterminateText = "Terminate Employment";
		innerTextEquals(terminateBtnText, expectedterminateText);
		
		page3.terminationDate.sendKeys(readDataFromExcel(10, 4,filePath, sheetNameJob));
		
		page3.terminationReason_drpDown.click();
		page3.terminationReason_drpDown.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
		page3.terminationReason_drpDown.sendKeys(Keys.ENTER);
		
		page3.notes.sendKeys("Not feeling well");
		page3.terminateSave_Btn.click();
		
		// After termination Activate Employment button will appear on screen instead of "Terminate Employment" button
		
		WebElement activateBtnText = page3.activateEmp_Btn;
		String expectedactivateText = "Activate Employment";
		innerTextEquals(activateBtnText, expectedactivateText);
		
	}
	
	@Test(priority = 7, description =  "TC33 = Activate Exployment")
	public void activateEmployment() throws Exception {
		/*
		 * Add employee
		 * Click on Job tab
		 * Click on Terminate employment
		 * Provide mandatory fields and save 
		 * Click on Activate Employment button
		 */
		Thread.sleep(5000);
		
		WebElement activateBtnText = page3.activateEmp_Btn;
		String expectedactivateText = "Activate Employment";
		innerTextEquals(activateBtnText, expectedactivateText);
		
		page3.activateEmp_Btn.click();
		
		// After reactivate, Activate Employment button will disappear on screen and "Terminate Employment" button will appear
		WebElement terminateBtnText = page3.terminateEmp_Btn;
		String expectedterminateText = "Terminate Employment";
		innerTextEquals(terminateBtnText, expectedterminateText);
		
	}
	
	@Test(priority = 8, description =  "TC34 = Attach documents under Job")
	public void addAttachmentUnderJob() throws Exception {
		/*
		 * Click on Job tab
		 * Add attachments under Job
		 */
		Thread.sleep(4000);
		
		page4.attachmentAdd_Btn.click();
		page4.upload_Btn.sendKeys(readDataFromExcel(2, 1,filePath, sheetName));
		page4.attachmentSave_Btn.click();
		Thread.sleep(2000);
		
		/*
		 *  Verify the attachment records
		 *  Filename, type, Added by
		 */
		WebElement actualFilename = page4.file_name;
		String expectedFilename = "ie2.png";
		innerTextEquals(actualFilename, expectedFilename);	
		
		WebElement actualFileType = page4.file_type;
		String expectedFileType = "image/png";
		innerTextEquals(actualFileType, expectedFileType);	
		
		WebElement actualAddedBy = page4.file_addedBy;
		String expectedAddedBy = "Admin";
		innerTextEquals(actualAddedBy, expectedAddedBy);			
	}
	
	@Test(priority = 9, description =  "TC35 = Delete existing Attach under Job by selecting checkbox near particular entry")
	public void deleteExistingAttachmentUnderJobByCheckbox() throws Exception {
		/*
		 * Click on job
		 * Add attachments under job
		 * Delete existing attachment by clicking on checkbox near particular entry
		 * Attachment should be deleted
		 */
		Thread.sleep(4000);
		
		page4.attachDelete_checkbox.click();
		page4.attachConfirmDelete_checkbox.click();
		page4.attachmentConfirmDelete_Btn.click();
		
		// Verify there is no immigration records after delete
		WebElement actualDeleteText = page4.noRecordsAttach;
		String expectedDeleteText = "No Records Found";
		innerTextEquals(actualDeleteText, expectedDeleteText);		
	}
	
	@Test(priority = 10, description =  "TC36 = Download existing Attach under Job")
	public void downloadExistingAttachmentUnderImmigrationRecord() throws Exception {
		/*
		 * Add attachments under Job
		 * Download existing attachment
		 * Attachment should be downloaded successfully
		 */
		addAttachmentUnderJob();
		Thread.sleep(4000);
		
		page4.download_icon.click();			
	}

	
	@AfterSuite
	public void teardown() {
		closeApp();
	}
	
	

	

}
