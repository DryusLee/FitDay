package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

abstract class BasePage {

    public static final String URL = "https://www.fitday.com/";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public abstract BasePage write(String text, By locator);

    public abstract BasePage openPage();

    public abstract BasePage isPageOpened();

}
