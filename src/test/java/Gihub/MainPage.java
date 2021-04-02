package Gihub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait waitForForm;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        waitForForm = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
    }

    public void open() {
        driver.get("https://imba.ru/");
        String CurrentUrl = driver.getCurrentUrl();
        assertTrue(CurrentUrl.equals("https://imba.ru/"));

        String title = driver.getTitle();
        assertTrue(title.equals("IMBA — Академия цифрового бизнеса Ingate"));


    }

}
