package org.iitwf.hc.nexuspulse;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
	
	public static void main(String[] args) {
		
		//Classname objname = new ClassName();
		//ChromeDriver driver = new ChromeDriver();
		//WebDriver driver 		= new ChromeDriver();
		
		//List is an Interface implemented by ArrayList Class
		//Methods which are abstarct in List are implemented by ArrayList
		//Interface refvar = new ClassName();
		//findElements() return List<WebElement>
		List<Integer> marksList = new ArrayList<Integer>();
		
		marksList.add(10);
		marksList.add(10);
		marksList.add(20);
		
		for(int i=0;i<marksList.size();i++)
		{
			System.out.println(marksList.get(i));
		}
	}

}
