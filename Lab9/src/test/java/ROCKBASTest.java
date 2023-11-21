import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ROCKBASTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("acceptInsecureCerts", true);
            driver = new ChromeDriver(options);
            driver.get("https://rockbastion.by/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void SortingOfGoodsByPrice() throws InterruptedException {
        WebElement catalogButton = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[5]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogButton).perform();
        WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[5]/div/div/div/div[1]/div[3]/a[2]"));
        targetElement.click();
        WebElement priceSelect = driver.findElement(By.xpath("//*[@id=\"input-sort\"]"));
        priceSelect.click();
        WebElement priceIncrease = driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[5]"));
        priceIncrease.click();
        Thread.sleep(2000);
    }
}