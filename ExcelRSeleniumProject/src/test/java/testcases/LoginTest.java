package testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v110.log.Log;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginObject;
import reusablemethods.Base;

/*
 * Application : OrangeHRM
 * Module: Login
 * @author: Veena K
 * This test case will cover all the functionalities of login page
 * Login with valid credentials
 * Login with invalid credentials and so on.
 */
public class LoginTest extends Base {
	public static final String filePath = "C:\\Users\\achun\\OneDrive\\Desktop\\Veena-Selenium\\Selenium workspace\\ExcelRSeleniumProject\\src\\test\\java\\testdata\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameLogin = "Orane HRM Login";

	public WebDriver driver;
	
	LoginObject page = new LoginObject(Base.driver);
	
	
//	public LoginTest() throws Exception {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	@BeforeTest
	public void setup() {
		launchApp(readDataFromExcel(1, 1,filePath, sheetName));
	}

	@Test(priority = 1, description =  "TC1 = Login with valid username and valid password")
	public void loginWithValidUsernameAndValidPassword() throws Exception {	
		page.uid_text.sendKeys(readDataFromExcel(3, 2, filePath, sheetNameLogin));
		page.pwd_text.sendKeys(readDataFromExcel(3, 3, filePath, sheetNameLogin));
		page.login_btn.click();
		titleEquals("OrangeHRM");
		urlEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		logOut();
			
	}
	
	@Test(priority = 2, description = "TC2 = Login with valid username and invalid password")
	public void loginWithValidUsernameAndInvalidPassword() throws Exception {	
		page.uid_text.clear();
		page.pwd_text.clear();
		page.uid_text.sendKeys(readDataFromExcel(4, 2, filePath, sheetNameLogin));
		page.pwd_text.sendKeys(readDataFromExcel(4, 3, filePath, sheetNameLogin));
		page.login_btn.click();
		WebElement actualErrorMessage =  page.invalid_login_errormessage;
		String expectedErrorMessage = "Invalid credentials";
		innerTextEquals(actualErrorMessage, expectedErrorMessage);
			
	}
	
	@Test(priority = 3, description = "TC3 = Login with invalid username and valid password")
	public void loginWithInvalidUsernameAndValidPassword() throws Exception {	
		page.uid_text.clear();
		page.pwd_text.clear();
		page.uid_text.sendKeys(readDataFromExcel(5, 2, filePath, sheetNameLogin));
		page.pwd_text.sendKeys(readDataFromExcel(5, 3, filePath, sheetNameLogin));
		page.login_btn.click();
		WebElement actualErrorMessage =  page.invalid_login_errormessage;
		String expectedErrorMessage = "Invalid credentials";
		innerTextEquals(actualErrorMessage, expectedErrorMessage);
			
	}
	
	@Test(priority = 4, description = "TC4 = Login with invalid username and invalid password")
	public void loginWithInvalidUsernameAndInvalidPassword() throws Exception {	
		page.uid_text.clear();
		page.pwd_text.clear();
		page.uid_text.sendKeys(readDataFromExcel(6, 2, filePath, sheetNameLogin));
		page.pwd_text.sendKeys(readDataFromExcel(6, 3, filePath, sheetNameLogin));
		page.login_btn.click();
		WebElement actualErrorMessage =  page.invalid_login_errormessage;
		String expectedErrorMessage = "Invalid credentials";
		innerTextEquals(actualErrorMessage, expectedErrorMessage);
			
	}
	
	@Test(priority = 5, description = "TC5 = Login with blank username and invalid password")
	public void loginWithBlankUsernameAndInvalidPassword() throws Exception {	
		page.uid_text.clear();
		page.pwd_text.clear();
		page.pwd_text.sendKeys(readDataFromExcel(7, 3, filePath, sheetNameLogin));
		page.login_btn.click();
		WebElement actualErrorMessage =  page.singleblank_errormessage;
		String expectedErrorMessage = "Required";
		innerTextEquals(actualErrorMessage, expectedErrorMessage);
			
	}
	
	@Test(priority = 6, description = "TC6 = Login with valid username and blank password")
	public void loginWithValidUsernameAndBlankPassword() throws Exception {	
		page.uid_text.clear();
		page.pwd_text.clear();
		page.uid_text.sendKeys(readDataFromExcel(8, 2, filePath, sheetNameLogin));
		page.login_btn.click();
		Thread.sleep(2000);
		WebElement actualErrorMessage =  page.singleblank_errormessage;
		String expectedErrorMessage = "Required";
		innerTextEquals(actualErrorMessage, expectedErrorMessage);
			
	}
	
	@Test(priority = 7, description = "TC7 = Login with blank username and blank password")
	public void loginWithBlankUsernameAndBlankPassword() throws Exception {	
		page.uid_text.clear();
		page.pwd_text.clear();
		page.login_btn.click();
		List<WebElement> actualErrorMessage =  page.multipleblankfield_errormessage;
		String expectedErrorMessage = "Required";
		multipleInnerTextEquals(actualErrorMessage, expectedErrorMessage);	
			
	}
	
	@AfterSuite
	public void teardown() {
		closeApp();
	}


}
