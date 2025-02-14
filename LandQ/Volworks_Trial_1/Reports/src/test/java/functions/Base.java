package functions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	public static WebDriver driver = null;
	public static final String baseUrl = "https://apps.volworks.com/#/login";
	public Properties prop;
	
    @BeforeTest
    public WebDriver initializeBrowser (String browser) {
    	
    	if(browser.equalsIgnoreCase("chrome")) {
    		
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		
    	} else if (browser.equalsIgnoreCase("edge")) {
    		
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    	}
    	
    	driver.manage().window().maximize();
    	driver.get(baseUrl);
    	return driver;
    }
    
    public void loadProjectDataProperties() {
    	
    	prop = new Properties();
    	String projectPath = System.getProperty("user.dir");
    	File file = new File(projectPath+"\\src\\resources\\ProjectData.properties");
    	try {
    		FileInputStream fis = new FileInputStream(file);
    		prop.load(fis);
    	} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
    }
    
    public String getTimeStamp() {
    	Date date = new Date();
    	String timeStampModified = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
    	return timeStampModified;
    }
}
