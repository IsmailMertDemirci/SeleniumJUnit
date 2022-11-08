package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1(){
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropMe=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        //Extends yaptığımız TestBase Class'da Actions clasını oluşturursak actions. diyerek direk kullanabiliriz
        actions.dragAndDrop(dragMe,dropMe).perform();

        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
        //Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Dropped!']")).isDisplayed());

    }
}
