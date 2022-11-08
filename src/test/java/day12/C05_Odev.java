package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C05_Odev extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Ödev 1
        //"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //"Hover over Me First" kutusunun ustune gelin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement homf= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hover Over Me First!']")));
        actions.moveToElement(homf).perform();
        //"Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
        //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //"Click and hold" kutusuna basili tutun
        WebElement cAndH= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Click and Hold!']")));
        actions.clickAndHold(cAndH).perform();
        //"Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement cAndHtext=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Well done! keep holding that click now.....']")));
        System.out.println(cAndHtext.getText());
        //"Double click me" butonunu cift tiklayin
        WebElement doubleClick=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
        actions.doubleClick(doubleClick).perform();
    }

}
