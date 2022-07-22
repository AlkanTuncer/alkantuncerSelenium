package day09_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertion_BestBuy {

    // https://www.bestbuy.com/
    // Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
    // ○titleTest => Sayfa başlığının “ Rest” içermediğini(contains) test edin
    // ○logoTest => BestBuy logosunun görüntülendigini test edin
    // ○Francais LinkTest => Fransizca Linkin görüntülendiğini test edin

    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.bestbuy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test(){
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bestbuy.com/",currentURL);

        Assert.assertFalse(driver.getTitle().contains("Rest"));

        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=\"Best Buy Logo\"]")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang=\"fr\"]")).isDisplayed());
    }

}
