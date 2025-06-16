package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class ExcelReader {



    public Object[][] readExcelFile(String sheetName) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/utilities/testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rows = sheet.getPhysicalNumberOfRows()-1;
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows][columns];

        for (int i=0;i<rows;i++){
            XSSFRow row = sheet.getRow(i+1);
            for (int j=0;j<columns;j++){
                XSSFCell cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
            }
        }

        System.out.println(data);
        return data;

    }






}
