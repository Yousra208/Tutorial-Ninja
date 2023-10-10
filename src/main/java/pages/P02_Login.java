package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login {
    WebDriver driver;
    public P02_Login(WebDriver driver){
        this.driver=driver;
    }

    private final By myAccount = By.xpath("//span[text()='My Account']");
    private final By login = By.xpath("//a[text()='Login']");
    private final By email = By.xpath("//input[@name='email']");
    private final By password = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//input[@value='Login']");
    final private By successLogin = By.xpath("//a[text()='Edit your account information']");

    public P02_Login clickOnMyAccount() {
        driver.findElement(myAccount).click();
        return this;
    }

    public P02_Login clickOnLogin() {
        driver.findElement(login).click();
        return this;
    }

    public P02_Login addEmail(String Email) {
        driver.findElement(email).sendKeys(Email);
        return this;
    }

    public P02_Login addPassword(String Password) {
        driver.findElement(password).sendKeys(Password);
        return this;
    }

    public P02_Login clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }
    public boolean confirmLoginSuccessfully() {
        return driver.findElement(this.successLogin).isDisplayed();
    }
}
