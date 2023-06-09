package RegisterPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;

    @FindBy(id = "customer.address.city")
    private WebElement city;

    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @FindBy(id = "customer.username")
    private WebElement username;

    @FindBy(id = "customer.password")
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    private WebElement repeatPassword;

    @FindBy(css = "input[value='Register']")
    private WebElement registerButton;

    @FindBy(className = "title")
    private WebElement welcomeText;

    @FindBy(linkText = "Log Out")
    private WebElement logOut;

    public RegisterPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToRegisterPage(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("Login page loaded successfully.");
    }

    public void registration(){

        this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
        this.firstName.sendKeys("John");
        this.wait.until(ExpectedConditions.visibilityOf(this.lastName));
        this.lastName.sendKeys("Doe");
        this.wait.until(ExpectedConditions.visibilityOf(this.address));
        this.address.sendKeys("Valid Street");
        this.wait.until(ExpectedConditions.visibilityOf(this.city));
        this.city.sendKeys("Valid");
        this.wait.until(ExpectedConditions.visibilityOf(this.state));
        this.state.sendKeys("Valid");
        this.wait.until(ExpectedConditions.visibilityOf(this.zipCode));
        this.zipCode.sendKeys("9999");
        this.wait.until(ExpectedConditions.visibilityOf(this.phoneNumber));
        this.phoneNumber.sendKeys("+1 555 777");
        this.wait.until(ExpectedConditions.visibilityOf(this.ssn));
        this.ssn.sendKeys("valid");
        this.wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.sendKeys("valid");
        this.wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.sendKeys("valid");
        this.wait.until(ExpectedConditions.visibilityOf(this.repeatPassword));
        this.repeatPassword.sendKeys("valid");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.registerButton));
        this.registerButton.click();

        System.out.println("New account registered.");
    }
    public String getWelcomeText(){
        return this.welcomeText.getText();
    }

    public void logOut(){
        this.wait.until(ExpectedConditions.visibilityOf(this.logOut));
        this.logOut.click();
    }
}
