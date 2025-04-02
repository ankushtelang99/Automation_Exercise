package excelsheet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReading {


	public static void main(String[] args) throws IOException 
	{

		String path ="C:\\Users\\ANKUSH TELANG\\Desktop\\DemoExcel.xlsx";

		File Fread = new File(path);   

		FileInputStream fis = new FileInputStream(Fread);  

		XSSFWorkbook wb = new XSSFWorkbook (fis);  

		XSSFSheet sh1 =	wb.getSheet("QSSheet");   

		DataFormatter df = new DataFormatter();

		String value2 = df.formatCellValue(sh1.getRow(5).getCell(0));	

		System.out.println(value2);	





	}


}



