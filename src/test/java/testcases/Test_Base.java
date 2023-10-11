package testcases;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static drivers.DriverHolder.setDriver;


public class Test_Base {
    WebDriver driver;

    @Parameters("browser")
    @BeforeTest()
    public void setupDriver(String browser) throws InterruptedException {

        driver= DriverFactory.getNewInstance(browser);
        setDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();

    }
   @AfterTest
   public void quit(){
       driver.quit();
   }
}
