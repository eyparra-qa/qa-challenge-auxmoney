package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PostScreen extends BaseScreen {
    public PostScreen(AndroidDriver<MobileElement> driver) { super(driver); }

    By postsListItems = By.id("es.jaimesuarez.rindustest:id/rv_list_items");
    By postsListText = By.id("es.jaimesuarez.rindustest:id/tv_post_title");
    By commentsList = By.id("es.jaimesuarez.rindustest:id/rv_postDetail_comments_list");
    By commentNames = By.id("es.jaimesuarez.rindustest:id/tv_comment_name");
    By buttonBack = By.className("android.widget.ImageButton");
    By labelFirstComment = By.id("es.jaimesuarez.rindustest:id/tv_post_title");
    By labelUserNameDetail = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_name");
    By labelUserName = By.id("es.jaimesuarez.rindustest:id/tv_user_name");
    By labelUserTitle = By.className("android.widget.TextView");

    public void checkPostsList(List<String> data) {
        MobileElement postsItems = driver.findElement(postsListItems);
        List<MobileElement> items = postsItems.findElements(postsListText);
        List<String> textElements = new ArrayList<>();

        for (MobileElement elementText: items) {
            textElements.add(elementText.getText());
        }

        for (String item: data) {
            Assert.assertTrue(textElements.contains(item));
        }
    }

    public void clickOnFirstComment() {
        MobileElement postsItems = driver.findElement(postsListItems);
        List<MobileElement> items = postsItems.findElements(postsListText);

        items.get(0).click();
    }

    public void checkCommentsOfPost(List<String> data) {
        List<String> textElements = new ArrayList<>();

        MobileElement comments = driver.findElement(commentsList);
        List<MobileElement> commentsItems = comments.findElements(commentNames);

        for (MobileElement elementText: commentsItems) {
            textElements.add(elementText.getText());
        }

        for (String item: data) {
            Assert.assertTrue(textElements.contains(item));
        }
    }

    public void goBackToUsersPage() {
        driver.findElement(buttonBack).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(labelFirstComment)).isDisplayed();
        driver.findElement(buttonBack).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(labelUserNameDetail)).isDisplayed();
        driver.findElement(buttonBack).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(labelUserName)).isDisplayed();

        String titleText = driver.findElement(labelUserTitle).getText();

        Assert.assertEquals(titleText, "Users");
    }
}
