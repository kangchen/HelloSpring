package com.kcorner.spring.sort;

import org.springframework.beans.factory.annotation.Autowired;

public class BubbleSort implements Runnable, Sort {
	
	private DataList datalist;
	private long time = 0;
	
	public BubbleSort(DataList datalist) {
		this.datalist = datalist;
	}
	
	public BubbleSort() {

	}

	public void init() {
		System.out.println("Bubble Sort initializing method is called");
	}
	
	public void clean() {
		datalist.setItem(null);
		System.out.println("Bubble Sort cleaning method is called");
	}
	
    /*
     * Bubble Sort Algorithm O(N*N)
     */	
	public void sort() {
		long starttime = System.nanoTime();
		for (int i=0; i<datalist.getItem().size()-1; i++){
			for (int j=0; j<datalist.getItem().size()-1; j++){
				if (datalist.getItem().get(j) > datalist.getItem().get(j+1)) {
					swap(j,j+1);
				}
			}
		}
        long endtime = System.nanoTime();
        time = endtime - starttime;
	}
	
    private void swap(int x, int y) {
        int tmp = datalist.getItem().get(x);
        datalist.getItem().set(x, datalist.getItem().get(y));
        datalist.getItem().set(y, tmp);
    }

    @Autowired
	public void setDatalist(DataList datalist) {
		this.datalist = datalist;
	}

	public DataList getDatalist() {
		return datalist;
	}
	
    private long getTime() {
        return time;
    }
    
    public String toString() {
    	return "Bubble sort completed in " + getTime() + " nanoseconds";
    }
    
    public void println() {
    	for (Integer a: datalist.getItem()) System.out.print(a + "  ");
    	System.out.println();
    }

	@Override  //Runnable
	public void run() {
		// TODO Auto-generated method stub
		sort();		
	}  
//	
//	@Override  //InitializingBean
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Bubble Sort initializing method is called.");
//	}
//
//	@Override  //DisposableBean
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Bubble Sort destroy method is called.");
//	}
//   
	
}
