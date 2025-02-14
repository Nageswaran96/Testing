package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loop {
	int rowCount;
	int columnCount;
	public void getReportColumns(WebDriver driver, WebElement element) {
		for (int i=1; i<=rowCount; i++) {
			for (int j=1; j<=columnCount; j++) {
				if(element.isDisplayed()) {
					String tableData = element.getText();
					System.out.println(tableData);
				}else {
					
				}				
			}
		}
		
	}

}
