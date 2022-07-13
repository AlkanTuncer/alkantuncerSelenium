package day02_1307_DriverMetotlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver03_Metotlar_Manage {
    public static void main(String[] args) {

        // MANAGE - WINDOW METOTU

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com.tr");

        /*
            driver.manage().window().maximize()    -> Browser'ı tam sayfa yapar. Maksimize eder.
            driver.manage().window().minimize()    -> Browser'ı simge durumuna küçültür. Minimize eder.
            driver.manage().window().fullscreen()  -> Browser'ı tam ekran yapar.
            driver.manage().window().getPosition() -> Browser'ımızın koordinatlarını String olarak verir.
            driver.manage().window().getSize()     -> Browser'ın ölçülerini String olarak verir.

         */

        try {
            System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
            System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
            driver.manage().window().minimize();    // minimize
            Thread.sleep(3000);               // 3 sn sonra diğer metota gecicek.
            driver.manage().window().maximize();    // maximize
            Thread.sleep(3000);
            driver.manage().window().fullscreen();  // fullscreen
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.close();
        }

    }
}
