package Gihub;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class SignUpTest extends DriverSettings {

    @Test
    public void signUp () {
        //open website and check title
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        //negative sign in test without e-mail
        SignIn signIn = PageFactory.initElements(driver, SignIn.class);
        signIn.signInForm();

        signIn.passwordSet("12345");
        signIn.signInButton();
        signIn.checkErrorMessage();
        signIn.authLink();

        //negative authentication test without e-mail
        Auth auth = PageFactory.initElements(driver, Auth.class);
        auth.openForm();

        auth.fillInFirstName("User");
        auth.fillInNumberPhone("+79110009090");
        auth.fillInPassword("12345678");
        auth.confirmPassword("12345678");
        auth.choiceProf();
        auth.professionSet();
        auth.buttonReg();
}
}
