package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ActivityLogPage extends BasePage {

    public static final By ENTRY_FIELD = By.xpath("//*[@id='activity-search-bar']/form/input");
    public static final By SLOW_DANCING_MINUTES = By.xpath("//*[@id='result-activities']/.//tr[5]/td[3]/input[2]");
    public static final By FAST_DANCING_MINUTES = By.xpath("//*[@id='result-activities']/.//tr[6]/td[3]/input[2]");
    public static final By ADD_SLOW_DANCING_BUTTON = By.xpath("//*[@id='result-activities']/.//tr[5]/td[7]/a");
    public static final By ADD_FAST_DANCING_BUTTON = By.xpath("//*[@id='result-activities']/.//tr[6]/td[7]/a");
    public static final By ACTIVITY_LOG_ICON = By.xpath("(//*[contains(text(), 'Activity Log')])");
    public static final By ADD_TO_ACTIVITY_LOG_BUTTON = By.cssSelector(".activity-add-button");
    public static final By ADDED_SLOW_DANCING_CALS = By.xpath("//*[@id='activity-log']/table/tbody/tr[1]/td[6]");
    public static final By ADDED_FAST_DANCING_CALS = By.xpath("//*[@id='activity-log']/table/tbody/tr[2]/td[6]");

    public static final By SEXUAL_DROP_DOWN = By.name("pkey");
    public static final By SEXUAL_ACTIVITY_MINUTES = By.xpath("//*[@id='result-activities']/.//tr/td[3]/input[2]");
    public static final By ADD_SEXUAL_ACTIVITY_BUTTON = By.xpath("//*[@id='result-activities']/.//tr/td[7]/a");
    public static final By ADDED_SEXUAL_ACTIVITY_CALS = By.xpath("//*[@id='activity-log']/table/tbody/tr[3]/td[6]");

    public static final By BASKETBALL_GAME_HOURS = By.xpath("//*[@id='result-activities']/.//tr[4]/td[3]/input[1]");
    public static final By BASKETBALL_GAME_MINUTES = By.xpath("//*[@id='result-activities']/.//tr[4]/td[3]/input[2]");
    public static final By BASKETBALL_NON_GAME_MINUTES = By.xpath("//*[@id='result-activities']/.//tr[5]/td[3]/input[2]");
    public static final By ADD_BASKETBALL_GAME_BUTTON = By.xpath("//*[@id='result-activities']/.//tr[4]/td[7]/a");
    public static final By ADD_BASKETBALL_NON_GAME_BUTTON = By.xpath("//*[@id='result-activities']/.//tr[5]/td[7]/a");
    public static final By ADDED_BASKETBALL_GAME_CALS = By.xpath("//*[@id='activity-log']/.//tr[4]/td[6]");
    public static final By ADDED_BASKETBALL_NON_GAME_CALS = By.xpath("//*[@id='activity-log']/.//tr[5]/td[6]");

    public ActivityLogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ActivityLogPage isPageOpened() {
        driver.findElement(ACTIVITY_LOG_ICON).isDisplayed();
        return new ActivityLogPage(driver);
    }

    public ActivityLogPage openPage() {
        driver.get(URL + "app/log/activities");
        isPageOpened();
        return new ActivityLogPage(driver);
    }

    public ActivityLogPage write(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public void addFastDancing(String text) {
        driver.findElement(ENTRY_FIELD).sendKeys(text);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(FAST_DANCING_MINUTES)));
        write("20", FAST_DANCING_MINUTES);
        driver.findElement(ADD_FAST_DANCING_BUTTON).click();
        driver.findElement(ADD_TO_ACTIVITY_LOG_BUTTON).click();
    }

    public ActivityLogPage addSlowDancing(String text) {
        driver.findElement(ENTRY_FIELD).sendKeys(text);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SLOW_DANCING_MINUTES)));
        write("15", SLOW_DANCING_MINUTES);
        driver.findElement(ADD_SLOW_DANCING_BUTTON).click();
        driver.findElement(ADD_TO_ACTIVITY_LOG_BUTTON).click();
        return this;
    }

    public String getAddedCalsForSlowDancing() {
        return driver.findElement(ADDED_SLOW_DANCING_CALS).getText();
    }

    public String getAddedCalsForFastDancing() {
        return driver.findElement(ADDED_FAST_DANCING_CALS).getText();
    }

    public void addSexualActivity(){
        Select browse = new Select(driver.findElement(By.id("activity-browse")));
        browse.selectByVisibleText("Sexual activity");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SEXUAL_ACTIVITY_MINUTES)));
        Select details = new Select(driver.findElement(SEXUAL_DROP_DOWN));
        details.selectByVisibleText("general, moderate effort");
        write("03",SEXUAL_ACTIVITY_MINUTES);
        driver.findElement(ADD_SEXUAL_ACTIVITY_BUTTON).click();
        driver.findElement(ADD_TO_ACTIVITY_LOG_BUTTON).click();
    }

    public String getAddedCalsForSexualActivity() {
        return driver.findElement(ADDED_SEXUAL_ACTIVITY_CALS).getText();
    }

    public ActivityLogPage addBasketballGame(){
        Select browse = new Select(driver.findElement(By.id("activity-browse")));
        browse.selectByVisibleText("Sports");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(BASKETBALL_GAME_HOURS)));
        write("01", BASKETBALL_GAME_HOURS);
        write("00",BASKETBALL_GAME_MINUTES);
        driver.findElement(ADD_BASKETBALL_GAME_BUTTON).click();
        driver.findElement(ADD_TO_ACTIVITY_LOG_BUTTON).click();
        return this;
    }
    public void addBasketballNonGame(){
        Select browse = new Select(driver.findElement(By.id("activity-browse")));
        browse.selectByVisibleText("Sports");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(BASKETBALL_NON_GAME_MINUTES)));
        write("30", BASKETBALL_NON_GAME_MINUTES);
        driver.findElement(ADD_BASKETBALL_NON_GAME_BUTTON).click();
        driver.findElement(ADD_TO_ACTIVITY_LOG_BUTTON).click();
    }

    public String getAddedCalsForBasketballGame() {
        return driver.findElement(ADDED_BASKETBALL_GAME_CALS).getText();
    }

    public String getAddedCalsForBasketballNonGame() {
        return driver.findElement(ADDED_BASKETBALL_NON_GAME_CALS).getText();
    }

}
