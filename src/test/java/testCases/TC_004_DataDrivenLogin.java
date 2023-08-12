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

public class TC_004_DataDrivenLogin extends BaseTestClass {
	
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
		
		LoginPageObjects lp=new LoginPageObjects(driver);
		try
		{
		String title=lp.checklogin();
		
		if(exp_result.equalsIgnoreCase("Pass")) 
		{
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
			
				//ho.handleAlertAndClose();
				//ho.clickClose();	
			
			if(title.equalsIgnoreCase("Log out")) 
			{
				lp.clickLogout();
				Assert.assertTrue(false);
			}
			else 
			{
				
				Assert.assertTrue(false);
			}
			
		}
		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	

}
