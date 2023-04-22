package io.aplicar.web.carina.automation.testUtils;


import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

/**
 * @author Amir Khan
 */
public class TestSetup extends AbstractTest {
    public static WebDriver driver;
    @BeforeMethod
    public WebDriver beforeMethod()
    {
             driver = getDriver(DEFAULT);
            driver.get(R.CONFIG.get("url"));
            return  driver;
    }



}
