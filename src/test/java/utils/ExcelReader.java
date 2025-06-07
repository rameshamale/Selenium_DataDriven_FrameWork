package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] readExcelData(String sheetName) {
        Object[][] data = null;

        try {
            // Path to Excel file
            String filePath = System.getProperty("user.dir") + "/TestData/LoginData.xlsx";
            FileInputStream fis = new FileInputStream(filePath);

            // Load workbook and sheet
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            // Initialize the array (skip header row, so rows-1)
            data = new Object[rows - 1][cols];

            // Read data (i=1 to skip header)
            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.toString();
                    System.out.print(cell.toString() + "\t"); // Optional print
                }
                System.out.println();
            }

            // Close resources
            workbook.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
