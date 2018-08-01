package RailWays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class loginPage extends generalPage{
	// Locators
		private final By txtUsername = By.xpath("//input[@id='username']");
		private final By txtPassword = By.xpath("//input[@id='password']");
		private final By btnLogin = By.xpath("//input[@value='login']");
		private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
		private final By linkForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");
		private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
		private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
		private final By txtResetToken = By.xpath("//input[@id='resetToken']");
		private final By btnResetPassword = By.xpath("//input[@value='Reset Password']");

		// Elements
		public WebElement getTxtUsername() {
			return Constant.WEBDRIVER.findElement(txtUsername);
		}

		public WebElement getTxtPassword() {
			return Constant.WEBDRIVER.findElement(txtPassword);
		}

		public WebElement getBtnLogin() {
			return Constant.WEBDRIVER.findElement(btnLogin);
		}

		public WebElement getLblLoginErrorMsg() {
			return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
		}
		
		public WebElement getLinkForgotPassword() {
			return Constant.WEBDRIVER.findElement(linkForgotPassword);
		}
		
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
		public homePage login(String username, String password) {
			// Submit login credentials
			this.getTxtUsername().sendKeys(username);
			this.getTxtPassword().sendKeys(password);
			this.getBtnLogin().click();

			// Land on Home page
			return new homePage();
		}

		public loginPage invalidLogin(String username, String password) {
			// Submit login credentials
			this.getTxtUsername().sendKeys(username);
			this.getTxtPassword().sendKeys(password);
			this.getBtnLogin().click();

			// Land on Home page
			return this;
		}

		public String getErrorMsg() {
			return getLblLoginErrorMsg().getText();
		}

		public boolean isDisplayed() {
			return (getTxtUsername().isDisplayed() && getTxtPassword().isDisplayed());
		}
		
		public forgotPasswordPage gotoForgetPasswordPage() {
			this.getLinkForgotPassword().click();
			return new forgotPasswordPage();
		}
		
		public loginPage resetPassword(String newPw, String confirmPw, String token)
	    {
	        this.getTxtNewPassword().sendKeys(newPw);
	        this.getTxtConfirmPassword().sendKeys(confirmPw);
	        this.getTxtResetToken().clear();
	        this.getTxtResetToken().sendKeys(token);
	        this.getBtnResetPassword().click();
	        return this;
	    }
}
