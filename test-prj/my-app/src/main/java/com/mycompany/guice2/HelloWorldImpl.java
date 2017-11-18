package com.mycompany.guice2;

import com.google.inject.Singleton;

@Singleton
public class HelloWorldImpl implements HelloWorld {

	public String sayHello() {
		return "Hello, world!";
	}

}
