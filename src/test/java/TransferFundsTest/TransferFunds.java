package TransferFundsTest;

import AdminPage.AdminPage;
import RegisterPage.RegisterPage;
import TransferFundsPage.TransferFundsPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFunds extends DriverBase {

    @Test
    public void transferFunds() throws InterruptedException {

        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver, wait);

        adminPage.accountDataClear();
        String dataBaseCleanedText = adminPage.getDatabaseCleanedText();
        Assert.assertEquals(dataBaseCleanedText, "Database Cleaned.");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");

        transferFundsPage.goToTransferFundPage();
        transferFundsPage.amount();
        transferFundsPage.transferButtonClick();
        String transferCompleteText = transferFundsPage.getTransferCompleteText();
        Assert.assertEquals(transferCompleteText, "Transfer Complete!");
        System.out.println("Transfer Completed!");

    }
}
