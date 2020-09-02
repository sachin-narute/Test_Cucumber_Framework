package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import testBase.TestBase;


public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;

	static XSSFWorkbook WB;
	static XSSFSheet WS;
	static XSSFCell cell;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) throws IOException {
		String path =System.getProperty("user.dir")+"\\Resource\\TestData.xlsx";
		FileInputStream fispath = new FileInputStream(path);

		XSSFWorkbook WB=new XSSFWorkbook(fispath);
		XSSFSheet WS = WB.getSheet("sheetName");

		int rowCount= WS.getPhysicalNumberOfRows()-1;
		int columnCount= WS.getRow(0).getPhysicalNumberOfCells();

		Object[][] data=new Object[rowCount][columnCount];


		for (int i = 0; i < rowCount; i++) {
			for (int k = 0; k < columnCount; k++) {

				//data[i][k] = WS.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]+"  "+i+" "+k);

				cell = WS.getRow(i+1).getCell(k);
				//System.out.println(WS.getRow(i+1).getCell(k).getCellType())	 ;
				if (cell != null){

					switch (cell.getCellType()) {
					case _NONE:
						data[i][k] =  "";
						//System.out.println(data[i][k]);
						break;
					case BLANK:
						data[i][k] =  "";
						System.out.println(data[i][k]);
						break;
					case  BOOLEAN:
						data[i][k] = String.valueOf(cell.getBooleanCellValue());
						//System.out.println(data[i][k]);
						break;
					case NUMERIC:
						data[i][k] = String.valueOf(cell.getNumericCellValue());
						//System.out.println(data[i][k]);
						break;
					case STRING:
						data[i][k] = cell.getStringCellValue();
						//System.out.println(data[i][k]);
						break;
					default:
						data[i][k] = "";
						//System.out.println(data[i][k]);
						break;
					}
				}else
				{
					data[i][k] = "";
					//System.out.println(data[i][k]);
				}

			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}



}
