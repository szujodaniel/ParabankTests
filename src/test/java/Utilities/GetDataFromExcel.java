package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.*;



public class GetDataFromExcel {

    public static ArrayList<Object[]> downPaymentData() throws IOException {

        ArrayList<Object[]> downPayment = new ArrayList<>();

        String excelFilePath = "resources/requestLoanTestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("requestLoanTestData");

        int rows = sheet.getLastRowNum();

        for (int r = 1; r <= rows-1; r++) {

            XSSFRow row = sheet.getRow(r);

            XSSFCell cell = row.getCell(0);

            String value = String.valueOf((int)cell.getNumericCellValue());

            Object[] obj = {value};
            downPayment.add(obj);
        }
        return downPayment;
    }

    public static ArrayList<Object[]> availableFundsData() throws IOException {

        ArrayList<Object[]> availableFunds = new ArrayList<>();

        String excelFilePath = "resources/requestLoanTestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("requestLoanTestData");

        int rows = sheet.getLastRowNum();

        for (int r = 1; r <= rows-1; r++) {

            XSSFRow row = sheet.getRow(r);

            XSSFCell cell = row.getCell(1);

            String amount = String.valueOf((int)cell.getNumericCellValue());

            Object[] obj = {amount};
            availableFunds.add(obj);
        }
        return availableFunds;
    }

    public static ArrayList<Object[]> combinedData() throws IOException {

        ArrayList<Object[]> combined = new ArrayList<>();

        String excelFilePath = "resources/requestLoanTestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("requestLoanTestData");

        int rows = sheet.getLastRowNum();

        for (int r = 1; r <= rows; r++) {

            XSSFRow row = sheet.getRow(r);

            XSSFCell cell = row.getCell(2);

            String value = String.valueOf((int)cell.getNumericCellValue());

            Object[] obj = {value};
            combined.add(obj);
        }
        return combined;
    }
}
