package Gihub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Auth {
    private WebDriver driver;
    private WebDriverWait waitForForm;

    public Auth (WebDriver driver) {
        this.driver = driver;
        waitForForm = new WebDriverWait (driver, 30);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
    }
    @FindBy(id = "top")
    private WebElement header;
    private By phoneBlockButton = By.xpath("//*[@id=\"phone-block\"]/div[2]/a");
    private By formSignup = By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/form");

    @FindBy (id = "name")
    private WebElement nameFirst;

    @FindBy (name="phone")
    private WebElement phoneNumber;

    @FindBy (id = "password")
    private WebElement userPassword;

    @FindBy (id = "confirm_password")
    private WebElement confirmPassword;

    @FindBy (name = "profession")
    private WebElement choiceProf;

    @FindBy (xpath = "//*[@id=\"wrapwrap\"]/main/div[1]/form/div[6]/div/select/option[3]")
    private WebElement professionSet;

    @FindBy (xpath = "/html/body/div[1]/main/div[1]/form/div[7]/button")
    private WebElement buttonReg;


    public void openForm () {
        header.findElement(phoneBlockButton).click();
        waitForForm.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(formSignup));
    }

    public void fillInFirstName (String firstName) {
        nameFirst.sendKeys("firstName");
    }

    public void fillInNumberPhone (String numberPhone) {
        phoneNumber.sendKeys("+79110009090");
    }

    public void fillInPassword (String password) {
        userPassword.sendKeys("12345678");
    }

    public void confirmPassword (String passwordConfirm) {
        confirmPassword.sendKeys("12345678");
    }

    public void choiceProf () {
        choiceProf.click();
    }

    public void professionSet () {
        professionSet.click();
    }

    public void buttonReg () {
        if (buttonReg.isEnabled()) buttonReg.click();
    }
}

