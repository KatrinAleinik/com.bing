import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {

     XSSFWorkbook wb;
     XSSFSheet sheet;
     DataFormatter formatter;



    public ReadExcelFile(String excelPath) {
        try {

            File scr = new File(excelPath);
            FileInputStream fis = new FileInputStream(scr);
            wb = new XSSFWorkbook(fis);
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public String getData(int sheetnumber, int row, int colomn){

        formatter =new DataFormatter();
        sheet = wb.getSheetAt(sheetnumber);
        XSSFCell cell = sheet.getRow(row).getCell(colomn);
        String data = formatter.formatCellValue(cell);
        return data;
    }

    public int getRowCount(int sheetIndex){
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();

        row = row+1;

        return row;
    }



}
