package RailWays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Account.Account;
import Common.Utilities;
import Constant.Constant;

public class gmailPage extends generalPage {
	// Locators
	private final By txtGmail = By.xpath("//input[@type='email']");
	private final By btnNext = By.xpath("//span[text()='Next']");
	private final By txtGpass = By.xpath("//input[@type='password']");
	private final By linkConfirmation = By.xpath("//a[contains(.,'Confirm?confirmationCode')]");
	private final By linkResetPassword = By.xpath("//a[contains(.,'PasswordReset?resetToken')]");

	// Elements
	public WebElement getTxtGmail() {
		return Constant.WEBDRIVER.findElement(txtGmail);
	}

	public WebElement getBtnNext() {
		return Constant.WEBDRIVER.findElement(btnNext);
	}

	public WebElement getTxtGpass() {
		return Constant.WEBDRIVER.findElement(txtGpass);
	}

	public WebElement getLinkConfirmation() {
		return Constant.WEBDRIVER.findElement(linkConfirmation);
	}

	public WebElement getLinkResetPassword() {
		return Constant.WEBDRIVER.findElement(linkResetPassword);
	}

	// Methods

	public gmailPage gotoGmailPage() {
		Constant.WEBDRIVER.navigate().to(Constant.GMAIL_URL);
		return this;
	}

	public void loginGmail(String email, String password) {
		this.getTxtGmail().sendKeys(email);
		this.getBtnNext().click();
		try {
			this.waitForControlStable(getTxtGpass()).clear();;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getTxtGpass().sendKeys(password);
		this.getBtnNext().click();
	}
	

	
	public changePasswordPage clickActiveAccountLink(Account acc) {

		gotoGmailPage();
		loginGmail(Constant.GMAIL_USER, Constant.GMAIL_PASS);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Constant.WEBDRIVER
				.findElement(By.xpath(
						"//div[@role='link']//b[contains(text(),'confirm your account " + acc.getEmail() + "')]"))
				.click();

		Utilities.waitForPageLoad(Constant.WEBDRIVER, Constant.TIMEOUT);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Constant.WEBDRIVER.navigate().to(this.getLinkConfirmation().getText());

		Utilities.waitForPageLoad(Constant.WEBDRIVER, Constant.TIMEOUT);

		return new changePasswordPage();
	}

	public resetPasswordPage clickResetPasswordLink(Account acc) {

		gotoGmailPage();

		Constant.WEBDRIVER
				.findElement(By
						.xpath("//div[@role='link']//b[contains(text(),'reset your password " + acc.getEmail() + "')]"))
				.click();

		Utilities.waitForPageLoad(Constant.WEBDRIVER, Constant.TIMEOUT);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Constant.WEBDRIVER.navigate().to(this.getLinkResetPassword().getText());

		Utilities.waitForPageLoad(Constant.WEBDRIVER, Constant.TIMEOUT);

		return new resetPasswordPage();
	}
}
