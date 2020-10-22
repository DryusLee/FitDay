package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest(){
        DashboardPage actualpage = loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .isPageOpened();

    }
}
