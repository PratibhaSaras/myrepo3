package pageObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='signup-form']/child::h2")
	WebElement signUpText;

	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement signUpName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement signUpEmail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signUpBtn;

	@FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	WebElement SignUpPageText;

	@FindBy(id = "uniform-id_gender1")
	WebElement male;

	@FindBy(id = "uniform-id_gender2")
	WebElement female;

	@FindBy(xpath = "//input[@data-qa='password']")
	WebElement password;

	@FindBy(xpath = "//select[@id='days']")
	WebElement dobDay;

	@FindBy(xpath = "//select[@id='months']")
	WebElement dobMonth;

	@FindBy(xpath = "//select[@id='years']")
	WebElement dobYear;

	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement newsletter;

	@FindBy(xpath = "//input[@id='optin']")
	WebElement opt_in;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='company']")
	WebElement company;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1;

	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2;

	@FindBy(xpath = "//select[@id='country']")
	WebElement country;

	@FindBy(xpath = "//input[@id='state']")
	WebElement state;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipcode;

	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement mobile_number;

	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement createAcc_btn;
	

	public String getLoginPageConfirmation() {
		try {
			return (signUpText.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void enterName(String name) {
		signUpName.sendKeys(name);
	}

	public void enterEmail(String email) {
		signUpEmail.sendKeys(email);
		System.out.println("Email used: " + email);
	}

	public void clickSignUp() {
		signUpBtn.click();
	}

	public String getSignUpPageConfirmation() {
		try {
			return (SignUpPageText.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void selectGender(String gender) {

		if (gender.equals("Male"))
			male.click();

		if (gender.equals("Female"))
			female.click();

	}

	public void enterPswd(String pswd) {
		password.sendKeys(pswd);
	}

	public void selectDOB(String day, String month, String year) {

		Select d = new Select(dobDay);
		Select m = new Select(dobMonth);
		Select y = new Select(dobYear);

		//List<WebElement> op = d.getOptions();

		// boolean flag=checkSorting(days);
		// System.out.println("unique and sorted: "+flag);

		d.selectByVisibleText(day);
		m.selectByVisibleText(month);
		y.selectByVisibleText(year);

	}

	/*
	 * private boolean checkSorting(List<WebElement> days) {
	 * 
	 * //convert List of WebElement to List of String using java 8 List<String>
	 * daysJava8 = days.stream().map(obj->obj.getText()).skip(1).toList();
	 * 
	 * //convert List of WebElement to List of String using forEach List<String>
	 * daysSimple = new ArrayList<>(); for(WebElement we : days) {
	 * daysSimple.add(we.getText()); } daysSimple.remove(0);
	 * 
	 * daysJava8.stream().forEach(System.out::print);
	 * 
	 * //create a set from the days list to remove duplicates Set<String> temp= new
	 * TreeSet<String>(daysSimple);
	 * 
	 * //check unique if(daysSimple.size()!=temp.size()) {
	 * System.out.println("check unique"); return false; }
	 * 
	 * //check sorting using java 8 List<String> daysSortedJava8 =
	 * daysJava8.stream().sorted().toList();
	 * daysSortedJava8.stream().forEach(System.out::print);
	 * if(!(daysSortedJava8.equals(daysJava8))) {
	 * System.out.println("check sorting using java 8"); //return false; }
	 * 
	 * //check sorting using for loop for(int i=0; i<days.size()-1;i++) {
	 * System.out.println(daysJava8.get(i)); System.out.println(daysJava8.get(i+1));
	 * System.out.println(daysJava8.get(i).compareTo(daysJava8.get(i+1)));
	 * if(daysJava8.get(i).compareTo(daysJava8.get(i+1))>1) {
	 * System.out.println("check sorting using for loop"); return false; } }
	 * 
	 * //else return true return true; }
	 */

	public void chkboxes() {
		newsletter.click();
		opt_in.click();
	}

	public void setName(String fname, String lname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
	}

	public void setCompany(String comp) {
		company.sendKeys(comp);
	}

	public void setAddress(String add1, String add2) {
		address1.sendKeys(add1);
		address2.sendKeys(add2);
	}

	public void setCountry(String con) {
		Select s = new Select(country);
		s.selectByVisibleText(con);
	}

	public void setStateCityZipMobile(String s, String c, String z, String m) {
		state.sendKeys(s);
		city.sendKeys(c);
		zipcode.sendKeys(z);
		mobile_number.sendKeys(m);

	}

	public void clickCreateAccount() {
		createAcc_btn.click();
	}

	

	}
