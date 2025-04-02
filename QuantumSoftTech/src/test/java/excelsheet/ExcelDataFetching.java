package excelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataFetching 
{
        public static void main(String[] args) throws IOException 
        {
		
    	String path ="C:\\Users\\ANKUSH TELANG\\Desktop\\DemoExcel.xlsx";

		File Fread = new File(path);
		
		FileInputStream Fis = new FileInputStream(Fread);
		
		XSSFWorkbook wb = new XSSFWorkbook(Fis);
		
		XSSFSheet sh1 = wb.getSheet("QSSheet");
		
		DataFormatter df = new DataFormatter();
		
		
	    int numberofrowsinsheet = sh1.getLastRowNum();
	    
	    System.out.println("Total number of rows are:"+numberofrowsinsheet);
		
		int numberofcolumnsinsheet = sh1.getRow(0).getLastCellNum();
		
		System.out.println("Total number of columns are:"+numberofcolumnsinsheet);
		
		
		int rowcount = numberofrowsinsheet+1;
		
		for(int i = 0; i<rowcount;i++) 
		{
			for(int j = 0; j<numberofcolumnsinsheet;j++)
			{
				String value = df.formatCellValue(sh1.getRow(i).getCell(j));
				System.out.print(value+" ");
			}
			
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
