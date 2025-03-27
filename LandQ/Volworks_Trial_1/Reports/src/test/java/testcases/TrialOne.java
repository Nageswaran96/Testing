package testcases;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Db;
import pages.HomePage;
import pages.Login;
import pages.SideMenu;
import functions.Base;
import functions.General;
import functions.ReadingDataFromExcel;


public class TrialOne {
	public WebDriver driver;
	public String baseUrl;
	
	Login loginpage;
    SideMenu sideMenu;
    HomePage homePageFactory;
	General general;
	Base base;
	ReadingDataFromExcel readFromExcel;
	Db db;
	  
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		baseUrl = "https://staging.volworks.com/#/login";
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new"); // or "--headless" for the traditional mode
//		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
        
        loginpage = new Login(driver);
        sideMenu = new SideMenu(driver);
        homePageFactory = new HomePage(driver);
		db = new Db();
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException, IOException {
		loginpage.verifyLoginPage();
		loginpage.provideUsername("nageswaran96@gmail.com");
		loginpage.providePassword("nag@1234");
		loginpage.clickLoginBtn();
		loginpage.verifyLogin();
	}

	@Test(priority = 2)
	public void navigateToCCReport() throws InterruptedException {
		sideMenu.clickCC();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Covered Call");
	}

	@Test(priority = 3)
	public void navigateToBoosterReport() throws InterruptedException {
		sideMenu.clickBoosters();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Boosters");
	}

	@Test(priority = 4)
	public void navigateToPutWritesReport() throws InterruptedException {
		sideMenu.clickPutWrites();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Put Writes");
	}

	@Test(priority = 5)
	public void navigateToZccReport() throws InterruptedException {
		sideMenu.clickZcc();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Zero-Cost Collars");
	}

	@Test(priority = 6)
	public void navigateToPutNotional() throws InterruptedException {
		sideMenu.clickPutNotional();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Puts-Notional Cost");
	}

	@Test(priority = 7)
	public void navigateToJoblogs() throws InterruptedException {
		sideMenu.clickJobLogs();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Job Logs");
	}

	@Test(priority = 8)
	public void navigateToPayOffTool() throws InterruptedException {
		sideMenu.clickPayoffTool();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Strategy PayOff Tool");
	}

}
