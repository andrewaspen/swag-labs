import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void testLogin() throws InterruptedException {

        // Arrange
        System.setProperty("webdriver.chrome.driver", "chromedriver"); // Update this path to your actual path

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Launch the browser and navigate
        driver.get("https://www.saucedemo.com/");

        // Find and fill the username field
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        // Find and fill the password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify login by checking if the inventory page is loaded
        WebElement inventoryPage = driver.findElement(By.id("inventory_container"));
        assert inventoryPage.isDisplayed() : "Login failed or inventory page not loaded.";

        Thread.sleep(3000);

        driver.quit();

    }

    @Test
    public void testLoginWithWrongUsername() throws InterruptedException {

        // Arrange
        System.setProperty("webdriver.chrome.driver", "chromedriver"); // Update this path to your actual path

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Launch the browser and navigate
        driver.get("https://www.saucedemo.com/");

        // Find and fill the wrong username into the field
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("TestWrongUsername");

        // Find and fill the password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify error message is displayed
        WebElement errorMessageForWrongUsername = driver.findElement(By.xpath("//h3[@data-test='error' and contains(text(), 'Epic sadface: Username and password do not match any user in this service')]"));
        assert errorMessageForWrongUsername.isDisplayed();

        Thread.sleep(2000);

        driver.quit();

    }
    @Test
    public void testLoginLockedOutUser() throws InterruptedException {
        // Arrange
        System.setProperty("webdriver.chrome.driver", "chromedriver"); // Update this path to your actual path

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Launch the browser and navigate
        driver.get("https://www.saucedemo.com/");

        // Find and fill the wrong username into the field
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("locked_out_user");

        // Find and fill the password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify error message is displayed
        WebElement errorMessageForWrongUsername = driver.findElement(By.xpath("//h3[@data-test='error' and contains(text(), 'Epic sadface: Sorry, this user has been locked out.')]"));
        assert errorMessageForWrongUsername.isDisplayed();

        Thread.sleep(2000);

        driver.quit();
    }
}
