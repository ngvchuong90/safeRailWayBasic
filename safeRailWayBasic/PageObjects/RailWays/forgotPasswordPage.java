package RailWays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class forgotPasswordPage {
	// Locators
	private final By txtEmailAddress = By.xpath("//input[@id='email']");
	private final By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");

	// Elements
	public WebElement getTxtEmailAddress() {
		return Constant.WEBDRIVER.findElement(txtEmailAddress);
	}

	public WebElement getBtnSendInstructions() {
		return Constant.WEBDRIVER.findElement(btnSendInstructions);
	}

	// Methods

	public forgotPasswordPage sendForgotPasswordLink(String email) {
		this.getTxtEmailAddress().sendKeys(email);
		this.getBtnSendInstructions().click();
		return this;
	}
}
