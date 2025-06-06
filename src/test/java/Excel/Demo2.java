package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo2 {
public static void main(String[] args) throws IOException {
		
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Simple interest.xlsx");
	
	XSSFWorkbook WorkBook=new XSSFWorkbook(file);
	XSSFSheet sheet=WorkBook.getSheet("sheet1");
	int rows=sheet.getLastRowNum();
	int columns=sheet.getRow(0).getLastCellNum();
	System.out.println("Number of Rows in Excel file :  "+rows);  
	System.out.println("Number of cells in Excel file : "+columns);
	
	for(int r=0; r<rows; r++)
	{
		XSSFRow currentrow=sheet.getRow(r);
		for(int c=0; c<columns; c++)
		{
			XSSFCell currentcell=currentrow.getCell(c);
			System.out.println(currentcell.toString());
		}
	}
	}

}
