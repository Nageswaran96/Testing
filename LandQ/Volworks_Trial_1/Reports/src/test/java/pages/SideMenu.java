package pages;

import jdk.jfr.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
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

	@FindBy (xpath = "//app-side-menu/div/app-side-menu-item")
	WebElement sideMenuListHeader;

	@FindBy (xpath = "//a[@href=\'#/strategies/build?title=Strategy PayOff Tool\'][1]")
	WebElement sm_Enabled_PayOffTool;

	@FindBy (xpath = "//a[@href=\'#/strategies/build?title=Strategy PayOff Tool\'][2]")
	WebElement sm_Disabled_PayOffTool;

	@FindBy (xpath = "//a[@href=\'#/booter-lq?title=Boosters\'][1]")
	WebElement sm_Enabled_Boosters;

	@FindBy (xpath = "//a[@href=\'#/booter-lq?title=Boosters\'][2]")
	WebElement sm_Disabled_Boosters;
	
	@FindBy (xpath = "//a[@href='#/new-covered-call?title=Covered Call'][1]")
	WebElement sm_Enabled_CC;

	@FindBy (xpath = "//a[@href='#/new-covered-call?title=Covered Call'][2]")
	WebElement sm_Disabled_CC;

	@FindBy (xpath = "//a[@href='#/put-write-lq?title=Put Writes'][1]")
	WebElement sm_Enabled_PutWrites;

	@FindBy (xpath = "//a[@href='#/put-write-lq?title=Put Writes'][2]")
	WebElement sm_Disabled_PutWrites;
	
	@FindBy (xpath = "//a[@href=\'#/zero-cost-collar?title=Zero-Cost Collars\'][1]")
	WebElement sm_Enabled_Zcc;

	@FindBy (xpath = "//a[@href=\'#/zero-cost-collar?title=Zero-Cost Collars\'][2]")
	WebElement sm_Disabled_Zcc;
	
	@FindBy (xpath = "//a[@href=\'#/put-notional-cost?title=Puts-Notional Cost\'][1]")
	WebElement sm_Enabled_putNotional;

	@FindBy (xpath = "//a[@href=\'#/put-notional-cost?title=Puts-Notional Cost\'][2]")
	WebElement sm_Disabled_putNotional;
	
	@FindBy (xpath = "//div[@class=\'side-menu-item open\']/a[@href=\'#/jobs-logs?title=Job Logs\'][1]" )
	WebElement sm_Enabled_jobLogs;

	@FindBy (xpath = "//div[@class=\'side-menu-item open\']/a[@href=\'#/jobs-logs?title=Job Logs\'][2]" )
	WebElement sm_Disabled_jobLogs;

	public SearchContext xPathEdit (WebElement path) {
		String path1 = path.toString();
		String toDoRemove = "[1]";
		String toDoAdd = "[2]";
		String newString = "";
		if (path1.contains("[1]")) {
			newString = path1.replace(toDoRemove, toDoAdd);
		}
		WebElement newPath = driver.findElement(By.xpath(newString));
		return newPath;
	}
	public void clickPayoffTool() {
		if (sm_Enabled_PayOffTool.isDisplayed()) {
			sm_Enabled_PayOffTool.click();
		} else if (sm_Disabled_PayOffTool.isDisplayed()) {
			sm_Disabled_PayOffTool.click();
		}
	}
	
	public void clickBoosters() {
		if(sm_Enabled_Boosters.isDisplayed()) {
			sm_Enabled_Boosters.click();
		} else if (sm_Disabled_Boosters.isDisplayed()) {
			sm_Disabled_Boosters.click();
		}
	}
	
	public void clickCC() {
		if (sm_Enabled_CC.isDisplayed()) {
			sm_Enabled_CC.click();
		} else if (sm_Disabled_CC.isDisplayed()){
			sm_Disabled_CC.click();
		}
	}

	public void clickPutWrites() {
		if (sm_Enabled_PutWrites.isDisplayed()) {
			sm_Enabled_PutWrites.click();
		} else if (sm_Disabled_PutWrites.isDisplayed()) {
			sm_Disabled_PutWrites.click();
		}
	}

	public void clickZcc() {
		if (sm_Enabled_Zcc.isDisplayed()) {
			sm_Enabled_Zcc.click();
		} else if (sm_Disabled_Zcc.isDisplayed()) {
			sm_Disabled_Zcc.click();
		}
	}
	
	public void clickPutNotional() {
		if (sm_Enabled_putNotional.isDisplayed()) {
			sm_Enabled_putNotional.click();
		} else if (sm_Disabled_putNotional.isDisplayed()) {
			sm_Disabled_putNotional.click();
		}
	}
	
	public void clickJobLogs() {
		if (sm_Enabled_jobLogs.isDisplayed()) {
			sm_Enabled_jobLogs.click();
		} else if (sm_Disabled_jobLogs.isDisplayed()) {
			sm_Disabled_jobLogs.click();
		}
	}
}
