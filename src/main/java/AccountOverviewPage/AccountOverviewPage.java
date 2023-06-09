package AccountOverviewPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountOverviewPage {
   private WebDriver driver;
   private WebDriverWait wait;

   @FindBy(linkText = "Accounts Overview")
   private WebElement accountOverviewPage;

    @FindBy(linkText = "13455")
    private WebElement accountNumber;

    @FindBy(xpath = "//td[contains(text(), 'CHECKING')]")
    private WebElement accountType;

    public AccountOverviewPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToAccountOverviewPage(){
    this.wait.until(ExpectedConditions.elementToBeClickable(this.accountOverviewPage));
    this.accountOverviewPage.click();
    }

    public void chooseAccountNumber(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.accountNumber));
        this.accountNumber.click();
    }

    public String getAccountTypeText(){
        this.wait.until(ExpectedConditions.visibilityOf(this.accountType));
        return this.accountType.getText();
    }
}
