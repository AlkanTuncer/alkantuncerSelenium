package day04and05_XPath_CssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TekrarTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ adresine gidin
        driver.navigate().to("https://www.amazon.com/");

        //Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Spend less")){
            System.out.println("Test PASSED - Başlık 'Spend less' ifadesi içeriyor.");
        }else{
            System.out.println("Test FAILED");
        }

        //Gift Cards sekmesine basin
        WebElement giftCardsBtn = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));
        giftCardsBtn.click();

        //Birthday butonuna basin
        WebElement birthdayBtn = driver.findElement(By.xpath("//img[@alt='Birthday gift cards']"));
        birthdayBtn.click();

        //Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@id=\"acs-product-block-0\"]/div[1]/a/img")).click();

        //Gift card details’den 25 $’i secin
        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1")).click();

        //Urun ucretinin 25$ oldugunu test edin
        String urunUcreti = driver.findElement(By.xpath("//span[@class=\"a-color-price a-text-bold\"]")).getText();
        if (urunUcreti.equals("$25.00")){
            System.out.println("Test PASSED. - $25.00");
        }else{
            System.out.println("Test FAILED.");
        }

        //Sayfayi kapatin
        driver.close();

    }
}
