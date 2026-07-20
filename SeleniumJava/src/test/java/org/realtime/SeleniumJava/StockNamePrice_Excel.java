package org.realtime.SeleniumJava;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StockNamePrice_Excel {
	WebDriver driver;
	Map<String,Double> actualPriceMap ;
		
		public void launchApp (String string) {
			driver = new ChromeDriver();
			driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
			driver.manage().window().maximize();
		}
		
		public List<WebElement> fetchAllStockName() {
			 List<WebElement> StockName = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
			return StockName;
			
		}
	   public List<WebElement> fetchAllCurrentPrice() {
		   List<WebElement> CurrentPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		   return CurrentPrice;
	   }
	   
	   
	   public Map<String, Double> mapStockNamePrice() {
		   List<WebElement> StockName = fetchAllStockName();
		   List<WebElement> CurrentPrice = fetchAllCurrentPrice();
		   
		   Map<String, Double> StockNamePrice = new HashMap <String, Double>();
		   for (int i =0;i<5;i++) {
			   StockNamePrice.put(StockName.get(i).getText(), Double.valueOf(CurrentPrice.get(i).getText().replace(",","").trim()));
			   
			   
			   System.out.println(StockName.get(i).getText() +"----"+ CurrentPrice.get(i).getText());
		   }
		   return StockNamePrice;
	   }
	   
	   
	


public String[][] readStockPrice(String StockPrice, String string) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException
{
	
	File f = new File (StockPrice);
	XSSFWorkbook wb = new XSSFWorkbook(f);
	XSSFSheet sheet = wb.getSheetAt(0);
	int rows = sheet.getPhysicalNumberOfRows();
	int cols = sheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println("Rows " + rows);
	System.out.println("Cols " + cols);
	String data[][] = new String[rows][cols];
	
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(j);
			if(cell.getCellType()==CellType.NUMERIC)
			{
				double d = cell.getNumericCellValue();
				data[i][j] = Double.valueOf(d).toString();
				System.out.println("numeric value" + d);
			}
			else
			{
				data[i][j]=cell.getStringCellValue();
				System.out.println("Value" + cell.getStringCellValue().trim());
			}
		}
		
	}
	wb.close();
	return data;
}
@BeforeClass
public void setUp()
{
	launchApp("https://money.rediff.com/gainers/bse/daily/groupa");
	actualPriceMap = mapStockNamePrice();
}


@Test 
public void validateStockPriceList() throws InvalidFormatException, IOException, Exception
{
	 
	System.out.println("Price Map" + actualPriceMap);
	readStockPrice("StockPrice.xlsx", "Sheet1");
}



@Test(dataProvider = "test1")
public void validateStockPriceListDP(String sName,String sPrice) throws InvalidFormatException, IOException
{
	Double actualPrice = actualPriceMap.get(sName);
	Double expectedPrice = Double.parseDouble(sPrice);
	Assert.assertEquals(actualPrice,expectedPrice);
	
}

@DataProvider(name = "test1")
public String[][] createData() throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
	
	return readStockPrice("StockPrice.xlsx", "Sheet1");
}	


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
