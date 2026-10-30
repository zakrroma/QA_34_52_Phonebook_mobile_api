package mobile;

import dto.ContactDto;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;
import utils.ContactFactory;

import static utils.PropertiesReader.getProperty;

public class UpdateContactTests extends TestBase {
    ContactsScreen contactsScreen;

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

        ContactDto contact = ContactFactory.positiveContact();

        AddContactScreen addContactScreen = new AddContactScreen(driver);
        addContactScreen.fillAddContactForm(contact);
        addContactScreen.tapBtnCreate();
    }

    @Test
    public void updateContactPositiveTest() {
        contactsScreen.goToEditContact();

        UpdateContactScreen updateContactScreen = new UpdateContactScreen(driver);
        updateContactScreen.reInputDescription();
        updateContactScreen.tapBtnUpdate();

        Assert.assertTrue(contactsScreen
                .checkTextInPopupContactWasUpdated("Contact was updated!"));
    }
}
