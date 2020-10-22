package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WeightLogPage extends BasePage {

    public static final By WEIGHT_CURRENT_EDIT_BUTTON = By.cssSelector(".weight-current");
    public static final By WEIGHT_CURRENT_VALUE = By.name("weight");
    public static final By WEIGHT_CURRENT_SAVE_BUTTON = By.cssSelector(".save button");
    public static final By WEIGHT_ICON = By.cssSelector(".icon weight");

    public WeightLogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WeightLogPage isPageOpened() {
        driver.findElement(WEIGHT_ICON).isDisplayed();
        return new WeightLogPage(driver);
    }

    public WeightLogPage openPage() {
        driver.get(URL + "app/log/weight");
        isPageOpened();
        return new WeightLogPage(driver);
    }

    public WeightLogPage editAndSaveWeightCurrentValue() {
        driver.findElement(WEIGHT_CURRENT_EDIT_BUTTON).click();
        driver.findElement(WEIGHT_CURRENT_VALUE).sendKeys("100");
        driver.findElement(WEIGHT_CURRENT_SAVE_BUTTON).click();
        return new WeightLogPage(driver);
    }
}
