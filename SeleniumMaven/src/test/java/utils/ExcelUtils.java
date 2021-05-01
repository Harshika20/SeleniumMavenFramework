package utils;

import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	// whenever we create object for this class , constructor is called, if not create default constructor is called
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			
			wb = new XSSFWorkbook(excelPath);
			sheet = wb.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static void main(String[] args) {
		//getRowCount();
		getCellData(0, 0);
	}

	public static void getRowCount(){

		XSSFWorkbook wb;
		try {
			
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows:"+rowcount);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void getCellData(int rowNum,int colNum) {
		try {
			
			String cellData =  sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

