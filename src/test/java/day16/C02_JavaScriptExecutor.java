package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JavaScriptExecutor extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        //asagidaki careers butonunu gorunceye kadar javascript ile scroll yapalim
        WebElement careers=driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",careers);
        //Careers butonuna javascript ile click yapalim
        jse.executeScript("arguments[0].click()",careers);
    }
}
