package com.maveric.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class collections {

	public static void main(String[] args) 
	{
		ArrayList al=new ArrayList();
		//add
		al.add(10);
		al.add("Nandhini");
		al.add(20);
		System.out.println(al);
		al.add(2,"Dhandapani");
		al.add("suba");
		System.out.println("After add through Index"+al);
		
		//addAll
		Collection c=new ArrayList();
		c.add(20);
		c.add(30);
		c.add("Suba");
		al.addAll(c);
		System.out.println(al);
		
		//indexof
		int index=al.lastIndexOf(c);
		System.out.println(index);
		
		//clear
		c.clear();
		System.out.println(c);
		
		//iterator
		Iterator itr=al.iterator();  
		while(itr.hasNext())
		{  
			System.out.println(itr.next());  
		}
		
		 ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
		 list.add("Nandhini");//Adding object in arraylist  
		 list.add("suba");  
		 list.add("srija");  
	     list.add("Malar");
	     list.add("Joan");
		 //Traversing list through Iterator  
		 Iterator<String> itr1=list.iterator();  
		 while(itr1.hasNext())
		 {  
		   System.out.println(itr1.next());  
         }
		 System.out.println(list.size());
		 
		//retainAll
		 al.retainAll(list);
		 for(Object obj:al)  
			    System.out.println(obj);  
		  
		 //removeAll
		 al.removeAll(list);
		 System.out.println(al);
		 
		 Student s1=new Student(101,"Adhi",23);  
		 Student s2=new Student(102,"Anbu",21);  
		 Student s3=new Student(103,"Sakthi",25);  
		  //creating arraylist  
		  ArrayList<Student> al1=new ArrayList<Student>();  
		  al1.add(s1);//adding Student class object  
		  al1.add(s2);  
		  al1.add(s3);  
		    
		  for(Object obj:al1)
		  {
			  System.out.println(s1.rollno);
			  System.out.println(s1.age);
			  System.out.println(s1.name);
		  }
		  
		  LinkedList<String> Ll=new LinkedList<String>();  
		  Ll.add("Ravi");  
		  Ll.addLast("Ajay"); 
		  Ll.addFirst("Vijay");  
		   
		  
		  Iterator<String> itr2=Ll.iterator();  
		  while(itr2.hasNext())
		  {  
		   System.out.println(itr2.next());  
		  }  
		  
		  HashSet<String> set=new HashSet<String>();  
		  set.add("A");  
		  set.add("B");  
		  set.add("C");  
		  set.add("D");  
		  Iterator<String> itr3=set.iterator();  
		  while(itr3.hasNext()){  
		   System.out.println(itr3.next());  
		  }  
		 
	}
}


