package com.example.itot4year.libs;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ExcelParsing {

    /**
     * подключение к странице, с которой будем работать
     * @param fileName имя файла
     * @param sheetName имя страницы
     * @return страница excel
     * @throws IOException
     */
    public static HSSFSheet connectionSheet(String fileName, String sheetName) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(fileName));
        return wb.getSheet(sheetName);
    }

    /**
     * чтение ячейки
     * @param sheet страница Excel
     * @param rowNumber номер ряда
     * @param cellNumber номер колонки
     * @return значение на пересечении колонки и столбца
     * @throws IOException
     */
    public static String readExcel (HSSFSheet sheet, int rowNumber, int cellNumber) throws IOException {
        if (sheet.getRow(rowNumber) == null) {
            return null;
        }
        if (sheet.getRow(rowNumber).getCell(cellNumber) == null) {
            return null;
        }
        if (sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue() == "") {
            return "0";
        }

        return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
    }

    /**
     * чтение ряда значений
     * @param sheet страница Excel
     * @param rowNumber номер ряда
     * @param srartCell стартовая колонка
     * @param endCell конечная колонка
     * @return массив строковых значений из диапозона указанных колонок
     * @throws IOException
     */
    public static List<String> readExcelCell (HSSFSheet sheet,int rowNumber, int srartCell, int endCell) throws IOException {
        List<String> value = new ArrayList<String>();
        for (int i = srartCell; i<=endCell; i++) {
            value.add(readExcel(sheet, rowNumber, i));
        }
        return  value;
    }

    /**
     * чтение колонки занчений
     * @param sheet страница Excel
     * @param startRow стартовый ряд
     * @param endRow конечный ряд
     * @param cellNumber номер колонки
     * @return массив строковых значений из диапозона указанных рядов
     * @throws IOException
     */
    public static List<String> readExcelRow ( HSSFSheet sheet,int startRow, int endRow, int cellNumber) throws IOException {
        List<String> value = new ArrayList<String>();
        for (int i = startRow; i<=endRow; i++) {
            value.add(readExcel(sheet, i, cellNumber));
        }
        return  value;
    }
}
