package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC02_LoginTest extends BaseClass {

	@Test
	public void verify_login()
	{
		log.info("**** Starting TC02 Login Test  ****");
		log.debug(" Capturing application debug logs.... ");
		try
		{
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		log.info(" Clicked on myaccount link on the home page.. ");
		hp.clickLogin(); //Login link under MyAccount
		log.info(" Clicked on login link under myaccount.. ");
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		log.info(" Entering valid email and password.. ");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin(); //Login button
		log.info(" Clicked on ligin button.. ");
		
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
				
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		log.info("**** Finished TC02 Login Test  ****");
	}
}
