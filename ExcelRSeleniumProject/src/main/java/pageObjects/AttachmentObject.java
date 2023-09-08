package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttachmentObject {
	
	// Attachments locators
	@FindBy (xpath="//h6[text()='Attachments']/following-sibling::button")public WebElement attachmentAdd_Btn;
	@FindBy (xpath="//input[@class='oxd-file-input']")public WebElement upload_Btn;
	@FindBy (xpath="//button[text()=' Cancel ']/following-sibling::button[text()=' Save ']") public WebElement attachmentSave_Btn;
	@FindBy (xpath="//div[text()='Added By']/ancestor::div/div[@class='oxd-table-header']/following-sibling::div/div/div/div/div/button//i[@class='oxd-icon bi-pencil-fill']")public WebElement attachmentEdit_icon;
	@FindBy (xpath="//div[text()='Added By']/ancestor::div/div[@class='oxd-table-header']/following-sibling::div/div/div/div/div/button//i[@class='oxd-icon bi-trash']")public WebElement attachmentDelete_icon;
	@FindBy (xpath="//button[text()=' Yes, Delete ']") public WebElement attachmentConfirmDelete_Btn;
	@FindBy (xpath="//div[text()='File Name']/ancestor::div/div[@class='oxd-table-header']/following-sibling::div//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")public WebElement attachDelete_checkbox;
	@FindBy (xpath="//button[text()=' Delete Selected ']")public WebElement attachConfirmDelete_checkbox;
	@FindBy (xpath="//i[@class='oxd-icon bi-download']") public WebElement download_icon;
	@FindBy (xpath = "//h6[text()='Edit Attachment']")public WebElement editText;
	@FindBy (xpath = "//h6[text()='Attachments']/ancestor::div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/following-sibling::div/div/span[text()='No Records Found']")public WebElement noRecordsAttach;


	// Validation
	@FindBy (xpath = "//div[text()='ie2.png']")public WebElement file_name;
	@FindBy (xpath = "//div[text()='opera2.png']")public WebElement file_name2;
	@FindBy (xpath = "//div[text()='image/png']")public WebElement file_type;
	@FindBy (xpath = "//div[text()='Admin']")public WebElement file_addedBy;
	
	
	WebDriver driver;
	public AttachmentObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
}
