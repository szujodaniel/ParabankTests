package BillPayPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillPayPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Bill Pay")
    private WebElement billPayPage;

    @FindBy(name = "payee.name")
    private WebElement payeeName;

    @FindBy(name = "payee.address.street")
    private WebElement payeeAddress;

    @FindBy(name = "payee.address.city")
    private WebElement payeeCity;

    @FindBy(name = "payee.address.state")
    private WebElement payeeState;

    @FindBy(name = "payee.address.zipCode")
    private WebElement payeeZipCode;

    @FindBy(name = "payee.phoneNumber")
    private WebElement payeePhoneNumber;

    @FindBy(name = "payee.accountNumber")
    private WebElement payeeAccountNumber;

    @FindBy(name = "verifyAccount")
    private WebElement verifyAccount;

    @FindBy(name = "amount")
    private WebElement amount;

    @FindBy(css = "input[value='Send Payment']")
    private WebElement sendPayment;

    @FindBy(css = "option[selected='selected']")
    private WebElement accountId;

    @FindBy(xpath = "//h1[contains(text(), 'Bill Payment Complete')]")
    private WebElement billPaymentCompleteText;




    public BillPayPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToBillPayPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.billPayPage));
        this.billPayPage.click();
    }

    public void enterPayeeInformation(){

        this.wait.until(ExpectedConditions.visibilityOf(this.payeeName));
        this.payeeName.sendKeys("John Doe");
        this.wait.until(ExpectedConditions.visibilityOf(this.payeeAddress));
        this.payeeAddress.sendKeys("Valid Street");
        this.wait.until(ExpectedConditions.visibilityOf(this.payeeCity));
        this.payeeCity.sendKeys("Valid");
        this.wait.until(ExpectedConditions.visibilityOf(this.payeeState));
        this.payeeState.sendKeys("Valid");
        this.wait.until(ExpectedConditions.visibilityOf(this.payeeZipCode));
        this.payeeZipCode.sendKeys("9999");
        this.wait.until(ExpectedConditions.visibilityOf(this.payeePhoneNumber));
        this.payeePhoneNumber.sendKeys("+1 555 777");
        this.wait.until(ExpectedConditions.visibilityOf(this.payeeAccountNumber));
        this.payeeAccountNumber.sendKeys(accountId.getText());
        this.wait.until(ExpectedConditions.visibilityOf(this.verifyAccount));
        this.verifyAccount.sendKeys(accountId.getText());
        this.wait.until(ExpectedConditions.visibilityOf(this.amount));
        this.amount.sendKeys("50");
    }

    public void sendPayment(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.sendPayment));
        this.sendPayment.click();
    }

    public String getBillPaymentCompleteText(){
        this.wait.until(ExpectedConditions.visibilityOf(this.billPaymentCompleteText));
        return this.billPaymentCompleteText.getText();
    }
}
