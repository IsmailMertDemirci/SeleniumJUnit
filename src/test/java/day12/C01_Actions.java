package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Automation exercises sitesine gidiniz
        driver.get("https://www.automationexercise.com");
        //product bolumune girelim
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //bu soruda acilan sayfada secmemiz gereken sey biraz asagidaysa PAGE DOWN komutuyla secebilecegimizi gorduk
        //ilk urunu secelim
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();
    }
}
