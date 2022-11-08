package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_Odev {
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
        //driver.quit();
    }
    @Test
    public void test1(){

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    driver.get("http://demo.guru99.com/test/guru99home/");

    //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi =driver.findElements(By.tagName("iframe"));
        System.out.println("iframe sayisi = "+iframeSayisi.size());
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtube=driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/RbSlW8jZFe8']"));
        driver.switchTo().frame(youtube).findElement(By.xpath("//*[@aria-label='Play']")).click();


    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız
        WebElement iframe2= driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2).findElement(By.xpath("//*[@src='Jmeter720.png']")).click();


    }}

