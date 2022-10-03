package cucumber.tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utilities.DesiredCapabilitiesUtil;
import utilities.ThreadLocalDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.net.URL;

public class BaseTest {
    private final DesiredCapabilitiesUtil desiredCapabilitiesUtil = new DesiredCapabilitiesUtil();
    public AndroidDriver<MobileElement> driver;
    private final ThreadLocalDriver threadLocalDriver = new ThreadLocalDriver();

    @BeforeMethod
    @Parameters({ "udid", "platformVersion" })
    public void setup(String udid, String platformVersion) throws IOException {
        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities(udid, platformVersion);
        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps));
        driver = threadLocalDriver.getTLDriver();
    }

    @AfterMethod
    public synchronized void teardown() {
        driver.quit();
    }
}
