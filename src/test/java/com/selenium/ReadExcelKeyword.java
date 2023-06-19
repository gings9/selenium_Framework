package com.selenium;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelKeyword {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;

    public static void setExcelFile(String path, String SheetName) throws Exception {
        FileInputStream ExcelFile = new FileInputStream(path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
    }

    public static String getCellData(int row, int col) throws Exception {
        Cell = ExcelWSheet.getRow(row).getCell(col);
        String CellData = Cell.getStringCellValue();
        return CellData;
    }
}
