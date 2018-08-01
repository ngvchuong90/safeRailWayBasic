package RailWays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class resetPasswordPage extends generalPage{
	// Locators
	private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
	private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By txtResetToken = By.xpath("//input[@id='resetToken']");
	private final By btnResetPassword = By.xpath("//input[@value='Reset Password']");

	// Elements
	public WebElement getTxtNewPassword() {
		return Constant.WEBDRIVER.findElement(txtNewPassword);
	}

	public WebElement getTxtConfirmPassword() {
		return Constant.WEBDRIVER.findElement(txtConfirmPassword);
	}

	public WebElement getTxtResetToken() {
		return Constant.WEBDRIVER.findElement(txtResetToken);
	}

	public WebElement getBtnResetPassword() {
		return Constant.WEBDRIVER.findElement(btnResetPassword);
	}

	// Methods
	public resetPasswordPage resetPassword(String newPw, String confirmPw, String token) {
		this.getTxtNewPassword().sendKeys(newPw);
		this.getTxtConfirmPassword().sendKeys(confirmPw);
		this.getTxtResetToken().clear();
		this.getTxtResetToken().sendKeys(token);
		this.getBtnResetPassword().click();
		return this;
	}
}
