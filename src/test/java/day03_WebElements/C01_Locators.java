package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //http://a.testaddressbook.com/ adresine gidiniz.
        driver.navigate().to("https://a.testaddressbook.com/");

        //Sign in butonuna basin
        WebElement signInButton = driver.findElement(By.id("sign-in"));
        signInButton.click();

        //email textbox, password textbox ve sign in button elementlerini locate ediniz..
        WebElement emailTextBox = driver.findElement(By.name("session[email]"));
        WebElement passwordTextBox = driver.findElement(By.name("session[password]"));
        WebElement signIn = driver.findElement(By.name("commit"));

        //Email ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //Username :testtechproed@gmail.com
        //Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signIn.click();

        //Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String expectedUserId = "testtechproed@gmail.com";
        String actualUserId = driver.findElement(By.className("navbar-text")).getText();
        if (expectedUserId.equals(actualUserId)){
            System.out.println("Test PASSED _ User ID doğrulandı.");
        }else{
            System.out.println("Test FAILED _ Actual User ID : "+actualUserId);
        }

        //“Addresses” ve “Sign Out” textlerinin göruntulendiğini(displayed) doğrulayin(verify).
        if (driver.findElement(By.linkText("Addresses")).isDisplayed() & driver.findElement(By.linkText("Sign out")).isDisplayed()){
            System.out.println("Test PASSED _ Adresses and Sign out textleri görüntülendi.");
        }else{
            System.out.println("Test FAILED.");
        }

        //Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkSayisi = driver.findElements(By.tagName("a"));
        System.out.println("Link Sayısı = "+linkSayisi.size());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.close();
        }
    }
}
