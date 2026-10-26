package mobile;

import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.SplashScreen;

import static utils.PropertiesReader.*;

public class LoginTests extends TestBase {
    AuthenticationScreen authenticationScreen;
    UserDto user;

    @BeforeMethod
    public void goToRegistrationPage() {
        new SplashScreen(driver).goToAuthenticationScreen();
        authenticationScreen = new AuthenticationScreen(driver);

        user = UserDto.builder()
                .username(getProperty("base.properties","email"))
                .password(getProperty("base.properties","password"))
                .build();
    }

    @Test
    public void loginPositiveTest() {
        authenticationScreen.fillAuthenticationForm(user);
        authenticationScreen.tapLoginButton();

        Assert.assertTrue(new ContactsScreen(driver)
                .checkPresenceOfBtnAddContact());
    }
}
