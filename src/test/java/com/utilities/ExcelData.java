package com.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	XSSFWorkbook workbook;
	public ExcelData() {
		File src=new File("C:\\Users\\M1089247\\Comprehensive\\HybridFramework\\ExcelDriven\\Datadriven.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			workbook=new XSSFWorkbook(fis);
		}
		catch(Exception e){
			System.out.println("unable to get element");
			
		}
	}
	
	public String getStingdata(int sheetindex,int row,int column) {
		return workbook.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		
	}
	public double getNumericdata(int sheetindex,int row,int column) {
		return workbook.getSheetAt(sheetindex).getRow(row).getCell(column).getNumericCellValue();
		
	}
	public double getNumericData(String sheetname,int row,int column) {
		return workbook.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		
	}
	public String getStingData(String sheetname,int row,int column) {
		return workbook.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
	}
	
}
