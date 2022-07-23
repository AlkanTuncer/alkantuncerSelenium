package day09_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Homework2 {

    // 3 farklı test metodu oluşturun.
    // 2) https://www.youtube.com/ adresine gidin
    // ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    // ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void testSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.youtube.com/");
    }

    @Test
    public void testTitle(){
        Assert.assertEquals("Test PASSED - Title", "YouTube", driver.getTitle());
    }

    @Test
    public void testImage(){
        WebElement image = driver.findElement(By.xpath("(//yt-icon[@id=\"logo-icon\"])[1]"));
        Assert.assertTrue(image.isDisplayed());
    }

    @Test
    public void testSearchBox(){
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search\"]"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void testWrongTitle(){
        Assert.assertNotEquals("youtube", driver.getTitle());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
