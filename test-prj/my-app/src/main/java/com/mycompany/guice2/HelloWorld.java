package com.mycompany.guice2;

import com.google.inject.ImplementedBy;

@ImplementedBy(HelloWorldImpl.class)
public interface HelloWorld {
	String sayHello();
}
