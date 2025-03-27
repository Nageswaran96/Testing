package pages;

import functions.General;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
	
	static WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@FindBy(xpath = "//app-login/div[@class=\'login-page bg-light min-vh-100 d-flex flex-row align-items-center bright brightThemeImg\']")
	WebElement loginPage;

	@FindBy(xpath = "//app-dashboard [@class=\'ng-star-inserted\']")
	WebElement dashboardPage;

	@FindBy(name = "email")
	WebElement usernameInput;
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(className = "login-btn")
	WebElement loginButton;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLoginPage() {
		wait.until(ExpectedConditions.visibilityOfAllElements(loginPage, usernameInput, passwordInput, loginButton));
		if(loginPage.isDisplayed()) {
			return true;
		} else {
			return false;
		}
    }
	
	public void provideUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void providePassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginButton.click();
	}

	public boolean verifyLogin() {
		wait.until(ExpectedConditions.visibilityOf(dashboardPage));
		if (dashboardPage.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
}
