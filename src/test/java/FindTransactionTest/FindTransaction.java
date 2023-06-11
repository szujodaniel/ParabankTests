package FindTransactionTest;

import AdminPage.AdminPage;
import FindTransactionPage.FindTransactionPage;
import RegisterPage.RegisterPage;
import TransferFundsPage.TransferFundsPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTransaction extends DriverBase {

    @Test
    public void findTransactions() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver, wait);
        FindTransactionPage findTransactionPage = new FindTransactionPage(driver, wait);

        adminPage.accountDataClean();
        String dataBaseCleanedText = adminPage.getDatabaseCleanedText();
        Assert.assertEquals(dataBaseCleanedText, "Database Cleaned");

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
        System.out.println("Transfer Completed.");

        findTransactionPage.goToFindTransactionsPage();

        findTransactionPage.findByTransactionID();
        String transactionsResultsText = findTransactionPage.getTransactionResultsText();
        Assert.assertEquals(transactionsResultsText, "Transaction Results");
        System.out.println("Transaction found by ID.");

        findTransactionPage.findByDate();
        Assert.assertEquals(transactionsResultsText, "Transaction Results");
        System.out.println("Transaction found by Date.");

        findTransactionPage.findByDateRange();
        Assert.assertEquals(transactionsResultsText, "Transaction Results");
        System.out.println("Transaction found by Date range.");

        findTransactionPage.findByAmount();
        Assert.assertEquals(transactionsResultsText, "Transaction Results");
        System.out.println("Transaction found by amount.");
    }
}
