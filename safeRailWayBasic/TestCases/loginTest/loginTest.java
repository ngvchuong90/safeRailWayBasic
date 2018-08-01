package loginTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import RailWays.homePage;
import RailWays.loginPage;
import RailWays.myTicketPage;
import testCondition.testBase;

public class loginTest extends testBase{
	@Test
	public void TC01() {
		System.out.println("TC01 - User can log into Railway with valid username and password");
		homePage homePage = new homePage();

		String actualMsg = homePage.open().gotoLoginPage().login(Constant.USERNAME, Constant.PASSWORD)
				.getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;

		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}

	@Test
	public void TC02() {
		System.out.println("TC02 - User can't login with blank \"Username\" textbox");
		homePage homePage = new homePage();

		String actualMsg = homePage.open().gotoLoginPage().invalidLogin("", Constant.PASSWORD).getErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}

	@Test
	public void TC03() {
		System.out.println("TC03 - User cannot log into Railway with invalid password ");
		homePage homePage = new homePage();

		String actualMsg = homePage.open().gotoLoginPage().invalidLogin(Constant.USERNAME, "invalidpwd").getErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}

	@Test
	public void TC04() {
		System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
		homePage homePage = new homePage();

		boolean actualStatus = homePage.open().gotoBookTicketPageWithoutLogin().isDisplayed();

		Assert.assertTrue(actualStatus, "Login page doesn't display");
	}

	@Test
	public void TC05() {
		System.out.println("TC05 - System shows message when user enters wrong password several times");
		homePage homePage = new homePage();
		loginPage loginPage = homePage.open().gotoLoginPage();

		for (int i = 1; i < 5; i++) {
			loginPage.invalidLogin(Constant.USERNAME, "");
		}

		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}

	@Test
	public void TC06() {
		System.out.println("TC06 - Additional pages display once user logged in");
		homePage homePage = new homePage();
		homePage.open().gotoLoginPage().login(Constant.USERNAME, Constant.PASSWORD);

		boolean logoutTabDisplayed = homePage.isLogoutTabDisplayed();
		boolean myTicketTabDisplayed = homePage.isMyTicketTabDisplayed();
		boolean changePasswordTabDisplayed = homePage.isChangePasswordTabDisplayed();

		Assert.assertTrue(logoutTabDisplayed, "Logout Tab is not displayed as expected");
		Assert.assertTrue(myTicketTabDisplayed, "My Ticket Tab is not displayed as expected");
		Assert.assertTrue(changePasswordTabDisplayed, "Change Password Tab is not displayed as expected");

		myTicketPage myTicketPage = homePage.gotoMyTicketPage();

		boolean ticketPageDisplayed = myTicketPage.isDisplayed();
		Assert.assertTrue(ticketPageDisplayed, "My Ticket Page is not displayed as expected");

		boolean changePasswordPageDisplayed = myTicketPage.isDisplayed();
		Assert.assertTrue(changePasswordPageDisplayed, "Change Password Page is not displayed as expected");
	}
}
