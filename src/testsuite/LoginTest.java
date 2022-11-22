package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials(){
        //Enter valid credentials
        sendTextElement(By.name("username"),"tomsmith");
        sendTextElement(By.name("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//button/i [text() = ' Login']"));

        //verify the valid secure area message
        String expectedText = "Secure Area";
        String actualText = getTextFromElement(By.xpath("//div[@class = 'example']/h2[contains(text(), 'Secure Area')]"));
        Assert.assertEquals("Secure area text is not displayed",expectedText,actualText);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter the invalid username
        sendTextElement(By.name("username"),"tomsmith1");
        sendTextElement(By.name("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//button/i [text() = ' Login']"));

        //verify the invalid username
        String expectedText ="Your username is invalid!\n"+"×";
        String actualText = getTextFromElement(By.xpath("//div[1]//div[@class = 'flash error' and contains(text(),'Your username is invalid!')]"));
        Assert.assertEquals("Invalid username text is not displayed",expectedText,actualText);
        //String actualText = getTextFromElement(By.xpath("//div[1]//div[contains(text(), 'Your username is invalid!')]"));
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter the invalid password
        sendTextElement(By.name("username"),"tomsmith");
        sendTextElement(By.name("password"),"SuperSecretPassword");
        clickOnElement(By.xpath("//button/i [text() = ' Login']"));
        //verify the invalid password
        String expectedText ="Your password is invalid!\n"+"×";
        String actualText = getTextFromElement(By.xpath("//div[1]//div[@class = 'flash error' and contains(text(),'Your password is invalid!')]"));
        Assert.assertEquals("Invalid password text is not displayed",expectedText,actualText);
    }

    @After
    public void tearDown(){
      closeBrowser();
    }
}
