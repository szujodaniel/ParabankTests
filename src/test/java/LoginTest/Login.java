package LoginTest;

import AdminPage.AdminPage;
import LoginPage.LoginPage;
import RegisterPage.RegisterPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends DriverBase {


    @Test(description = "Empty username/password variations")
    @Parameters({"username", "password"})
    public void loginEmpty(String username, String password) {

        AdminPage adminPage = new AdminPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);

        adminPage.setup();
        String adminPageStatus = adminPage.getSettingSavedText();
        Assert.assertEquals(adminPageStatus, "Settings saved successfully.");
        System.out.println("Settings saved successfully.");

        loginPage.goToLoginPage();
        loginPage.emptyUsernameEmptyPassword(username, password);
        String actualErrorText = loginPage.getError();
        Assert.assertEquals(actualErrorText, "Please enter a username and password.");
        System.out.println("Login proceed successfully.");
    }

    @Test(description = "Wrong username/password variations")
    @Parameters({"wrongUsername", "wrongPassword"})
    public void loginWrong(String wrongUsername, String wrongPassword) {

        AdminPage adminPage = new AdminPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);

        adminPage.accountDataClear();
        String dataBaseCleanedText = adminPage.getDatabaseCleanedText();
        Assert.assertEquals(dataBaseCleanedText, "Database Cleaned.");

        loginPage.goToLoginPage();
        loginPage.wrongUsernameWrongPassword(wrongUsername, wrongPassword);
        String actualErrorText = loginPage.getError();
        Assert.assertEquals(actualErrorText, "The username and password could not be verified.");
        System.out.println("Login proceed successfully.");
    }

    @Test(description = "valid username/password")
    @Parameters({"validUsername", "validPassword"})
    public void loginValid(String validUsername, String validPassword) {

        AdminPage adminPage = new AdminPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);

        adminPage.setup();
        String adminPageStatus = adminPage.getSettingSavedText();
        Assert.assertEquals(adminPageStatus, "Settings saved successfully.");
        System.out.println("Settings saved successfully.");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");
        registerPage.logOut();

        loginPage.validUsernameValidPassword(validUsername, validPassword);

        if (validUsername.equalsIgnoreCase("valid") && validPassword.equalsIgnoreCase("valid")) {
            String accountsOverviewText = loginPage.getAccountOverviewText();
            Assert.assertEquals(accountsOverviewText, "Accounts Overview");
        } else if (validUsername.equalsIgnoreCase("wrong username") || validPassword.equalsIgnoreCase("wrong password")) {
            String actualErrorText = loginPage.getError();
            Assert.assertEquals(actualErrorText, "The username and password could not be verified.");
        }
        System.out.println("Login proceed successfully.");
    }

}
