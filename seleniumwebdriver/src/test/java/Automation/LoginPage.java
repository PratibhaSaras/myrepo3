package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
	
	WebDriver driver;
  
	LoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(xpath="//input[@id='email']") WebElement email;
		
		@FindBy(xpath="//input[@id='password']") WebElement pswd;
		
		@FindBy(xpath="//button[@type='submit']") WebElement sign_in_btn;
		
		@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']") WebElement accept_cookies;

		@FindBy(xpath="//span[text()='Sign in']") WebElement sign_in_logo;
		
		@FindBy(xpath="//button[contains(text(),'Sign in')]") WebElement sign_in_fly_btn;
		
		
		void hoverSignInAndClick() {
			 Actions a=new Actions(driver);
			  a.moveToElement(sign_in_logo).perform();
			  sign_in_fly_btn.click();
			  
		}

		void acceptCookies()
		{
			accept_cookies.click();
			  
		}
		
		
		void populateEmail(String emailid)
		{
			email.sendKeys(emailid);
		}
		
		void populatePassword(String pwd)
		{
			pswd.sendKeys(pwd);
		}
		
		void clickbtn()
		{
		 sign_in_btn.click();	
		}
		
		void tearDown()
		{
			driver.quit();
		}
	}
	
	
