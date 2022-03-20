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
            // you can write a function as well to get Column count

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
  /* private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;*/

  /*  public static void main(String[] arg) {
        try {
            getTableArray();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
       /* String Filepath = "C:\\Aarthy\\selenium-testng-framework-master\\src\\resources\\DAtasheet.xlsx";
      String SheetName="Sheet1";
        System.out.println(Filepath);

        FileInputStream ExcelFile = new FileInputStream(Filepath);

        // Access the required test data sheet

        ExcelWBook = new XSSFWorkbook(ExcelFile);

        ExcelWSheet = ExcelWBook.getSheet(SheetName);
       /* File f = new File(Filepath);
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook excelWorkbook = new XSSFWorkbook(fis);
        XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);
        int rows = excelSheet.getPhysicalNumberOfRows();//3
        int cols = excelSheet.getRow(0).getPhysicalNumberOfCells();//2
        String data[][] = new String[rows][cols];
        XSSFCell cell;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cell = excelSheet.getRow(i).getCell(j);
                String cellContents = cell.getStringCellValue();
                data[i][j] = cellContents;
                System.out.println(data[i][j]);
            }
        }
        fis.close();*/
    //}
}
