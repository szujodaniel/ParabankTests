package RegisterTest;

import AdminPage.AdminPage;
import RegisterPage.RegisterPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register extends DriverBase {

    @Test
    public void register(){
        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);

        adminPage.accountDataClear();
        String dataBaseCleanedText = adminPage.getDatabaseCleanedText();
        Assert.assertEquals(dataBaseCleanedText, "Database Cleaned.");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");
    }
}
