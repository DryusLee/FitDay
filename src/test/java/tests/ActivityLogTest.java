package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class ActivityLogTest extends BaseTest{
    String dancingSearch = "dancing";
    String slowDancingCals = "59";
    String fastDancingCals = "118";
    String sexualCals = "5";
    String BasketballGameCals = "627";
    String BasketballNonGameCals = "235";

    @Description("Add new dancing activity")
    @Test(retryAnalyzer = Retry.class)
    public void addDancingActivityTest(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        activityLogPage
                        .openPage()
                        .addSlowDancing(dancingSearch)
                        .addFastDancing(dancingSearch);
        Assert.assertEquals(activityLogPage.getAddedCalsForSlowDancing(), slowDancingCals);
        Assert.assertEquals(activityLogPage.getAddedCalsForFastDancing(), fastDancingCals);

    }

    @Description("Add new sexual activity")
    @Test(retryAnalyzer = Retry.class)
    public void addSexualActivityTest(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        activityLogPage
                .openPage()
                .addSexualActivity();
        Assert.assertEquals(activityLogPage.getAddedCalsForSexualActivity(), sexualCals);
    }

    @Description("Add new basketball (non)game activity")
    @Test(retryAnalyzer = Retry.class)
    public void addSportsTest(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        activityLogPage
                .openPage()
                .addBasketballGame()
                .addBasketballNonGame();
       Assert.assertEquals(activityLogPage.getAddedCalsForBasketballGame(), BasketballGameCals);
       Assert.assertEquals(activityLogPage.getAddedCalsForBasketballNonGame(), BasketballNonGameCals);

    }
}
