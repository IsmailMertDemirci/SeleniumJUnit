package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Odev {
    /*

         2- Browseri tam sayfa yapin
         3- Sayfayi “refresh” yapin
         4- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
         5- Gift Cards sekmesine basin
         6- Birthday butonuna basin
         7- Best Seller bolumunden ilk urunu tiklayin
         8- Gift card details’den 25 $’i secin
         9-Urun ucretinin 25$ oldugunu test edin
         10-Sayfayi kapatin
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
        driver.close();
    }
    @Test
    public void test1(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //3- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //4- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String wantedWord="Spend less";
        if(driver.getTitle().contains(wantedWord)){
            System.out.println("WantedWord test PASSED");
        }else {
            System.out.println("WantedWord test FAILED");
        }

        //5- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();

        //6- Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday gift cards']")).click();

        //7- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@alt='Amazon.com eGift Card'])[1]")).click();

        //8- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//*[@id='gc-mini-picker-amount-1'])[1]")).click();

        //9-Urun ucretinin 25$ oldugunu test edin
        WebElement dollar= driver.findElement(By.xpath("(//span[text()='$25.00'])[2]"));
        if (dollar.getText().contains("25$")){
            System.out.println("Dollar test PASSED");
        }else {
            System.out.println("Dollar test FAILED");
        }

    }


}
