package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void driverSetup() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

      //  ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--headless", "--window-size=1920,1200");

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        System.out.println("Driver Started");
    }

    @AfterMethod
    public void driverQuit() {
        driver.quit();
        System.out.println("Driver stopped");
    }

}
