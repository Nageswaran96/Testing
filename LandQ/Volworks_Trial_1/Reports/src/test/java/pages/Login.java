package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
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
	
	public void provideUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void providePassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginButton.click();
	}
}
