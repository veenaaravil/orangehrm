package testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AddEmployeeObject;
import pageObjects.LoginObject;
import reusablemethods.Base;

/*
 * Application : OrangeHRM
 * Main Module: PIM tab
 * Sub module: Add Employee tab under PIM
 * @author: Veena K
 * This test case will cover all the functionalities of add employee tab
 * Add new employee
 * Create credentials for the new employee etc.
 */

public class AddEmployeeTest extends Base{

	public static final String filePath = "C:\\Users\\achun\\OneDrive\\Desktop\\Veena-Selenium\\Selenium workspace\\ExcelRSeleniumProject\\src\\test\\java\\testdata\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameEmployee = "AddEmployee";

	public WebDriver driver;
	
	LoginObject page = new LoginObject(Base.driver);
	AddEmployeeObject page2 = new AddEmployeeObject(Base.driver);
	
	@BeforeTest
	public void setup() {
		launchApp(readDataFromExcel(1, 1,filePath, sheetName));
		login();
	}

	@Test(priority = 1, description =  "TC8 = Add new employee with mandatory fields")
	public void addNewEmployee() throws Exception {	
		
		// Click on PIM tab and perform validation operations
		page2.pimTab_link.click();
		WebElement actualPIMElement = page2.pimTab_link;
		String expectedText = "PIM";
		innerTextEquals(actualPIMElement, expectedText);
		String expectedPIMUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		urlEquals(expectedPIMUrl);
		elementAvailable(actualPIMElement, true);
		elementEnabled(actualPIMElement, true);
		
		// Click on Add Employee tab and perform validation operations
		page2.addEmployeeTab_link.click();
		WebElement actualAddEmployee = page2.addEmployeeTab_link;
		String expectedAddEmployeeText = "Add Employee";
		innerTextEquals(actualAddEmployee, expectedAddEmployeeText);
		String expectedAddEmployeeUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList#";
		urlEquals(expectedAddEmployeeUrl);
		elementAvailable(actualAddEmployee, true);
		elementEnabled(actualAddEmployee, true);
		
		// Enter mandatory fields to create an employee FirstName, LastName and EmployeeId
		page2.fname_text.sendKeys(readDataFromExcel(3, 2, filePath, sheetNameEmployee));
		page2.lname_text.sendKeys(readDataFromExcel(3, 3, filePath, sheetNameEmployee));
		Thread.sleep(1000);
		page2.save_Btn.submit();
		
		// After creating employee url will redirect to employee list tab
		
//		String urlAfterEmpCreation = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber";
//		urlContains(urlAfterEmpCreation);
	}
	
	@Test(priority = 2, description =  "TC9 = Add new employee without providing mandatory fields")
	public void createEmployeeWithBlankFirstnameAndLastName() throws Exception {	
		
		// Click on PIM tab
		page2.pimTab_link.click();
		// Click on Add Employee tab and perform validation operations
		page2.addEmployeeTab_link.click();
		Thread.sleep(2000);
		page2.save_Btn.submit();
		
		List<WebElement> actualErrorMessage =  page2.requiredfieldError_msg;
		String expectedErrorMsg = "Required";
		multipleInnerTextEquals(actualErrorMessage, expectedErrorMsg);
		
	}
	
