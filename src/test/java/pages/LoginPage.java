package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public static final By USERNAME_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.name("Password");
    public static final By LOGIN_BUTTON = By.name("login");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public LoginPage openPage(){
        driver.get("https://www.fitday.com/fitness/Login.html");
        return this;
    }
    public DashboardPage login(String username, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new DashboardPage(driver);
    }
}
