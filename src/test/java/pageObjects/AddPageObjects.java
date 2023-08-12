package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPageObjects extends BasePage {
	
	Alert al;

	public AddPageObjects(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//div[contains(@class,'col-md-7')]/h2")
	WebElement product;
	
	@FindBy(linkText = "Add to cart")
	WebElement btn_add_cart;
	
	@FindBy(id = "cartur")
	WebElement btn_cart;
	
	
	
	
	public String getProductText() {
		
		String tex=product.getText();
		return tex;	
	}
	
	public void addToCart() {
		btn_add_cart.click();		
	}
	
	public String verifyAdd() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		al=mywait.until(ExpectedConditions.alertIsPresent());
		String al_txt=al.getText();
		al.accept();
		return al_txt;
	}
	
	public void goToCart() {
		btn_cart.click();		
	}
	
	
	
	
	
	
	

}
