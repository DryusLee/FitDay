package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class WeightLogTest extends BaseTest {

    @Test
    public void editAndSaveWeightCurrentValueTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        log.info("Page not opened");
        weightLogPage
                .openPage()
                .editAndSaveWeightCurrentValue("200");

    }

    @Test
    public void editAndSaveWeightGoalTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        weightLogPage
                .openPage()
                .editAndSaveWeightGoalValue("10/25/2020", "02/15/2021", "200", "100")
                .weightGoalCheckChanges();
    }
}
