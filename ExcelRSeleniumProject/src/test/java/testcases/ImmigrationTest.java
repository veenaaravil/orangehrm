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
import pageObjects.ImmigrationObject;
import pageObjects.LoginObject;
import reusablemethods.Base;

/*
 * Application : OrangeHRM
 * Main Module: PIM tab
 * Sub module: Immigration tab under PIM
 * @author: Veena K
 * This test case will cover all the functionalities of Immigration tab
 * Create Immigration details as Passport and visa document
 * Add attachments etc
 */

public class ImmigrationTest extends Base{
	
	public static final String filePath = "C:\\Users\\achun\\OneDrive\\Desktop\\Veena-Selenium\\Selenium workspace\\ExcelRSeleniumProject\\src\\test\\java\\testdata\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameLogin = "Orane HRM Login";
	public static final String sheetNameEmployee = "AddEmployee";
	public static final String sheetNameImmigration = "Immigration";

	public WebDriver driver;
	
	// Import page object class
	LoginObject page = new LoginObject(Base.driver);
	AddEmployeeObject page2 = new AddEmployeeObject(Base.driver);
	ImmigrationObject page3 = new ImmigrationObject(Base.driver);
	AttachmentObject page4 = new AttachmentObject(Base.driver);
	
	@BeforeTest
	public void setup() throws Exception {
		launchApp(readDataFromExcel(1, 1,filePath, sheetName));
		login();
		addNewEmployee();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1, description =  "TC13 = Add Immigration details with passport as the Document")
	public void addImmigrationDetailsWithPassport() throws Exception {
		/*
		 * Click on Immigration tab and choose passport as document 
		 * Provide all mandatory fields and save the immigration details
		 * It should create immigration details with Passport as the document
		 * Also perform validations for the Immigration form fields
		 */
		page3.immigrationTab_link.click();
		WebElement imgText = page3.immigrationTab_link;
		String actualImgText = "Immigration";
		innerTextEquals(imgText, actualImgText);
		elementAvailable(imgText, true);
		elementEnabled(imgText, true);
		
		page3.imgAdd_Btn.click();
		page3.number_text.sendKeys(readDataFromExcel(3, 4,filePath, sheetNameImmigration));
		page3.issueDate.sendKeys(readDataFromExcel(3, 5,filePath, sheetNameImmigration));
		page3.expiryDate.sendKeys(readDataFromExcel(3, 6,filePath, sheetNameImmigration));
		page3.eligibleStatus_text.sendKeys(readDataFromExcel(3, 7,filePath, sheetNameImmigration));
		
		page3.issue_dropDwn.click();
		page3.issue_dropDwn.sendKeys(Keys.ARROW_DOWN);
		page3.issue_dropDwn.sendKeys(Keys.ENTER);
		page3.elgReviewDate.sendKeys(readDataFromExcel(3, 9,filePath, sheetNameImmigration));
		page3.comments_text.sendKeys(readDataFromExcel(3, 10,filePath, sheetNameImmigration));
		page3.imgSave_Btn.click();	
	}
	
	@Test(priority = 2, description =  "TC14 = Add Immigration details with visa as the Document")
	public void addImmigrationDetailsWithVisa() throws Exception {
		/*
		 * Click on Immigration tab and choose visa as document 
		 * Provide all mandatory fields and save the immigration details
		 * It should create immigration details with Visa as the document
		 * Also perform validations for the Immigration form fields
		 */
		Thread.sleep(5000);
		
		page3.imgAdd_Btn.click();
		Thread.sleep(1000);
		page3.visa_rdBtn.click();
		page3.number_text.sendKeys(readDataFromExcel(4, 4,filePath, sheetNameImmigration));
		page3.issueDate.sendKeys(readDataFromExcel(4, 5,filePath, sheetNameImmigration));
		page3.expiryDate.sendKeys(readDataFromExcel(4, 6,filePath, sheetNameImmigration));
		page3.eligibleStatus_text.sendKeys(readDataFromExcel(4, 7,filePath, sheetNameImmigration));
		
		page3.issue_dropDwn.click();
		page3.issue_dropDwn.sendKeys(Keys.ARROW_DOWN);
		page3.issue_dropDwn.sendKeys(Keys.ENTER);
		page3.elgReviewDate.sendKeys(readDataFromExcel(4, 9,filePath, sheetNameImmigration));
		page3.comments_text.sendKeys(readDataFromExcel(4, 10,filePath, sheetNameImmigration));
		page3.imgSave_Btn.click();	
	}
	
