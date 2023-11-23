package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {
    // Set up base url
    String baseUrl = "https://magento.softwaretestingboard.com/";

    //Open the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //Click on the register link
    @Test
    public void verifyThatSignInPageDisplay() {
        driver.findElement(By.linkText("Create an Account")).click();
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.className("base")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.id("firstname")).sendKeys("Krupali");
        driver.findElement(By.id("lastname")).sendKeys("Lalkia");
        Random random = new Random();
        int emailField = random.nextInt(1000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Krupali" + emailField + "@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Krupali123!");
        driver.findElement(By.id("password-confirmation")).sendKeys("Krupali123!");
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();

        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals(expectedText, actualText);

        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        String expectedMessage = "You are signed out";
        String actualMessage = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}

