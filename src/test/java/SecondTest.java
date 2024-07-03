import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest {
    @Test
    public void LoginTest() {
        // Arrange
        System.setProperty("webdriver.chrome.driver", "chromedriver"); // Update this path to your actual path

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Launch the browser and navigate to Google
        driver.get("https://www.google.com");

        // Act
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        searchField.sendKeys("Java");
        searchField.sendKeys(Keys.ENTER);

        // Assert
        try {
            Assert.assertEquals(driver.getTitle(), "Java - Google Search");
        } catch (AssertionError e) {
            e.printStackTrace();
        } finally {
            // Clean up
            driver.quit();
        }
    }
}