	@Test(priority = 3, description =  "TC15 = Add Immigration details without passport/visa number")
	public void addImmigrationDetailsWithoutPassportOrVisaNumber() throws Exception {
		/*
		 * Click on Immigration tab and choose visa/passport as document 
		 * Don't provide visa/passport number which is mandatory fields and save the immigration details
		 * It should not create the Immigration details when the passport/visa number is empty
		 * Also perform validations for the Immigration form fields
		 */
		Thread.sleep(5000);
		page3.imgAdd_Btn.click();
		Thread.sleep(1000);
		page3.visa_rdBtn.click();
		page3.issueDate.sendKeys(readDataFromExcel(4, 5,filePath, sheetNameImmigration));
		page3.expiryDate.sendKeys(readDataFromExcel(4, 6,filePath, sheetNameImmigration));
		page3.eligibleStatus_text.sendKeys(readDataFromExcel(4, 7,filePath, sheetNameImmigration));
		
		page3.issue_dropDwn.click();
		page3.issue_dropDwn.sendKeys(Keys.ARROW_DOWN);
		page3.issue_dropDwn.sendKeys(Keys.ENTER);
		page3.elgReviewDate.sendKeys(readDataFromExcel(4, 9,filePath, sheetNameImmigration));
		page3.comments_text.sendKeys(readDataFromExcel(4, 10,filePath, sheetNameImmigration));
		page3.imgSave_Btn.click();
		
		WebElement actualError = page3.numberField_errormsg;
		String expectedError = "Required";
		innerTextEquals(actualError, expectedError);
		
	}
	
	@Test(priority = 4, description =  "TC16 = Add Immigration details when expiry date less than issue date")
	public void addImmigrationDetailsWhenExpiryDateLessthanIssueDate() throws Exception {
		/*
		 * Click on Immigration tab and choose visa/passport as document 
		 * Provide expiry date which is less than issue date 
		 * It should throw field validation error message and should not create immigration details
		 * Also perform validations for the Immigration form fields
		 */
		Thread.sleep(5000);
		page3.imgAdd_Btn.click();
		Thread.sleep(1000);
		page3.visa_rdBtn.click();
		page3.number_text.sendKeys(readDataFromExcel(5, 4,filePath, sheetNameImmigration));
		page3.issueDate.sendKeys(readDataFromExcel(5, 5,filePath, sheetNameImmigration));
		page3.expiryDate.sendKeys(readDataFromExcel(5, 6,filePath, sheetNameImmigration));
		page3.eligibleStatus_text.sendKeys(readDataFromExcel(5, 7,filePath, sheetNameImmigration));
		
		page3.issue_dropDwn.click();
		page3.issue_dropDwn.sendKeys(Keys.ARROW_DOWN);
		page3.issue_dropDwn.sendKeys(Keys.ENTER);
		page3.elgReviewDate.sendKeys(readDataFromExcel(5, 9,filePath, sheetNameImmigration));
		page3.comments_text.sendKeys(readDataFromExcel(5, 10,filePath, sheetNameImmigration));
		page3.imgSave_Btn.click();
		
		WebElement actualError = page3.expiryDateField_errormsg;
		String expectedError = "Expiry date should be after issued date";
		innerTextEquals(actualError, expectedError);
		
	}
	
	@Test(priority = 5, description =  "TC17 = While creating immigration details click on Add button")
	public void clickOnAddButtonWhileCreatingImmigrationDetails() throws Exception {
		/*
		 * Click on Immigration tab 
		 * Click on add button near Assigned Immigration Records
		 * Again try to click on add button near "Assigned Immigration Records"
		 * The add button near "Assigned Immigration Records" should be disabled while creating/editing immigration details
		 */
		Thread.sleep(5000);
		page3.imgAdd_Btn.click();
		page3.imgAdd_Btn.click();
		
		// There should be only one immigration form even after clicking on add button twice
		WebElement addButton = page3.formText;
		String expectedFormText = "Add Immigration";
		innerTextEquals(addButton, expectedFormText);
		
	}
	
