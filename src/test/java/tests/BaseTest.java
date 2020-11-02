package tests;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;
import pages.WeightLogPage;
import utils.CapabilitiesGenerator;

abstract class BaseTest {

    public static final String USERNAME = "andrei123";
    public static final String PASSWORD = "@8ameMu&$be5VjG";

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    WeightLogPage weightLogPage;

    @BeforeMethod(description = "Opening Chrome Driver")
    public void createDriver(ITestContext context) {

        try {
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        } catch (SessionNotCreatedException ex) {
            Assert.fail("Браузер не был открыт. Проверьте, что используется корректная версия драйвера");
            //log.fatal(ex.getLocalizedMessage());
        }
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        weightLogPage = new WeightLogPage(driver);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }
}

