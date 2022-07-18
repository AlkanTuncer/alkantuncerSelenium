package day04and05_XPath_CssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon web sayfasına gidin. https://www.amazon.com/
        // Search(ara) “santoku victorinox”
        // Amazon'da göruntulenen ilgili sonuçların sayısını yazdırın
        // Sonra karşınıza çıkan ilk sonucun resmine tıklayın

        driver.navigate().to("https://www.amazon.com");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("santoku victorinox"+ Keys.ENTER);

        WebElement sonucSayisi = driver.findElement(By.className("sg-col-inner"));
        System.out.println("Sonuç Sayısı = " + sonucSayisi.getText());

        //WebElement ilkSonuc = driver.findElement(By.className("s-image"));  aşağıdaki XPath ögrendikten sonra yaptık.
        WebElement ilkSonuc = driver.findElement(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
        ilkSonuc.click();

        driver.close();

    }
}
