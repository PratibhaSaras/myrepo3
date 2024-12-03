package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_RegisterTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void testRegisteration() {
		logger.info("*****Starting the TC_Registration*******");

		try {

			HomePage hm = new HomePage(driver);
			RegisterPage rp = new RegisterPage(driver);
			logger.info("*****Validating homePage*******");
			String conf = hm.getHomePageConfirmation();
			Assert.assertEquals(conf, "Automation Exercise");
			hm.clickLoginSignUpBtn();
			logger.info("*****Validating Register Page*******");
			String conflogin = rp.getLoginPageConfirmation();
			System.out.println(conflogin);
			// Assert.assertEquals(conflogin, "New User Signup!");

			logger.info("*******Entering details*******");
			rp.enterName("Pratibha4");
			rp.enterEmail("test" + String.valueOf(System.currentTimeMillis()) + "@gmail.com");
			rp.clickSignUp();

			String confSignup = rp.getSignUpPageConfirmation();
			Assert.assertEquals(confSignup, "ENTER ACCOUNT INFORMATION");

			rp.selectGender("Female");
			rp.enterPswd("Test@1234");
			rp.selectDOB("5", "January", "2021");
			rp.chkboxes();
			rp.setName("Mayra", "Singh");
			rp.setCompany("Deloitte");
			rp.setAddress("KR", "Layout");
			rp.setCountry("India");
			rp.setStateCityZipMobile("Karnataka", "Bengaluru", "560071", "8779765555");
			rp.clickCreateAccount();
			
			MyAccountPage mp=new MyAccountPage(driver);
			String confAccountCreation = mp.getAccountCreationConfirmation();
			Assert.assertEquals(confAccountCreation, "ACCOUNT CREATED!");

			mp.clickContinue();
			String usr_actual = mp.getCurrentUserLoginmsg();
			String usr_expected = mp.getLoginConfimartion();
			Assert.assertEquals(usr_expected, usr_actual);

			mp.deleteAccount();
			mp.validateAccDeletion();
		} catch (Exception e) {
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		logger.info("*****Finished TC_RegistrationTest***********");
	}

}
