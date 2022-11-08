package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    //Bir onceki class'ta bulunan adrese gidelim
    //Login methodunu kullanarak sayfaya giris yapiniz
    //int satir=3, int sutun=4;
    //input olarak verilen satir sayisi ve sutun sayisina sahip cell'deki text'i yazdiralim
    //price basligindaki tum numaralari yazdiriniz

    @Test
    public void test1() {
        login();
        int satir=3;
        int sutun=4;
        WebElement cell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Satir ve sutundaki text = "+cell.getText());

        List<WebElement> priceBasligi=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w:priceBasligi
             ) {
            System.out.println(w.getText());
        }
    }
    private void login(){
        //https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        //Username : manager
        //Password : Manager1!
        driver.findElement(By.xpath("//*[@id='UserName']")).click();
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
           /*
Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
sutunlara yani hucrelere<td> tag'i ile ulasilir.
 */
    }
}
