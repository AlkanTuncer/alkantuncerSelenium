package day07_TekrarSorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Test {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //* 1. Sayfaya gidiniz http://automationexercise.com/
        driver.navigate().to("http://automationexercise.com/");

        //* 2. Site logosunu test ediniz
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Website for automation practice\"]"));
        if (logo.isDisplayed()) System.out.println("Test PASSED - Logo test edildi.");

        //* 3.'Signup / Login' button tıklayınız
        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();

        //* 4. email adres ve parola giriniz //* 5. Click 'login' yapınız
        driver.findElement(By.xpath("//input[@placeholder=\"Email Address\"]")).sendKeys("guidersoft@merhaba.com");
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("12345", Keys.ENTER);

        //* 6. Delete Account yazısını doğrulayınız
        WebElement deleteAccountButton = driver.findElement(By.xpath("(//a[@style=\"color:brown;\"])[2]"));
        if (deleteAccountButton.getText().equals("Delete Account")){
            System.out.println("Text dogrulandı. - Test PASSED.");
        }else{
            System.out.println("Test FAILED.");
        }

        //* 7. Sayfadan 'Logout yapınız
        driver.findElement(By.xpath("(//a[@style=\"color:brown;\"])[1]")).click();

        //* 8. lOGİN SAYFASINA GİDİLDİĞİNİ KONTROL EDİNİZ.
        WebElement login = driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]"));
        if (login.getText().equals("Login")){
            System.out.println("Login sayfasında. - Test PASSED.");
        }else{
            System.out.println("Test FAILED");
        }

        //* 9. Close driver
        driver.close();

    }
}
