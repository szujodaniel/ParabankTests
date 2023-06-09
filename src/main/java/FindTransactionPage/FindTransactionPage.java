package FindTransactionPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindTransactionPage {

    WebDriver driver;
    WebDriverWait wait;
    LocalDateTime localDateTime;

    @FindBy(xpath = "//h1[contains(text(), 'Transaction Results')]")
    private WebElement transactionResults;

    @FindBy(linkText = "Find Transactions")
    private WebElement findTransactionsPage;

    @FindBy(id = "criteria.transactionId")
    private WebElement transactionId;

    @FindBy(id = "criteria.onDate")
    private WebElement transactionDate;

    @FindBy(id = "criteria.fromDate")
    private WebElement transactionFromDate;

    @FindBy(id = "criteria.toDate")
    private WebElement transactionToDate;

    @FindBy(id = "criteria.amount")
    private WebElement transactionAmount;

    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/div[3]/button")
    private WebElement transactionIdButton;

    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/div[5]/button")
    private WebElement transactionDateButton;

    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/div[7]/button")
    private WebElement transactionDateRangeButton;

    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/div[9]/button")
    private WebElement transactionAmountButton;

    public FindTransactionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToFindTransactionsPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.findTransactionsPage));
        this.findTransactionsPage.click();
    }

    public void findByTransactionID() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.transactionId));
        this.transactionId.sendKeys("14476");

        this.wait.until(ExpectedConditions.visibilityOf(this.transactionIdButton));
        this.transactionIdButton.click();
    }

    public void findByDate() {
        localDateTime = LocalDateTime.now();
        driver.navigate().refresh();

        String transactionDate = DateTimeFormatter.ofPattern("MM-dd-yyyy").format(localDateTime);

        this.wait.until(ExpectedConditions.visibilityOf(this.transactionDate));
        this.transactionDate.sendKeys(transactionDate);

        this.wait.until(ExpectedConditions.visibilityOf(this.transactionDateButton));
        this.transactionDateButton.click();
    }

    public void findByDateRange() {
        driver.navigate().refresh();

        String transactionDate = DateTimeFormatter.ofPattern("MM-dd-yyyy").format(localDateTime);

        this.wait.until(ExpectedConditions.visibilityOf(this.transactionFromDate));
        this.transactionFromDate.sendKeys(transactionDate);

        this.wait.until(ExpectedConditions.visibilityOf(this.transactionToDate));
        this.transactionToDate.sendKeys(transactionDate);

        this.wait.until(ExpectedConditions.visibilityOf(this.transactionDateRangeButton));
        this.transactionDateRangeButton.click();

    }

    public void findByAmount() {
        driver.navigate().refresh();

        this.wait.until(ExpectedConditions.visibilityOf(this.transactionAmount));
        this.transactionAmount.sendKeys("500");

        this.wait.until(ExpectedConditions.visibilityOf(this.transactionAmountButton));
        this.transactionAmountButton.click();

    }

    public String getTransactionResultsText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.transactionResults));
        return this.transactionResults.getText();
    }
}

