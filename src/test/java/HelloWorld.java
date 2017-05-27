import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;public class HelloWorld {



    public static WebDriver driver;

    @Before
    public void setUp() {
        //chrome
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","./drivers/gecko");
        driver = new ChromeDriver();
        driver.get("http://192.168.99.100:3000/");

        //firefox

        //headless (phantomjs)

    }

    @Test
    public void checkBrowser() {
        String partialMessage = "Welcome";
        WebElement element;
        element = driver.findElement(By.id("flash_notice"));
        Assert.assertEquals("Welcome", "Welcome");
    }



    @Test
    public void accessBook(){
        String partialMessage = "The Well-Grounded Rubyist";
        WebElement element;

        element = driver.findElement(By.linkText("The Well-Grounded Rubyist"));
        element.click();

        element = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals("The Well-Grounded Rubyist","The Well-Grounded Rubyist");


        element = driver.findElement(By.linkText("Back to All Products"));
        Assert.assertEquals("Back to All Products","Back to All Products");
        element.click();



    }


    @Test
    public void signUp(){
        WebElement element;

        element = driver.findElement(By.linkText("Sign up"));
        element.click();

        element = driver.findElement(By.id("user_username"));
        element.sendKeys("vastest1");
        element = driver.findElement(By.id("user_email"));
        element.sendKeys("vms3.test@gmail.com");
        element = driver.findElement(By.id("user_password"));
        element.sendKeys("852456");
        element = driver.findElement(By.id("user_password_confirmation"));
        element.sendKeys("852456");
        element = driver.findElement(By.name("commit"));
        element.click();

    }

    @Test
    public void login() {
        loginMethod();
    }

    @Test
    public void addBookToCart() {
        WebElement element;
        loginMethod();

        element = driver.findElement(By.linkText("Learning Ruby"));
        element.click();

        element = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals("Learning Ruby","Learning Ruby");

        element = driver.findElement(By.linkText("Add to Card"));
        element.click();

        element = driver.findElement(By.id("flash_notice"));
        Assert.assertEquals("Item added to cart!","Item added to cart!");

    }

    @Test
    public void removeBookfromCart() {
        WebElement element;

        loginMethod();

        element = driver.findElement(By.linkText("Learning Ruby"));
        element.click();

        element = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals("Learning Ruby","Learning Ruby");

        element = driver.findElement(By.linkText("Add to Card"));
        element.click();

        element = driver.findElement(By.id("flash_notice"));
        Assert.assertEquals("Item added to cart!","Item added to cart!");

        element = driver.findElement(By.linkText("Remove"));
        element.click();

        element = driver.findElement(By.id("flash_notice"));
        Assert.assertEquals("Item removed from cart","Item removed from cart");

    }

    @Test
    public void finishBuying() {
        loginMethod();
        WebElement element;

        element = driver.findElement(By.linkText("Learning Ruby"));
        element.click();

        element = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals("Learning Ruby", "Learning Ruby");

        element = driver.findElement(By.linkText("Add to Card"));
        element.click();

        element = driver.findElement(By.id("flash_notice"));
        Assert.assertEquals("Item added to cart!", "Item added to cart!");

        element = driver.findElement(By.name("commit"));
        element.click();

    }

    private void loginMethod() {
        WebElement element;

        element = driver.findElement(By.linkText("Log in"));
        element.click();

        element = driver.findElement(By.id("login"));
        element.sendKeys("vastest1");
        element = driver.findElement(By.id("password"));
        element.sendKeys("852456");
        element = driver.findElement(By.name("commit"));
        element.click();

        element = driver.findElement(By.id("flash_notice"));
        Assert.assertEquals("Logged in successfully.", "Logged in successfully.");
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}