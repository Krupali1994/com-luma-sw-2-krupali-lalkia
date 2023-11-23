package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    // Set up base url

    String baseUrl = "https://magento.softwaretestingboard.com/";

    //Open the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("krupali123@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Krupali123");
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();

        String expectedText = "Welcome, Krupali Lalkia!";
        String actualText = driver.findElement(By.xpath("//span[text()='Welcome, Krupali Lalkia!']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("krupali111@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Krupali123");
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();

        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("krupali123@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Krupali123");
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();
        String expectedText = "Welcome, Krupali Lalkia!";
        String actualText = driver.findElement(By.xpath("//span[text()='Welcome, Krupali Lalkia!']")).getText();
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
