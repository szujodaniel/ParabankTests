package OpenNewAccountPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Open New Account")
    private WebElement openNewAccount;

    @FindBy(id = "type")
    private WebElement accountType;

    @FindBy(css = "input[value='Open New Account']")
    private WebElement openNewAccountButton;

    @FindBy(xpath = "//p[contains(text(), 'Congratulations')]")
    private WebElement accountOpened;

    Select selectType;

    public OpenNewAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void checkingAccount() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.openNewAccount));
        this.openNewAccount.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.accountType));
        Select selectType = new Select(this.accountType);
        selectType.selectByValue("0");
        Thread.sleep(1000);
        this.openNewAccountButton.click();
    }

    public void savingsAccount() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.openNewAccount));
        this.openNewAccount.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.accountType));
        selectType = new Select(this.accountType);
        selectType.selectByValue("1");
        Thread.sleep(1000);
        this.openNewAccountButton.click();
    }

    public String getAccountOpenedText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.accountOpened));
        return this.accountOpened.getText();
    }
}

