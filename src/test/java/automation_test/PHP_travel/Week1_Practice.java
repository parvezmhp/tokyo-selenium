package automation_test.PHP_travel;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Week1_Practice {
    WebDriver wav;

    @BeforeMethod
    public void get_wav() {
        WebDriverManager.chromedriver().setup();
        wav = new ChromeDriver();
        wav.get("https://www.mortgagecalculator.org/");
    }

    @Test
    public void WebAddressVerification() {
        String expected_wav = "Mortgage Calculator";
        String actual_wav = wav.getTitle();
        Assert.assertEquals (expected_wav,actual_wav);
    }

    @AfterMethod
    public void close_wav() {
        wav.quit();
    }
}
