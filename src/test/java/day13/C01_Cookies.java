package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //-tum cookie’leri listeleyin
        Set<Cookie> allCookies=driver.manage().getCookies();
        System.out.println(allCookies);
        for (Cookie w:allCookies
             ) {
            System.out.println(w.getName());
            System.out.println(w.getValue());
        }
        //Lambda ile cookiesSet.stream().forEach(t-> System.out.println("name : "+t.getName()+" value :"+t.getValue()));

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi=allCookies.size();
        Assert.assertTrue(cookieSayisi>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:allCookies
             ) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }
        //Lambda ile cookiesSet.stream().filter(t-> t.getName().equals("i18n-prefs")).forEach(t-> Assert.assertEquals("USD",t.getValue()));

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookie);

        allCookies=driver.manage().getCookies();
        System.out.println(allCookies);
        for (Cookie w:allCookies
        ) {
            System.out.println(w.getName());
            System.out.println(w.getValue());
        }

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(allCookies.contains(newCookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies);
        for (Cookie w:allCookies
        ) {
            System.out.println(w.getName());
            System.out.println(w.getValue());
        }
        Cookie isim=driver.manage().getCookieNamed("skin");
        Assert.assertFalse(allCookies.contains(isim));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        allCookies=driver.manage().getCookies();
        Assert.assertTrue(allCookies.isEmpty());
    }
}
