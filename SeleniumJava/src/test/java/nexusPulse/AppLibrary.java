package nexusPulse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class AppLibrary {
	
	
		
	
public static String getFutureDate(int n, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, n);
		
		Date d = cal.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		String formattedDate = sdf.format(d);
		
		System.out.println("Formatted Date: " + formattedDate);
		 return formattedDate;
		
	
	}

public static String randomString(String fixedString) {
	
	Random rand = new Random();
int randomDigit	= 100 + rand.nextInt(100)+1;

int lBound = 65,uBound = 90;
char randomUcase = (char)(lBound + rand.nextInt(uBound-lBound)+1);

lBound = 97; uBound=122;
char randomLcase= (char)(lBound + rand.nextInt(uBound-lBound)+1);


	String uniqueReason =fixedString + randomDigit + randomUcase + randomLcase;
	System.out.println(uniqueReason);
	return uniqueReason;
	
}

public static  Properties readConfig(String fileName) throws IOException {
	File f = new File("config//" + fileName);
	System.out.println(f.getAbsolutePath());
	
	FileInputStream fis = new FileInputStream(f);
	Properties prop = new Properties();
	prop.load(fis);
	
	
	return prop;
}
	

}
