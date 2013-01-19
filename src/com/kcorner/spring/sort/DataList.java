package com.kcorner.spring.sort;

import java.util.ArrayList;
import java.util.List;

public class DataList {
	
	private List<Integer> item = new ArrayList<Integer> ();
    private int size = 0;
    private int maxInt = 0;
	
	public DataList(int size, int maxInt) {
		this.size = size;
		this.maxInt = maxInt;
		autoIntGenerator();
	}

	private void autoIntGenerator() {
        for(int i=0;i<getSize();i++){
            item.add((int)(Math.random()*getMaxInt()));
        }
	}
	
	public int getSize() {
		return size;
	}

	public int getMaxInt() {
		return maxInt;
	}

	public List<Integer> getItem() {
		return item;
	}

	public void setItem(List<Integer> item) {
		this.item = item;
	}
		
}
