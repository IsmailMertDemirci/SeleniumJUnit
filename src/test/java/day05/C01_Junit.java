package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Junit {
    //method olusturtuk, burada junit ile testlerimizi yapabilmek icin üzerine @ annotations dedigimiz @ isaretini
    // koyuyoruz ve test yazıyoruz
    //run tusu main method yazarsak veya test notasyonunu yazarsak cıkar.
    //JUnit ten run yaparsak buradaki bütün methodlar calisir yani aynı anda birden fazla yerin testini yapabiliriz.
    @Test
    public void method1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        //kod calıstıktan sonar asağıda kac saniyede calıstğı ve test passed seklinde cıkar.

    }
    public void method2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");

    }
    public void method3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hepsiburada.com");
        /*
        @Before : Önce ; @After : Sonra Demek. @Test kısmında yazdığımız methodlar;
        çalışmaya başlamadan önce @Before yazan method çalışır; sonra kendisi çalışır
        ve en son olarak ta @After da yazılan method çalışır...Bu durum her @Test methodun da aynı şekilde devam eder.
        @After ve @Before methodlarının nerde yazıldığının önemi yoktur
         */
    }

}
