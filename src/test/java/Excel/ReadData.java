package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
public static void main(String[] args) throws IOException {
		
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Simple interest.xlsx");
	
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	
	XSSFSheet sheet=workbook.getSheet("sheet1");
	
	//Get total number of rows
	int total_rows=sheet.getLastRowNum();
	//Get total number of columns
	int total_cells=sheet.getRow(0).getLastCellNum();
	
	System.out.println("Number of Rows in Excel file :  "+total_rows);  
	System.out.println("Number of cells in Excel file : "+total_cells);
	
	for(int r=1; r<total_rows; r++)
	{
		XSSFRow currentrow=sheet.getRow(r);
		for(int c=0; c<total_cells; c++)
		{
			XSSFCell currentcell=currentrow.getCell(c);
			System.out.println(currentcell.toString()+"\t");
		}
		System.out.println();
	}

	workbook.close();
    file.close();
	}

}
