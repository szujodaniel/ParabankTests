package AccountOverviewTest;

import AccountOverviewPage.AccountOverviewPage;
import AdminPage.AdminPage;
import RegisterPage.RegisterPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountOverview extends DriverBase {

    @Test
    public void accountOverview(){
        AdminPage adminPage = new AdminPage(driver,wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        AccountOverviewPage accountOverviewPage = new AccountOverviewPage(driver, wait);

        adminPage.accountDataClear();
        String dataBaseCleanedText = adminPage.getDatabaseCleanedText();
        Assert.assertEquals(dataBaseCleanedText, "Database Cleaned.");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");

        accountOverviewPage.goToAccountOverviewPage();
        accountOverviewPage.chooseAccountNumber();
        String accountNumberText = accountOverviewPage.getAccountTypeText();
        Assert.assertEquals(accountNumberText, "CHECKING");
        System.out.println("Account overviewed successfully");
    }
}