	@Test(priority = 3, description =  "TC10 = Add new employee and create login credentials")
	public void addEmployeeAndCreateLoginDetails() throws Exception {	

		// Click on PIM tab
		page2.pimTab_link.click();
		// Click on Add Employee tab and perform validation operations
		page2.addEmployeeTab_link.click();

		// Enter mandatory fields to create an employee FirstName, LastName and EmployeeId
		page2.fname_text.sendKeys(readDataFromExcel(4, 2, filePath, sheetNameEmployee));
		page2.lname_text.sendKeys(readDataFromExcel(4, 3, filePath, sheetNameEmployee));
		Thread.sleep(1000);
		page2.createLoginDetails_rdBtn.click();
		WebElement rdButton = page2.createLoginDetails_rdBtn;
		elementEnabled(rdButton, true);
		
		// Enter username, password & confirm password and save login credentials
		page2.username_text.clear();
		page2.pwd_text.clear();
		page2.username_text.sendKeys(readDataFromExcel(4, 4, filePath, sheetNameEmployee));
		page2.pwd_text.sendKeys(readDataFromExcel(4, 5, filePath, sheetNameEmployee));
		Thread.sleep(1000);
		page2.cnfPwd_text.sendKeys(readDataFromExcel(4, 6, filePath, sheetNameEmployee));
		
		// Verify the status is enabled
		WebElement statusButton = page2.enabled_rdBtn;
		elementEnabled(statusButton, true);
		
		// Verify passoword textbox validation 
		WebElement actualPwdValidation = page2.pwdvalidation_text;
		String expectedPwdValidation = "For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers";
		innerTextEquals(actualPwdValidation, expectedPwdValidation);
		Thread.sleep(1000);
		page2.save_Btn.submit();		
	}
	
	@Test(priority = 4, description =  "TC11 = Add new employee and create login credentials with invalid characters")
	public void addEmployeeAndCreateCredentialsWithInvalidData() throws Exception {	

		// Click on PIM tab
		page2.pimTab_link.click();
		// Click on Add Employee tab
		page2.addEmployeeTab_link.click();

		// Enter mandatory fields to create an employee FirstName, LastName and EmployeeId
		page2.fname_text.sendKeys(readDataFromExcel(5, 2, filePath, sheetNameEmployee));
		page2.lname_text.sendKeys(readDataFromExcel(5, 3, filePath, sheetNameEmployee));
		Thread.sleep(1000);
		page2.createLoginDetails_rdBtn.click();
		WebElement rdButton = page2.createLoginDetails_rdBtn;
		elementEnabled(rdButton, true);
		
		// Enter username > 5 characters, password > 7 characters which exceeds the allowed character limit
		page2.username_text.clear();
		page2.pwd_text.clear();
		page2.username_text.sendKeys(readDataFromExcel(5, 4, filePath, sheetNameEmployee));
		page2.pwd_text.sendKeys(readDataFromExcel(5, 5, filePath, sheetNameEmployee));
		Thread.sleep(1000);
		page2.cnfPwd_text.sendKeys(readDataFromExcel(5, 6, filePath, sheetNameEmployee));
		Thread.sleep(1000);
		page2.save_Btn.submit();	
		
		// Validate field validation error messages
		WebElement actuaUname_ErrorMsg = page2.uname_validationmsg;
		String expectedUnameErrorMsg = "Should be at least 5 characters";
		innerTextEquals(actuaUname_ErrorMsg, expectedUnameErrorMsg);
		
		WebElement actuaPwd_ErrorMsg = page2.pwd_validationmsg;
		String expectedPwdErrorMsg = "Should have at least 7 characters";
		innerTextEquals(actuaPwd_ErrorMsg, expectedPwdErrorMsg);
		
		WebElement actuaCnfPwd_ErrorMsg = page2.cnfpwd_validationmsg;
		String expectedCnfPwdErrorMsg = "Passwords do not match";
		innerTextEquals(actuaCnfPwd_ErrorMsg, expectedCnfPwdErrorMsg);
	}
	
	@Test(priority = 5, description =  "TC12 = Login with new login credentials")

	public void loginWithNewLoginCredentials() throws Exception {
		logOut();
		page.uid_text.clear();
		Thread.sleep(2000);
		page.pwd_text.clear();
		page.uid_text.sendKeys(readDataFromExcel(4, 4, filePath, sheetNameEmployee));
		Thread.sleep(2000);
		page.pwd_text.sendKeys(readDataFromExcel(4, 5, filePath, sheetNameEmployee));
		Thread.sleep(2000);
		page.login_btn.click();
		Reporter.log("=====Application Logged in successfully with new Login Credentials=====", true);
	}

	@AfterSuite
	public void teardown() {
		closeApp();
	}

}
