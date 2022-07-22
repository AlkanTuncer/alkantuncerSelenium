package day09_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButtons {

    // // //https://www.facebook.com/ adresine gidin
    //    // //-“Create an Account” button’una basin
    //    //  //-“radio buttons” elementlerini locate edin
    //    //  //Secili degilse cinsiyet butonundan size uygun olani secin

    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();
        WebElement female = driver.findElement(By.xpath("(//label[@class=\"_58mt\"])[1]"));
        WebElement male = driver.findElement(By.xpath("(//label[@class=\"_58mt\"])[2]"));
        WebElement custom = driver.findElement(By.xpath("(//label[@class=\"_58mt\"])[3]"));
        try {
            Thread.sleep(3000);  // Seçilme aşamasını görmek için öncesine ve sonrasına 3 sn ekledim.
            male.click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
