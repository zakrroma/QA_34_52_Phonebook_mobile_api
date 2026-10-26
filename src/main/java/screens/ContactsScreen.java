package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ContactsScreen extends BaseScreen{
    public ContactsScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.sheygam.contactapp:id/emptyTxt")
    WebElement textNoContact;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    WebElement btnAddContact;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Contact was added!']")
    WebElement popupContactWasAdded;

    public boolean checkTextNoContact(String text) {
        return isTextInElementPresent(textNoContact, text);
    }

    public boolean checkPresenceOfBtnAddContact() {
        return btnAddContact.isDisplayed();
    }

    public void tapBtnAddContact() {
        clickWait(btnAddContact);
    }

    public boolean checkTextInPopupContactWasAdded(String text) {
        return isTextInElementPresent(popupContactWasAdded, text);
    }
}
