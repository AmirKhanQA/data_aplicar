package io.aplicar.web.carina.automation.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.aplicar.web.carina.automation.utils.CampusDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


import java.io.File;
import java.io.IOException;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//li[@class='search-hit__school-item']")
    private List<ExtendedWebElement> search_hit_school_item;

    @FindBy(xpath = "//button[@id='show-more-button']")
    private ExtendedWebElement show_more_button;
    @FindBy(xpath = "((//li[@class='search-hit__school-item'])[%d]/header/div)[1]")
    private ExtendedWebElement schoolThumbnail;

    @FindBy(xpath = "((//li[@class='search-hit__school-item'])[%d]/header/div)[2]")
    private ExtendedWebElement schoolAddress;

    @FindBy(xpath = "(//li[@class='search-hit__school-item'])[%d]/header/a")
    private ExtendedWebElement schoolName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void GetTheCampusDetails() {
        List<CampusDetails> campusDetailsList = new ArrayList<>();

        for (int i = 1; i <= search_hit_school_item.size(); i++) {
            if(show_more_button.isElementPresent(5));
            {
                show_more_button.click();
            }
            schoolThumbnail.format(i).scrollTo();
            String message = schoolThumbnail.format(i).getAttribute("style");
            String[] url = message.split("url");
            String schoolThumbnailURL = url[1].replaceAll("[()\"]", "");
            String school_name = schoolName.format(i).getText();
            String school_address = schoolAddress.format(i).getText();

            campusDetailsList.add(new CampusDetails(schoolThumbnailURL, school_name, school_address));
        }

        String jsonFile = "C:\\Users\\amir.khan1\\IdeaProjects\\data_aplicar\\src\\test\\resources\\xls\\data.json";
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(jsonFile), campusDetailsList);
            LOGGER.info("Data written to " + jsonFile + " successfully.");
        } catch (IOException e) {
            LOGGER.error("Error writing data to " + jsonFile + ": " + e.getMessage());
        }
    }


}
