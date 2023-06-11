package Utilities;


import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class DriverBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    public void driverSetup()  {

        WebDriverManager.getInstance(CHROME).setup();

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        System.out.println("Driver Started.");
    }
    @AfterTest
    public void driverQuit() {
        driver.quit();
        System.out.println("Driver stopped.");
    }
}
