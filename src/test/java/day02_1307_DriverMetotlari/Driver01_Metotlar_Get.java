package day02_1307_DriverMetotlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver01_Metotlar_Get {
    public static void main(String[] args) {

        // Her zaman yapıcaz (:

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        /*
            driver.get()              -> İstediğimiz web sitesine gitmeye yarar.
            driver.getTitle()         -> Gittiğimiz sitenin başlık bilgisini String olarak bize verir.
            driver.getCurrentUrl()    -> İçinde bulundugumuz sayfanın URL'sini String olarak bize verir.
            driver.getPageSource()    -> Bulundugumuz sayfanın kaynak kodlarını bize verir.
            driver.getWindowHandle()  -> Bulundugumuz sayfanın tc numarasını bize verir. Her sayfa için unique'tir.
            driver.getWindowHandles() -> Sayfanın handle değerini bize verir.
         */

        driver.get("https://www.amazon.com");
        System.out.println("driver.getTitle() = "+driver.getTitle());
        System.out.println("Current URL : "+driver.getCurrentUrl());
        //System.out.println("driver.getPageSource() = " + driver.getPageSource());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());

    }
}
