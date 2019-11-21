package com.ttn.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public Row row;
	
	public void ReadMyExcel() {
		
		try {
			FileInputStream inputStream = new FileInputStream("D:\\Project\\Eclipse\\Keyword\\testcase.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			int rows = firstSheet.getLastRowNum();
			for (int i = 1; i < rows + 1; i++) {
				row = firstSheet.getRow(i);
				System.out.println(getCellData(0));
				System.out.println(getCellData(1));
				System.out.println(getCellData(2));
				System.out.println(getCellData(3));
				System.out.println(getCellData(4));
				System.out.println(getCellData(5));
			}
		}
		catch(Exception e){
			
		}
	}
	
	
	public String getCellData(int colNum) {
		String cellData = "";
		Cell cell = row.getCell(colNum);
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			cellData = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			cellData = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			cellData = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			cellData = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BLANK:
			cellData = "";
		}
		return cellData;
	}
}
