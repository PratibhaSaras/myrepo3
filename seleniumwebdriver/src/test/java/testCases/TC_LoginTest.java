package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void testLogin() {
		
		logger.info("****Staring Login Test****");
		try {
		HomePage hm= new HomePage(driver);
		
		logger.info("****Home Page Validation***");
		String conf=hm.getHomePageConfirmation();
		Assert.assertEquals(conf, "Automation Exercise");
		
		logger.info("*****Clicking on login****" );
		hm.clickLoginSignUpBtn();
		
		logger.info("***Validating login page is reached*****");
		LoginPage lp= new LoginPage(driver);
		String loginMsg=lp.getLoginPageConfirmation();
		Assert.assertEquals(loginMsg,"Login to your account");
		
		logger.info("***Entering email id******");
		lp.enterLoginEmail(p.getProperty("loginEmail"));
		
		logger.info("**Entering password*******");
		lp.enterPassword(p.getProperty("loginPswd"));
		
		logger.info("*****Clicking on login*****");
		lp.clickLoginBtn();
		
		logger.info("******Verifying user is logged in*****");
		MyAccountPage mp= new MyAccountPage(driver);
		String s = mp.getLoginConfimartion();
		String s1= mp.getCurrentUserLoginmsg();
		Assert.assertEquals(s, s1);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}
}
