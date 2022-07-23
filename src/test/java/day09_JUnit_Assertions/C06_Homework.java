package day09_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Homework {

    // amazona gidilsin
    // arama butonuna nutella yazılsın
    // title nutelle var mı kontrol edilsin
    // amazona gidilsin
    // arama butonuna java yazılsın
    // title da java var mı kontrol edilsin
    // amazona gidilsin
    // arama butonuna ali yazılsın
    // title da ali var mı kontrol edilsin
    // Assertion ile yapılacak

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.amazon.com/");

    }

    @Test
    public void testNutella(){
        WebElement searchBox= driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBox.clear();
        searchBox.sendKeys("nutella", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("nutella"));
    }

    @Test
    public void testJava(){
        WebElement searchBox= driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBox.clear();
        searchBox.sendKeys("java",Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("java"));
    }

    @Test
    public void testAli(){
        WebElement searchBox= driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBox.clear();
        searchBox.sendKeys("ali",Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("ali"));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
