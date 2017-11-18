package com.mycompany.guice;

import java.util.Set;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.multibindings.Multibinder;
//最简单的手动绑定注入
public class HelloWorldcase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Injector inject = Guice.createInjector(new Module() {
			public void configure(Binder binder) {
				binder.bind(HelloWorld.class).to(HelloWorldImpl.class);
				binder.bind(HelloWorldImpl.class);
				
				Multibinder<HelloWorld> multibinder = Multibinder.newSetBinder(binder, HelloWorld.class);
				multibinder.addBinding().to(HelloWorldImpl.class);
				multibinder.addBinding().to(HelloWorldImpl2.class);
				multibinder.addBinding().to(HelloWorldImpl2.class);
				
				
				binder.bind(HelloWorldWrapper3.class);
			}
		});
		
		// --1
		HelloWorld helloWorld = inject.getInstance(HelloWorldImpl.class);
		System.out.println(helloWorld.sayHello());
		
		// --2 get instance different
		HelloWorld helloWorld2 = inject.getInstance(HelloWorldImpl.class);
		System.out.println(helloWorld.hashCode() == helloWorld2.hashCode());
		
		// --3  injectMembers member variable
		HelloWorldWrapper helloWorldWrapper = new HelloWorldWrapper();
		inject.injectMembers(helloWorldWrapper);
		helloWorldWrapper.say();
		
		// --4  injectMembers  member function
		HelloWorldWrapper2 helloWorldWrapper2 = new HelloWorldWrapper2();
		inject.injectMembers(helloWorldWrapper2);
		helloWorldWrapper.say();
		
		// --5 multibinder
		HelloWorldWrapper3 helloWorldWrapper3 = inject.getInstance(HelloWorldWrapper3.class);
		helloWorldWrapper3.say();
		
	}

}
