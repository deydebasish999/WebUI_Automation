package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



	public class ReadDataFromExcel {

		public static long Page_Load_Timeout = 11;
		public static long Implicitly_Wait = 11;
		private XSSFWorkbook wb;

		
        public ReadDataFromExcel(String dataSheetName) {
		File src = new File(System.getProperty("user.dir") +"\\" +dataSheetName+ ".xlsx");
		try {
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}

        public String readPasswordfromxlfilenextColumn2(int sheetno, int dataIndex) throws IOException {
        	//String excelUserPassword1 = null;
        	String val = null;
        	XSSFSheet sheet1 = wb.getSheetAt(sheetno);
        	DataFormatter formatter = new DataFormatter();
        	val = formatter.formatCellValue(sheet1.getRow(dataIndex).getCell(0));
        	// excelUserPassword = sheet1.getRow(dataIndex).getCell(2).getStringCellValue();
        	// System.out.println(excelUserPassword);
        	return val;

        	}

        	// column 4
        	public String readPasswordfromxlfilenextColumn3(int sheetno, int dataIndex) throws IOException {
        	String excelUserPassword2 = null;
        	XSSFSheet sheet1 = wb.getSheetAt(sheetno);
        	String val1 = null;
        	XSSFSheet sheet11 = wb.getSheetAt(sheetno);
        	DataFormatter formatter = new DataFormatter();
        	val1 = formatter.formatCellValue(sheet11.getRow(dataIndex).getCell(1));
        	// excelUserPassword = sheet1.getRow(dataIndex).getCell(3).getStringCellValue();
        	// System.out.println(excelUserPassword);
        	return val1;

        	}

		
		}


