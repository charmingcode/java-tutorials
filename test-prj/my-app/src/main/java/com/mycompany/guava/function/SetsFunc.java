package com.mycompany.guava.function;

import java.util.HashMap;
import java.util.Set;

import com.google.common.collect.Sets;

import kafka.utils.Os;

public class SetsFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> hashMap1 = new HashMap<String, String>();
		HashMap<String, String> hashMap2 = new HashMap<String, String>();
		
		hashMap1.put("1", "a");
		hashMap1.put("2", "b");
		hashMap1.put("3", "c");
		
		hashMap2.put("1", "a");
		hashMap2.put("2", "b");
		hashMap2.put("3", "c");
		
		Set<String> set = Sets.difference(hashMap1.keySet(), hashMap2.keySet());
		System.out.println(set);
		
		hashMap1.put("4", "a");
		hashMap1.put("5", "b");
		hashMap1.put("6", "c");
		
		set = Sets.difference(hashMap1.keySet(), hashMap2.keySet());
		System.out.println(set);
		
		set = Sets.difference(hashMap2.keySet(), hashMap1.keySet());
		System.out.println(set);
		
		 HashMap<String,String>n1=new HashMap<String,String>(){{put("2","s");}};
	     HashMap<String,String>n2=new HashMap<String,String>(){{put("2","s");}};
	     System.out.println(n1.equals(n2));
	     n2.put("2","a");
	     System.out.println(n1.equals(n2));
	     n1.put("2","a");
	     System.out.println(n1.equals(n2));
	     
	     
		

	}

}
