package practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P05 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Verify that we have pom.xml file in our project => please try in 4 min s

        String path="C:\\Users\\Mert\\IdeaProjects\\com.Batch81Junit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));
        /*
         String dosyaYol = "pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYol)));
         */
    }
}
