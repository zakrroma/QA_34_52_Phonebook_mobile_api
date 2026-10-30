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
import utils.IGetContacts;

import static utils.PropertiesReader.getProperty;

public class DeleteContactTests extends TestBase implements IGetContacts {
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
    public void deleteContactPositiveTestUsingApi() {
        int countBeforeDelete = getContactCount();
        System.out.println("Count before delete: " + countBeforeDelete);

        contactsScreen.deleteContact();

        int countAfterDelete = getContactCount();
        System.out.println("Count after delete: " + countAfterDelete);

        Assert.assertNotEquals(countAfterDelete, countBeforeDelete);
    }
}
