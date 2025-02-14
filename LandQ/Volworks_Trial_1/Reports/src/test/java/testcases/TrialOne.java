package testcases;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
	  
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		baseUrl = "https://apps.volworks.com/#/login";	
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new"); // or "--headless" for the traditional mode
//		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
        
        loginpage = new Login(driver);
        sideMenu = new SideMenu(driver);
        homePageFactory = new HomePage(driver);
     
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException, IOException {
		loginpage.provideUsername("nageswaran96@gmail.com");
		loginpage.providePassword("nag@1234");
		loginpage.clickLoginBtn();
		Thread.sleep(10000);

	}
	
	@Test(priority = 2)
	public void navigateToCCReport() throws InterruptedException {
		sideMenu.clickCC();
		Thread.sleep(Duration.ofSeconds(7));		
	}
	  
	@SuppressWarnings("static-access")
	@Test(priority = 3)
	public void switchToTab() throws IOException, InterruptedException {
		general.switchTab(driver, "Covered Calls");
		Thread.sleep(5000);
		readFromExcel.readExcel();
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void verifyReportBody() {
		homePageFactory.verifyReportBody(driver);
	}
	
	@SuppressWarnings("static-access")
	@Test(priority = 5)
	public void navigateToBoosterReport() throws InterruptedException {
		sideMenu.clickBoosters();
		Thread.sleep(Duration.ofSeconds(7));
		general.switchTab(driver, "Boosters");
	}

}
