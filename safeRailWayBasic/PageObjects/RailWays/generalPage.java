package RailWays;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class generalPage {
	// Locators
	private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
	private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
	private final By tabRegister = By.xpath("//span[.='Register']/ancestor::a");
	private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
	private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");

	// Elements
	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
	}

	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
	}

	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
	}

	protected WebElement getTabBookTicket() {
		return Constant.WEBDRIVER.findElement(tabBookTicket);
	}

	protected WebElement getTabRegister() {
		return Constant.WEBDRIVER.findElement(tabRegister);
	}

	protected WebElement getTabMyTicket() {
		return Constant.WEBDRIVER.findElement(tabMyTicket);
	}

	protected WebElement getTabChangePassword() {
		return Constant.WEBDRIVER.findElement(tabChangePassword);
	}

	// Methods
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}

	public loginPage gotoLoginPage() {
		this.getTabLogin().click();
		return new loginPage();
	}

	public bookTicketPage gotoBookTicketPage() {
		this.getTabBookTicket().click();
		return new bookTicketPage();
	}

	public loginPage gotoBookTicketPageWithoutLogin() {
		this.getTabBookTicket().click();
		return new loginPage();
	}

	public registerPage gotoRegisterPage() {
		this.getTabRegister().click();
		return new registerPage();
	}

	public myTicketPage gotoMyTicketPage() {
		this.getTabMyTicket().click();
		return new myTicketPage();
	}

	public changePasswordPage gotoChangePasswordPage() {
		this.getTabChangePassword().click();
		return new changePasswordPage();
	}

	public WebElement waitForControlStable(WebElement element) throws InterruptedException {
		System.out.println("Zo");	
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 20);
		System.out.println("Zo");	
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		System.out.println("Zo");	
//		wait.until(ExpectedConditions.visibilityOf(element));
//		System.out.println("Zo");	
		wait.until(ExpectedConditions.stalenessOf(element));
		System.out.println("Ra");
		System.out.println(element.isDisplayed());	
		System.out.println(element.isEnabled());
//		do {
//			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			System.out.println(element.isDisplayed() + " isDisplayed ");
//		} while (!element.isDisplayed());
//
//		System.out.println(element.isEnabled());
//		do {
//			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			System.out.println(element.isEnabled() + " isDisplayed ");
//		} while (!element.isEnabled());
		
		return element;
	}	
}
