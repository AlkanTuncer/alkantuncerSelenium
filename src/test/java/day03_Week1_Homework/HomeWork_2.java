package day03_Week1_Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork_2 {
    public static void main(String[] args) {

       /*
            1. Yeni bir class olusturalim (Homework)
            2. ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
            oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
            3. Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
            4. https://www.walmart.com/ sayfasina gidin.
            5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
            6. Tekrar “facebook” sayfasina donun
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.facebook.com");

        if (driver.getTitle().equals("facebook")){
            System.out.println("Title : facebook");
        }else{
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        }else{
            System.out.println("Actual URL : "+driver.getCurrentUrl());
        }

        driver.navigate().to("https://www.walmart.com");
        if (driver.getTitle().contains("Walmart.com"))System.out.println("Title 'Walmart.com' içeriyor");

        driver.navigate().back();
        driver.close();

    }
}
