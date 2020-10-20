package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage{
    //*[@id="dashboard-top"])
    public static final By PROFILE_LINK = By.id("profile-link");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public DashboardPage isPageOpened(){
        Assert.assertTrue(driver.findElement(By.id("profile-link")).isDisplayed());
        return this;
    }
    public DashboardPage openPage(){
        driver.get("");
        return this;
    }
}
