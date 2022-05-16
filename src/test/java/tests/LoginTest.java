package tests;

import org.testng.annotations.Test;
import pages.DashboardPage;

public class LoginTest extends BaseTest{

    @Test(description = "login")
    public void loginTest(){
        DashboardPage actualpage = loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .isPageOpened();
    }
}
