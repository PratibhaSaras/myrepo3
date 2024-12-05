package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//b[normalize-space()='Account Created!']")
	WebElement AccCreation_text;

	@FindBy(linkText = "Continue")
	WebElement continue_btn;

	@FindBy(xpath="//li[10]//a[1]")
	WebElement login_text;

	@FindBy(xpath = "//b")
	WebElement user;

	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement del_btn;

	@FindBy(xpath = "//b[text()='Account Deleted!']")
	WebElement del_confirmation_text;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout_link;

	public String getAccountCreationConfirmation() {
		try {
			return (AccCreation_text.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	public void clickContinue() {
		continue_btn.click();

	}

	public String getLoginConfimartion() {
		try {
			return (login_text.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String getCurrentUserLoginmsg() {
		try {
			return ("Logged in as " + user.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void deleteAccount() {
		del_btn.click();
	}

	public void validateAccDeletion() {
		Assert.assertTrue(del_confirmation_text.isDisplayed());
	}
	
	public void logOut() {
		logout_link.click();
	}
	
	public boolean loginPageIsVisible() {
		
		try {
			return login_text.isDisplayed();
		}
		catch(Exception e) {
			return false;
		
		}
	}

}
