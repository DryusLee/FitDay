package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ActivityLogPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.WeightLogPage;
import utils.CapabilitiesGenerator;

@Log4j2
abstract class BaseTest {

    public static final String USERNAME = "andrei123";
    public static final String PASSWORD = "@8ameMu&$be5VjG";

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    WeightLogPage weightLogPage;
    ActivityLogPage activityLogPage;

    @BeforeMethod(description = "Opening Chrome Driver")
    public void createDriver(ITestContext context) {

        try {
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        } catch (SessionNotCreatedException ex) {
            log.fatal(ex.getLocalizedMessage());
        }
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        weightLogPage = new WeightLogPage(driver);
        activityLogPage = new ActivityLogPage(driver);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod(alwaysRun = true)
   public void closeBrowser() {
        driver.close();
    }
}

