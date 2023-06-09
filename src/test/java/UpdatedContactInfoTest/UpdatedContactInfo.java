package UpdatedContactInfoTest;

import AdminPage.AdminPage;
import RegisterPage.RegisterPage;
import UpdateContactInfoPage.UpdateContactInfoPage;
import Utilities.DriverBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatedContactInfo extends DriverBase {

    @Test
    public void updatedContactInfo(){
        AdminPage adminPage = new AdminPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        UpdateContactInfoPage updateContactInfoPage = new UpdateContactInfoPage(driver, wait);

        adminPage.accountDataClear();
        String dataBaseCleanedText = adminPage.getDatabaseCleanedText();
        Assert.assertEquals(dataBaseCleanedText, "Database Cleaned.");

        registerPage.goToRegisterPage();
        registerPage.registration();
        String welcomeText = registerPage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome valid");
        System.out.println("Registered successfully.");

        updateContactInfoPage.goToUpdateContactInfoPage();
        updateContactInfoPage.updateProfile();
        updateContactInfoPage.updateProfileButton();
        String profileUpdatedText = updateContactInfoPage.getProfileUpdatedText();
        Assert.assertEquals(profileUpdatedText, "Profile Updated");
    }
}
