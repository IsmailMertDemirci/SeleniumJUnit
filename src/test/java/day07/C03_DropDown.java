package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    /*
    -Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
     */
    WebDriver driver;
    Select select;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45 oldugunu testedin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);

        /*
        Dropdan menuye ulasmak icin Select class'inda bir obje olustururuz ve locate ettigimiz dropdown webelementini
        Select class'ina tanimlariz ve getOption methodunu kullanarak dropDown'u bir List'e atarak dropdown menunun butun
        elemanlarinin sayisina ulasabiliriz
         */
        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());

        int expectedNumber=45;
        int actualNumber= ddmList.size();
        Assert.assertNotEquals(expectedNumber,actualNumber);

    }
    @Test
    public void test2(){
        //           1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);

        //select.selectByVisibleText("Books"); // E??er Dropdown menudeki option'a string olarak ula??mak istersek bu methodu kullan??r??z
        //select.selectByIndex(5); // E??er dropdown menus??nun index'i ile ulasmak istersek bu methodu kullan??r??z
        select.selectByValue("search-alias=stripbooks-intl-ship"); // E??er dropdown menusundeki optiona value ile ula??mak istersek bu methodu kullan??r??z
         /*
        Dropdown menude se??ti??imiz optiona ula??mak istersek select.getFirstSelectedOption()
        methodunu kullan??r??z
         */
        System.out.println(select.getFirstSelectedOption().getText());
//           2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
//           3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
//           4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        /*
        selectByVisibleText () / deselectByVisibleText ()   g??r??nt??lenen metne g??re bir se??ene??i se??er / se??imi kald??r??r
        selectByValue () / deselectByValue ()   "value" ??z niteli??inin de??erine g??re bir se??ene??i se??er / se??imi kald??r??r
        selectByIndex () / deselectByIndex ()   indeksine g??re bir se??ene??i se??er / se??imi kald??r??r
        isMultiple ()   a????l??r ????e bir seferde birden fazla se??ime izin veriyorsa, DO??RU d??nd??r??r; Aksi takdirde YANLI??
        Hi??birini se??me() ??nceden se??ilen t??m se??eneklerin se??imini kald??r??r
         */

    }
}
