package io.aplicar.web.carina.automation.gui.pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import io.aplicar.web.carina.automation.utils.CampusDetails;
import io.aplicar.web.carina.automation.utils.StudyPortalsCampusDetails;
import io.aplicar.web.carina.automation.utils.StudyPortalsCampusDetails_2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Array;
import java.util.*;

public class StudyPortalsHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h2[@class='StudyName']")
    private List<ExtendedWebElement> StudyCourses;

    @FindBy(xpath = "(//h2[@class='StudyName'])[%d]")
    private ExtendedWebElement courseName;

    @FindBy(xpath = "(//p[@class='Summary is-collapsed'])[%d]")
    private ExtendedWebElement description;

    @FindBy(xpath = "(//div[@class='TuitionValue'])[%d]")
    private ExtendedWebElement tuitionFee;

    @FindBy(xpath = "(//div[@class='DurationValue'])[%d]")
    private ExtendedWebElement DurationValue;

    @FindBy(xpath = "(//span[@class='SecondaryFacts DesktopOnlyBlock'])[%d]")
    private ExtendedWebElement StudyCourseType;

    @FindBy(xpath = "(//strong[@class='OrganisationName'])[%d]")
    private ExtendedWebElement instituteName;

    @FindBy(xpath = "//span[@class='LocationItems']")
    private ExtendedWebElement OrganisationLocation;

    @FindBy(xpath = "(//img[@class='OrganisationLogo'])[%d]")
    private ExtendedWebElement OrganisationLogo;

    @FindBy(xpath = "(//a[contains(@class,'StudyLink TextLink')])[1]")
    private ExtendedWebElement instituteURL;

    @FindBy(xpath = "//button[@class='NextButton NavigatorButton']")
    private ExtendedWebElement NextButton;

    @FindBy(xpath = "(//button[contains(@class,'NavigatorButton')])[1]")
    private ExtendedWebElement SeeMoreButton;


    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    private ExtendedWebElement SignInButton;

    @FindBy(xpath = "(//button[normalize-space()='Log in'])[1]")
    private ExtendedWebElement LogInButton;

    @FindBy(xpath = "(//input[@name='Email'])[1]")
    private ExtendedWebElement Email;

    @FindBy(xpath = "(//input[@name='Password'])[1]")
    private ExtendedWebElement Password;

    @FindBy(xpath = "(//button[@class='SubmitButton DriverButton'])[1]")
    private ExtendedWebElement LoginSubmitButton;


    @FindBy(xpath = "//div[normalize-space()='Start date']/../div/div/div/time")
    private ExtendedWebElement intakeDate;

    @FindBy(xpath = "(//div[@data-target='general'])[1]")
    private ExtendedWebElement startDate;

    public StudyPortalsHomePage(WebDriver driver) {
        super(driver);
    }

    public void GetTheCampusDetails() {
        List<Map<String, Object>> campusDetailsList = new ArrayList<>();



        String InstituteURL;
        String CourseName;
        String TuitionFee;
        String Description;
        String InstituteName;
        String Country = null;
        String State = null;
        String City = null;
        String ProgramImage;
        String ProgramLevel;
        String StudyMode;
        String StudyType;
        String Duration;
        String StartDate = null;
        String IntakeDate = null;

        for (int j = 1; j <= 14; j++) {
            NextButton.isElementPresent(40);
            NextButton.scrollTo();
            NextButton.click();
//            waitUntil(ExpectedConditions.visibilityOf(SeeMoreButton.getElement()), 60);
//            SeeMoreButton.scrollTo();
//            SeeMoreButton.isElementPresent(60);
//            SeeMoreButton.getElement().click();
        }

            for (int i = 1; i <=StudyCourses.size(); i++) {
           /* if(SeeMoreButton.isElementPresent(5));
            {
                //NextButton.click();
                SeeMoreButton.scrollTo();
                SeeMoreButton.click();
            }*/
                String parentWindowHandle = driver.getWindowHandle();

                courseName.format(i).scrollTo();
                if (tuitionFee.format(i).isElementPresent(5)) {
                    CourseName = courseName.format(i).getText();
                    TuitionFee = tuitionFee.format(i).getText();
                    Description=description.format(i).getText();
                    Duration = DurationValue.format(i).getText();
                    String[] studyType = StudyCourseType.format(i).getText().split("/");
                    ProgramLevel=studyType[0];
                    StudyMode=studyType[1];
                    StudyType=studyType[2];
                    InstituteName = instituteName.format(i).getText();

                    String[] Organisation_Logo1 = OrganisationLogo.format(i).getAttribute("src").split("fit");
                    ProgramImage = Organisation_Logo1[0].replaceAll("\\?", "");
                    driver.manage().deleteAllCookies();
                    courseName.format(i).click();


                    if (SignInButton.isElementPresent(5)) {
                        SignInButton.click();
                        LogInButton.click();
                        Email.type("amir.khan@innovationm.com");
                        Password.type("Amir@12345678");
                        LoginSubmitButton.click();
                    }
                    switchTONextTab();
                    if(instituteURL.isElementPresent(10)) {
                        instituteURL.scrollTo();
                        instituteURL.click();
                        OrganisationLocation.scrollTo();
                        if(OrganisationLocation.isElementPresent(10)) {
                            String[] organisationLocation = OrganisationLocation.getText().split(",");
                            System.out.println("OrganisationLocation is ->" + OrganisationLocation.getText());
                            City = organisationLocation[0];
                            State = organisationLocation[1];
                            Country = organisationLocation[2];
                        }

                        if (startDate.isElementPresent() &&intakeDate.isElementPresent()) {
                            IntakeDate= intakeDate.getText();
                            StartDate = startDate.getText();
                        }
                        switchTONextTab();
                    }

                    InstituteURL = driver.getCurrentUrl();


                    Set<String> allWindowHandles = driver.getWindowHandles();
                    for (String windowHandle : allWindowHandles) {
                        if (!windowHandle.equals(parentWindowHandle)) {
                            driver.switchTo().window(windowHandle);
                            driver.close();
                        }
                    }

                    driver.switchTo().window(parentWindowHandle);
                    Map<String, Object> campusMap = new HashMap<>();
                    Map<String, Object> campusDetailsMap = new HashMap<>();

                    campusDetailsMap.put("instituteName", InstituteName);
                    campusDetailsMap.put("instituteURL", InstituteURL);
                    campusDetailsMap.put("city", City);
                    campusDetailsMap.put("state", State);
                    campusDetailsMap.put("country", Country);
                    campusMap.put("duration", Duration);
                    campusMap.put("description", Description);
                    campusMap.put("startDate", StartDate);
                    campusMap.put("programImage", ProgramImage);
                    campusMap.put("programLevel", ProgramLevel);
                    campusMap.put("studyType", StudyType);
                    campusMap.put("studyMode", StudyMode);
                    campusMap.put("intakeDate", IntakeDate);
                    campusMap.put("courseName", CourseName);
                    campusMap.put("tuitionFee", TuitionFee);
                    campusDetailsList.add(campusDetailsMap);
                    campusDetailsList.add(campusMap);

                    //campusDetailsList.add(new StudyPortalsCampusDetails(InstituteURL,InstituteName,Country,State,City,CourseName,  TuitionFee,  Description,ProgramImage,ProgramLevel,StudyMode,StudyType,Duration,StartDate,IntakeDate));

                }

                String jsonFile = "C:\\Users\\amir.khan1\\IdeaProjects\\data_aplicar\\src\\test\\resources\\xls\\studyPortalsData.json";
                ObjectMapper mapper = new ObjectMapper();

                try {
                    mapper.writeValue(new File(jsonFile), campusDetailsList);
                    LOGGER.info("Data written to " + jsonFile + " successfully.");
                } catch (IOException e) {
                    LOGGER.error("Error writing data to " + jsonFile + ": " + e.getMessage());
                }
            }

    }


    public  void switchTONextTab()
    {
        // Get the window handles of all open tabs
        Set<String> handles = driver.getWindowHandles();

// Get the current window handle
        String currentHandle = driver.getWindowHandle();

// Find the index of the current window handle in the list of handles
        int currentIndex = new ArrayList<String>(handles).indexOf(currentHandle);

// Find the next window handle in the list
        String nextHandle = new ArrayList<String>(handles).get(currentIndex + 1);

// Switch to the next tab
        driver.switchTo().window(nextHandle);
    }



}
