package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password is invalid!”
 */
public class LoginTest extends BaseTest {
    //BaseUrl
    String baseUrl = "http://the-internet.herokuapp.com/login";

    //calling openBrowser method from parentclass BaseTest
    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }

    //1. userSholdLoginSuccessfullyWithValidCredentials
    // * * Enter “tomsmith” username
    // * * Enter “SuperSecretPassword!” password
    // * * Click on ‘LOGIN’ button
    // * * Verify the text “Secure Area”
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // * * Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");

        // * * Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword!");

        // * * Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();

        // * * Verify the text “Secure Area”
        String expectedtext = "Secure Area";
        String actualtext = driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals("User is unable to navigate to  Secure Area page", expectedtext, actualtext);
    }

        // 2. verifyTheUsernameErrorMessage
        // * * Enter “tomsmith1” username
        // * * Enter “SuperSecretPassword!” password
        // * * Click on ‘LOGIN’ button
        // * * Verify the error message “Your username is invalid!”

        @Test
       public void verifyTheUsernameErrorMessage(){
            // * * Enter “tomsmith1” username
            driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith1");

            // * * Enter “SuperSecretPassword!” password
            driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword!");

            // * * Click on ‘LOGIN’ button
            driver.findElement(By.xpath("//button[@class = 'radius']")).click();

            // * * Verify the error message “Your username is invalid!”
            String expectedText = "Your username is invalid!\n" +
                    "×";
            String actualtext = driver.findElement(By.xpath("//div[@id='flash']")).getText();
            Assert.assertEquals("User is unable to see the message your username is invalid", expectedText, actualtext);
        }

         //3. verifyThePasswordErrorMessage
        // * * Enter “tomsmith” username
        // * * Enter “SuperSecretPassword” password
       // * * Click on ‘LOGIN’ button
       // * * Verify the error message “Your password is invalid!”

    @Test
    public void verifyThePasswordErrorMessage(){
        // * * Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");

        // * * Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword");

        // * * Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();

        // * * Verify the error message “Your password is invalid!”
        String expectedText = "Your password is invalid!\n" +
                "×";
        String actualtext = driver.findElement(By.xpath("//div[@id='flash-messages']//div[1]")).getText();
        Assert.assertEquals("User is unable to navigate to  Secure Area pag", expectedText, actualtext);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
