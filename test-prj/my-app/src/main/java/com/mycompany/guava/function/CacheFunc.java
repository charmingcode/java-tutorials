package com.mycompany.guava.function;

import java.util.concurrent.Callable;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CacheFunc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();  
	        String resultVal = cache.get("jerry", new Callable<String>() {  
	            public String call() {  
	                String strProValue="hello "+"jerry"+"!";                
	                return strProValue;
	            }  
	        });  
	        System.out.println("jerry value : " + resultVal);
	        
	        resultVal = cache.get("peida", new Callable<String>() {  
	            public String call() {  
	                String strProValue="hello "+"peida"+"!";                
	                return strProValue;
	            }  
	        });  
	        
	        System.out.println("peida value : " + resultVal);  
	        
	        resultVal = cache.get("jerry", new Callable<String>() {  
	            public String call() {  
	                String strProValue="hello "+"jerry 2"+"!";                
	                return strProValue;
	            }  
	        });  
	        System.out.println("jerry value : " + resultVal);  
	}

}
