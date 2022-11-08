package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C08_Odev2 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //    1-https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //    2-video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).perform();
        //    3-videoyu izlemek icin Play tusuna basin
        WebElement youtube=driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtube);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        //    4-videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@title='Watch on youtube.com']")).isEnabled());
    }
}
