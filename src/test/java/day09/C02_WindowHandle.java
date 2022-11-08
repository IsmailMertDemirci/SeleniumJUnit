package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
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
        driver.quit();//iki pencerede calistigimiz icin quit
    }
    @Test
    public void test1(){
        /*
        //1- Amazon Sayfasina girelim
        //2- Url'nin amazon içerdiğini test edelim
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        //4- title'in BestBuy içerdiğini test edelim
        //5- İlk sayfaya dönüp sayfada java aratalım
        //6- Arama sonuclarının java içerdiğini test edelim
        //7- Yeniden bestbuy sayfasına gidelim
        //8- Logonun görünürlüğünü test edelim
        //9- Sayfaları Kapatalım
         */
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();

        /*
        Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
        driver'in window handle değerini string bir değişkene atarız
        Sonrasında farklı bir sayfaya yada sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
        String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
         */
        //2- Url'nin amazon içerdiğini test edelim
        String expextedWord="amazon";
        Assert.assertTrue(driver.getCurrentUrl().contains(expextedWord));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        //4- title'in Best Buy içerdiğini test edelim
        String expectedTitle="Best Buy";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
        String bestBuyWindowHandle=driver.getWindowHandle();

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        //driver.switchTo().window(amazonWindowHandle).findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime="Java";
        String actualSonucYazisi=sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(arananKelime));
        //Assert.assertTrue(aramaSonucu.getText().contains(arananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());

        //9- Sayfaları Kapatalım

    }
}
