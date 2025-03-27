package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderElements {
    static WebDriver driver;

    public HeaderElements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//app-default-header//img[@src=\'./assets/dark-theme/side-menu-icon-bright.png\']")
    WebElement sideMenuIcon;

    @FindBy (xpath = "//app-default-header//button/img[@src=\'/assets/images/heart.svg\']")
    WebElement favoriteOnHeader;

    @FindBy (xpath = "//app-default-header//div[@class=\'row title nav-title\']/div[@class=\'row\']")
    WebElement reportName;

    @FindBy (xpath = "//app-default-header//div[@class=\'row title nav-title\']/div[@class=\'row date ml-2\']")
    WebElement reportUpdatedTime;


}
