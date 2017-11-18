package com.mycompany.guice;

import com.google.inject.Inject;

public class HelloWorldWrapper2 {
	private String label = "HelloWorldWrapper2"; 
	
	public HelloWorld helloWorld;
	@Inject
	public void inject_abc(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
	
	public void say() {
		System.out.println(label + " xxx " + helloWorld.sayHello()); 
	}
}
