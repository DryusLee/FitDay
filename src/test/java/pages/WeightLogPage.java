package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
    public static final By GET_CURRENT_WEIGHT = By.cssSelector(".weight-current .fd-highlight");
    public static final By GET_CURRENT_WEIGHT_FROM_TABLE = By.xpath("//*[@id='weight-tabs']/.//tr[3]/td[3]");
    public static final By GET_GOAL_WEIGHT_FROM_TABLE = By.xpath("//*[@id='weight-tabs']/.//tr[3]/td[2]");
    public static final By GET_GOAL_DATE_FROM_TABLE = By.xpath("//*[@id='weight-tabs']/.//tr[1]/td[2]");

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

    public void editAndSaveWeightCurrentValue(String weightvalue) {
        driver.findElement(WEIGHT_CURRENT_EDIT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WEIGHT_CURRENT_SAVE_BUTTON)));
        driver.findElement(WEIGHT_CURRENT_VALUE).clear();
        driver.findElement(WEIGHT_CURRENT_VALUE).sendKeys(weightvalue);
        driver.findElement(WEIGHT_CURRENT_SAVE_BUTTON).click();
    }

    public void editAndSaveWeightGoalValue(String start, String goal, String startWeight, String goalWeight) {
        driver.findElement(WEIGHT_GOAL_EDIT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WEIGHT_GOAL_SAVE_BUTTON)));
        write(start, WEIGHT_GOAL_START_DATE);
        write(startWeight, WEIGHT_GOAL_START_WEIGHT);
        driver.findElement(WEIGHT_GOAL_GOAL_DATE).clear();
        driver.findElement(WEIGHT_GOAL_GOAL_DATE).sendKeys(goal);
        driver.findElement(WEIGHT_ICON).click();
        write(goalWeight, WEIGHT_GOAL_GOAL_WEIGHT);
        driver.findElement(WEIGHT_GOAL_SAVE_BUTTON).click();
    }

    public WeightLogPage write(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public String getCurrentWeight() {
        return driver.findElement(GET_CURRENT_WEIGHT).getText();
    }

    public String getWeightFromProgressTable() {
        return driver.findElement(GET_CURRENT_WEIGHT_FROM_TABLE).getText();
    }

    public String getGoalWeightFromTable() {
        return driver.findElement(GET_GOAL_WEIGHT_FROM_TABLE).getText();
    }

    public String getDateFromTable() {
        return driver.findElement(GET_GOAL_DATE_FROM_TABLE).getText();
    }
}
