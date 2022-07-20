package day07_TekrarSorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Test {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
            Amazon Search Barı :
            <div class="nav-fill">
            <div class="nav-search-field ">
                <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder=""
                class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">  </div>
            <a class="gb_d" data-pid="23" href="https://mail.google.com/mail/&amp;ogbl" target="_top">Gmailecom</a>

            1- id : twotabsearchtextbox
            2- name : field-keywords
            3- className : nav-input nav-progressive-attribute
            4- tagName : input
            5- linkText : Gmailecom
            6- partil linkText : lecom, mail, mailecom
            7- Xpath (hem relative hem absolute) : //input[@id="twotabsearchtextbox"]
                                                 : /html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input
            8- Css Locate : input[id='twotabsearchtextbox']
                          : id için -> #twotabsearchtextbox
                          : class için -> .nav-input nav-progressive-attribute
         */

        driver.findElement(By.id("twotabsearchtextbox"));

        driver.findElement(By.name("field-keywords"));

        driver.findElement(By.className("nav-input nav-progressive-attribute"));

        driver.findElement(By.tagName("input")); // Unique sonuç vermez.

        driver.findElement(By.linkText("Gmailecom"));

        driver.findElement(By.partialLinkText("lecom"));

        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));

        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

    }
}
