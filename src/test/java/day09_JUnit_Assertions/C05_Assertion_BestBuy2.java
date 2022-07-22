package day09_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertion_BestBuy2 {   // Bu class öncekinden daha uygun bir kullanım TEST için. Tek tek hangi test passed ya da failed görebiliriz rahatça.

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

    @Test
    public void testUrl() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bestbuy.com/", currentURL);
    }

    @Test
    public void testTitle(){
        Assert.assertFalse(driver.getTitle().contains("Rest"));
    }

    @Test
    public void testLogo(){
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Best Buy Logo\"]"));
        Assert.assertTrue("Logo görülmedi",logo.isDisplayed());
    }

    @Test
    public void textLinkFr(){
        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang=\"fr\"]")).isDisplayed());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
