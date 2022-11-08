package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    /*
    1-https://the-internet.herokuapp.com/context_menu sitesine gidelim
    2- Cizili alan uzerinde sag click yapalim
    3-Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    4-Tamam diyerek alert’i kapatalim
    5-Elemental Selenium linkine tiklayalim
    6-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test1(){
      //1-https://the-internet.herokuapp.com/context_menu sitesine gidelim
      driver.get("https://the-internet.herokuapp.com/context_menu");

      //2- Cizili alan uzerinde sag click yapalim
      WebElement ciziliAlan=driver.findElement(By.xpath("//*[@id='hot-spot']"));
      Actions actions=new Actions(driver);
      actions.contextClick(ciziliAlan).perform();

      //3-Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
      Assert.assertTrue(driver.switchTo().alert().getText().contains("You selected a context menu"));
      //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

      //4-Tamam diyerek alert’i kapatalim
      driver.switchTo().alert().accept();

      //5-Elemental Selenium linkine tiklayalim
      driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

      //6-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
      List<String> windowList=new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(windowList.get(1));
      Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());



    }
}
