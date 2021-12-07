package automation_test.PHP_travel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGWebDriver1 {
    WebDriver driver1;

    @BeforeMethod
    public void LaunchWebPage() {
        WebDriverManager.chromedriver().setup();
        driver1 = new ChromeDriver();
        driver1.get("https://phptravels.com/demo");
           }

    @Test
    public void verifyHomePage() {
        String ExpectedWebAddess = "Demo Script Test drive - PHPTRAVELS";
        String ActualWebAddress = driver1.getTitle();
        Assert.assertEquals(ActualWebAddress, ExpectedWebAddess);
    }

    @AfterMethod
    public void CloseWebPage() {
        driver1.quit();
    }
}
