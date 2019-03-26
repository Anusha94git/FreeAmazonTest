package com.amazon.qa.TestUtility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amazon.qa.base.TestBase;

public class TestUtil extends TestBase
{

	public static long implicit_timeout = 90;
	public static long pageload_timeout = 90;
	public static String FilePath = "F:\\Javaworkspace\\FreeAmazonTest\\src\\main\\java\\com\\amazon\\qa\\testdata\\NewUserDetails.xlsx";
	
	
	
	static Workbook book;
	static Sheet sheet;
	
	
	public static String sheetName = "Sheet1";
	
	
	public static Object[][] getTestData(String SheetName) 
	{
		FileInputStream file = null;
		try
		{
		 file = new FileInputStream(FilePath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			book = WorkbookFactory.create(file);
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				
			}
		}
		return data;
		
	}
	
	
	
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +System.currentTimeMillis() + ".png"));
	
		}
	
	
	
	
	
	
	
	
	
}
