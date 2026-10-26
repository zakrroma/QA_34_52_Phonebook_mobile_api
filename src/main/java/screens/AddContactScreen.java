package screens;

import dto.ContactDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AddContactScreen extends BaseScreen {
    public AddContactScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputName")
    WebElement fieldName;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputLastName")
    WebElement fieldLastName;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputEmail")
    WebElement fieldEmail;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputPhone")
    WebElement fieldPhone;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputAddress")
    WebElement fieldAddress;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputDesc")
    WebElement fieldDescription;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/createBtn")
    WebElement btnCreate;

    public void fillAddContactForm(ContactDto contact) {
        fieldName.sendKeys(contact.getName());
        fieldLastName.sendKeys(contact.getLastName());
        fieldEmail.sendKeys(contact.getEmail());
        fieldPhone.sendKeys(contact.getPhone());
        fieldAddress.sendKeys(contact.getAddress());
        fieldDescription.sendKeys(contact.getDescription());
    }

    public void tapBtnCreate() {
        btnCreate.click();
    }
}
