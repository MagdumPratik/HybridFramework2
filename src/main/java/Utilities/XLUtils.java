package Utilities;

import java.io.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLUtils {
	public static FileInputStream fis;
	public static FileOutputStream fio;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		return rowcount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		return cellcount;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		String data;
		try
		{
			DataFormatter formatter=new DataFormatter();
			String cellDAta=formatter.formatCellValue(cell);
			return cellDAta;
		}
		catch(Exception e)
		{
			data="";
			
		}
		workbook.close();
		fis.close();
		return data;
	}
	
}
