package day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnit04_Homework {

    // amazona gidilsin
    // arama butonuna nutella yazılsın
    // title nutelle var mı kontrol edilsin
    // amazona gidilsin
    // arama butonuna java yazılsın
    // title da java var mı kontrol edilsin
    // amazona gidilsin
    // arama butonuna ali yazılsın
    // title da ali var mı kontrol edilsin

    WebDriver driver;

    @Before
    public void testSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("Driver çalışmaya başladı.");
    }

    @Test
    public void testNutella(){
        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("nutella", Keys.ENTER);
        if (driver.getTitle().contains("nutella")){
            System.out.println("Test PASSED - Title'da 'nutella' var.");
        }else{
            System.out.println("Test FAILED - Title'da 'nutella' yok.");
        }
    }

    @Test
    public void testJava(){
        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("java", Keys.ENTER);
        if (driver.getTitle().contains("java")){
            System.out.println("Test PASSED - Title'da 'java' var.");
        }else{
            System.out.println("Test FAILED - Title'da 'java' yok.");
        }
    }

    @Test
    public void testAli(){
        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("ali", Keys.ENTER);
        if (driver.getTitle().contains("ali")){
            System.out.println("Test PASSED - Title'da 'ali' var.");
        }else{
            System.out.println("Test FAILED - Title'da 'ali' yok.");
        }
    }

    @After
    public void testClose(){
        driver.close();
        System.out.println("Driver kapatıldı.");
    }

}
