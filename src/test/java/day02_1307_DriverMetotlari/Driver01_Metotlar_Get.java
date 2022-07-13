package day02_1307_DriverMetotlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver01_Metotlar_Get {
    public static void main(String[] args) {

        // Her zaman yapıcaz - Demirbaşlar (:

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        /*
            driver.get()              -> istediğimiz web sitesine gitmeye yarar.
            driver.getTitle()         -> gittiğimiz sitenin başlık bilgisini String olarak bize verir.
            driver.getCurrentUrl()    -> içinde bulundugumuz sayfanın URL'sini String olarak bize verir.
            driver.getPageSource()    -> bulundugumuz sayfanın kaynak kodlarını bize verir.
            driver.getWindowHandle()  -> bulundugumuz sayfanın tc numarasını bize verir. Her sayfa için unique'tir.
            driver.getWindowHandles() -> sayfanın handle değerini bize verir.
            driver.close()            -> içinde bulundugumuz browser'ı kapatacaktır.
            driver.quit()             -> içinde bulundugumuz browser'ların hepsini kapatır.
         */

        driver.get("https://www.amazon.com");
        System.out.println("driver.getTitle() = "+driver.getTitle());
        System.out.println("Current URL : "+driver.getCurrentUrl());
        //System.out.println("driver.getPageSource() = " + driver.getPageSource());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.close();
        }

    }
}
