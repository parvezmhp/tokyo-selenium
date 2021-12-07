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
import utilities.DateUtils;
import utilities.ReadConfigFiles;
import utilities.SqlConnector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateMortgageRateParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMortgageRateParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("------------Test Name: CalculateMonthly Payment-----------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test
    public void calculateMonthlyPayment() {
        String date = DateUtils.returnNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];

        try {
            ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
            while (rs.next()) {
                new NavigationBar(driver)
                        .navigateToHome()
                        .typeHomePrice(rs.getString("homevalue"))
                        .typeDownPayment(rs.getString("downpayment"))
                        .clickOnDownPaymentInDollar()
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTermYears(rs.getString("loanterm"))
                        .selectMonth(month)
                        .selectYear(year)
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePMIRate(rs.getString("PMI"))
                        .typeHOIAmount(rs.getString("HOI"))
                        .typeHOAAmount(rs.getString("HOA"))
                        .selectLoanType(rs.getString("FHA"))
                        .selectPurchaseOption(rs.getString("Buy"))
                        .clickCalculateButton()
                        .validateTotalMonthlyPayment(rs.getString("TotalMonthlyPayment"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @AfterMethod
    public void quitBrowser() {
        LOGGER.info("---------End Test Case: Calculate Monthly Payment-------");
        ActOn.browser(driver).close();
    }
}
