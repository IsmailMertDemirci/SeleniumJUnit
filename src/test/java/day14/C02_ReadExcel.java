package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //Olusturdugumuz dosya yolunu ya bulamazsam dedigi icin exception ekliyoruz

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream) yapalim
        Workbook workbook= WorkbookFactory.create(fis);
        //Workbook ve fis objesi ile akisa aldigimiz dosyamiza bir excel dosyasi create ettik

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        // - Row objesi olusturun sheet.getRow(index)
        // - Cell objesi olusturun row.getCell(index)
        String actualData=workbook.getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
        System.out.println(actualData);
    }
}
