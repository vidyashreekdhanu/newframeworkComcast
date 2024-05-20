 package Com.Crm.genric.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutility {
	public String getdatafromexcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./testData/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		  String data = book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	
		book.close();
		return data;
	}
public int getrowcount(String sheet) throws EncryptedDocumentException, IOException
{
	FileInputStream fis= new FileInputStream("./testData/Book1.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	int rowcount = book.getSheet(sheet).getLastRowNum();
	return rowcount;
}
public void setdataintoexcel(String sheetname,int rownum,int cellnum, String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis= new FileInputStream("./testData/Book1.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	book.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);
	FileOutputStream fos = new FileOutputStream("./testData/Book1.xlsx");
	book.write(fos);
	book.close();
}
}