	@Test(priority = 6, description =  "TC18 = Creating multiple Immigration details for the same employee")
	public void addMultipleImmigrationDetails() throws Exception {
		/*
		 * Creating multiple Immigration details for the same employee
		 */
		
		addNewEmployee();
		Thread.sleep(4000);
		addImmigrationDetailsWithPassport();
		Thread.sleep(4000);
		page3.imgAdd_Btn.click();
		page3.visa_rdBtn.click();
		page3.number_text.sendKeys(readDataFromExcel(4, 4,filePath, sheetNameImmigration));
		page3.issueDate.sendKeys(readDataFromExcel(4, 5,filePath, sheetNameImmigration));
		page3.expiryDate.sendKeys(readDataFromExcel(4, 6,filePath, sheetNameImmigration));
		page3.eligibleStatus_text.sendKeys(readDataFromExcel(4, 7,filePath, sheetNameImmigration));
		
		page3.issue_dropDwn.click();
		page3.issue_dropDwn.sendKeys(Keys.ARROW_DOWN);
		page3.issue_dropDwn.sendKeys(Keys.ENTER);
		page3.elgReviewDate.sendKeys(readDataFromExcel(4, 9,filePath, sheetNameImmigration));
		page3.comments_text.sendKeys(readDataFromExcel(4, 10,filePath, sheetNameImmigration));
		page3.imgSave_Btn.click();
		
		// Verify the immigration record count is "2"
		WebElement actualCount = page3.imgrecords_count;
		String expectedCount = "(2) Records Found";
		innerTextEquals(actualCount, expectedCount);
		
	}
	
	@Test(priority = 7, description =  "TC19 = Edit Existing Immigration Details")
	public void editExistingImmigrationDetails() throws Exception {
		/*
		 * Create immigration details and
		 * Edit existing immigration details
		 */
		addNewEmployee();
		Thread.sleep(4000);
		addImmigrationDetailsWithPassport();
		Thread.sleep(4000);
		page3.imgEdit_icon.click();
		Thread.sleep(3000);
		
		// Verify the immigration edit form text is "Edit Immigration"
		WebElement actualEditText = page3.EditImg;
		String expectedEditText = "Edit Immigration";
		innerTextEquals(actualEditText, expectedEditText);
		
		// Clear existing data
		page3.number_text.clear();
		page3.eligibleStatus_text.clear();
		page3.comments_text.clear();
		
		// Update existing record with new values		
		page3.visa_rdBtn.click();
		page3.number_text.sendKeys(readDataFromExcel(7, 4,filePath, sheetNameImmigration));
		page3.eligibleStatus_text.sendKeys(readDataFromExcel(7, 7,filePath, sheetNameImmigration));
		page3.comments_text.sendKeys(readDataFromExcel(7, 10,filePath, sheetNameImmigration));
		page3.imgSave_Btn.click();		
	}
	
	@Test(priority = 8, description =  "TC20 = Delete Immigration record by using delete icon")
	public void deleteImmigrationRecordWithDeleteIcon() throws Exception {
		/*
		 * Create immigration details and
		 * Delete the existing Immigration record using Delete icon
		 */
		addNewEmployee();
		Thread.sleep(4000);
		addImmigrationDetailsWithPassport();
		Thread.sleep(4000);
		page3.imgDelete_icon.click();
		page3.imgConfirmDelete_Btn.click();
		
		// Verify there is no immigration records after delete
		WebElement actualDeleteText = page3.noRecordsImg;
		String expectedDeleteText = "No Records Found";
		innerTextEquals(actualDeleteText, expectedDeleteText);		
	}
	
