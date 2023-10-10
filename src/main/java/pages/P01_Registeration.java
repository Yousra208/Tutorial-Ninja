package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_Registeration {
WebDriver driver;
    public P01_Registeration(WebDriver driver){
        this.driver=driver;
    }

    private final By myAccount = By.xpath("//span[text()='My Account']");
    final private By registration=By.xpath("//a[text()='Register']");
    final private By firstName=By.xpath("//input[@name='firstname']");
    final private By lastName=By.xpath("//input[@name='lastname']");
    final private By email=By.xpath("//input[@name='email']");
    final private By phone=By.xpath("//input[@name='telephone']");
    final private By password=By.xpath("//input[@name='password']");
    final private By confirmPassword=By.xpath("//input[@name='confirm']");
    final private By checkbox = By.xpath("//input[@name='agree']");
    final private By continueButton=By.xpath("//input[@value='Continue']");
    private final By successRegisteration = By.xpath("//a[text()='Success']");


    public P01_Registeration clickOnMyAccount() {
        driver.findElement(myAccount).click();
        return this;
    }

    public P01_Registeration clickOnRegistrationPage() {
        driver.findElement(registration).click();
        return this;
    }
    public P01_Registeration addFirstName(String first_Name) {
        driver.findElement(firstName).sendKeys(first_Name);
        return this;
    }
    public P01_Registeration addLastName(String last_Name) {
        driver.findElement(lastName).sendKeys(last_Name);
        return this;
    }

    public P01_Registeration addEmail(String Email) {
        driver.findElement(email).sendKeys(Email);
        return this;
    }

    public P01_Registeration addPhone(String Phone) {
        driver.findElement(phone).sendKeys(Phone);

        return this;
    }

    public P01_Registeration addPassword(String Password) {
        driver.findElement(password).sendKeys(Password);

        return this;
    }

    public P01_Registeration addConfirmPassword(String confirm_Password) {
        driver.findElement(confirmPassword).sendKeys(confirm_Password);

        return this;
    }

    public P01_Registeration checkCheckbox() {
        driver.findElement(checkbox).click();
        return this;
    }

    public P01_Registeration clickContinueButton() {
        driver.findElement(continueButton).click();
        return this;
    }
    public boolean confirmRegisterationSuccessfully() {
        return driver.findElement(this.successRegisteration).isDisplayed();
    }
}
