package day07_TekrarSorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;
import java.util.List;

public class C03_Test {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.bestbuy.com/ adresine gidin
        driver.navigate().to("https://www.bestbuy.com/");

        // 2- cookies cikarsa kabul et butonuna basin
        // 3- sayfada kac adet button bulundugunu yazdirin
       List<WebElement> buttonsList = driver.findElements(By.tagName("button"));
        System.out.println("Buton Sayısı = " + buttonsList.size());

        // 4- sayfadaki herbir button uzerindeki yazilari yazdirin
        for (int i = 0; i < buttonsList.size(); i++) {
            System.out.println((i+1)+". Buton = "+buttonsList.get(i).getText());
        }

        for (WebElement buttonText : buttonsList){
            System.out.println("Buton Yazısı = " + buttonText.getText());
        }

        // 5- sayfadaki herbir Bayrak altındaki  yazilari yazdirin
        String canadaText = driver.findElement(By.xpath("//a[@class=\"canada-link\"]")).getText();
        String usText = driver.findElement(By.xpath("//a[@class=\"us-link\"]")).getText();
        String mexicoText = driver.findElement(By.xpath("//a[@href=\"https://www.bestbuy.com.mx/\"]")).getText();

        System.out.println(canadaText+" - "+usText+" - "+mexicoText);

        // 6- sayfadaki United Statesin yerini Realtive locater ile belirleyiniz.
        WebElement canada = driver.findElement(By.xpath("//img[@alt=\"Canada\"]"));
        WebElement usa = driver.findElement(By.xpath("//img[@alt=\"United States\"]"));
        WebElement mexico = driver.findElement(By.xpath("//img[@alt=\"Mexico\"]"));

        WebElement usaRL = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(canada).toLeftOf(mexico));

        driver.close();

    }
}
