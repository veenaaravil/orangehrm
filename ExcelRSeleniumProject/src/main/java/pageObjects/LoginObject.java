package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObject {
	@FindBy(name = "username")public WebElement uid_text;
	@FindBy(name = "password")public WebElement pwd_text;
	@FindBy(xpath = "//button[text()=' Login ']")public WebElement login_btn;
	@FindBy(xpath = "//p[text()='Invalid credentials']")public WebElement invalid_login_errormessage;
	@FindBy (xpath = "//span[text()='Required']")public WebElement singleblank_errormessage;
	@FindBy (xpath = "//span[text()='Required']")public List<WebElement> multipleblankfield_errormessage;
	@FindBy (xpath = "//p[@class='oxd-userdropdown-name']")public WebElement user_dropDown;
	@FindBy (xpath = "//a[text()='Logout']")public WebElement logout;
	WebDriver driver;


	public LoginObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
}
