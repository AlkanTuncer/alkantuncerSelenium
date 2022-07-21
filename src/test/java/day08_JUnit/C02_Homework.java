package day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Homework {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.navigate().to("https://www.amazon.com/");

        // 2- arama kutusunu locate edelim
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone", Keys.ENTER);

        // 3- “iphone ” ile arama yapalim (Yukarda yaptım.)
        // 4 - Bulunan sonuc sayisini yazdiralim
        WebElement sonuclar = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String[] sonuclarText = sonuclar.getText().split(" ");
        String sonucSayisi = sonuclarText[2];
        System.out.println("Sonuç Sayısı : "+sonucSayisi);

        // 5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("//img[@data-image-index=\"1\"]")).click();

        // 6- Bir onceki sayfaya donup,sayfadaki tum ürün baslıklarını yazdiralim
        driver.navigate().back();
        List<WebElement> urunTitles = driver.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));

        for (int i = 0; i < urunTitles.size(); i++) {
            System.out.println((i+1)+". Ürün : "+urunTitles.get(i).getText());
        }
        System.out.println("urunTitles.size() = " + urunTitles.size());

        driver.close();

    }
}
