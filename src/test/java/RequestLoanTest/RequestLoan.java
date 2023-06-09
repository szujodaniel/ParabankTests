package RequestLoanTest;

import AdminPage.AdminPage;
import RegisterPage.RegisterPage;
import RequestLoanPage.RequestLoanPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;

import static Utilities.GetDataFromExcel.*;

public class RequestLoan extends DriverBase {

    @DataProvider
    static Iterator<Object[]> getDownPaymentData() throws IOException {
        return downPaymentData().iterator();
    }

    @DataProvider
    static Iterator<Object[]> getAvailableFundsData() throws IOException {
        return availableFundsData().iterator();
    }

    @DataProvider
    static Iterator<Object[]> getCombinedData() throws IOException {
        return combinedData().iterator();
    }


    @Test(dataProvider = "getDownPaymentData",priority = 1)
    public void downPayment(String amount) {
        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver, wait);

        adminPage.adminPageSetupDownPayment();
        String adminPageStatus = adminPage.getSettingSavedText();
        Assert.assertEquals(adminPageStatus, "Settings saved successfully.");
        System.out.println("Settings saved successfully.");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");

        requestLoanPage.goToRequestLoanPage();
        requestLoanPage.addLoanAmount("1000");
        requestLoanPage.addDownPayment(amount);
        requestLoanPage.applyNow();
        String status = requestLoanPage.getStatusText();
        if (amount.equalsIgnoreCase("500") || amount.equalsIgnoreCase("501")) {
            Assert.assertEquals(status, "Approved");
        } else {
            Assert.assertEquals(status, "Denied");
        }
    }

    @Test(dataProvider = "getAvailableFundsData",priority = 3)
    public void availableFunds(String amount) {
        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver, wait);

        adminPage.adminPageSetupAvailableFunds();
        String adminPageStatus = adminPage.getSettingSavedText();
        Assert.assertEquals(adminPageStatus, "Settings saved successfully.");
        System.out.println("Settings saved successfully.");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");

        requestLoanPage.goToRequestLoanPage();
        requestLoanPage.addLoanAmount("1000");
        requestLoanPage.addDownPayment(amount);
        requestLoanPage.applyNow();
        String status = requestLoanPage.getStatusText();
        if (amount.equalsIgnoreCase("1000")) {
            Assert.assertEquals(status, "Approved");
        } else {
            Assert.assertEquals(status, "Denied");
        }
    }

    @Test(dataProvider = "getCombinedData",priority = 2)
    public void combined(String amount) {
        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver, wait);

        adminPage.adminPageSetupCombined();
        String adminPageStatus = adminPage.getSettingSavedText();
        Assert.assertEquals(adminPageStatus, "Settings saved successfully.");
        System.out.println("Settings saved successfully.");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");

        requestLoanPage.goToRequestLoanPage();
        requestLoanPage.addLoanAmount("1000");
        requestLoanPage.addDownPayment(amount);
        requestLoanPage.applyNow();
        String status = requestLoanPage.getStatusText();
        if (amount.equalsIgnoreCase("1000") || amount.equalsIgnoreCase("500")) {
            Assert.assertEquals(status, "Approved");
        } else {
            Assert.assertEquals(status, "Denied");
        }
    }
}