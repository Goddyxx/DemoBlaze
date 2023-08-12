package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddPageObjects;
import pageObjects.CartPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import testBase.BaseTestClass;

public class TC_003_PlaceOrder extends BaseTestClass {
	
	
	
	@Test(groups={"Regression","Master"})
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
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}	
	
	
	@Test(dependsOnMethods= {"test_Login"},groups={"Regression","Master"})
		public void addToCart() {
		
		LoginPageObjects lp1=new LoginPageObjects(driver);
		lp1.clickPhone();
		lp1.clickSony();
		
		
		AddPageObjects ap=new AddPageObjects(driver);
		try {
			String value=ap.getProductText();
			Assert.assertEquals(value, "Sony xperia z5", "Wrong product!!!");
			ap.addToCart();
			
			String alert_text=ap.verifyAdd();
			Assert.assertEquals(alert_text, "Product added.");
			System.out.println("Product added alert handled");	
			ap.goToCart();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	@Test(dependsOnMethods= {"test_Login","addToCart"})
	public void placeOrder() {
		
		CartPageObjects cp=new CartPageObjects(driver);
		cp.placeOrder();
	
	
}
	

}
