package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.MobileActions;

public class BaseScreen {
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;
    protected MobileActions mobileActions;

    public BaseScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        mobileActions = new MobileActions(driver);
    }
}
