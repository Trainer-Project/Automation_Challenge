package codingChallengeInJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//How to read excel files using Apache POI
public class ReadExcel {
	public static void main(String[] args) throws IOException {
		System.out.println("");
		// I have placed an excel file 'Test.xlsx' in my D Driver
		FileInputStream fis = new FileInputStream("./ZooplaTestData/TestData.xlsx");
		// creating workbook instance that refers to .xls file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// creating a Sheet object to retrieve the object
		XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
		Iterator<Row> itr = sheet.iterator(); // iterating over excel file
		while (itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING: // field that represents string cell type
					System.out.print(cell.getStringCellValue() + "\t\t\t");
					break;
				case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
					System.out.print(cell.getNumericCellValue() + "\t\t\t");
					break;
				default:
				}
			}
			System.out.println("");
		}
	}
}