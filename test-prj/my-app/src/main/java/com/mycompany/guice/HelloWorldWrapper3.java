package com.mycompany.guice;

import java.util.Set;

import com.google.inject.Inject;

public class HelloWorldWrapper3 {
	public Set<HelloWorld> set;
	@Inject
	public void HelloWorldWrapper3(Set<HelloWorld> set) {
		this.set = set;
	}
	
	public void say() {
		System.out.println("HelloWorldWrapper3 begin to say --==");
		for (HelloWorld helloWorld : set) {
			System.out.println(helloWorld.sayHello());
		}
		System.out.println("HelloWorldWrapper3 end --==");
	}
}
