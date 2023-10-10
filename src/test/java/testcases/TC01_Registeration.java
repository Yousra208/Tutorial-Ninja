package testcases;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_Registeration;
import utility.Utilities;

@Epic("New User Registeration")
@Story("Check New user Registeration")

public class TC01_Registeration extends Test_Base {

    static Faker faker = new Faker();
    static final String First_Name = faker.name().firstName();
    static final String Last_Name = faker.name().lastName();
    static final String Phone = faker.phoneNumber().cellPhone();
    static final String Password = faker.internet().password();
    static final String Email = faker.internet().emailAddress();
    static final String confirmPassword = Password;

    @Test(priority = 1, description = "New user Registeration")
    @Severity(SeverityLevel.CRITICAL)
    public void Registeration_P() {
        new P01_Registeration(driver).clickOnMyAccount().clickOnRegistrationPage().addFirstName(First_Name).addLastName(Last_Name).addEmail(Email).addPhone(Phone).addPassword(Password).addConfirmPassword(confirmPassword).checkCheckbox().clickContinueButton();
        Utilities.captureScreenshot(driver, "registration_P");
        Assert.assertTrue(new P01_Registeration(driver).confirmRegisterationSuccessfully());

    }

}
