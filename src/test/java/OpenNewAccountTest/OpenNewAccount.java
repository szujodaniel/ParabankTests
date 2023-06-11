package OpenNewAccountTest;

import AdminPage.AdminPage;
import OpenNewAccountPage.OpenNewAccountPage;
import RegisterPage.RegisterPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccount extends DriverBase {

    @Test
    public void openNewAccount() throws InterruptedException {

        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver, wait);

        adminPage.accountDataClean();
        String dataBaseCleanedText = adminPage.getDatabaseCleanedText();
        Assert.assertEquals(dataBaseCleanedText, "Database Cleaned");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");

        openNewAccountPage.checkingAccount();
        String accountOpenedText = openNewAccountPage.getAccountOpenedText();
        Assert.assertEquals(accountOpenedText, "Congratulations, your account is now open.");
        System.out.println("New Checking account opened.");

        openNewAccountPage.savingsAccount();
        Assert.assertEquals(accountOpenedText, "Congratulations, your account is now open.");
        System.out.println("New Savings account opened.");
    }
}
