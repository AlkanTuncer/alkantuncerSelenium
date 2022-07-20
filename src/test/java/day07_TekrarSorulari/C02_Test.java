package day07_TekrarSorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Test {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.facebook.com/ adresine gidin
        driver.navigate().to("https://www.facebook.com/");

        //  2- cookies cikarsa kabul et butonuna basin

        // 3- e-posta kutusuna rastgele bir mail girin
        driver.findElement(By.xpath("//input[@class=\"inputtext _55r1 _6luy\"]")).sendKeys("53_53_ALKANTUNCER@hotmail.com");

        // 4- sifre kismina rastgele bir sifre girin
        driver.findElement(By.xpath("//input[@class=\"inputtext _55r1 _6luy _9npi\"]")).sendKeys("5353");

        // 5- giris yap butonuna basin
        driver.findElement(By.xpath("//button[@class=\"_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy\"]")).submit();

        // 6- uyari olarak "The email or mobile number you entered isn’t connected to an account.
        // Find your account and log in. “ mesajinin ciktigini test edin
        if (driver.findElement(By.xpath("//div[@class=\"_9ay7\"]")).isDisplayed()){
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED.");
        }

        // 7- sayfayi kapatin
        driver.close();

    }
}
