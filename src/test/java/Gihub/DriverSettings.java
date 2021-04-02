package Gihub;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverSettings {

    public WebDriver driver;
    public WebDriverWait waitForForm;

    @Before
    public void openUp () {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        waitForForm = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
    }

    @After
    public void closeBrowser () {
        driver.quit();
    }
}
