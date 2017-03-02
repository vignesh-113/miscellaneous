package Formloop;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exllib {
	public String getExcelValue(String sheetName, int rowNum, int cellNum){
		String retValue=null;
		String filePth = "E:/zipcodes.xls";
		try {
			FileInputStream fis = new FileInputStream(filePth);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetName);
			Row r = s.getRow(rowNum);
			Cell c = r.getCell(cellNum);
			retValue = c.getStringCellValue();			
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retValue;
	}
	public int getRowCount(String sheetName){
		int retVal=0;
		try {
			String filePth = "E:/zipcodes.xls";
			FileInputStream fis = new FileInputStream(filePth);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetName);
			retVal =s.getLastRowNum();			 		
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
