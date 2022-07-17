package SeleniumWeek1_HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork_1 {
    public static void main(String[] args) {

        //1.  https://id.heroku.com/login sayfasina gidin
        //2.  Bir mail adersi giriniz
        //3.  Bir password giriniz
        //4.  Login butonuna tiklayiniz
        //5.  "There was a problem with your login." texti gorunur ise
        //6.  "kayit yapilamadi" yazdiriniz
        //8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        //9.  Tum sayfalari kapatiniz

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://id.heroku.com/login");

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("lazkopat53@hotmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345AT.");
        driver.findElement(By.xpath("//*[@id=\"login\"]/form/button")).submit();

        if (driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]")).getText().equals("There was a problem with your login.")){
            System.out.println("Kayıt yapılamadı.");
        }else{
            System.out.println("Kayıt yapıldı.");
        }

        driver.close();

    }
}
