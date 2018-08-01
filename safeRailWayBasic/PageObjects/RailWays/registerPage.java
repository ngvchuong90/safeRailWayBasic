package RailWays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Account.Account;
import Constant.Constant;

public class registerPage {
	// Locators
	private final By txtEmail = By.xpath("//input[@id='email']");
	private final By txtPassword = By.xpath("//input[@id='password']");
	private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By txtPid = By.xpath("//input[@id='pid']");
	private final By btnRegister = By.xpath("//input[@value='Register']");
	private final By lblThanksMsg = By.xpath("//div[@id='content']//h1");
	private final By lblRegisterFailedMsg = By.xpath("//p[@class='message error']");
	private final By lblPasswordErrorMsg = By.xpath("//label[@class='validation-error' and @for='password']");
	private final By lblPidErrorMsg = By.xpath("//label[@class='validation-error' and @for='pid']");

	// Elements
	public WebElement getTxtEmail() {
		return Constant.WEBDRIVER.findElement(txtEmail);
	}

	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(txtPassword);
	}

	public WebElement getTxtConfirmPassword() {
		return Constant.WEBDRIVER.findElement(txtConfirmPassword);
	}

	public WebElement getTxtPid() {
		return Constant.WEBDRIVER.findElement(txtPid);
	}

	public WebElement getBtnRegister() {
		return Constant.WEBDRIVER.findElement(btnRegister);
	}

	public WebElement getLblThanksMsg() {
		return Constant.WEBDRIVER.findElement(lblThanksMsg);
	}

	public WebElement getLblRegisterFailedMsg() {
		return Constant.WEBDRIVER.findElement(lblRegisterFailedMsg);
	}

	public WebElement getLblPasswordErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblPasswordErrorMsg);
	}

	public WebElement lblPidErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblPidErrorMsg);
	}

	// Methods
	public registerPage Register(Account acc) {
		this.getTxtEmail().sendKeys(acc.getEmail());
		this.getTxtPassword().sendKeys(acc.getPassword());
		this.getTxtConfirmPassword().sendKeys(acc.getConfirmpass());
		this.getTxtPid().sendKeys(acc.getPid());
		this.getBtnRegister().click();

		return this;
	}

	public String getThanksMsg() {
		return getLblThanksMsg().getText();
	}

	public String getRegisterFailedMsg() {
		return getLblRegisterFailedMsg().getText();
	}

	public String getPasswordErrorMsg() {
		return getLblPasswordErrorMsg().getText();
	}

	public String getPidErrorMsg() {
		return lblPidErrorMsg().getText();
	}
}
