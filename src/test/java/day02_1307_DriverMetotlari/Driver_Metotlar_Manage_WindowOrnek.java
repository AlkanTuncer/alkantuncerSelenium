package day02_1307_DriverMetotlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_Metotlar_Manage_WindowOrnek {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.futbin.com");

        try {
            driver.manage().window().setPosition(new Point(80,12));
            Thread.sleep(3000);
            driver.manage().window().setSize(new Dimension(580,990));
            System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
            System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.close();
        }

    }
}
