package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;


public class AlbumScreen extends BaseScreen {
    public AlbumScreen(AndroidDriver<MobileElement> driver) { super(driver); }
    By textElementInTheScreen = By.xpath("//android.widget.TextView");;

    public void checkAlbumItems(String[] albumItems) {
        int index = 1;
        List<MobileElement> albums = driver.findElements(textElementInTheScreen);

        for (String item : albumItems) {
            String textElement = albums.get(index).getText();
            Assert.assertEquals(textElement, item);
            index++;
        }
    }
}
