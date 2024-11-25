package Automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
		;
		
	}
	@Test
	public void testRegisteration() {

		RegisterPage rp=new RegisterPage(driver);
		rp.validateHomePageIsReached();
		rp.clickLogin();
		//rp.verifyLoginPageVisible();
		rp.enterName("Pratibha4");
		rp.enterEmail("test"+String.valueOf(System.currentTimeMillis())+"@gmail.com");
		rp.clickSignUp();
		rp.verifySignUpFormVisible();
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
		rp.validateAccCreation();
		rp.clickContinue();
		rp.validateLogin();
		rp.deleteAccount();
		rp.validateAccDeletion();
		rp.tearDown();
	}
	
	
	
	
}
