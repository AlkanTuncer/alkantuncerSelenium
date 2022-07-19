package day06_1807_RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Tekrar02 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.google.com/ adresine gidin
        driver.navigate().to("https://www.google.com/");

        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Google")){
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED.");
        }

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        WebElement sonucText = driver.findElement(By.xpath("//div[@id=\"result-stats\"]"));
        System.out.println("Sonuç Text = " + sonucText.getText());

        // String sonucSayısı = sonucText.getText().substring(9,20);
        String[] sonuc = sonucText.getText().split(" ");
        String sonucSayısı = sonuc[1].replace(".","");
        System.out.println("Sonuç Sayısı = "+sonucSayısı);

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin.
        int sayi = Integer.parseInt(sonucSayısı);
        if (sayi>10_000_000){
            System.out.println("Sayı 10 milyondan fazla. - Test PASSED.");
        }else{
            System.out.println("Test FAILED.");
        }

        //Sayfayi kapatin
        driver.close();

    }
}
