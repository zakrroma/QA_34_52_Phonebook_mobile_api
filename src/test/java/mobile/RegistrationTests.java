package mobile;

import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.SplashScreen;
import utils.UserFactory;

public class RegistrationTests extends TestBase {
    AuthenticationScreen authenticationScreen;
    UserDto user;

    @BeforeMethod
    public void goToRegistrationPage() {
        new SplashScreen(driver).goToAuthenticationScreen();
        authenticationScreen = new AuthenticationScreen(driver);

        user = UserFactory.positiveUser();
    }

    @Test
    public void registrationPositiveTest() {
        authenticationScreen.fillAuthenticationForm(user);
        authenticationScreen.tapRegistrationButton();

        Assert.assertTrue(new ContactsScreen(driver)
                .checkTextNoContact("No Contacts. Add One more!"));
    }
}
