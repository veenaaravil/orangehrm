package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImmigrationObject {
	// Immigration locators
	
	@FindBy(xpath="//a[text()='Immigration']") public WebElement immigrationTab_link;
	@FindBy (xpath="//h6[text()='Assigned Immigration Records']/following-sibling::button")public WebElement imgAdd_Btn;
	@FindBy (xpath="//label[text()='Passport']/span")public WebElement passport_rdBtn;
	@FindBy (xpath="//label[text()='Visa']/span")public WebElement visa_rdBtn;
	@FindBy (xpath="//label[text()='Number']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input")public WebElement number_text;
	@FindBy (xpath="//label[text()='Issued Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/div/div/input") public WebElement issueDate;
	@FindBy (xpath="//label[text()='Expiry Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/div/div/input")public WebElement expiryDate;
	@FindBy (xpath="//label[text()='Eligible Review Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/div/div/input")public WebElement elgReviewDate;
	@FindBy (xpath="//label[text()='Eligible Status']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input")public WebElement eligibleStatus_text;
	@FindBy (xpath="//label[text()='Issued By']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/div/div/div[@class='oxd-select-text--after']")public WebElement issuedBy_drpDown;
	@FindBy (xpath="//textarea[@placeholder='Type Comments here']")public WebElement comments_text;
	@FindBy (xpath="//button[text()=' Save ']") public WebElement imgSave_Btn;
	@FindBy (xpath="//div[text()='Expiry Date']/ancestor::div/div[@class='oxd-table-header']/following-sibling::div/div/div/div/div/button//i[@class='oxd-icon bi-trash']")public WebElement imgDelete_icon;
	@FindBy (xpath="//button[text()=' Yes, Delete ']") public WebElement imgConfirmDelete_Btn;
	@FindBy (xpath="//div[text()='Document']/ancestor::div/div[@class='oxd-table-header']/following-sibling::div//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")public WebElement imgDelete_checkbox;
	@FindBy (xpath="//button[text()=' Delete Selected ']")public WebElement imgConfirmDelete_checkbox;
	@FindBy (xpath="//div[text()='Expiry Date']/ancestor::div/div[@class='oxd-table-header']/following-sibling::div/div/div/div/div/button//i[@class='oxd-icon bi-pencil-fill']")public WebElement imgEdit_icon;
	
	@FindBy (xpath = "//div[@class='oxd-select-text-input']")public WebElement issue_dropDwn;
	@FindBy (xpath = "//h6[text()='Assigned Immigration Records']/ancestor::div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/following-sibling::div[@class='orangehrm-container']/div[@class='oxd-table']")public WebElement imgTable;
	@FindBy (xpath = "//span[text()='Required']")public WebElement numberField_errormsg;
	@FindBy (xpath = "//span[text()='Expiry date should be after issued date']")public WebElement expiryDateField_errormsg;
	@FindBy (xpath = "//h6[text()='Add Immigration']")public WebElement formText;
	@FindBy (xpath = "//span[text()=' (2) Records Found']")public WebElement imgrecords_count;
	@FindBy (xpath = "//h6[text()='Edit Immigration']")public WebElement EditImg;
	@FindBy (xpath = "//h6[text()='Assigned Immigration Records']/ancestor::div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/following-sibling::div/div/span[text()='No Records Found']")public WebElement noRecordsImg;

	
	WebDriver driver;
	public ImmigrationObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
}
