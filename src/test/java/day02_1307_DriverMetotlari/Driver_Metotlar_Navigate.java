package day02_1307_DriverMetotlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_Metotlar_Navigate {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();  // Genelde çalışırken direkt max pencerede başlatıcaz.

        /*
            driver.navigate().to()  -> driver.get() ile aynı işi yapar. Girilen siteye gider.
            driver.navigate.back()  -> Browser'da geri gelir.
         */


        try {
            driver.navigate().to("https://www.amazon.com.tr");  // amazon'a gitti.
            Thread.sleep(3000);
            driver.navigate().to("https://www.netflix.com");    // aynı sayfada netflix'e gitti.
            Thread.sleep(3000);
            driver.navigate().back();                               // sonra amazon'a geri döndü.
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.close();
        }

    }
}
