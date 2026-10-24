package mobile;

import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.SplashScreen;

public class RegistrationTests extends TestBase {

    @Test
    public void registrationPositiveTest() {
        new SplashScreen(driver).goToAuthenticationScreen();
        AuthenticationScreen authenticationScreen =
                new AuthenticationScreen(driver);
    }
}
