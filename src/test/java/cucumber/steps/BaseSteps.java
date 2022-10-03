package cucumber.steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import screens.*;

public class BaseSteps {
    protected AlbumScreen albumScreen;
    protected PostScreen postScreen;
    protected TodoScreen todoScreen;
    protected UserInfoScreen userInfoScreen;
    protected UserDetailsScreen userDetailsScreen;

    public void setupScreens(AndroidDriver<MobileElement> driver) {
        albumScreen = new AlbumScreen(driver);
        postScreen = new PostScreen(driver);
        todoScreen = new TodoScreen(driver);
        userInfoScreen = new UserInfoScreen(driver);
        userDetailsScreen = new UserDetailsScreen(driver);
    }
}
