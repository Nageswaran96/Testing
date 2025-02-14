package functions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {
	
	public void readExcel() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\downloads\\volworks-reports-Trailing Returns.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total no of Rows " + totalRows);
		System.out.println("Total no of Cells " + totalCells);
		
		for(int r=0; r<=totalRows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			
			for(int c=0; c<=totalCells; c++) {
				XSSFCell cell = currentRow.getCell(c);
				System.out.println(cell.toString() + "\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
}
