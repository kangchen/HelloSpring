package com.kcorner.spring.sort;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SortApp {

	private static AbstractApplicationContext context;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Sort sort = (Sort) context.getBean("bubbleSort");

		sort.println();
		sort.sort();
		sort.println();
		System.out.println(sort.toString());
		
	}

}
