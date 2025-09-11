package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
//	String archivoExcel = new File("user.dir") + "/TestSuites/FirstTestSuite.xlsx";//ruta del archivo xls o xlsx
////	Workbook libroExcel = WorkbookFactory.create(new FileInputStream(archivoExcel)); //crear un libro excel
////	Sheet hojaActual = (Sheet) libroExcel.getSheetAt(0); //acceder a la primera hoja
////	Row filaActual = ((XSSFSheet) hojaActual).getRow(0); //acceder a la primera fila en la hoja
////	Cell celdaActual = filaActual.getCell(0); //acceder a la primera celda en la fila

	public static Object[][] ExcelReader(String workbookName, String SheetName) {
		
	
		File file = new File(workbookName);
		InputStream fis;
		Object object[][] = null;
		try {

			fis = new FileInputStream(file);

			HSSFWorkbook workbook = new HSSFWorkbook(fis);
		    HSSFSheet sheet = workbook.getSheet(SheetName);
			HSSFRow row;
			object = new Object[sheet.getLastRowNum()][5];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i + 1);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					object[i][j] = row.getCell(j, Row.CREATE_NULL_AS_BLANK).toString();

				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}


}
