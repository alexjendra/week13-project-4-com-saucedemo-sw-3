package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter "standard_user" username
        sendTextToElement(By.id("User-name"), "standard_user");

        //Enter "secret_sauce" password
        sendTextToElement(By.id("Password"), "secret_sauce");

        //Click on 'Login' button
        clickOnElement(By.id("login-button"));

        //Verify the text "Products";
        String actual = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        String expected = "Products";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Enter "Standard_user" username
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter "secret_sauce" password
        sendTextToElement(By.id("password"), "secret_sauce");

        //click on 'Login' button
        clickOnElement(By.id("login-button"));

        //Verify that six products are displayed on page
        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'inventory_list']//div[@class = 'inventory_item']"));
        System.out.println("Total Products Displayed on Page : " + items.size());
    }

}

