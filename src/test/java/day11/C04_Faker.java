package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C04_Faker extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // /*
        //1-"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        //2-"create new account"  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3-"firstName" giris kutusuna bir isim yazin
        Faker faker=new Faker();

        /*
        Faker class'ını kullanma amacımız form doldurmamız gereken web sitelerinde defalarca kendi üreteceğimiz veriler yerine
        bizim için random veriler üretir ve işimizi kolaylaştırır.

        Faker class'ını kullanmak için mvnrespository.com adresinden java faker kütüphanesini aratır ve en çok kullanılanı
        pom.xml dosyamıza (dependencies tagları arasına) ekleriz. Sonra faker class'ından bir obje oluşturup;

        email için: faker.internet() methodunu kullanarak emailAddress() method'unu seçeriz.
        password: faker.internet().password()
        isim: faker.name().firstName()
        soyisim: faker.name().lastName()

        method'larını kullanırız.
 */

        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        String email=faker.internet().emailAddress();//ayni mail adresini girmesi icin String bir degiskene atadik
        actions.click(isim).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Jul").
                sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();;
        //4-"surname" giris kutusuna bir soyisim yazin
        //5-"email" giris kutusuna bir email yazin
        //6-"email" onay kutusuna emaili tekrar yazin
        //7-Bir sifre girin
        //8-Tarih icin gun secin
        //9-Tarih icin ay secin
        //10-Tarih icin yil secin
        //11-Cinsiyeti secin
        //12-Kaydol butonuna basın
        //13-Sayfayi kapatin
        //  */

    }
}
