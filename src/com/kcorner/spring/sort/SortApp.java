package com.kcorner.spring.sort;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SortApp {

	private static AbstractApplicationContext context;
	private static String sortType;

	public SortApp(String sortType) {
		setSortType(sortType);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Sort sort = context.getBean(getSortType(), Sort.class);

		sort.println();  //print list of unsorted integers
		sort.sort();	 //sorting the integer list
		sort.println();  //print list of sorted integers
		System.out.println(sort.toString());
		
	}
	public static String getSortType() {
		return sortType;
	}
	public static void setSortType(String sortType) {
		SortApp.sortType = sortType;
	}

}
