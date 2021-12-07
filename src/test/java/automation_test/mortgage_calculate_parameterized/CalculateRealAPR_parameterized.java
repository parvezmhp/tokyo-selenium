package automation_test.mortgage_calculate_parameterized;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import parameters.DataProviderClass;
import utilities.ReadConfigFiles;

public class CalculateRealAPR_parameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateRealAPR_parameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("------------Test Name: Calculate Real APR-------------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test(dataProvider = "RealAPRRates", dataProviderClass = DataProviderClass.class)
    public void calculateRealAPR (String homePrice, String downPayment, String InterestRate, String actualAPR) {
            new NavigationBar(driver)
                    .mouseHoverToRates()
                    .navigateToRealApr()
                    .waitForPageToLoad()
                    .typeHousePrice(homePrice)
                    .clickOnDownPaymentInDollar()
                    .typeDownPayment(downPayment)
                    .typeInterestRate(InterestRate)
                    .clickOnTheCalculateButton()
                    .validateActualRealAPR(actualAPR);
        }

        @AfterMethod
    public void closeVBrowser() {
        LOGGER.info("--------End of the Case: Calculate Real APR---------");
        ActOn.browser(driver).close();
        }
}