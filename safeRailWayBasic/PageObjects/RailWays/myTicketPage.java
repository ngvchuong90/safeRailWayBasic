package RailWays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class myTicketPage {
	// Locators
	private final By lblManageTicket = By.xpath("//h1[text()='Manage ticket']");

	// Elements
	public WebElement getLblManageTicket() {
		return Constant.WEBDRIVER.findElement(lblManageTicket);
	}

	// Methods
	public boolean isDisplayed() {
		return getLblManageTicket().isDisplayed();
	}
}
