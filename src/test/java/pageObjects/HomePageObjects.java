package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePageObjects extends BasePage {
	
	JavascriptExecutor js;
	Alert al;
	Alert al2;
	

	public HomePageObjects(WebDriver driver) {
		super(driver);
		
	}
	
	// Elements -- New Sign up
			@FindBy(id = "signin2")
			WebElement signup;

			@FindBy(id = "sign-username")
			WebElement txt_user;
			
			@FindBy(id = "sign-password")
			WebElement txt_pwd;
			
			@FindBy(xpath = "//button[@onclick='register()']")
			WebElement register;
			
			// Elements -- Login
			@FindBy(id = "login2")
			WebElement login;
			
			@FindBy(id = "loginusername")
			WebElement txt_exist_user;
			
			@FindBy(id = "loginpassword")
			WebElement txt_exist_pwd;
			
			@FindBy(xpath = "//button[@onclick='logIn()']")
			WebElement loginbtn;
			
			@FindBy(xpath = "//div[@id='logInModal']//button[@type='button'][normalize-space()='Close']")
			WebElement closebtn;
			
			
			
			

			// Action Methods
			
			
			
			public void clickSignup() {
				signup.click();
			}
			
			public void clickClose() {
				closebtn.click();
			}
			

			public void setUsername(String uname) {
				txt_user.sendKeys(uname);
			}
			
			public void setPassword(String password) {
				txt_pwd.sendKeys(password);
			}
			
			public void Register() {
				register.click();
			}
			
			public void handleAlertAndClose() 
			{
				WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
				al=mywait.until(ExpectedConditions.alertIsPresent());
				al.accept();
				
				
			}
			public String signUpAlert() 
			{
				WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
				al2=mywait.until(ExpectedConditions.alertIsPresent());
				String al2_txt=al2.getText();
				al2.accept();
				return al2_txt;
				
			}
			
			public void Login() {
				WebDriverWait mywait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
				mywait2.until(ExpectedConditions.elementToBeClickable(login));
				login.click();
			}
			
			
			public void setExistUsername(String uname) {
				txt_exist_user.clear();
				txt_exist_user.sendKeys(uname);
			}
			
			public void setExistPassword(String password) {
				txt_exist_pwd.clear();
				txt_exist_pwd.sendKeys(password);
			}
			
			public void existLogin() {
				loginbtn.click();
			}
			
			
			
			

}
