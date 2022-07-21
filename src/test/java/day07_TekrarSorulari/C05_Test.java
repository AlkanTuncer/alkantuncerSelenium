package day07_TekrarSorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_Test {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //ödev amazona gidiniz
        driver.navigate().to("https://www.amazon.com/");

        //iphone aratınız
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone", Keys.ENTER);

        //satırlar arasında gezip "td" yazdırınız
        List<WebElement> td = driver.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));

        for (int i = 0; i < td.size(); i++) {
            System.out.println((i+1)+". Sonuç : "+td.get(i).getText());
        }

        driver.close();

    }
}
