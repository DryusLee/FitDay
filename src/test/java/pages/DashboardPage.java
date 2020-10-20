package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{
    //*[@id="dashboard-top"])
    String profileLocator = "profile-link";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public DashboardPage findProfileLink(String profileName){
        driver.findElement(By.id(String.format(profileLocator, profileName))).click();
        return this;
    }
    public DashboardPage openPage(){
        driver.get("");
        return this;
    }
}
