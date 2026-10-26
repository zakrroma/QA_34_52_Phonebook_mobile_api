package mobile;

import dto.ContactDto;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AddContactScreen;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.SplashScreen;
import utils.ContactFactory;

import static utils.PropertiesReader.getProperty;

public class AddContactTests extends TestBase {
    ContactsScreen contactsScreen;
    AddContactScreen addContactScreen;
    ContactDto contact;

    @BeforeMethod
    public void goToRegistrationPage() {
        new SplashScreen(driver).goToAuthenticationScreen();

        AuthenticationScreen authenticationScreen = new AuthenticationScreen(driver);

        UserDto user = UserDto.builder()
                .username(getProperty("base.properties","email"))
                .password(getProperty("base.properties","password"))
                .build();

        authenticationScreen.fillAuthenticationForm(user);
        authenticationScreen.tapLoginButton();

        contactsScreen = new ContactsScreen(driver);
        contactsScreen.tapBtnAddContact();

        addContactScreen = new AddContactScreen(driver);

        contact = ContactFactory.positiveContact();
    }

    @Test
    public void addContactPositiveTest() {
        addContactScreen.fillAddContactForm(contact);
        addContactScreen.tapBtnCreate();

        Assert.assertTrue(contactsScreen
                .checkTextInPopupContactWasAdded("Contact was added!"));
    }
}
