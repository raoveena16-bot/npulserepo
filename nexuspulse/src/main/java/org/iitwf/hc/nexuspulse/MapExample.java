package org.iitwf.hc.nexuspulse;

import java.util.HashMap;
import java.util.Set;

public class MapExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		HashMap<String,Integer> productDetails = new HashMap<String,Integer>();
		productDetails.put("P1",Integer.valueOf(10));
		productDetails.put("P2",Integer.valueOf(15));
		productDetails.put("P3",Integer.valueOf(20));
		productDetails.put("P4",Integer.valueOf(30));
		
		
		Integer i = productDetails.get("P4");
		System.out.println("PRice of a product P4::" + i );
		
		//Store all the keys in Set
		Set<String> productNamesSet = productDetails.keySet();
		
		for(String pName:productNamesSet)
		{
			System.out.println("Key:::" + pName);
			System.out.println("Value::"+ productDetails.get(pName));
		}
		
		
	}

}
