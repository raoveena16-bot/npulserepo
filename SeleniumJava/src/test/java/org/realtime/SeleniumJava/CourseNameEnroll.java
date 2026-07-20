package org.realtime.SeleniumJava;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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


public class CourseNameEnroll {
	WebDriver driver;
	Map<String, Integer>actualCourseEnroll;
	
	
	public void getCourseNameEnroll() {
		lanuchApp();
		fetchAllCourseNames();
		fetchAllEnroll();
		mapCourseNameEnroll();
	}
	
	
	public void lanuchApp() {
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-table/");
		driver.manage().window().maximize();
		
	}
	
	public List<WebElement> fetchAllCourseNames() {
		List<WebElement> CourseName1 = driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr/td[2]"));
		return CourseName1;
	}
	
	public List<WebElement> fetchAllEnroll() {
	List<WebElement> Enroll1 = driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr/td[5]"));
    return Enroll1;
}
    public Map<String, Integer> mapCourseNameEnroll() {
    	
    	//Creating a List which will store all the collected WebElements
    	List<WebElement> CourseName = fetchAllCourseNames();
    	List<WebElement> Enroll = fetchAllEnroll();
        //You are creating a HashMap where: Key → Course Name (String) and Value → Enrollment Count (Integer)
    	Map<String, Integer> CourseEnroll = new HashMap <>();
    	
    	for(int i =0; i<CourseName.size(); i++) {
    		CourseEnroll.put(CourseName.get(i).getText(),Integer.parseInt(Enroll.get(i).getText()));
    		System.out.println(CourseName.get(i).getText()+"____________"+Integer.parseInt(Enroll.get(i).getText()));
    	}
    	return CourseEnroll;
    	
	}  
    
    public String[][] readCourseEnroll(String CourseEnroll) throws InvalidFormatException, IOException {
    	
    	File f = new File(CourseEnroll);
    	XSSFWorkbook wb = new XSSFWorkbook(f);
    	XSSFSheet sheet = wb.getSheetAt(0);
    	int rows = sheet.getPhysicalNumberOfRows();
    	int cols = sheet.getRow(0).getPhysicalNumberOfCells();
    	System.out.println("Rows" + rows);
    	System.out.println("Cols" + cols);
    	String data[][] = new String[rows][cols];
    	
    	for (int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			XSSFRow row = sheet.getRow(i);
    			XSSFCell cell = row.getCell(j);
    			if (cell.getCellType() == CellType.NUMERIC) {
                    data[i][j] = String.valueOf(cell.getNumericCellValue());
                } 
    			
    			else {
                    data[i][j] = cell.getStringCellValue().trim();
                } 
    			System.out.println("Value" + cell.getStringCellValue().trim());
    			}
    	}
    			
    			return data;
    			
    		}
    	
		
    
    	@BeforeClass 
    	
    	public void setup() {
    		lanuchApp();
    		actualCourseEnroll = mapCourseNameEnroll();
    		
    	}
    	@Test
    	
    	public void validateCourseEnroll() throws InvalidFormatException, IOException {
    		
    		System.out.println("Price Map" + actualCourseEnroll);
    		readCourseEnroll("StockPrice.xlsx");
    	}
    	
    	@DataProvider (name ="test1")
    	
    	public void validateCourseEnrollDP(String Course, String Enroll) {
    		Integer actualEnroll = actualCourseEnroll.get(Course);
    		Integer expectedEnroll = Integer.parseInt(Enroll);
    		Assert.assertEquals(actualEnroll,expectedEnroll);
    		System.out.println("Test Passed");
    	
    	
    	
    	
    		
    	}
    
    	
    }



