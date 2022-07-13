package day01_0807;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\alkan\\IdeaProjects\\alkantuncerSelenium\\src\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com.tr/");     // Siteyi açan kod.

        try {
            Thread.sleep(5000);                 // Site açılacak 5 saniye sonra kapanacak.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();                               // Siteyi kapatan kod.

    }
}
