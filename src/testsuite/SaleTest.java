package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    // Set up base url

    String baseUrl = "https://magento.softwaretestingboard.com/";

    //Open the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        driver.findElement(By.linkText("Sale")).click();
        driver.findElement(By.linkText("Jackets")).click();
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.className("base")).getText();
        Assert.assertEquals(expectedText, actualText);

        List<WebElement> list = driver.findElements(By.className("toolbar-amount"));
        list.size();
        System.out.println("Olivia 1/4 Zip Light Jacket");
        System.out.println("Juno Jacket");
        System.out.println("Neve Studio Dance Jacket");
        System.out.println("Nadia Elements Shell");
        System.out.println("Jade Yoga Jacket");
        System.out.println("Adrienne Trek Jacket");
        System.out.println("Inez Full Zip Jacket");
        System.out.println("Riona Full Zip Jacket");
        System.out.println("Ingrid Running Jacket");
        System.out.println("Augusta Pullover Jacket");
        System.out.println("Josie Yoga Jacket");
        System.out.println("Stellar Solar Jacket");

        String expectedText1 = "12 Items";
        String actualText2 = driver.findElement(By.className("toolbar-amount")).getText();
        Assert.assertEquals(expectedText1, actualText2);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
