package RailWays;

import Account.Account;
import Constant.Constant;

public class homePage extends generalPage{
	// Locators

	// Elements

	// Methods

	public homePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}

	public void RegisterAndActivate(Account acc) {
		homePage hP = new homePage().open();
		hP.gotoRegisterPage().Register(acc);

		gmailPage gmailPage = new gmailPage();
		gmailPage.clickActiveAccountLink(acc);
	}

	public boolean isLogoutTabDisplayed() {
		return getTabLogout().isDisplayed();
	}

	public boolean isMyTicketTabDisplayed() {
		return getTabMyTicket().isDisplayed();
	}

	public boolean isChangePasswordTabDisplayed() {
		return getTabChangePassword().isDisplayed();
	}
}
