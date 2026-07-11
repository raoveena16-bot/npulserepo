package org.iitwf.hc.nexuspulse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html
//https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/
public class AppLibrary {


	public static String randomString(String fixedString)
	{
		
		Random rand = new Random();
		int randomDigit = 100+rand.nextInt(100)+1;
		
		int lBound = 65,uBound=90;
		char randomUCase = (char)(lBound+rand.nextInt(uBound-lBound)+1) ;
	 
		
		lBound = 97;uBound=122;
		char randomLCase = (char)(lBound+rand.nextInt(uBound-lBound)+1) ;
		
		String uniqueReason = fixedString +randomDigit +randomUCase+randomLCase;
		System.out.println(uniqueReason);
		
		return uniqueReason;
	}
	public static String getFutureDate(int n,String format)
	{

		//Identifying the future date from the current date

		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DAY_OF_MONTH, n);

		Date d = cal.getTime();
 	
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		String formattedDate = sdf.format(d);
		
		System.out.println("Formatted Date::" + formattedDate);
		
		return formattedDate;
		
	}
	public static Properties readConfig(String fileName) throws IOException
	{
		File f = new File("config//"+fileName);
		System.out.println(f.getAbsolutePath());
		
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		 
		return prop;
	}
}
