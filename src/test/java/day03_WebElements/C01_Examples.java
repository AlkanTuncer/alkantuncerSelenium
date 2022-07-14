package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Examples {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.navigate().to("https://www.youtube.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED _ Actual Title = "+actualTitle);
        }

        //Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        if (driver.getCurrentUrl().contains("youtube")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        }

        //Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //Youtube sayfasina geri donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //Amazon sayfasina donun
        driver.navigate().forward();

        //Sayfayi tamsayfa yapi
        driver.manage().window().fullscreen();

        //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        if (driver.getTitle().contains("Amazon")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED _ Actual Title = " + driver.getTitle());
        }

        //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        if (driver.getCurrentUrl().equals("https://www.amazon.com/")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("URL = " + driver.getCurrentUrl());
        }

        //Sayfayi  kapatin
        driver.close();

    }
}
