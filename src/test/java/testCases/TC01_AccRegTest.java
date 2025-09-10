package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC01_AccRegTest extends BaseClass {
	
	@Test
	public void verify_acc_reg()
	{
		log.info("***** Starting TC01 Account Registration Test  ****");
		log.debug("This is a debug log message");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		log.info("Clicked on MyAccount Link.. ");
		
		hp.clickRegister();
		log.info("Clicked on Register Link.. ");
		
		AccountRegPage regpage=new AccountRegPage(driver);
		
		log.info("Providing customer details...");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		log.info("Validating expected message..");
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		log.info("Test passed");
		} 
		catch (Exception e)
		{
			log.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		log.info("***** Finished TC01 Account Registration Test *****");
		}
		
	}

}

