package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RealAPR {
    private final By CalculatorTab = By.xpath("//label[1][text()='Calculator']");
    private final By HomePriceInputField = By.name("HomeValue");
    private final By DownPaymentInDollar = By.name("DownPaymentSel");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By InterestRateInputField = By.name("Interest");
    private final By CalculateRateTab = By.name("calculate");
    private final By ActualAPR = By.xpath("//*[@id='analysisDiv']/table[1]/tbody/tr/td/strong/../../td[2]/Strong");

    private static final Logger LOGGER = LogManager.getLogger(RealAPR.class);

    public WebDriver driver;

    public RealAPR(WebDriver driver) {
        this.driver = driver;
    }

    public RealAPR waitForPageToLoad() {
        LOGGER.debug("Wait for the page to load");
        ActOn.wait(driver, CalculatorTab).waitForElementToBeVisible();
        return this;
    }
    public RealAPR typeHousePrice(String value) {
        LOGGER.debug("Typing the House price: " + value);
        ActOn.elements(driver, HomePriceInputField).setValue(value);
        return this;
    }

    public RealAPR clickOnDownPaymentInDollar() {
        LOGGER.debug("Clicking on the Down Payment in Dollar");
        ActOn.elements(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealAPR typeDownPayment(String value) {
        LOGGER.debug("Typing the Down Payment: " + value);
        ActOn.elements(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public RealAPR typeInterestRate(String value) {
        LOGGER.debug("Typing the Interest Rate: " + value);
        ActOn.elements(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public RealAPR clickOnTheCalculateButton() {
        ActOn.elements(driver, CalculateRateTab).click();
        return this;
    }

    public RealAPR validateActualRealAPR(String expectedAPRrate) {
        LOGGER.debug("Validate APR rate is: " + expectedAPRrate);
        String actualReaAPRrate = ActOn.elements(driver, ActualAPR).getTextValue();
        Assert.assertEquals(actualReaAPRrate, "3.130%");
        return this;
    }
}
