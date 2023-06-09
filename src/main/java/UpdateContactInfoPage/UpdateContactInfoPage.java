package UpdateContactInfoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateContactInfoPage {

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

    @FindBy(css = "input[value='Update Profile")
    private WebElement updateProfileButton;

    @FindBy(linkText = "Update Contact Info")
    private WebElement updateContactInfoPage;

    @FindBy(xpath = "//*[text()='Profile Updated']")
    private WebElement profileUpdatedText;

    public UpdateContactInfoPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToUpdateContactInfoPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.updateContactInfoPage));
        this.updateContactInfoPage.click();
    }

    public void updateProfile(){
        this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
        this.firstName.sendKeys("Jim");
        this.wait.until(ExpectedConditions.visibilityOf(this.lastName));
        this.lastName.sendKeys("Derry");
        this.wait.until(ExpectedConditions.visibilityOf(this.address));
        this.address.sendKeys("Derry Street");
        this.wait.until(ExpectedConditions.visibilityOf(this.city));
        this.city.sendKeys("Small");
        this.wait.until(ExpectedConditions.visibilityOf(this.state));
        this.state.sendKeys("Valid");
        this.wait.until(ExpectedConditions.visibilityOf(this.zipCode));
        this.zipCode.sendKeys("9999");
        this.wait.until(ExpectedConditions.visibilityOf(this.phoneNumber));
        this.phoneNumber.sendKeys("+1 555 888");
    }

    public void updateProfileButton(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.updateProfileButton));
        this.updateProfileButton.click();
    }

    public String getProfileUpdatedText(){
        this.wait.until(ExpectedConditions.visibilityOf(profileUpdatedText));
        return profileUpdatedText.getText();
    }
}
