package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;

import testBase.BaseTestClass;

public class TC_001_CheckRegistration extends BaseTestClass {
	
	
	
	@Test(groups= {"Sanity","Master"})
	public void test_account_Registration()
	{
		logger.debug("Application logs......");
		logger.info("***** Starting TC_001_CheckRegistration ******** ");
		try
		{
		HomePageObjects ho=new HomePageObjects(driver);
		ho.clickSignup();
		ho.setUsername(randomeString());
		ho.setPassword(randomeString());
		ho.Register();
		//ho.signUpAlert();
		String al_txt1=ho.signUpAlert();
		
		Assert.assertEquals(al_txt1, "Sign up successful.");
		
		
		}
		catch (Exception e)
		{
			logger.error("Test failed");
			e.printStackTrace();
		}
		
		logger.info("Test Execution complete");
		
	}	
	
	

}
