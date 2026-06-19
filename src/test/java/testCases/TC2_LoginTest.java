package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;

public class TC2_LoginTest extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void verify_login()
	{
		logger.info("***starting TC2_LoginTest****");
		try {
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			hp.ClickLogin();
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			myAccountPage mp = new myAccountPage(driver);
			boolean acc_status = mp.isMyAccoutmsgExists();
			Assert.assertEquals(acc_status, true, "LOgin failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC2_LoginTest****");
	}

}
