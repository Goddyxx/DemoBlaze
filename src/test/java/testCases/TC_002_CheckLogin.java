package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import testBase.BaseTestClass;

public class TC_002_CheckLogin extends BaseTestClass {
	
	@Test(groups={"Sanity","Master"})
	public void test_Login()
	{
		try
		{
		HomePageObjects ho=new HomePageObjects(driver);
		ho.Login();
		ho.setExistUsername(rb.getString("existing_user"));
		ho.setExistPassword(rb.getString("existing_pwd"));
		ho.existLogin();
		
		LoginPageObjects lp=new LoginPageObjects(driver);
		String title=lp.checklogin();
		
		Assert.assertEquals(title, "Log out");
		
		lp.clickLogout();
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}	
	
	

}
