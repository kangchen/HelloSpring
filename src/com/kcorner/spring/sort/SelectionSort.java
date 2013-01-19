package com.kcorner.spring.sort;

import org.springframework.beans.factory.annotation.Required;

public final class SelectionSort implements Runnable, Sort {
		
	private DataList datalist;
	private long time = 0;
	
	public SelectionSort() {}
	
	public void init() {
		System.out.println("Selection Sort initializing method is called");
	}
	
	public void clean() {
		datalist.setItem(null);
		System.out.println("Selection Sort cleaning method is called");
	}	
	
	@Override // Runnable
	public void run() {
		sort();
	}
 
	@Required
    public void setDatalist(DataList datalist) {
		this.datalist = datalist;
	}

	/*
     * Selection Sort Algorithm O((N*N)/2)
     */
	@Override // Sort
	public void sort() {
        long starttime = System.nanoTime();
        int idx=0;          //location of smallest number
        int tmp=0;          //find smallest number

        for(int i=0; i<datalist.getItem().size()-1; i++) {
            tmp = datalist.getItem().get(i);
            for(int j=i; j<datalist.getItem().size(); j++) {
               if (datalist.getItem().get(j) <= tmp) {
                   tmp = datalist.getItem().get(j);
                   idx = j;
               }
            }
            swap(i,idx);
        }

        long endtime = System.nanoTime();
        time = endtime - starttime;
	}
	
    private long getTime() {
        return time;
    }
    
    private void swap(int x, int y) {
        int tmp = datalist.getItem().get(x);
        datalist.getItem().set(x, datalist.getItem().get(y));
        datalist.getItem().set(y, tmp);
    }	
    
    public String toString() {
    	return "Selection sort completed in " + getTime() + " nanoseconds";
    } 
    
    @Override // Sort
    public void println() {
    	for (Integer a: datalist.getItem()) System.out.print(a + "  ");
    	System.out.println();
    }     
}
