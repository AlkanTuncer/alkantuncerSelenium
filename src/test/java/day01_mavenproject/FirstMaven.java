package day01_mavenproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMaven {
    public static void main(String [] args) {

        /*
            pom.xml - Maven'in Kalbi
              - Dependencies'i POM dosyasına ekleriz ve POM dosyasından yönetiriz.
              - POM groupId, version gibi proje bilgilerinede sahiptir.


            1. Bonigarcia - WebDriverManager olan dependency'e ekleyeceğiz.
            2. Selenium - dependency'e ekleyeceğiz.
            3. mvnrepository.com'a gidip yukarıdaki adımları uygulucaz.

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.apple.com");

    }
}
