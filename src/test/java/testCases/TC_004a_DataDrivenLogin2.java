package testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviderUtility;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import testBase.BaseTestClass;

public class TC_004a_DataDrivenLogin2 extends BaseTestClass {
	
	String act_result;
	Alert al2;
	

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviderUtility.class)
	public void test_dataDrivenLogin(String username, String password, String exp_result) throws InterruptedException {
		
		logger.info("****** Starting Data Driven Login Test ************");
		HomePageObjects ho=new HomePageObjects(driver);
		ho.Login();
		ho.setExistUsername(username);
		ho.setExistPassword(password);
		ho.existLogin();
		
		if(exp_result.equalsIgnoreCase("Pass")) 
		{
			LoginPageObjects lp=new LoginPageObjects(driver);
			String title=lp.checklogin();
			if(title.equalsIgnoreCase("Log out")) 
			{
				lp.clickLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				
				Assert.assertTrue(false);
			}
			
			
		}
		else 
		{
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
			if(w.until(ExpectedConditions.alertIsPresent())==null) {
				Assert.assertTrue(false);
			}
			else {
				ho.handleAlertAndClose();
				ho.clickClose();
			}
			
				
				
			
		}
			
	
	}
	

}
