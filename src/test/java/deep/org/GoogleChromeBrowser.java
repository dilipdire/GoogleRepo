package deep.org;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleChromeBrowser {


    WebDriver driver;

    @BeforeMethod
    public void setUpEnv() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }
    @Test(priority = 0)
    public void test1() {
        WebElement en = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        en.sendKeys("Dilip");
    }
    @Test(priority = 2)
    public void searchBTN() throws InterruptedException {
        WebElement btn = driver.findElement(By.xpath("(//*[contains(@value,'Google Search')])[2]"));
        btn.click();
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
