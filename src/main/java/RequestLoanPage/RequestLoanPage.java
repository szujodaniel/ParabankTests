package RequestLoanPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestLoanPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Request Loan")
    private WebElement requestLoanPage;

    @FindBy(id = "amount")
    private WebElement loanAmount;

    @FindBy(id = "downPayment")
    private WebElement downPayment;

    @FindBy(css = "input[value='Apply Now']")
    private WebElement applyNowButton;

    @FindBy(id = "loanStatus")
    private WebElement loanStatus;

    @FindBy(className = "error")
    private WebElement errorText;



    public RequestLoanPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToRequestLoanPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.requestLoanPage));
        this.requestLoanPage.click();

    }

    public void addLoanAmount(String amount){
        this.wait.until(ExpectedConditions.visibilityOf(this.loanAmount));
        this.loanAmount.sendKeys(amount);
    }

    public void addDownPayment(String amount){
        this.wait.until(ExpectedConditions.visibilityOf(this.downPayment));
        this.downPayment.sendKeys(amount);
    }

    public void applyNow(){
        this.wait.until(ExpectedConditions.visibilityOf(this.applyNowButton));
        this.applyNowButton.click();
    }

    public String getStatusText(){
        this.wait.until(ExpectedConditions.visibilityOf(this.loanStatus));
        return this.loanStatus.getText();
    }

    public String getErrorText(){
        this.wait.until(ExpectedConditions.visibilityOf(this.errorText));
        return this.errorText.getText();
    }



}
