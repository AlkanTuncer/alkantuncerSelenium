package day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit02 {

    @Test
    public void method(){
        System.out.println("Method çalıştı.");
    }
   @Before   // İlk çalısacak.
    public void yaz(){
        System.out.println("Sistem çalışmaya başladı.");
    }
    @After   // En son çalışacak.
    public void duzelt(){
        System.out.println("Sistem ortalığı düzeltmeyi bitirdi.");
    }

}
