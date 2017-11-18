package com.mycompany.guice2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mycompany.guice2.HelloWorld;
//通过注解自动绑定注入 且验证 scope = singleton
public class HelloWorldcase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Injector inject =  Guice.createInjector();
		
		// --1
		HelloWorld helloWorld = inject.getInstance(HelloWorld.class);
		System.out.println(helloWorld.sayHello());
		
		// --2 get instance same
		HelloWorld helloWorld2 = inject.getInstance(HelloWorld.class);
		System.out.println(helloWorld.hashCode() == helloWorld2.hashCode());
	}

}
