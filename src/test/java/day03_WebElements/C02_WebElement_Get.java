package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WebElement_Get {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. http://a.testaddressbook.com/ adresine gidiniz.
        driver.navigate().to("https://a.testaddressbook.com/");

        // sign in linkini locate edelim.
        WebElement singInButton = driver.findElement(By.id("sign-in"));

        System.out.println("singInButton = " + singInButton.getText());  // Butonun üzerindeki yazıyı aldık.
        System.out.println("singInButton.getAriaRole() = " + singInButton.getAriaRole());  // Butonun özelliğini gösterir.
        System.out.println("singInButton.getAttribute() = " + singInButton.getAttribute("id")); // Verilen attribute'ün value'sini verir.
        System.out.println("singInButton.getTagName() = " + singInButton.getTagName()); // Butonun tag'ini verir. link oldugu için a burda.
        System.out.println("singInButton.getRect().height = " + singInButton.getRect().height); // Sing In butonunun yüksekliğini.
        System.out.println("singInButton.getRect().width = " + singInButton.getRect().width); // Butonun genişliği.
        System.out.println("singInButton.getCssValue() = " + singInButton.getCssValue("color")); // Butonun rengini verir.

        // WebElement Is Method’lari
        //  webElement.isEnable( ); Web Element erisilebilir ise true yoksa false doner.
        //  webElement.isDisplayed( ); Web Element gorunur ise true yoksa false doner.
        //  webElement.isSelected( ); Web Element secili ise true yoksa false doner.

        System.out.println("singInButton.isEnabled() = " + singInButton.isEnabled());
        System.out.println("singInButton.isDisplayed() = " + singInButton.isDisplayed());
        System.out.println("singInButton.isSelected() = " + singInButton.isSelected());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.close();
        }

    }
}
