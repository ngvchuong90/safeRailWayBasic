package registerTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Account.Account;
import RailWays.homePage;
import RailWays.registerPage;
import testCondition.testBase;

public class registerTest extends testBase{
		@Test
	public void TC07() {
		System.out.println("TC07 - User can create new account");
		homePage homePage = new homePage();

		Account acc = new Account();
		acc.generateData();

		String actualMsg = homePage.open().gotoRegisterPage().Register(acc).getThanksMsg();
		String expectedMsg = "Thank you for registering your account";
		Assert.assertEquals(actualMsg, expectedMsg, "Cannot create account");
	}

	@Test
	public void TC08() {
		System.out.println("TC08 - User can't login with an account hasn't been activated");
		homePage homePage = new homePage();

		Account acc = new Account();
		acc.generateData();

		homePage.open().gotoRegisterPage().Register(acc);

		String actualMsg = homePage.gotoLoginPage().invalidLogin(acc.getEmail(), acc.getPassword()).getErrorMsg();
		String expectedMsg = "Invalid username or password. Please try again.";
		Assert.assertEquals(actualMsg, expectedMsg, "User can login");
	}

	@Test
	public void TC10() {
		System.out.println(
				"TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");
		homePage homePage = new homePage();

		Account acc = new Account();
		acc.generateData();

		acc.setConfirmpass("invalidpass");

		registerPage registerPage = homePage.open().gotoRegisterPage().Register(acc);

		String actualMsg = registerPage.getRegisterFailedMsg();
		String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}

	@Test
	public void TC11() {
		System.out.println("TC10 - User can't create account while password and PID fields are empty");
		homePage homePage = new homePage();

		Account acc = new Account();
		acc.generateData();

		acc.setPassword("");
		acc.setConfirmpass("");
		acc.setPid("");

		registerPage registerPage = homePage.open().gotoRegisterPage().Register(acc);

		String registerFailedMsg = registerPage.getRegisterFailedMsg();
		String passwordErrorMsg = registerPage.getPasswordErrorMsg();
		String pidErrorMsg = registerPage.getPidErrorMsg();

		String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
		String expPasswordErrorMsg = "Invalid password length";
		String expPidErrorMsg = "Invalid ID length";

		Assert.assertEquals(registerFailedMsg, expectedMsg, "Error message is not displayed as expected");
		Assert.assertEquals(passwordErrorMsg, expPasswordErrorMsg, "Error message is not displayed as expected");
		Assert.assertEquals(pidErrorMsg, expPidErrorMsg, "Error message is not displayed as expected");
	}
}
