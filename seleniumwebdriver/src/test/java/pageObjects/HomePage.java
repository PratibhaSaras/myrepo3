package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[normalize-space()= 'Signup / Login']")
	WebElement loginSignUpBtn;
	
	public String getHomePageConfirmation() {
		try {
			return (driver.getTitle());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void clickLoginSignUpBtn() {
		loginSignUpBtn.click();
	}
	
}
