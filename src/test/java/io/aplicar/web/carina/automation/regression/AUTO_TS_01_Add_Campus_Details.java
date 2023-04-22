package io.aplicar.web.carina.automation.regression;

import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import io.aplicar.web.carina.automation.gui.pages.HomePage;
import io.aplicar.web.carina.automation.testUtils.Groups;
import io.aplicar.web.carina.automation.testUtils.TestSetup;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AUTO_TS_01_Add_Campus_Details extends TestSetup {

    @Test(testName = "Print and Add Campus Details", dataProvider = "DataProvider", groups = {Groups.Regression},invocationCount = 1,description = "JIRA#AUTO-TC-001" )
    @CsvDataSourceParameters(path = "xls/DataOrb_App_Data.csv", dsUid = "TestCaseID", executeColumn = "TestCaseID", executeValue = "AUTO-TC-001")
    public void testPrintAndAddCampusDetails_AUTO_TC_001(HashMap<String, String> testData) {
        Reporter.log("TC_AUTO_TC_01 -Print and Add Campus Details", true);
        HomePage homePage = new HomePage(driver);
        homePage.GetTheCampusDetails();

    }

}