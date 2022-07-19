package day06_1807_RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {
    public static void main(String[] args) {

        /*
            https://www.diemol.com/selenium-4-demo/relative-locators-demo.html (Derste bu sitede 'incele' diyerek anlatıldı.)
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo");

        // 1 - once tarif edeceğimiz ve uzerlerinden tarif yapacagimiz web elemntlerini locate etmeliyiz.
        WebElement berlin = driver.findElement(By.xpath("//img[@id=\"pid7_thumb\"]"));

        WebElement bayArea = driver.findElement(By.id("pid8_thumb"));
        WebElement boston = driver.findElement(By.id("pid6_thumb"));
        WebElement newYorkCity = driver.findElement(By.xpath("//img[@id=\"pid3_thumb\"]"));

        // 2 - Berlin’i  3 farkli relative locator ile locate edin
        WebElement berlinRL = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston).toLeftOf(bayArea));
        WebElement berlinRL2 = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(bayArea).below(newYorkCity));
        WebElement berlinRL3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston).below(newYorkCity));

        // 3 - Relative locator’larin dogru calistigini test edin
        String expectedBerlin = berlin.getAttribute("id");

        String actualBerlinRL = berlinRL.getAttribute("id");
        String actualBerlinRL2 = berlinRL2.getAttribute("id");
        String actualBerlinRL3 = berlinRL3.getAttribute("id");

        //İlk locator için dogrulama.
        if (expectedBerlin.equals(actualBerlinRL)){
            System.out.println("BerlinRL - Relative Locator Test PASSED.");
        }else {
            System.out.println("BerlinRL - Relative Locator Test FAILED.");
        }

        //2.locator için dogrulama - id'e göre dogruluyoruz hepsinde
        if (expectedBerlin.equals(actualBerlinRL2)){
            System.out.println("BerlinRL2 - Relative Locator Test PASSED.");
        }else {
            System.out.println("BerlinRL2 - Relative Locator Test FAILED.");
        }

        //3.locator için dogrulama
        if (expectedBerlin.equals(actualBerlinRL3)){
            System.out.println("BerlinRL3 - Relative Locator Test PASSED.");
        }else {
            System.out.println("BerlinRL3 - Relative Locator Test FAILED.");
        }

        driver.close();

    }
}
