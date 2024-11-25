package php.ecom.generic.fileutitlity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityFile {
	public FileInputStream fis=null;
	public String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream("./src/test/resources/CartVibeData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String data=book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		System.out.println("hi:"+data);
		return data;
	}

	public int getLastRowNum(String sheet) throws EncryptedDocumentException, IOException {
		
		Workbook book=WorkbookFactory.create(fis);
		int lastRowNum=book.getSheet(sheet).getLastRowNum();
		return lastRowNum; 
	}
	
	
	public void setDataInExcel(String sheet, int row, int cell, int setData) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CartVibeData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		book.getSheet(sheet).getRow(row).getCell(cell).setCellValue(setData);
		FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\rstar\\\\OneDrive\\\\Desktop\\\\excel\\\\ddt_excel.xlsx");
		book.write(fos);
	}

}
