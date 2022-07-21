package day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnit03 {

    WebDriver driver;

    @Before
    public void testSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("Setup çalıştı.");
    }

    @Test
    public void test02(){
        //amazon'a gidilsin.title alınsın ve dogrulama yapılsın.
        driver.navigate().to("https://www.amazon.com/");
        String amazonActualTitle = driver.getTitle();
        String amazonExpectedTitle = "Amazon";
        if (amazonActualTitle.contains(amazonExpectedTitle)){
            System.out.println("Test PASSED - Amazon Title");
        }else{
            System.out.println("Test FAILED");
        }
    }

    @Test
    public void test03(){
        //google'a gidilsin. title alınsın ve dogrulama yapılsın.
        driver.navigate().to("https://www.google.com/");
        String googleActTitle = driver.getTitle();
        String googleExpTitle = "Google";
        if (googleActTitle.contains(googleExpTitle)){
            System.out.println("Test PASSED - Google Title");
        }else{
            System.out.println("Test FAILED.");
        }
    }

    @After
    public void testClose(){
        driver.close();
        System.out.println("Driver kapatıldı.");
    }

}
