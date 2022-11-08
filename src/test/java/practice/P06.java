package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P06 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe= driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();


        // tüm hayvan emojilerine tıklayın
        List<WebElement> emojiler=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
        for (WebElement w:emojiler
             ) {
            w.click();
        }
        // formu doldurun (dilediğinizi yazabilirsiniz)
        driver.switchTo().defaultContent();
        List<WebElement> boxes=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> textlist=new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","a","f","s","q"));
        for (int i = 0; i < boxes.size() ; i++) {
            boxes.get(i).sendKeys(textlist.get(i));
        }
        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }
}
