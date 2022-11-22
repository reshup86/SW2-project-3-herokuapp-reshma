package utility;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    public void clickOnElement(By by){
        WebElement clickElement = driver.findElement(by);
        clickElement.click();
    }
    public void sendTextElement(By by, String text){
        WebElement textField = driver.findElement(by);
        textField.sendKeys(text);
    }
    public String getTextFromElement (By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
}
