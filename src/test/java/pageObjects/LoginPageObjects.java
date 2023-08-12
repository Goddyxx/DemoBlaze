package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects extends BasePage {

	public LoginPageObjects(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText = "Log out")
	WebElement logoutbtn;
	
	@FindBy(id = "itemc")
	WebElement phones;
	
	@FindBy(linkText = "Sony xperia z5")
	WebElement sonyxperia;
	
	public String checklogin() {
		
		String tex=logoutbtn.getText();
		return tex;
		
	}
	
	public boolean isLogoutPresent() {
		boolean flag=logoutbtn.isDisplayed();
		return flag;
	}
	
	public void clickPhone() {
		phones.click();		
	}
	
	public void clickSony() {
		sonyxperia.click();		
	}
	
	public void clickLogout() {
		logoutbtn.click();		
	}
	
	

}
