package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C06_Odev extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Ödev 2
        //"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //"Our Products" butonuna basin
        WebElement frameBox=driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(frameBox);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement productsButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Our Products']")));
        productsButton.click();
        //"Cameras product"i tiklayin
        WebElement cameraButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='camera-img']")));
        cameraButton.click();
        //Popup mesajini yazdirin
        WebElement warningText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-body']")));
        System.out.println(warningText.getText());
        //"close" butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent().findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();
        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("http://webdriveruniversity.com/index.html"));
    }

}
