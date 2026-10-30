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

    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Contact was updated!']")
    WebElement popupContactWasUpdated;

    @AndroidFindBy(id = "android:id/button1")
    WebElement btnConfirmDelete;

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

    public boolean checkTextInPopupContactWasUpdated(String text) {
        return isTextInElementPresent(popupContactWasUpdated, text);
    }

    public void goToEditContact() {
        swipe(width/10*9, height/6, width/10, height/6);
    }

    public void deleteContact() {
        swipe(width/10, height/6, width/10*9, height/6);
        clickWait(btnConfirmDelete);
    }
}
