package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo3 {
public static void main(String[] args) throws IOException {
		
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Myfile_Dynamic.xlsx");
	
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("Dynamic Data");
	int rows=sheet.getPhysicalNumberOfRows();
	int columns=sheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println("Number of Rows in Excel file :  "+rows);  
	System.out.println("Number of cells in Excel file : "+columns);
	
	//read the data from excel sheet
	 for(int r=1; r<rows; r++)
	 {
		XSSFRow currentrow= sheet.getRow(r);
		for(int c=0; c<columns; c++)
		{
			XSSFCell currentcell=currentrow.getCell(c);
			System.out.print(currentcell.toString()+" ");
		}
	 }

	}

}
