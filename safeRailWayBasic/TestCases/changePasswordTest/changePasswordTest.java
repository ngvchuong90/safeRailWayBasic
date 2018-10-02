package changePasswordTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Account.Account;
import Common.Utilities;
import RailWays.gmailPage;
import RailWays.homePage;
import testCondition.testBase;

public class changePasswordTest extends testBase{
	@Test
	public void TC09() {
		System.out.println("TC09 - User can change password");
		String password = Utilities.getRandomString(8);
		homePage homePage = new homePage();
		
		Account acc = new Account();
		acc.generateData();
		homePage.RegisterAndActivate(acc);
		
		String actualMsg = homePage.open().gotoLoginPage().login(acc.getEmail(), acc.getPassword())
				.gotoChangePasswordPage().changePassword(acc.getPassword(), password, password).getSuccessMsg();
		String expectedMsg = "Your password has been updated!";
		Assert.assertEquals(actualMsg, expectedMsg, "Wrong Message is displayed");
		//asdasdasd
	}
	
	
//	@Test
//	public void TC12() {
//		System.out.println("TC12 - Errors display when password reset token is blank");
//		homePage homePage = new homePage();
//
//		Account acc = new Account();
//		acc.generateData();
//		homePage.RegisterAndActivate(acc);
//		
//		homePage.open().gotoLoginPage().gotoForgetPasswordPage().sendForgotPasswordLink(acc.getEmail());
//		
//		gmailPage gmailPage = new gmailPage();
//		gmailPage.clickResetPasswordLink(acc).resetPassword("newPass", "newPass", "");
//	}
}
