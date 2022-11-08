package day12;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C07_Odev extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Ödev 3
        //
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a  kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN);

        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        // 4.Diger window'a gecin
        List<String> windows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        //5."username" ve  "password" kutularina deger yazdirin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Username']")));
        WebElement password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Password']")));
        Faker faker=new Faker();
        userName.sendKeys(faker.name().username());
        password.sendKeys(faker.internet().password());

        //6."login" butonuna basin
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertTrue(driver.switchTo().alert().getText().contains("validation failed"));

        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //Ilk sayfaya geri donun
        driver.switchTo().window(windows.get(0));

        //Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("http://webdriveruniversity.com/"));

        driver.quit();
    }

}
