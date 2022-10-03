package utilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;

public class DesiredCapabilitiesUtil {
    public DesiredCapabilities getDesiredCapabilities(String udid, String platformVersion) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        File applicationParentDirectoryPath = new File("src");
        File app = new File(applicationParentDirectoryPath, "rindustest.apk");

        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("app", app.getAbsolutePath());
        desiredCapabilities.setCapability("skipUnlock", true);
        desiredCapabilities.setCapability("noReset", false);
        return desiredCapabilities;
    }
}