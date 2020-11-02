package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class WeightLogPage extends BasePage {

    public static final By WEIGHT_CURRENT_EDIT_BUTTON = By.cssSelector(".weight-current");
    public static final By WEIGHT_CURRENT_VALUE = By.name("weight");
    public static final By WEIGHT_CURRENT_SAVE_BUTTON = By.cssSelector(".save button");
    public static final By WEIGHT_ICON = By.cssSelector(".icon weight");
    //public static final By WEIGHT_SHOWING = By.cssSelector(".fd-highlight");

    public WeightLogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WeightLogPage isPageOpened() {
        
        driver.findElement(WEIGHT_ICON).isDisplayed();
        return new WeightLogPage(driver);
    }

    public WeightLogPage openPage() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL + "app/log/weight");
        isPageOpened();
        return new WeightLogPage(driver);
    }

    public WeightLogPage editAndSaveWeightCurrentValue(String weightvalue) {
        driver.findElement(WEIGHT_CURRENT_EDIT_BUTTON).click();
        driver.findElement(WEIGHT_CURRENT_VALUE).sendKeys(weightvalue);
        driver.findElement(WEIGHT_CURRENT_SAVE_BUTTON).click();
        return new WeightLogPage(driver);
    }
}
