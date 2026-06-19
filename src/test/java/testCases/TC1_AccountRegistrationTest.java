package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC1_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"Sanity","Master"})
	public void verify_account_registration()
	{
		    logger.info("****starting TC1_AccountRegistrationTest*****");
		    try {
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			logger.info("clicked my account link");
			hp.ClickRegister();
			logger.info("clicked register link");
			AccountRegistrationPage ap = new AccountRegistrationPage(driver);
			logger.info("providing customer details");
			ap.setFirstname(randomString().toUpperCase());
			ap.setLastname(randomString().toUpperCase());
			ap.setEMail(randomString()+"@gmail.com");
			ap.setTelephone(randomNumber());
			String Password = randomAlphaNumeric();
			ap.setPassword(Password);
			ap.setConfirmPassword(Password);
			ap.setPrivacyPolicy();
			ap.clickContinue();
			logger.info("Validating expected msg");
			String confirmmsg = ap.getConfirmationMsg();
			/*if(confirmmsg.equals("Your Account Has Been not Created!"))
			{
				Assert.assertTrue(true);
			}
			else {
				logger.error("test failed");
		    	logger.debug("debug logs");
		    	Assert.assertTrue(false);
			}*/
			Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
		    }
		    catch(Exception e)
		    {
		    	logger.error("test failed");
		    	logger.debug("debug logs");
		    	Assert.fail();
		    }
		    logger.info("***finished tc1 AccountRegistrationTest****");
			
	}
}
