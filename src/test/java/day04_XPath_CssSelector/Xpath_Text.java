package day04_XPath_CssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpath_Text {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 3 kere basin
        WebElement addButton = driver.findElement(By.xpath("//*[.=\"Add Element\"]"));
        addButton.click();
        addButton.click();
        addButton.click();

        // 2.Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("(//*[.=\"Delete\"])[2]"));
        boolean isDisplayed = deleteButton.isDisplayed();
        if (isDisplayed){
            System.out.println("Test PASSED - Delete Button görünüyor.");
        }else{
            System.out.println("Test FAILED - Delete Button görünmüyor.");
        }

        // 3.Delete tusuna basin
        driver.findElement(By.xpath("(//*[.=\"Delete\"])[3]")).click();

        // *“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        if (driver.findElement(By.xpath("//*[contains(text(),'Remove Elements')]")).isDisplayed()){
            System.out.println("Test PASSED - 'Add/Remove Elements' yazısı görünüyor.");
        }else{
            System.out.println("Test FAILED");
        }

        driver.close();

    }
}