	@Test(priority = 9, description =  "TC21 = Delete Immigration record by using delete checkbox near particular Immigration record")
	public void deleteImmigrationRecordUsingCheckbox() throws Exception {
		/*
		 * Create immigration details and
		 * Delete the existing Immigration record by clicking on checkbox near particular entry
		 * And then confirm Delete
		 */
		addNewEmployee();
		Thread.sleep(4000);
		addImmigrationDetailsWithPassport();
		Thread.sleep(4000);
		page3.imgDelete_checkbox.click();
		page3.imgConfirmDelete_checkbox.click();
		page3.imgConfirmDelete_Btn.click();
		
		// Verify there is no immigration records after delete
		WebElement actualDeleteText = page3.noRecordsImg;
		String expectedDeleteText = "No Records Found";
		innerTextEquals(actualDeleteText, expectedDeleteText);		
	}
	
	@Test(priority = 10, description =  "TC22 = Attach documents under Immigration")
	public void addAttachmentUnderImmigration() throws Exception {
		/*
		 * Create immigration details and
		 * Add attachments under Immigration
		 */
//		addImmigrationDetailsWithPassport();
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
	
	@Test(priority = 11, description =  "TC23 = Replace existing Attach under Immigration")
	public void replaceExistingAttachmentUnderImmigration() throws Exception {
		/*
		 * Create immigration details and
		 * Add attachments under Immigration
		 * Replace existing attachment
		 */
//		addAttachmentUnderImmigration();
		Thread.sleep(2000);
	
		page4.attachmentEdit_icon.click();
		Thread.sleep(4000);
		page4.upload_Btn.sendKeys(readDataFromExcel(3, 1,filePath, sheetName));
		Thread.sleep(2000);
		page4.attachmentSave_Btn.click();
		Thread.sleep(2000);
		
		/*
		 *  Verify the attachment records
		 *  Filename, type, Added by
		 */
		WebElement actualFilename = page4.file_name2;
		String expectedFilename = "opera2.png";
		innerTextEquals(actualFilename, expectedFilename);	
		
		WebElement actualFileType = page4.file_type;
		String expectedFileType = "image/png";
		innerTextEquals(actualFileType, expectedFileType);	
		
		WebElement actualAddedBy = page4.file_addedBy;
		String expectedAddedBy = "Admin";
		innerTextEquals(actualAddedBy, expectedAddedBy);			
	}
	
	@Test(priority = 12, description =  "TC24 = Delete existing Attach under Immigration using Delete icon")
	public void deleteExistingAttachmentUnderImmigrationUsingDeleteIcon() throws Exception {
		/*
		 * Create immigration details and
		 * Add attachments under Immigration
		 * Delete existing attachment by using Delete icon
		 * Attachment should be deleted
		 */
//		addAttachmentUnderImmigration();
		Thread.sleep(2000);
		page4.attachmentDelete_icon.click();
		page4.attachmentConfirmDelete_Btn.click();
		
		// Verify there is no immigration records after delete
		WebElement actualDeleteText = page4.noRecordsAttach;
		String expectedDeleteText = "No Records Found";
		innerTextEquals(actualDeleteText, expectedDeleteText);					
	}
	
	@Test(priority = 13, description =  "TC25 = Delete existing Attach under Immigration by selecting checkbox near particular entry")
	public void deleteExistingAttachmentUnderImmigrationByCheckbox() throws Exception {
		/*
		 * Create immigration details and
		 * Add attachments under Immigration
		 * Delete existing attachment by clicking on checkbox near particular entry
		 * Attachment should be deleted
		 */
		addAttachmentUnderImmigration();
		Thread.sleep(2000);
		
		page4.attachDelete_checkbox.click();
		page4.attachConfirmDelete_checkbox.click();
		page4.attachmentConfirmDelete_Btn.click();
		
		// Verify there is no immigration records after delete
		WebElement actualDeleteText = page4.noRecordsAttach;
		String expectedDeleteText = "No Records Found";
		innerTextEquals(actualDeleteText, expectedDeleteText);		
	}
	
	@Test(priority = 14, description =  "TC26 = Download existing Attach under Immigration")
	public void downloadExistingAttachmentUnderImmigrationRecord() throws Exception {
		/*
		 * Create immigration details and
		 * Add attachments under Immigration
		 * Download existing attachment
		 * Attachment should be downloaded successfully
		 */
		addAttachmentUnderImmigration();
		Thread.sleep(2000);
		
		page4.download_icon.click();			
	}

	@AfterSuite
	public void teardown() {
		closeApp();
	}
}
