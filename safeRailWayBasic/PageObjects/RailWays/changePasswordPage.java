package RailWays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class changePasswordPage {
	// Locators
	private final By lblChangePassword = By.xpath("//h1[text()='Change password']");
	private final By txtCurrentPW = By.xpath("//input[@id='currentPassword']");
	private final By txtNewPW = By.xpath("//input[@id='newPassword']");
	private final By txtConfirmPW = By.xpath("//input[@id='confirmPassword']");
	private final By btnChangePW = By.xpath("//input[@value='Change Password']");
	private final By lblSuccessMsg = By.xpath("//p[@class='message success']");
	private final By lblErrorMsg = By.xpath("//p[@class='message error']");

	// Elements
	public WebElement getLblChangePassword() {
		return Constant.WEBDRIVER.findElement(lblChangePassword);
	}

	public WebElement getTxtCurrentPW() {
		return Constant.WEBDRIVER.findElement(txtCurrentPW);
	}

	public WebElement getTxtNewPW() {
		return Constant.WEBDRIVER.findElement(txtNewPW);
	}

	public WebElement getTxtConfirmPW() {
		return Constant.WEBDRIVER.findElement(txtConfirmPW);
	}

	public WebElement getBtnChangePW() {
		return Constant.WEBDRIVER.findElement(btnChangePW);
	}

	public WebElement getLblSuccessMsg() {
		return Constant.WEBDRIVER.findElement(lblSuccessMsg);
	}

	public WebElement getLblErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg);
	}

	// Methods
	public boolean isDisplayed() {
		return getLblChangePassword().isDisplayed();
	}

	public changePasswordPage changePassword(String currentPw, String newPw, String confirmPw) {
		this.getTxtCurrentPW().sendKeys(currentPw);
		this.getTxtNewPW().sendKeys(newPw);
		this.getTxtConfirmPW().sendKeys(confirmPw);
		this.getBtnChangePW().click();
		return this;
	}

	public String getSuccessMsg() {
		return getLblSuccessMsg().getText();
	}

	public String getErrorMsg() {
		return getLblErrorMsg().getText();
	}
}
