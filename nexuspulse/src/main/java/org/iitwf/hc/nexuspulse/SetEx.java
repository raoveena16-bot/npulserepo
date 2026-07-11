package org.iitwf.hc.nexuspulse;

import java.util.HashSet;
import java.util.Set;

public class SetEx {
	
	public static void main(String[] args) {
		
		//Classname objname = new ClassName();
		//ChromeDriver driver = new ChromeDriver();
		//WebDriver driver 		= new ChromeDriver();
		
		//Set is an Interface implemented by HashSet Class
		//Methods which are abstarct in List are implemented by ArrayList
		//Interface refvar = new ClassName();
		//getWindowHandles returns Set- Switch multiple Windows
		
		Set<Integer> marksList = new HashSet<Integer>();
		
		marksList.add(10);//index 0 
		marksList.add(10);//index 1
		marksList.add(20);//index 2
		marksList.add(10);//index 3
		marksList.add(10);//index 4
		marksList.add(10);//index 5
		
		//Enhanced for-loop or forEach
		for(Integer i : marksList)
		{
			System.out.println(i);
			
		}
		
		
		
		
		
	}

}
