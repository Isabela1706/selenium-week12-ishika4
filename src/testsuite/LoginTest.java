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
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” for the username
        sendTextElement(By.xpath("//input [@type = 'text']"), "standard_user");

        //Enter “secret_sauce” for the password
        sendTextElement(By.xpath("//input [@type = 'password']"), "secret_sauce");

        //Click on the ‘Login’ button
        clickOnElement(By.xpath("//input [@type = 'submit']"));

        //Verify the text “Products”
        String productText = getTextFromElement(By.xpath("//span [@class = 'title']"));
        verifyText("Invalid Product display", "Products", productText);


    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” for the username
        sendTextElement(By.xpath("//input [@type = 'text']"), "standard_user");

        //Enter “secret_sauce” for the password
        sendTextElement(By.xpath("//input [@type = 'password']"), "secret_sauce");

        //Click on the ‘Login’ button
        clickOnElement(By.xpath("//input [@type = 'submit']"));

        //Verify that six products are displayed on page
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int numberOfProducts = 6;
        Assert.assertEquals("6 products does not display", numberOfProducts, listOfProducts.size());


    }

    @After
    public void tearDown() {
         closeBrowser();
    }
}
