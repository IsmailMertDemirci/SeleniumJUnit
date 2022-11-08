package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTable extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.
        login();









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

        //table( ) metodu oluşturun
        table();

    }
    private void table(){
        /*
        Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
        Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
        Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
        Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
        sutunlara yani hucrelere<td> tag'i ile ulasilir.
        */
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi = "+sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar=driver.findElement(By.xpath("//thead//tr"));
        System.out.println(basliklar.getText());

        WebElement body=driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body: "+body.getText());

        //printRows( ) metodu oluşturun //tr
        printRows();

    }
    private void printRows(){
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satirList.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t-> System.out.println(t.getText()));

        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.print("4.row elements : ");
        satirList.stream().map(WebElement::getText).limit(4).skip(3).forEach(System.out::println);
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }
}
