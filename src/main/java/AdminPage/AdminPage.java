package AdminPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//b[contains(text(), 'Database Cleaned')]")
    private WebElement dataBaseCleaned;

    @FindBy(css = "button[value='CLEAN']")
    private WebElement clear;

    @FindBy(xpath = "//*[text()='Running']")
    private WebElement running;

    @FindBy(css = "input[value='Startup']")
    private WebElement startup;

    @FindBy(css = "input[value='jdbc']")
    private WebElement databaseType;

    @FindBy(id = "soapEndpoint")
    private WebElement soapEndpoint;

    @FindBy(id = "restEndpoint")
    private WebElement restEndpoint;

    @FindBy(id = "endpoint")
    private WebElement endpoint;

    @FindBy(id = "initialBalance")
    private WebElement initBalance;

    @FindBy(id = "minimumBalance")
    private WebElement minimumBalance;

    @FindBy(id = "loanProvider")
    private WebElement loanProvider;

    @FindBy(id = "loanProcessor")
    private WebElement loanProcessor;

    @FindBy(id = "loanProcessorThreshold")
    private WebElement loanProcessorThreshold;

    @FindBy(css = "input[value='Submit']" )
    private WebElement submitButton;

    @FindBy(css = "p[style='color: #080']" )
    private WebElement settingsSaved;

   private Select loanProviderSelect;

   private Select loanProcessorSelect;


    public AdminPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void accountDataClean(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");

        // Check the server status (Running or Stopped)
        if (this.running.isDisplayed()) {
            System.out.println("Server is Running.");
        } else {
            this.wait.until(ExpectedConditions.elementToBeClickable(startup));
            startup.click();
            System.out.println("Server changed to Running.");
        }
        this.wait.until(ExpectedConditions.elementToBeClickable(this.clear));
        this.clear.click();
        System.out.println("Database cleared.");
    }

    public void adminPageSetupDownPayment() {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");

        // Check the server status (Running or Stopped)
        if (this.running.isDisplayed()) {
            System.out.println("Server is Running.");
        } else {
            this.wait.until(ExpectedConditions.elementToBeClickable(this.startup));
            this.startup.click();
            System.out.println("Server changed to Running.");
        }

        // Clear the Database
        this.wait.until(ExpectedConditions.elementToBeClickable(this.clear));
        this.clear.click();
        System.out.println("Database cleared.");

        // Choose Database type (JDBC)
        this.wait.until(ExpectedConditions.elementToBeClickable(this.databaseType));
        this.databaseType.click();
        System.out.println("JDBC database is set.");

        // Clear the endpoints (Web service)
        List<WebElement> webService = driver.findElements(By.className("inputLarge"));
        for (int i = 0; i < webService.size(); i++) {
            webService.get(i).clear();
        }
        System.out.println("Endpoints cleared.");

        // Set Application Settings
        this.wait.until(ExpectedConditions.visibilityOf(this.initBalance));
        this.initBalance.clear();
        this.initBalance.sendKeys("1000");

        this.wait.until(ExpectedConditions.visibilityOf(this.minimumBalance));
        this.minimumBalance.clear();
        this.minimumBalance.sendKeys("1000");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProvider));
        this.loanProviderSelect = new Select(loanProvider);
        this.loanProviderSelect.selectByVisibleText("Local");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProcessor));
        this.loanProcessorSelect = new Select(loanProcessor);
        this.loanProcessorSelect.selectByVisibleText("Down Payment");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProcessorThreshold));
        this.loanProcessorThreshold.clear();
        this.loanProcessorThreshold.sendKeys("50");

        this.wait.until(ExpectedConditions.elementToBeClickable(this.submitButton));
        this.submitButton.click();

        System.out.println("Application set to Down Payment.");
    }

    public void adminPageSetupCombined(){

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");

        // Check the server status (Running or Stopped)
        if (this.running.isDisplayed()) {
            System.out.println("Server is Running.");
        } else {
            this.wait.until(ExpectedConditions.elementToBeClickable(this.startup));
            this.startup.click();
            System.out.println("Server changed to Running.");
        }

        // Clear the Database
        this.wait.until(ExpectedConditions.elementToBeClickable(this.clear));
        this.clear.click();
        System.out.println("Database cleared.");

        // Choose Database type (JDBC)
        this.wait.until(ExpectedConditions.elementToBeClickable(this.databaseType));
        this.databaseType.click();
        System.out.println("JDBC database is set.");

        // Clear the endpoints (Web service)
        List<WebElement> webService = driver.findElements(By.className("inputLarge"));
        for (int i = 0; i < webService.size(); i++) {
            webService.get(i).clear();
        }
        System.out.println("Endpoints cleared.");

        // Set Application Settings
        this.wait.until(ExpectedConditions.visibilityOf(this.initBalance));
        this.initBalance.clear();
        this.initBalance.sendKeys("1000");

        this.wait.until(ExpectedConditions.visibilityOf(this.minimumBalance));
        this.minimumBalance.clear();
        this.minimumBalance.sendKeys("1000");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProvider));
        this.loanProviderSelect = new Select(loanProvider);
        this.loanProviderSelect.selectByVisibleText("Local");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProcessor));
        this.loanProcessorSelect = new Select(this.loanProcessor);
        this.loanProcessorSelect.selectByVisibleText("Combined");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProcessorThreshold));
        this.loanProcessorThreshold.clear();
        this.loanProcessorThreshold.sendKeys("50");

        this.wait.until(ExpectedConditions.elementToBeClickable(this.submitButton));
        this.submitButton.click();

        System.out.println("Application is set to Combined.");

    }

    public void adminPageSetupAvailableFunds(){

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");

        // Check the server status (Running or Stopped)
        if (this.running.isDisplayed()) {
            System.out.println("Server is Running.");
        } else {
            this.wait.until(ExpectedConditions.elementToBeClickable(this.startup));
            this.startup.click();
            System.out.println("Server changed to Running.");
        }

        // Clear the Database
        this.wait.until(ExpectedConditions.elementToBeClickable(this.clear));
        this.clear.click();
        System.out.println("Database cleared.");

        // Choose Database type (JDBC)
        this.wait.until(ExpectedConditions.elementToBeClickable(this.databaseType));
        this.databaseType.click();
        System.out.println("JDBC database is set.");

        // Clear the endpoints (Web service)
        List<WebElement> webService = driver.findElements(By.className("inputLarge"));
        for (int i = 0; i < webService.size(); i++) {
            webService.get(i).clear();
        }
        System.out.println("Endpoints cleared.");

        // Set Application Settings

        this.wait.until(ExpectedConditions.visibilityOf(this.initBalance));
        this.initBalance.clear();
        this.initBalance.sendKeys("1000");

        this.wait.until(ExpectedConditions.visibilityOf(this.minimumBalance));
        this.minimumBalance.clear();
        this.minimumBalance.sendKeys("1000");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProvider));
        this.loanProviderSelect = new Select(this.loanProvider);
        this.loanProviderSelect.selectByVisibleText("Local");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProcessor));
        this.loanProcessorSelect = new Select(this.loanProcessor);
        this.loanProcessorSelect.selectByVisibleText("Available Funds");

        this.wait.until(ExpectedConditions.visibilityOf(this.loanProcessorThreshold));
        this.loanProcessorThreshold.clear();
        this.loanProcessorThreshold.sendKeys("50");

        this.wait.until(ExpectedConditions.elementToBeClickable(this.submitButton));
        this.submitButton.click();

        System.out.println("Application set to Available Funds.");
    }

    public String getSettingSavedText(){
        return this.settingsSaved.getText();
    }
    public String getDatabaseCleanedText(){
        return this.dataBaseCleaned.getText();
    }
}

