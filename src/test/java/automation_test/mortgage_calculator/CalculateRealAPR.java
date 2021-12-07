package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class CalculateRealAPR {

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

        @Test
    public void calculateRealAPR () {
            new NavigationBar(driver)
                    .mouseHoverToRates()
                    .navigateToRealApr()
                    .waitForPageToLoad()
                    .typeHousePrice("200000")
                    .clickOnDownPaymentInDollar()
                    .typeDownPayment("15000")
                    .typeInterestRate("3")
                    .clickOnTheCalculateButton()
                    .validateActualRealAPR("3.130%");
        }

        @AfterMethod
    public void closeVBrowser() {
        ActOn.browser(driver).close();
        }
}