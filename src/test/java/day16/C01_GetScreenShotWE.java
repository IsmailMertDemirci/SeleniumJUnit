package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Key;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        //Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        //Arama sonuc yazisinin resmini alalim
        WebElement aramaSonucu= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu=aramaSonucu.getScreenshotAs(OutputType.FILE);
        /*
        // WebElement'in screenshot'ını alırken, tüm sayfanınkini alırken yaptığımız
        // TakeScreenShot class'ından obje üretme işlemini yapmıyoruz.
        // Bunun yerine locate'ini aldığımız WebElement üzerinden
        // getScreenshot method'unu çalıştırıyoruz
         */
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntusuWE/WebElementScreenShot.jpeg"));
    }
}
