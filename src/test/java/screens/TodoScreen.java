package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoScreen extends BaseScreen {
    public TodoScreen(AndroidDriver<MobileElement> driver) { super(driver); }

    By todosListItems = By.id("es.jaimesuarez.rindustest:id/rv_list_items");
    By todosListText = By.id("es.jaimesuarez.rindustest:id/tv_todo_title");
    By todosListCheckbox = By.id("es.jaimesuarez.rindustest:id/cb_todo_checked");

    public void checkTodosList(List<String> data) {
        MobileElement todosItems = driver.findElement(todosListItems);
        List<MobileElement> items = todosItems.findElements(todosListText);
        List<String> textElements = new ArrayList<>();

        for (MobileElement elementText: items) {
            textElements.add(elementText.getText());
        }

        for (String item: data) {
            Assert.assertTrue(textElements.contains(item));
        }
    }

    public void changeTaskStatus(List<String> data) {
        MobileElement todosItems = driver.findElement(todosListItems);
        List<MobileElement> taskTextItems = todosItems.findElements(todosListText);
        List<MobileElement> checkBoxItems = todosItems.findElements(todosListCheckbox);
        String checkboxStatus = "";
        List<String> checkBoxIndex = new ArrayList<>();

        for (String item: data) {
            int index = 0;

            for (MobileElement element: taskTextItems) {
                String elementText = element.getText();

                if(elementText.equals(item)) {
                    MobileElement checkBoxElement = checkBoxItems.get(index);
                    checkboxStatus = checkBoxElement.getAttribute("checked");

                    if(Boolean.parseBoolean(checkboxStatus)){
                        checkBoxElement.click();
                        checkBoxElement.click();
                    }
                    else {
                        checkBoxElement.click();
                    }
                    checkBoxIndex.add(String.valueOf(index));
                    break;
                }
                index++;
            }
        }
        checkBoxItems = todosItems.findElements(todosListCheckbox);

        for (String indexItem: checkBoxIndex) {
            int elementIndex = Integer.parseInt(indexItem);
            checkboxStatus = checkBoxItems.get(elementIndex).getAttribute("checked");

            Assert.assertTrue(Boolean.parseBoolean(checkboxStatus));
        }
    }
}
