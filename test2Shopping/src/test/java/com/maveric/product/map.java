package com.maveric.product;

import java.util.HashMap;
import java.util.*;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class map 
{
	public static void main(String[] args)
	{
		//String 
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("Name","Nandhini");
		map1.put("EmpId","3180");
		map1.put("company","Maverc-systems");
		System.out.println(map1);
		
		map1.remove("Name");
		System.out.println("After remove: "+map1);
		
		//Key,value
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(1, "Kothai");
		map2.put(2, "Shobana");
		map2.put(3, "Dharini");
		System.out.println(map2);
		map2.remove(2);
		
		System.out.println("After remove: "+map2);
		System.out.println("1 is there: "+ map2.containsKey(1));
		System.out.println("All Available Keys: "+ map2.keySet());
		System.out.println("All values:"+ map2.values());
		System.out.println("Empty?: "+map2.isEmpty());

	}
}
