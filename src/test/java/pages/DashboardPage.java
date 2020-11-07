package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    public static final By PROFILE_LINK = By.id("profile-link");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage isPageOpened() {
        Assert.assertTrue(driver.findElement(PROFILE_LINK).isDisplayed());
        return this;
    }

    public DashboardPage openPage() {
        driver.get("https://www.fitday.com/app/home/dashboard#21OCT2020");
        return this;
    }
    @Override
    public BasePage write(String text, By locator) {
        return null;
    }
}
