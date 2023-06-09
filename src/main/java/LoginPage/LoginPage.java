package LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "input[type='submit']")
    private WebElement logInButton;

    @FindBy(className = "error")
    private WebElement error;

    @FindBy(linkText = "Accounts Overview")
    private WebElement accountsOverview;

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage(){

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        System.out.println("Login page loaded successfully.");
    }

    public void emptyUsernameEmptyPassword(String username, String password){
        this.wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.sendKeys(username);
        this.wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.sendKeys(password);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.logInButton));
        this.logInButton.click();

    }

    public void wrongUsernameWrongPassword(String wrongUsername, String wrongPassword){
        this.wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.sendKeys(wrongUsername);
        this.wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.sendKeys(wrongPassword);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.logInButton));
        this.logInButton.click();

    }

    public void validUsernameValidPassword(String validUsername, String validPassword){
        this.wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.sendKeys(validUsername);
        this.wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.sendKeys(validPassword);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.logInButton));
        this.logInButton.click();

    }

    public String getError(){
        this.wait.until(ExpectedConditions.visibilityOf(this.error));
        return this.error.getText();
    }

    public String getAccountOverviewText(){
        this.wait.until(ExpectedConditions.visibilityOf(this.accountsOverview));
        return this.accountsOverview.getText();
    }

}
