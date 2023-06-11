package BillPayTest;

import AdminPage.AdminPage;
import BillPayPage.BillPayPage;
import RegisterPage.RegisterPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillPay extends DriverBase {

    @Test
    public void billPay() throws InterruptedException {

        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        BillPayPage billPayPage = new BillPayPage(driver, wait);

        adminPage.accountDataClean();
        String dataBaseCleanedText = adminPage.getDatabaseCleanedText();
        Assert.assertEquals(dataBaseCleanedText, "Database Cleaned");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");

        billPayPage.goToBillPayPage();
        billPayPage.enterPayeeInformation();
        billPayPage.sendPayment();
        String billPayText = billPayPage.getBillPaymentCompleteText();
        Assert.assertEquals(billPayText, "Bill Payment Complete");
        System.out.println("Bill Payment Completed.");
    }
}
