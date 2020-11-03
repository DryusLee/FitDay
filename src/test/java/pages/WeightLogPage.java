package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@Log4j2
public class WeightLogPage extends BasePage {

    public static final By WEIGHT_CURRENT_EDIT_BUTTON = By.cssSelector(".weight-current .edit");
    public static final By WEIGHT_CURRENT_VALUE = By.name("weight");
    public static final By WEIGHT_CURRENT_SAVE_BUTTON = By.cssSelector(".weight-current .save");
    public static final By WEIGHT_GOAL_EDIT_BUTTON = By.cssSelector(".weight-goal .edit");
    public static final By WEIGHT_GOAL_SAVE_BUTTON = By.cssSelector(".weight-goal .save");
    public static final By WEIGHT_GOAL_START_DATE = By.id("startdate");
    public static final By WEIGHT_GOAL_GOAL_DATE = By.id("goaldate");
    public static final By WEIGHT_GOAL_START_WEIGHT = By.id("startweight");
    public static final By WEIGHT_GOAL_GOAL_WEIGHT = By.id("goalweight");
    public static final By WEIGHT_ICON = By.xpath("//*[contains(text(), 'Weight Log')]");
    public static final By TABLE_GOAL_DATE = By.xpath("//*[contains(text(), 'January')]");

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

    public void editAndSaveWeightCurrentValue(String weightvalue) {
        driver.findElement(WEIGHT_CURRENT_EDIT_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(WEIGHT_CURRENT_VALUE).clear();
        driver.findElement(WEIGHT_CURRENT_VALUE).sendKeys(weightvalue);
        driver.findElement(WEIGHT_CURRENT_SAVE_BUTTON).click();
    }

    public WeightLogPage editAndSaveWeightGoalValue(String start, String goal, String startweight, String goalweight) {
        driver.findElement(WEIGHT_GOAL_EDIT_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(WEIGHT_GOAL_START_DATE).clear();
        driver.findElement(WEIGHT_GOAL_START_DATE).sendKeys(start);
        driver.findElement(WEIGHT_GOAL_START_WEIGHT).clear();
        driver.findElement(WEIGHT_GOAL_START_WEIGHT).sendKeys(startweight);
        driver.findElement(WEIGHT_GOAL_GOAL_DATE).clear();
        driver.findElement(WEIGHT_GOAL_GOAL_DATE).sendKeys(goal);
        driver.findElement(WEIGHT_ICON).click();
        driver.findElement(WEIGHT_GOAL_GOAL_WEIGHT).clear();
        driver.findElement(WEIGHT_GOAL_GOAL_WEIGHT).sendKeys(goalweight);
        driver.findElement(WEIGHT_GOAL_SAVE_BUTTON).click();
        return this;
    }

    public void weightGoalCheckChanges() {
        String goalMonth = driver.findElement(TABLE_GOAL_DATE).getText();
        if (goalMonth.equals("February")) {
            log.error("Месяц отобразился некорректно");
        }
    }
}
