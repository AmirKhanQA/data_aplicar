package io.aplicar.web.carina.automation.regression;

import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import io.aplicar.web.carina.automation.gui.pages.HomePage;
import io.aplicar.web.carina.automation.gui.pages.StudyPortalsHomePage;
import io.aplicar.web.carina.automation.testUtils.Groups;
import io.aplicar.web.carina.automation.testUtils.TestSetup;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AUTO_TS_02_Add_Study_Portals_Campus_Details extends TestSetup {

    @Test(testName = "Print and Add Campus Details of Study_Portals", dataProvider = "DataProvider", groups = {Groups.Regression},invocationCount = 1,description = "JIRA#AUTO-TC-002" )
    @CsvDataSourceParameters(path = "xls/DataOrb_App_Data.csv", dsUid = "TestCaseID", executeColumn = "TestCaseID", executeValue = "AUTO-TC-002")
    public void testPrintAndAddCampusDetailsOfStudyPortals_AUTO_TC_002(HashMap<String, String> testData) {
        Reporter.log("TC_AUTO_TC_01 -Print and Add Campus Details of Study_Portals", true);
        StudyPortalsHomePage studyPortalsHomePage = new StudyPortalsHomePage(driver);
        studyPortalsHomePage.GetTheCampusDetails();

    }

}