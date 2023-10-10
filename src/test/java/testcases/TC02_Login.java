package testcases;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P02_Login;
import utility.Utilities;

import static testcases.TC01_Registeration.Email;
import static testcases.TC01_Registeration.Password;

@Epic("User Login")
@Story("Check User login with valid email and password")

public class TC02_Login extends Test_Base {

    @Test(priority = 1, description = "user login with valid email and password")
    public void LoginWithValidEmailAndPassword_P() {
        new P02_Login(driver).clickOnMyAccount().clickOnLogin().addEmail(Email).addPassword(Password).clickLoginButton();
        Utilities.captureScreenshot(driver, "login_P");
        Assert.assertTrue(new P02_Login(driver).confirmLoginSuccessfully());
    }

}
