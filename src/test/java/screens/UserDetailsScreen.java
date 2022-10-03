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

public class UserDetailsScreen extends BaseScreen {
    public UserDetailsScreen(AndroidDriver<MobileElement> driver) { super(driver); }

    By buttonSeeMoreAlbums = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_albums_title");
    By buttonSeeMoreTodos = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_todos_title");
    By buttonSeeMorePosts = By.id("es.jaimesuarez.rindustest:id/tv_userDetail_posts_title");
    By albumItems = By.id("es.jaimesuarez.rindustest:id/tv_album_title");
    By todosItems = By.id("es.jaimesuarez.rindustest:id/tv_todo_title");
    By postsItems = By.id("es.jaimesuarez.rindustest:id/tv_post_title");
    By userDetailTodos = By.id("es.jaimesuarez.rindustest:id/rv_userDetail_todos");

    public void goToAlbums(){
        driver.findElement(buttonSeeMoreAlbums).click();
    }

    public void goToTodos(){
        driver.findElement(buttonSeeMoreTodos).click();
    }

    public void goToPosts(){
        driver.findElement(buttonSeeMorePosts).click();
    }

    public void moveItemsToTheLeft(String menu, String textToMatch) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(albumItems)).isDisplayed();

        String elementProperty = "";

        switch (menu){
            case "albums":
                    elementProperty = "es.jaimesuarez.rindustest:id/tv_album_title";
                break;
            case "todos":
                    elementProperty = "es.jaimesuarez.rindustest:id/tv_todo_title";
                break;
            case "posts":
                    elementProperty = "es.jaimesuarez.rindustest:id/tv_post_title";
                break;
        }

        PointOption pointOptionStart, pointOptionEnd;
        Rectangle rect = driver.findElement(By.id(elementProperty)).getRect();
        String itemText = driver.findElement(By.id(elementProperty)).getText();
        pointOptionStart = PointOption.point(rect.x + rect.width - 0, rect.y + rect.height / 2);
        pointOptionEnd = PointOption.point(rect.x + 0, rect.y + rect.height / 2);

        new TouchAction(driver)
                .press(pointOptionStart)
                .waitAction(waitOptions(Duration.ofSeconds(1)))
                .moveTo(pointOptionEnd)
                .release().perform();

        String newItemText = "";

        switch (menu) {
            case "albums", "posts":
                        newItemText = driver.findElement(By.id(elementProperty)).getText();
                    break;
            case "todos":
                    MobileElement todosElements = driver.findElement(userDetailTodos);
                    List<MobileElement> todosElementsText = todosElements.findElements(todosItems);
                    newItemText = todosElementsText.get(1).getText();
                break;
        }


        Assert.assertNotEquals(itemText, textToMatch);
        Assert.assertEquals(newItemText, textToMatch);
    }
}
