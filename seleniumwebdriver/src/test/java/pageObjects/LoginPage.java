package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage  {
	
	   public LoginPage(WebDriver driver)
	   {
		   super(driver);
	   }
	   
	   @FindBy(xpath="//h2[normalize-space()='Login to your account']")
	   WebElement loginTxt;
	   
	   @FindBy(xpath="//input[@data-qa='login-email']")
	   WebElement loginEmail;
	   
	   @FindBy(xpath="//input[@data-qa='login-password']")
	   WebElement loginPswd;
	   
	   @FindBy(xpath="//button[@data-qa='login-button']")
	   WebElement loginBtn;
	   
	   public String getLoginPageConfirmation() {
		   try {
			   return loginTxt.getText();
		   }
		   catch(Exception e)
		   {
			   return e.getMessage();		   }
	   }
	   
	   public void enterLoginEmail(String s) {
		   loginEmail.sendKeys(s);
	   }
	   
	   public void enterPassword(String pswd) {
		   loginPswd.sendKeys(pswd);
	   }
	   
	   public void clickLoginBtn() {
		   loginBtn.click();
	   }
	   
	   
	}
	
	
