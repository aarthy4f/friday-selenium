package e2e.util;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;



public class ExcelUtil {

   private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray() throws Exception {
        String Filedata = "./src/test/resources/data/InsuranceData.xlsx";
        String[][] tabArray = null;

        String SheetName = "Sheet1";
        try {

            FileInputStream ExcelFile = new FileInputStream(Filedata);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 1;

            int startCol = 1;

            int ci, cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            System.out.println(totalRows);

            int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
            totalCols=totalCols-1;
            System.out.println(totalCols);
            tabArray = new String[totalRows][totalCols];

            ci = 0;

            for (int i = startRow; i <= totalRows; i++, ci++) {

                cj = 0;

                for (int j = startCol; j <= totalCols; j++, cj++) {

                   tabArray[ci][cj] = getCellData(i, j);

                    System.out.println(tabArray[ci][cj]);

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return (tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);



                String CellData = Cell.getStringCellValue();
                //System.out.println(CellData);

                return CellData;


        } catch (Exception e) {

            System.out.println(e.getMessage());

            throw (e);

        }

    }

}
