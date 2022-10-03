package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class UserInfoScreen extends BaseScreen {
    public UserInfoScreen(AndroidDriver<MobileElement> driver) { super(driver); }

    By toolbar = By.id("es.jaimesuarez.rindustest:id/toolbar");
    By userList = By.id("es.jaimesuarez.rindustest:id/rv_users");
    By userListFrameLayout = By.className("android.widget.FrameLayout");
    By userItemContent = By.id("es.jaimesuarez.rindustest:id/cl_user_item");
    By userTextView = By.xpath("//android.widget.TextView");
    By labelUserNameInfo = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_name");
    By labelNickNameInfo = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_username");
    By labelUserWebsideinfo = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_website");
    By labelUserEmailInfo = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_email");
    By labelUserCompanyInfo = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_company");
    By buttonBack = By.className("android.widget.ImageButton");

    public void waitUntilToolbarIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toolbar)).isDisplayed();
    }

    public void searchByUser(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userList)).isDisplayed();

        MobileElement allUserList = driver.findElement(userList);
        List<MobileElement> userElement = allUserList.findElements(userListFrameLayout);

        for (MobileElement element: userElement) {
            MobileElement userDetails = element.findElement(userItemContent);
            List<MobileElement> allDescendantsChilds = userDetails.findElements(userTextView);
            String userNameOfElement = allDescendantsChilds.get(0).getText();

            if (userNameOfElement.equals(userName)) {
                Assert.assertEquals(userNameOfElement, userName);
                break;
            }
        }
    }

    public void checkUserInfo(String userName, String valueToCheck, String userInfo) {
        MobileElement elementIndex = new MobileElement() {};

        MobileElement allUserList = driver.findElement(userList);
        List<MobileElement> userElement = allUserList.findElements(userListFrameLayout);

        for (MobileElement element: userElement) {
            MobileElement userDetails = element.findElement(userItemContent);
            List<MobileElement> allDescendantsChilds = userDetails.findElements(userTextView);
            String userNameOfElement = allDescendantsChilds.get(0).getText();

            if (userNameOfElement.equals(userName)) {
                switch (valueToCheck) {
                    case "userName":
                        elementIndex = allDescendantsChilds.get(0);
                        break;
                    case "userNickName":
                        elementIndex = allDescendantsChilds.get(1);
                        break;
                    case "company":
                        elementIndex = allDescendantsChilds.get(2);
                        break;
                }

                String elementText = elementIndex.getText();
                Assert.assertEquals(elementText, userInfo);
                break;
            }
        }
    }

    public void scrollDownInUsersPage() {
        MobileElement allUserList = driver.findElement(userList);
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = dimension.getHeight();
        int scrollEnd = (int)(dimension.getHeight() * 0.2);

        TouchAction ts = new TouchAction(driver);
        ts.press(point(0, scrollStart))
                .waitAction(waitOptions(Duration.ofSeconds(1)))
                .moveTo(point(0,scrollEnd))
                .release().perform();
    }

    public void clickOnUser(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userList)).isDisplayed();

        MobileElement allUserList = driver.findElement(userList);
        List<MobileElement> userElement = allUserList.findElements(userListFrameLayout);

        for (MobileElement element: userElement) {
            MobileElement userDetails = element.findElement(userItemContent);
            List<MobileElement> allDescendantsChilds = userDetails.findElements(userTextView);
            String userNameOfElement = allDescendantsChilds.get(0).getText();

            if (userNameOfElement.equals(userName)) {
                element.click();
                break;
            }
        }
    }

    public void checkInformationInUserDetails(String valueToCheck, String userInfo) {
        MobileElement elementToCheck = new MobileElement(){};

        wait.until(ExpectedConditions.visibilityOfElementLocated(labelUserNameInfo)).isDisplayed();

        switch (valueToCheck){
            case "userName":
                elementToCheck = driver.findElement(labelUserNameInfo);
                break;
            case "nickName":
                elementToCheck = driver.findElement(labelNickNameInfo);
                break;
            case "webside":
                elementToCheck = driver.findElement(labelUserWebsideinfo);
                break;
            case "email":
                elementToCheck = driver.findElement(labelUserEmailInfo);
                break;
            case "company":
                elementToCheck = driver.findElement(labelUserCompanyInfo);
                break;
        }
        String elementText = elementToCheck.getText();
        Assert.assertEquals(elementText, userInfo);
    }

    public void backButtonValidation() {
        String userName = driver.findElement(labelUserNameInfo).getText();

        driver.findElement(buttonBack).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userList)).isDisplayed();
        checkUserInfo(userName, "userName", userName);
    }
}