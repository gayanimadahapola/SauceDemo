package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import java.util.Random;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

public class SauceDemoTests {

    @Test
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/gayanimadubhashini/Documents/QATestProjects/Shopping/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        login(driver);
        addItemsToCart(driver, 3);
        enterShippingDetails(driver);
        verifyCheckoutOverviewPage(driver);
        completeThePurchase(driver);
    }
    private static void login(WebDriver driver) {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    private static void addItemsToCart(WebDriver driver, int itemCount) {
        //List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"inventory_item\"]"));
        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
        Random random = new Random();
        for (int i = 0; i < itemCount; i++) {
            int index = random.nextInt(products.size());
            WebElement product = products.get(index);
            //product.findElement(By.xpath("//button[text()=\"Add to cart\"]")).click();
            product.findElement(By.cssSelector(".btn_inventory")).click();
            products.remove(index);
        }
        // Click on cart icon
        driver.findElement(By.id("shopping_cart_container")).click();
        // Click on Checkout icon
        driver.findElement(By.id("checkout")).click();
    }

    private static void enterShippingDetails(WebDriver driver)
    {
        driver.findElement(By.id("first-name")).sendKeys("Peter");
        driver.findElement(By.id("last-name")).sendKeys("Pan");
        driver.findElement(By.id("postal-code")).sendKeys("1234");
        driver.findElement(By.id("continue")).click();
    }
    public void verifyCheckoutOverviewPage(WebDriver driver)
    {
        //Verify Payment Info, Shipping info, Item Total, tax and total amounts fields are not empty
        String paymentInfo = driver.findElement(By.xpath("(//div[text()='Payment Information']/../div[@class='summary_value_label'])[1]")).getText();
        Assert.assertTrue(!paymentInfo.isEmpty());
        String shippingInfo = driver.findElement(By.xpath("(//div[text()='Payment Information']/../div[@class='summary_value_label'])[2]")).getText();
        Assert.assertTrue(!shippingInfo.isEmpty());
        String itemTotal = driver.findElement(By.xpath("//div[text()='Price Total']/../div[@class='summary_subtotal_label']")).getText();
        Assert.assertTrue(!itemTotal.isEmpty());
        String tax = driver.findElement(By.xpath("//div[text()='Price Total']/../div[@class='summary_tax_label']")).getText();
        Assert.assertTrue(!tax.isEmpty());
        String totalAmount = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText();
        Assert.assertTrue(!totalAmount.isEmpty());
    }

    public static void completeThePurchase(WebDriver driver)
    {
        driver.findElement(By.id("finish")).click();
        //Verify confirmation message
        String confirmationMessage = driver.findElement(By.cssSelector(".complete-header")).getText();
        Assert.assertEquals("Thank you for your order!", confirmationMessage);

        //Close the browser
        driver.quit();
    }



}
