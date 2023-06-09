package TransferFundsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Transfer Funds")
    private WebElement transferFundPage;

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountId;

    @FindBy(id = "toAccountId")
    private WebElement toAccountId;

    @FindBy(css = "input[value='Transfer']")
    private WebElement transferButton;

    @FindBy(xpath = "//h1[contains(text(), 'Transfer Complete!')]")
    private WebElement transferCompleteText;

    public TransferFundsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToTransferFundPage() throws InterruptedException {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.transferFundPage));
        this.transferFundPage.click();

    }

    public void amount() throws InterruptedException {
        Select selectFromAccount = new Select(this.fromAccountId);
        Select selectToAccount = new Select(toAccountId);

        this.wait.until(ExpectedConditions.elementToBeClickable(this.fromAccountId));
        this.wait.until(ExpectedConditions.elementToBeClickable(this.toAccountId));
        selectFromAccount.selectByValue("13455");
        selectToAccount.selectByValue("13455");

        this.wait.until(ExpectedConditions.visibilityOf(this.amount));
        this.amount.sendKeys("500");

    }

    public void transferButtonClick() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.transferButton));
        this.transferButton.click();
    }

    public String getTransferCompleteText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.transferCompleteText));
        return this.transferCompleteText.getText();
    }
}
