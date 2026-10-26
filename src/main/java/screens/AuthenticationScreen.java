package screens;

import dto.UserDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AuthenticationScreen extends BaseScreen {
    public AuthenticationScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputEmail")
    WebElement inputEmail;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputPassword")
    WebElement inputPassword;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/regBtn")
    WebElement btnRegistration;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/loginBtn")
    WebElement btnLogin;

    public void fillAuthenticationForm(UserDto user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }

    public void tapRegistrationButton() {
        clickWait(btnRegistration);
    }

    public void tapLoginButton() {
        clickWait(btnLogin);
    }
}
