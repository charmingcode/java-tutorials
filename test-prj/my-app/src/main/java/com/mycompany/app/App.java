package com.mycompany.app;

import com.mycompany.function.EnumFunc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        System.out.println( "EnumFunc test:" );
       
        for (EnumFunc enumFunc: EnumFunc.values()) {
        	 System.out.println( enumFunc.getClass() + " : " + enumFunc);
		}
        
    }
}
