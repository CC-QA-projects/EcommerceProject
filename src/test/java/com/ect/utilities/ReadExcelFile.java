package com.ect.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    public static FileInputStream fis;
    public static XSSFWorkbook workBook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    // Method to get cell value
    public static String getCellValue(String fileName, String sheetname, int rowNo, int cellNo) {
        try {
            fis = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(fis);
            excelSheet = workBook.getSheet(sheetname);
            cell = excelSheet.getRow(rowNo).getCell(cellNo);

            workBook.close();

            return cell.getStringCellValue();
            
        } catch (Exception e) {
            return " ";
        }
    }

    // Method to get row count
    public static int getRowCount(String fileName, String sheetName) {
        try {
        	
            fis = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(fis);
            excelSheet = workBook.getSheet(sheetName);

            int row = excelSheet.getLastRowNum() + 1;
            workBook.close();
            return row;

        } catch (Exception e) {
            return 0;
        }
    }

    // Method to get column count
    public static int getColCount(String fileName, String sheetName) {
        try {
            fis = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(fis);
            excelSheet = workBook.getSheet(sheetName);
            
            int col = excelSheet.getRow(0).getLastCellNum();
            workBook.close();
            return col;

        } catch (Exception e) {
            return 0;
        }
    }

    // Method to get string data by sheet index
    public String getStringData(int sheetIndex, int row, int column) {
        return workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
    }

    // Method to get string data by sheet name
    public String getStringData(String sheetName, int row, int column) {
        return workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    // Method to get numeric data by sheet name
    public double getNumericData(String sheetName, int row, int column) {
        return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
}
