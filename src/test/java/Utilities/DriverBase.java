package Utilities;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class DriverBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    public void driverSetup()  {

        WebDriverManager.getInstance(CHROME).setup();

        List<String> options = new ArrayList<>();
        options.add("--disable-extensions");
        options.add("--headless");
        options.add("--disable-gpu");
        options.add("--no-sandbox");
        options.add("--incognito");
        options.add("--disable-application-cache");
        options.add("--disable-dev-shm-usage");

        ChromeOptions option = new ChromeOptions();
        option.addArguments(options);

        driver = new ChromeDriver(option);

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
