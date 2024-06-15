package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME=20;
	public static final int PAGE_LOAD_TIME=30;

	public static String getGenerateEmailDateTimeStamp() {
		Date date = new Date();
		String email = date.toString().replace(" ", "_").replace(":", "_");
		return "Hello"+email+"@gmail.com";
	}

	public static Object[][] getTestDataFromExcel(String sheetName) {
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testDataExcel.xlsx");
		XSSFWorkbook workbook=null;
		try {
			FileInputStream fisExcel = new FileInputStream(file);
			workbook = new XSSFWorkbook(fisExcel);	
		} catch (Throwable e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for(int i=0; i<rows; i++) {
			XSSFRow row =sheet.getRow(i+1);
			for(int j=0; j<cols; j++) {
				XSSFCell cell=row.getCell(j);
				CellType cellType = cell.getCellType();

				switch(cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					System.out.println("Hello" + data[i][j]);
					break;
				case NUMERIC:
					data[i][j] = String.valueOf((long)cell.getNumericCellValue());
					System.out.println("Numeric" + data[i][j]);
					break;
				case BOOLEAN:
					data[i][j] = String.valueOf(cell.getBooleanCellValue());
					System.out.println(data[i][j]);
					break;
				default:
					break;
				}

			}
		}
		return data;

	}

//	private static Object String(int numericCellValue) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
public static String captureScreenshot(WebDriver driver, String testName) {
	File srcScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	System.out.println(System.getProperty("user.dir"));
	String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
	try {
		FileHandler.copy(srcScreenshotFile, new File(destinationScreenshotPath));
	} catch (IOException e) {
		e.printStackTrace();
	}
	return destinationScreenshotPath;
}

}
