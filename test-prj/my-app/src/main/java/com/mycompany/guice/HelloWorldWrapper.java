package com.mycompany.guice;

import com.google.inject.Inject;

public class HelloWorldWrapper {

	private String label = "HelloWorldWrapper"; 
	@Inject
	public HelloWorld helloWorld;
	
	public void say() {
		System.out.println(label + " xxx " + helloWorld.sayHello()); 
	}
	
}
