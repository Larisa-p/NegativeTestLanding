package Gihub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SignIn {
    private WebDriver driver;
    private WebDriverWait waitForForm;

    public SignIn (WebDriver driver) {
        this.driver = driver;
        waitForForm = new WebDriverWait (driver, 30);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
    }

    @FindBy (id = "top")
    private WebElement header;
    private By signInButton = By.xpath("//*[@id=\"phone-block\"]/div[3]/a");
    private By formSignIn = By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/form");

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (xpath = "//*[@id=\"wrapwrap\"]/main/div[1]/form/div[3]/button")
    private WebElement buttonSignIn;
    private By errorMessage = By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/form/p");

    @FindBy (xpath = "//*[@id=\"wrapwrap\"]/main/div[1]/form/div[3]/div[1]/a[1]")
    private WebElement linkToAuth;

    public void signInForm () {
        header.findElement(signInButton).click();
        waitForForm.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(formSignIn));
    }
    public void passwordSet (String passwordText) {
        password.sendKeys("12345");
    }
    public void signInButton () {
        buttonSignIn.click();
    }

    public void checkErrorMessage () {
        waitForForm.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMessage));
    }

    public void authLink () {
        System.out.println(linkToAuth.getText());
        linkToAuth.click();
    }
}

