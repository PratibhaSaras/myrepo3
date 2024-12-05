package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_LoginTDDTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups= {"Sanity","Regression"})
	public void verify_loginDDT(String email, String pswd, String res) {
		logger.info("****Starting the test***");
		HomePage hm = new HomePage(driver);
		hm.clickLoginSignUpBtn();

		MyAccountPage page = new MyAccountPage(driver);

		logger.info("****Entering login and password");
		LoginPage p = new LoginPage(driver);
		p.enterLoginEmail(email);
		p.enterPassword(pswd);
		logger.info("***clicking on login");
		p.clickLoginBtn();
		Boolean s = page.loginPageIsVisible();
		System.out.println(s);
		System.out.println(res);

		if (res.equalsIgnoreCase("valid")) {
			if (s == true) {
				logger.info("****clicking on logout***");
				page.logOut();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

		if (res.equalsIgnoreCase("Invalid")) {
				if (s == true) {
					page.logOut();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		}

	}
}
