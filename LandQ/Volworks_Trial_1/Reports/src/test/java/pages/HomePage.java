package pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functions.General;

public class HomePage {
	WebDriver driver;
	General general;
	
	@FindBy (xpath = "//app-dashboard[@class=\'ng-star-inserted\']" )
	WebElement fullReport;
	
	@FindBy (xpath = "//c-sidebar[@id=\'sidebar\']")
	WebElement sideMenu;
	
	@FindBy (xpath = "//c-sidebar-brand[@class=\'sidebar-brand\']")
	WebElement sideMenuLogo;
	
	@FindBy (xpath = "//div[@class=\'side-menu sidebar scrollbar ng-star-inserted\']")
	WebElement sideMenuScrollBar;
	
	@FindBy (xpath = "//div[@class=\"report-heading-row\"]/div")
	List<WebElement> reportHeadingRow; //Columns on Headers

	@FindBy (className = "report")
	List<WebElement> report;

	@FindBy (xpath = "//div[@class=\"report-heading\"]")
	List<WebElement> reportHeading; //Rows for Header,filter, SPY header and Avg
	
//	@FindBy (xpath = "//div[@class=\"report-heading-row\"]")
//	WebElement reportHeadingRow;
			
	@FindBy (xpath = "//div[@class=\'report-body ng-star-inserted\']")
	WebElement reportBody;
	
	@FindBy (xpath = "//div[@class=\"report\"]/div[@class='report-body ng-star-inserted']")
	List<WebElement> tableBodyRows;
	
	public boolean isElementDisplayed(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch(NoSuchElementException e) {
	        return false;
	    }
	}
	
//	boolean isEnabledButton = ((WebElement) driver.findElement((By) reportBody)).isEnabled();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@SuppressWarnings("static-access")
	public void verifyReportBody(WebDriver driver) {
		general.waitingForElementVisible(driver, reportBody);
	}
	
	
	@SuppressWarnings("static-access")
	public void getTableHeaderColumns() {
		general.collectOneRowRecords(driver, reportHeadingRow);		
	}
	
	public void getTableHeadersRows() {
		General.collectMultiRows(driver, reportHeading);
	}
	
	public void getTableBodyRows() {
		General.collectMultiRows(driver, tableBodyRows);
	}
}
