package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SplashScreen extends BaseScreen {
    public SplashScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=" +
            "'com.sheygam.contactapp:id/version_text']")
    WebElement version;

    public boolean checkVersion(String text) {
        return isTextInElementPresent(version, text);
    }

    public void goToAuthenticationScreen() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By
                            .xpath("//android.widget.TextView[@text=" +
                                    "'Authentication']")));
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("Timeout exception");
        }
    }
}
