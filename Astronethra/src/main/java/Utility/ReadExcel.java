package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	DataFormatter formatter = new DataFormatter();
	
	private String systemPath = System.getProperty("user.dir");
	private String filePath = systemPath + "\\src\\test\\resources\\TestData.xlsx";
	
	public ReadExcel() {
		try {
			File src = new File(filePath);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Returns the data of the row on that column
	 * @param sheetNumber It is the index of the sheet obtained from getSheet() method, this indicates from which sheet data need to be taken
	 * @param row It is the row number from which data needs to be taken, this value is returned from getRequiredRowIndex()
	 * @param column It is the column from which the value should be taken
	 * @return returns the value of that row and columns
	 */
	public String getData(int sheetNumber, int row, int column) {
		sheet = workbook.getSheetAt(sheetNumber);
		String data = formatter.formatCellValue(sheet.getRow(row).getCell(column));
		return data;
	}
	
	/**
	 * Return the sheet index
	 * @param sheetName Test Data sheet name is passed in the program, based on the given sheet name index of that sheet is returned
	 * @return returns index of the sheet
	 */
	public int getSheet(String sheetName) {
		int index = -1;
		List<String> requiredSheet = new ArrayList<String>();
		for (int i=0; i< workbook.getNumberOfSheets(); i++) {
			requiredSheet.add(workbook.getSheetName(i) );
		}
		for(int j=0; j<requiredSheet.size(); j++) {
			String txt = requiredSheet.get(j);
			if(txt.equalsIgnoreCase(sheetName)) {
				index = j;
			}
		}
		return index;
	}
	
	/**
	 * Returning index of given Key
	 * @param sheetNumber passing in which sheet it should search for key
	 * @param key Key is the parameter(variable name)
	 * @return index in the sheet on which this parameter occurs
	 */
	public int getRequiredRowIndex(int sheetNumber, String key) {	
		sheet = workbook.getSheetAt(sheetNumber);
		XSSFRow row; 
		XSSFCell cell;
		int i = -1;
		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext())
		{
			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
				String cellValue = formatter.formatCellValue(cell);	
				if(cellValue.equalsIgnoreCase(key)) {
					i = cell.getRowIndex();
				}
			}
		}		
		return i;
	}
	
	/**
	 * This is the final method that can be used in our test cases to read the values of any key
	 * @param sheetName Sheet name from which data should be read
	 * @param key value of which data should be taken
	 * @return returns the value of the key
	 */
	public String getKeyValue(String sheetName,String key) {
		String txt = null;
		int s1 = getSheet(sheetName);
		int r1 = getRequiredRowIndex(s1,key);
		txt = getData(s1,r1,1);
		return txt;
	}

}
