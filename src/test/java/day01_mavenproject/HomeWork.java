package day01_mavenproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {
    public static void main(String[] args) {

        // Task 1 : Google'a git - Pathli yolla.

        System.setProperty("webdriver.chrome.driver","C:\\Users\\alkan\\IdeaProjects\\alkantuncerSelenium\\src\\driver\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com/");


        // Task 2 : Paypal'a git - Bonigarcia ile.

        WebDriverManager.chromedriver().setup();
        WebDriver wDriver = new ChromeDriver();
        wDriver.get("https://www.paypal.com/");

    }
}
