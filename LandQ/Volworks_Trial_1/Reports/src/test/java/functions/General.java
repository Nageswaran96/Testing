package functions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class General {
static Calendar today = Calendar.getInstance();
	
	public void newDate() {
		Date Today = today.getTime();
		System.out.println(Today);
	}
	
	public static void switchTab(WebDriver driver,  String tabName) {
		
		Set<String> allWindows = driver.getWindowHandles();
		String tab;
		for (String currentWindow: allWindows) {
			driver.switchTo().window(currentWindow);
			if (driver.getCurrentUrl().contains(tabName)) {
				tab = driver.getTitle();
				System.out.println("Current Tab Url " + driver.getCurrentUrl());
				System.out.println("Current Tab Name is " + tab);
				break;
			}
//			if(driver.getTitle().equals(tabName)) {
//				tab = driver.getTitle();
//				System.out.println("Current Tab Url " + driver.getCurrentUrl());
//				System.out.println("Current Tab Name is " + tab);
//				break;
//			}
		}
	}
	
	public static void waitingForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));    
	}
	
	public static void collectOneRowRecords(WebDriver driver, List<WebElement> element) {
		List<String> reportData = new ArrayList<String>();
		List<WebElement> oneRowRecords = element;
		for (WebElement webElement: oneRowRecords ) {		
				if (webElement.isDisplayed()) {
					reportData.add(webElement.getText());
					@SuppressWarnings("unused")
					String name = webElement.getText();
//					if(name != null) {
//						System.out.print(name + " ");
//					} else {
//						System.out.print("NO ");
//					}
		
				} else {
					reportData.add("N/A");
				}			
		}
		
		for (String i: reportData) {
			if(!i.isBlank()) {
				System.out.print(i+"  -  ");
			} else {
				System.out.println("N/A ");
			}
		}

	}
	
	public static void collectMultiRows(WebDriver driver, List<WebElement> element) {
		List<WebElement> subElements = new ArrayList<WebElement>();
		List<WebElement> multiRowRecords = element;
		for(WebElement elements: multiRowRecords) {
			if (!elements.getTagName().isEmpty()) {				
				subElements.add(elements);
			} else {
				System.out.print("Empty");
			}
		}
		
		for(WebElement elementss: subElements) {
			if(elementss.isDisplayed()) {
				General.collectOneRowRecords(driver, subElements);
				System.out.println("-");
			} else {
				System.out.println("N/A");
			}
		}
		
	}

}
