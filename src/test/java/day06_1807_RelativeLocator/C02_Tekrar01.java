package day06_1807_RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Tekrar01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //*  1. https://trytestingthis.netlify.app/ sayfasina gidin
        driver.navigate().to("https://trytestingthis.netlify.app/");

        //*  2. Kullanıcı adı "test" giriniz
        driver.findElement(By.xpath("//input[@id=\"uname\"]")).sendKeys("test");

        //*  3.  Password olarak "test" giriniz
        driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("test");

        //*  4.  Login butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();

        //*  5.  "Login Successful :)" texti gorunur ise Pass yazdırın.
        if (driver.findElement(By.xpath("//*[.=\"Login Successful :) \"]")).getText().equals("Login Successful :)")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        if (driver.findElement(By.xpath("//*[.=\"Login Successful :) \"]")).isDisplayed()){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        //*  6. Textin içindeki "Click here to go back to the home page" !<"here">! tiklayın
        driver.findElement(By.xpath("//a[@href=\"index.html\"]")).click();

        //*  7.  Ana sayfadaki "This is your layout two" görünürlüğünü test edin.
        if (driver.findElement(By.xpath("//*[.=\"This is your layout two\"]")).isDisplayed()){
            System.out.println("Test PASS");
        }else{
            System.out.println("Test FAIL");
        }

        //*  8.  Tum sayfalari kapatiniz
        driver.close();

    }
}
