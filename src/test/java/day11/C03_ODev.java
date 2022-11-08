package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.awt.*;
import java.security.Key;
import java.util.List;

public class C03_ODev extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //test1
        //-  amazon gidin
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);

        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());

        for (WebElement w:ddmList
             ) {
            System.out.println(w.getText());
        }

        //dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertNotEquals(ddmList.size(),40);


        //dropdown menuden Automotive bölümü seçin
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).click();
        select.selectByVisibleText("Automotive");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("", Keys.ENTER);

        //arama kutusunu bos birakip enter diyin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("", Keys.ENTER);
        WebElement sonucYazisi= driver.findElement(By.xpath("//div[@class='a-cardui-body _octopus-search-result-card_style_apbBrowseSearchResultsRibText__3NqJw']"));
        System.out.println(sonucYazisi.getText());
        //sonuc sayisi bildiren yazinin Automotive icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("Automotive"));
        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun=driver.findElement(RelativeLocator.with(By.tagName("img"))
                        .toLeftOf(By.xpath("(//*[@data-image-source-density='1'])[3]"))
                        .toRightOf(By.xpath("(//*[@data-image-source-density='1'])[1]")));
        birinciUrun.click();
        //ürünün title'ni ve fiyatını variable’a  assign edip yazdirin ve ürünü sepete ekleyin
        //driver.findElement(By.xpath("(//*[@data-image-source-density='1'])[2]")).click();
        String title=driver.findElement(By.xpath("//*[@class='a-size-large product-title-word-break']")).getText();
        System.out.println(title);
        String fiyat=driver.findElement(By.xpath("(//span[text()='$24.95'])[4]")).getText();
        System.out.println(fiyat);
        driver.findElement(By.xpath("(//*[@id='add-to-cart-button'])[1]")).click();

        //Test03

        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        //dropdown’dan bebek bölümüne secin
        WebElement ddm2=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select2=new Select(ddm2);
        select2.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))
                .sendKeys("baby stroller", Keys.ENTER);
        WebElement sonucYazisi2= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi2);
        //sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(sonucYazisi2.getText().contains("baby stroller"));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun=driver.findElement(RelativeLocator.with(By.tagName("img"))
                .below(driver.findElement(By.xpath("(//*[@data-image-source-density='1'])[2]"))).
                above(driver.findElement(By.xpath("(//*[@data-image-source-density='1'])[4]"))));
        ikinciUrun.click();
        //6-title ve fiyat bilgilerini assign edip yazdirin ve ürünü sepete ekleyin
        String title2=driver.findElement(By.xpath("//*[@class='a-size-large product-title-word-break']")).getText();
        System.out.println(title2);
        String fiyat2=driver.findElement(By.xpath("(//*[text()='$69.99'])[4]")).getText();
        System.out.println(fiyat2);
        driver.findElement(By.xpath("(//*[@id='add-to-cart-button'])[1]")).click();

    // Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.xpath("(//*[@class='a-button-text'])[7]")).click();
        String sepetIkinciUrunTitle=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[5]")).getText();
        String sepetBirinciUrunTitle=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[6]")).getText();
        Assert.assertEquals(title2,sepetIkinciUrunTitle);
        Assert.assertEquals(title,sepetBirinciUrunTitle);

        String sepettekiIkinciUrunFiyat=driver.findElement(By.xpath("//*[text()='$69.99']")).getText();
        Assert.assertEquals(fiyat2,sepettekiIkinciUrunFiyat);
        String sepettekiIlkUrunFiyat=driver.findElement(By.xpath("//*[text()='$24.95']")).getText();
        Assert.assertEquals(fiyat,sepettekiIlkUrunFiyat);
}}
