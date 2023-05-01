package io.aplicar.web.carina.automation.gui.pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import io.aplicar.web.carina.automation.utils.CampusDetails;
import io.aplicar.web.carina.automation.utils.StudyPortalsCampusDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudyPortalsHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h2[@class='StudyName']")
    private List<ExtendedWebElement> StudyCourses;

    @FindBy(xpath = "(//h2[@class='StudyName'])[%d]")
    private ExtendedWebElement StudyCourseName;

    @FindBy(xpath = "(//p[@class='Summary is-collapsed'])[%d]")
    private ExtendedWebElement StudyCourseSummary;

    @FindBy(xpath = "(//div[@class='TuitionValue'])[%d]")
    private ExtendedWebElement TuitionFeeValue;

    @FindBy(xpath = "(//div[@class='DurationValue'])[%d]")
    private ExtendedWebElement DurationValue;

    @FindBy(xpath = "(//span[@class='SecondaryFacts DesktopOnlyBlock'])[%d]")
    private ExtendedWebElement StudyCourseType;

    @FindBy(xpath = "(//strong[@class='OrganisationName'])[%d]")
    private ExtendedWebElement OrganisationName;

    @FindBy(xpath = "(//strong[@class='OrganisationLocation'])[%d]")
    private ExtendedWebElement OrganisationLocation;

    @FindBy(xpath = "(//img[@class='OrganisationLogo'])[%d]")
    private ExtendedWebElement OrganisationLogo;

    @FindBy(xpath = "(//a[contains(@class,'StudyLink TextLink')])[1]")
    private ExtendedWebElement StudyOrganisationLink;

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



    public StudyPortalsHomePage(WebDriver driver) {
        super(driver);
    }

    public void GetTheCampusDetails() {
        List<StudyPortalsCampusDetails> campusDetailsList = new ArrayList<>();
        String Study_Course_Name;
        String Study_Course_Summary;
        String Tuition_Fee_Value;
        String Duration_Value;
        String Study_Course_Type;
        String Organisation_Name;
        String Organisation_Location;
        String Organisation_Logo;
        String studyOrganisationLink;
        for (int j = 1; j <= 0; j++) {
            NextButton.isElementPresent(10);
            NextButton.scrollTo();
            NextButton.click();
//            waitUntil(ExpectedConditions.visibilityOf(SeeMoreButton.getElement()), 60);
//            SeeMoreButton.scrollTo();
//            SeeMoreButton.isElementPresent(60);
//            SeeMoreButton.getElement().click();
        }

            for (int i = 1; i <= StudyCourses.size(); i++) {
           /* if(SeeMoreButton.isElementPresent(5));
            {
                //NextButton.click();
                SeeMoreButton.scrollTo();
                SeeMoreButton.click();
            }*/

                String parentWindowHandle = driver.getWindowHandle();

                StudyCourseName.format(i).scrollTo();
                if (TuitionFeeValue.format(i).isElementPresent(5)) {
                    Study_Course_Name = StudyCourseName.format(i).getText();
                    Tuition_Fee_Value = TuitionFeeValue.format(i).getText();
                    Study_Course_Summary=StudyCourseSummary.format(i).getText();
                    Duration_Value = DurationValue.format(i).getText();
                    Study_Course_Type = StudyCourseType.format(i).getText();
                    Organisation_Name = OrganisationName.format(i).getText();
                    Organisation_Location = OrganisationLocation.format(i).getText();
                    String[] Organisation_Logo1 = OrganisationLogo.format(i).getAttribute("src").split("fit");
                    Organisation_Logo = Organisation_Logo1[0].replaceAll("\\?", "");
                    driver.manage().deleteAllCookies();
                    StudyCourseName.format(i).click();


                    if (SignInButton.isElementPresent(5)) {
                        SignInButton.click();
                        LogInButton.click();
                        Email.type("amir.khan@innovationm.com");
                        Password.type("Amir@12345678");
                        LoginSubmitButton.click();
                    }
                    switchTONextTab();
                    if(StudyOrganisationLink.isElementPresent(7)) {
                        StudyOrganisationLink.scrollTo();
                        StudyOrganisationLink.click();
                        switchTONextTab();
                    }

                        studyOrganisationLink = driver.getCurrentUrl();


                    Set<String> allWindowHandles = driver.getWindowHandles();
                    for (String windowHandle : allWindowHandles) {
                        if (!windowHandle.equals(parentWindowHandle)) {
                            driver.switchTo().window(windowHandle);
                            driver.close();
                        }
                    }

                    driver.switchTo().window(parentWindowHandle);


                    campusDetailsList.add(new StudyPortalsCampusDetails(Study_Course_Name,Study_Course_Summary, Tuition_Fee_Value, Duration_Value, Study_Course_Type, Organisation_Name, Organisation_Location, Organisation_Logo, studyOrganisationLink));
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
