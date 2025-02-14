package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu {
	WebDriver driver;
	
	public SideMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[@class=\'side-menu-item-title ng-star-inserted\'][1]")
	WebElement payoffTool;

	@FindBy (xpath = "//a[@href=\'#/booter-lq?title=Boosters\'][1]")
	WebElement boosters;
	
	@FindBy (xpath = "//a[@href='#/new-covered-call?title=Covered Call'][1]")
	WebElement CC;
	
	@FindBy (xpath = "//a[@href=\'#/zero-cost-collar?title=Zero-Cost Collars\'][1]")
	WebElement zcc;
	
	@FindBy (xpath = "//a[@href=\'#/put-notional-cost?title=Puts-Notional Cost\'][1]")
	WebElement putNotional;
	
	@FindBy (xpath = "//div[@class=\'side-menu-item open\']/a[@href=\'#/jobs-logs?title=Job Logs\'][1]" )
	WebElement jobLogs;
		
	public void clickPayoffTool() {
		payoffTool.click();
	}
	
	public void clickBoosters() {
		boosters.click();
	}
	
	public void clickCC() {
		CC.click();
	}
	
	public void clickZcc() {
		zcc.click();
	}
	
	public void clickPutNotional() {
		putNotional.click();
	}
	
	public void clickJobLogs() {
		jobLogs.click();
	}
}
