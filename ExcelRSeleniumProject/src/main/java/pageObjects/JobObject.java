package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobObject {
	// Job Details
	
	@FindBy (xpath = "//a[text()='Job']")public WebElement jobTab_link;
	@FindBy (xpath = "//input[@placeholder='yyyy-mm-dd']")public WebElement joinedDate;
	@FindBy (xpath = "//label[text()='Job Title']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[@class='oxd-select-text-input']")public WebElement jobTitle_drpDown;
	@FindBy (xpath = "//label[text()='Job Category']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[@class='oxd-select-text-input']")public WebElement jobCategory_drpDown;
	@FindBy (xpath = "//label[text()='Sub Unit']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[@class='oxd-select-text-input']")public WebElement subUnit_drpDown;
	@FindBy (xpath = "//label[text()='Location']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[@class='oxd-select-text-input']")public WebElement location_drpDown;
	@FindBy (xpath = "//label[text()='Employment Status']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[@class='oxd-select-text-input']")public WebElement empStatus_drpDown;
	
	// Employment Contract Details
	
	@FindBy (xpath = "//p[text()='Include Employment Contract Details']/following-sibling::div//span")public WebElement empContract_rdBtn;
	@FindBy (xpath = "//*[text()='Contract Start Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input")public WebElement contractStartDate;
	@FindBy (xpath = "//*[text()='Contract End Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input")public WebElement contractEndDate;
	@FindBy (xpath = "//input[@class='oxd-file-input']")public WebElement contractFileUpload_Btn;
	@FindBy (xpath = "//button[text()=' Save ']")public WebElement contractSave_Btn;
	@FindBy (xpath = "//label[text()='Delete Current']/span")public WebElement deleteContract_rdBtn;
	@FindBy (xpath = "//label[text()='Replace Current']/span")public WebElement replaceContract_rdBtn;
	
	@FindBy (xpath = "//label[text()='Delete Current']")public WebElement deleteContractText;
	@FindBy (xpath = "//label[text()='Replace Current']")public WebElement replaceContractText;
	
	
	@FindBy (xpath = "//span[text()='End date should be after Start date']")public WebElement endDateErrorMsg;
	
	// Employee Termination
	
	@FindBy (xpath = "//button[@title='Terminate Employment']")public WebElement terminateEmp_Btn;
	@FindBy (xpath = "//label[text()='Termination Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//*[@placeholder='yyyy-mm-dd']")public WebElement terminationDate;
	@FindBy (xpath = "//label[text()='Termination Reason']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//*[@class='oxd-select-text-input']")public WebElement terminationReason_drpDown;
	@FindBy (xpath = "//label[text()='Note']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//*[@placeholder='Type here']")public WebElement notes;
	@FindBy (xpath = "//button[text()=' Cancel ']/following-sibling::button[text()=' Save ']")public WebElement terminateSave_Btn;
	@FindBy (xpath = "//button[text()= ' Activate Employment ']")public WebElement activateEmp_Btn;
	
	WebDriver driver;
	public JobObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
}
