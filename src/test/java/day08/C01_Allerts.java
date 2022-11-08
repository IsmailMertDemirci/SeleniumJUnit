package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {
    /*
    https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    Click for JS Alert butonuna tiklayalim
    Tikladiktan sonra cikan uyari mesajina(allert'e) tamam diyelim
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Click for JS Alert butonuna tiklayalim
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //Tikladiktan sonra cikan uyari mesajina(allert'e) tamam diyelim
        driver.switchTo().alert().accept();
        //JavaScript alertlerinde hicbir tiklama yapilamiyor, alerti kabul etmek icin bu kod blogu kullaniliyor
        /*
        driver.switchTo().alert().accept(); //uyarıyı gecmek icin kullanırız, uyarıyı gecmeyi kabul et gibi bir anlamı var.

        driver.switchTo().alert().dismiss(); //iki secenek cıktığınıda iptal e basmak istiyorsak dismiss kullanacağız
                                             //tamam demek istiyorsak accept kullanacağız
                                            //uyarıdaki alert kismina bir mesaj yazmak istiyorsak getText() kullanacağız.
         */
    }
}
