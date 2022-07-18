package day04and05_XPath_CssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CssSelector {

    /*
        css = tagName[attribute name='value'];

        css = "tagName#idValue"     -> Bu ikisi sadece id value ile çalışır.
        css = "#idValue"

        css = "tagName.classValue"  -> Bu ikisi sadece class value ile çalışır.
        css = ".classValue"
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.navigate().to("http://a.testaddressbook.com/sign_in");

        //Locate email textbox, password textbox, signin button
        WebElement emailTextBox = driver.findElement(By.cssSelector("input#session_email"));
        WebElement passwordTB = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        WebElement signInButton = driver.findElement(By.cssSelector("input[value=\"Sign in\"]"));

        //Asagidaki kullanıcı adını ve şifreyi girin ve sign in duğmesini tıklayın
        //Username :testtechproed@gmail.com
        // Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTB.sendKeys("Test1234!");
        signInButton.click();

        //NOT: cssSelector kullanarak elementleri locate ediniz.

        WebElement simpleYazisi = driver.findElement(By.tagName("h4"));
        System.out.println("Sayfadaki Yazı = " + simpleYazisi.getText());

        driver.close();


    }
}
