package day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

        // 1. “https://www.saucedemo.com/ Adresine gidin
        driver.navigate().to("https://www.saucedemo.com/");

        // 2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@class=\"input_error form_input\"]")).sendKeys("standard_user");

        // 3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("(//input[@class=\"input_error form_input\"])[2]")).sendKeys("secret_sauce");

        // 4 . Login tusuna basin
        driver.findElement(By.xpath("//input[@data-test=\"login-button\"]")).click();

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]"));
        System.out.println("İlk Ürün İsmi = "+ilkUrun.getText());
        ilkUrun.click();

        // 6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory\"]")).click();

        // 7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();

        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement urunSepet = driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]"));
        if (urunSepet.isDisplayed()){
            System.out.println("Test PASSED - Ürün başarıyla sepete eklendi.");
        }else{
            System.out.println("Test FAILED - Ürün sepete eklenemedi.");
        }

        // 9. Sayfayi kapatin
        driver.close();

    }
}
