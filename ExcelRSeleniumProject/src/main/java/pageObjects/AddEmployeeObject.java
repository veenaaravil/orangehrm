package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeeObject {
	@FindBy (xpath="//span[text()='PIM']") public WebElement pimTab_link;
	@FindBy (xpath="//a[text()='Add Employee']") public WebElement addEmployeeTab_link;
	@FindBy (name = "firstName") public WebElement fname_text;
	@FindBy (name="middleName") public WebElement mname_text;
	@FindBy (name="lastName") public WebElement lname_text;
	@FindBy (xpath="//label[text()='Employee Id']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input") public WebElement empid_text;
	@FindBy (xpath="//p[text()='Create Login Details']/following-sibling::div/label/span")public WebElement createLoginDetails_rdBtn;
	@FindBy (xpath="//label[text()='Username']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input")public WebElement username_text;
	@FindBy (xpath="//input[@value='1']/following-sibling::span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']") public WebElement enabled_rdBtn;
	@FindBy (xpath="//input[@value='2']/following-sibling::span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']")public WebElement disabled_rdBtn;
	@FindBy (xpath="//label[text()='Password']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input") public WebElement pwd_text;
	@FindBy (xpath="//label[text()='Confirm Password']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input") public WebElement cnfPwd_text;
	@FindBy (xpath="//i[@class='oxd-icon bi-plus']")public WebElement upload_Btn;
	@FindBy (xpath="//button[text()=' Save ']")public WebElement save_Btn;
	@FindBy (xpath = "//span[text()='Required']")public List<WebElement> requiredfieldError_msg;
	@FindBy (xpath = "//p[text()='For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers']")public WebElement pwdvalidation_text;
	@FindBy (xpath = "//span[text()='Should be at least 5 characters']")public WebElement uname_validationmsg;
	@FindBy (xpath = "//span[text()='Should have at least 7 characters']")public WebElement pwd_validationmsg;
	@FindBy (xpath = "//span[text()='Passwords do not match']")public WebElement cnfpwd_validationmsg;
	
	WebDriver driver;
	public AddEmployeeObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
}
