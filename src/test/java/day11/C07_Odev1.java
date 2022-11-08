package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C07_Odev1  extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //        1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //        2- Hover over Me First" kutusunun ustune gelin
        WebElement homf= driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(homf).perform();
        //        3-Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
        //        4-Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //        5-Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //        6-“Click and hold" kutusuna basili tutun
        WebElement cAndH= driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(cAndH).perform();
        //        7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement cAndHtext=driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']"));
        System.out.println(cAndHtext.getText());
        //        8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//h2"))).perform();
    }
}
