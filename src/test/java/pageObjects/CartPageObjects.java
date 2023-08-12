package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageObjects extends BasePage {
	
	Alert al;

	public CartPageObjects(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//button[normalize-space()='Place Order']")
	WebElement btn_place_order;
	

	public void placeOrder() {
		btn_place_order.click();		
	}
	
	
	
	
	
	
	
	
	

}
