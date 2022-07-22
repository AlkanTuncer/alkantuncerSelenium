package day09_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CheckBox {

    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    //b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın

    private WebDriver driver;
    private WebElement checkBox1;
    private WebElement checkBox2;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        checkBox1 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        checkBox2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));
    }

    @Test
    public void testCheckBox1(){
        if (checkBox1.isSelected()){
            System.out.println("Check Box 1 seçili.");
        }else {
            checkBox1.click();
            System.out.println("Check Box 1 onay kutusu seçildi.");
        }
    }

    @Test
    public void testCheckBox2(){
        if (checkBox2.isSelected()){
            System.out.println("Check Box 2 seçili.");
        }else{
            checkBox2.click();
            System.out.println("Check Box 2 onay kutusu seçildi.");
        }
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
