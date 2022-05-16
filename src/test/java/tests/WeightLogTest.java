package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class WeightLogTest extends BaseTest {
    String weightvalue = "200";
    String weightLBS = weightvalue + " lbs";
    String weightCurrentTableValue = weightvalue + ".0 lbs";
    String start = "11/25/2020";
    String goal = "02/25/2021";
    String startWeight = "200";
    String goalWeight = "100";
    String date = "February 25, 2021";
    String weightGoalFromTable = goalWeight + ".0 lbs";

    @Description("Edit weight value")
    @Test
    public void editAndSaveWeightCurrentValueTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        log.info("Залогинено");
        weightLogPage
                .openPage()
                .editAndSaveWeightCurrentValue(weightvalue);
        
        Assert.assertEquals(weightLogPage.getCurrentWeight(), weightLBS);
        Assert.assertEquals(weightLogPage.getWeightFromProgressTable(), weightCurrentTableValue);

    }

    @Description("Edit weight goal value")
    @Test
    public void editAndSaveWeightGoalTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        weightLogPage
                .openPage()
                .editAndSaveWeightGoalValue(start, goal, startWeight, goalWeight);
        Assert.assertEquals(weightLogPage.getGoalWeightFromTable(), weightGoalFromTable);
        Assert.assertEquals(weightLogPage.getDateFromTable(), date);
    }
}
