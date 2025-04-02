package excelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriting 
{
	public static void writeData() throws IOException
	{
		String path ="C:\\Users\\ANKUSH TELANG\\Desktop\\DemoExcel.xlsx";

		File Fread = new File(path);   

		FileInputStream fis = new FileInputStream(Fread);  

		XSSFWorkbook wb = new XSSFWorkbook (fis);  

		XSSFSheet sh1 =	wb.getSheet("QSSheet");   

		DataFormatter df = new DataFormatter();

		
		File write = new File(path);
		
		FileOutputStream fos = new FileOutputStream(write);
		
	    sh1.createRow(1).createCell(0).setCellValue("Ankush");
	    sh1.createRow(2).createCell(0).setCellValue("Ashok");
		sh1.createRow(3).createCell(0).setCellValue("Telang");

		wb.write(fos);
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		writeData();
	}

}
