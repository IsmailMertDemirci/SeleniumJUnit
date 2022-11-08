package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    /*
    -amazon sayfasina gidelim
    -3 farkli test methodu olusturalim
      a- Url'nin amazon icerdigini test edelim
      b- Title'nin facebook icermedigini test edelim
      c-sol ust kosede amazon logosunun gorundugunu test edelim
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
        //amazon.com u beforeclass'a yazarsak testleri ayri ayri calistirdigimizda amazona gitmez
        //ama hep amazonda calisacaksak beforeclass'a eklemek mantikli, her testte yazmamis oluruz boylece
        //a- Url'nin amazon icerdigini test edelim
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));//AssertFalse dersek test fail olur cunku () ici dogru
        //Assert.assertEquals(expectedUrl,actualUrl); seklinde equal methodu kullanildiginda hata varsa if den farkli
        //olarak hata raporu cikar terminalde, oradan <Click to see the difference> tiklarsak ikisinin arasindaki farkli
        //olan kisimlari gorebiliriz, eger karsilastirilan iki link farkli ise assertNotEquals kullanilirsa true doner
    }
    @Test
    public void test2(){
        //b- Title'nin facebook icermedigini test edelim
        String actualTitle=driver.getTitle();
        String expectedTitle="facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));//test pass olur cunku () ici dogru
    }
    @Test
    public void test3(){
        //c-sol ust kosede amazon logosunun gorundugunu test edelim
        WebElement logo=driver.findElement(By.id("nav-logo-spirates"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
