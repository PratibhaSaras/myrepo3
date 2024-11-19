package Automation;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest {
	
	WebDriver driver;
@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://hm.com");
		driver.manage().window().maximize();
		
		
		
	}
  @Test(priority=1)
  public void testWebApp () throws InterruptedException  {
	  
	  Assert.assertEquals(driver.getTitle(),"H&M | Online Fashion, Homeware & Kids Clothes | H&M IN" );
	  LoginPage lp= new LoginPage(driver);
	  lp.acceptCookies();
	  lp.hoverSignInAndClick();
	  lp.populateEmail("test1234@gmail.com");
	  lp.populatePassword("Test@1234");
	  lp.clickbtn();
	 
	 lp.tearDown();
	  		
	  
	  
  }
}
