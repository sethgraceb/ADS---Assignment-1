import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Seth Grace Banaga - used Ivana's notes and sample codes from the slides
 *  @version HT 2018
 */

 class SortComparison {
	 private static double[] input;
	 private static int length;
    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
		double temp;
		for (int i = 0; i < a.length; i++){
			for (int j = i; j > 0; j--){
				if (a[j] < a[j-1]){
				temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				}
			}
		}
		return a; 
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    
    static double [] quickSort (double a[]){
    	input = a;
    	length = a.length;
    	quickSort(0, length - 1);
    	return a;

    }//end quicksort
 
    private static void quickSort(int low, int high) {
        
        int i = low;
        int j = high;
        
        double pivot = input[low + (high - low) / 2];
        
        while (i <= j) {
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                
                i++;
                j--;
            }
        }
        
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }
    
    private static void swap(int i, int j) { 
    	double temp = input[i]; 
    	input[i] = input[j]; 
    	input[j] = temp; 
    	}

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] mergeSort (double a[]){		
    	int N = a.length;
        if (N <= 1) return a;
        double[] x = new double[N / 2];
        double[] y = new double[N - N/2];
        for (int i = 0; i < x.length; i++){
            x[i] = a[i];
        }
        for (int i = 0; i < y.length; i++){
            y[i] = a[i + N/2];
        }
        return merge(mergeSort(x), mergeSort(y));
    }//end mergesort
    
    private static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if      (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i] <= b[j])  c[k] = a[i++];
            else                    c[k] = b[j++];
        }
        return c;
    }
    /**
     * Sorts an array of doubles using Shell Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] shellSort (double a[]){
    	int i, j;
    	double temp;
    	
    	int h = 1;
    	while (h <= a.length / 3){
    		h = h * 3 + 1;
    	}
    	while (h > 0) {
    		for (j = h; j < a.length; j++){
    			temp = a[j];
    			i = j;
    			
    			while (i > h - 1 && a[i - h] >= temp) {
    				a[i] = a[i - h];
    				i -= h;
    			}
    			a[i] = temp;
    		} 
    		h = (h - 1) / 3;
    	}
    	return a;
    }//end shellsort
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	double temp = 0;
		for (int i = 0; i < a.length - 1; i++){
			int minElement = i; //min element in unsorted array
			for (int j = i+1; j < a.length; j++)
				if (a[j] < a[minElement])
				minElement = j;
				
				temp = a[minElement];
				a[minElement] = a[i];
				a[i] = temp;		
		}
		return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Bubble Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] bubbleSort (double a[]){
    	double temp;
		for (int i = 0; i < a.length; i++){
			for (int j = 1; j < (a.length - i); j++){
				if (a[j-1] > a[j]){
				temp = a[j-1];
				a[j-1] = a[j];
				a[j] = temp;
				}
			}
		}
		return a;	 
    }//end bubblesort

    public static void main(String[] args) { 
//    	In in1 = new In("C:\\Users\\home\\workspace\\SortComparison\\src\\numbers10.txt");
//		In in2 = new In("C:\\Users\\home\\workspace\\SortComparison\\src\\numbers100.txt");
//		In in3 = new In("C:\\Users\\home\\workspace\\SortComparison\\src\\numbers1000.txt");
//		In in4 = new In("C:\\Users\\home\\workspace\\SortComparison\\src\\numbers1000Duplicates.txt");
//		In in5 = new In("C:\\Users\\home\\workspace\\SortComparison\\src\\numbersNearlyOrdered1000.txt");
//		In in6 = new In("C:\\Users\\home\\workspace\\SortComparison\\src\\numbersReverse1000.txt");
//		In in7 = new In("C:\\Users\\home\\workspace\\SortComparison\\src\\numbersSorted1000.txt");
//		double[] a1 = in1.readAllDoubles();
//		double[] a2 = in2.readAllDoubles();
//		double[] a3 = in3.readAllDoubles();
//		double[] a4 = in4.readAllDoubles();
//		double[] a5 = in5.readAllDoubles();
//		double[] a6 = in6.readAllDoubles();
//		double[] a7 = in7.readAllDoubles();
//  
//		System.out.println("Before Sorting insertionsort: ");
//		System.out.println(Arrays.toString(a1));
//		insertionSort(a1);
//		System.out.println("\nAfter Sorting insertionsort: ");
//		System.out.println(Arrays.toString(a1));
//	//------------------------------------------------
//		System.out.println("\nBefore Sorting shellsort: ");
//	    System.out.println(Arrays.toString(a2));
//	    shellSort(a2);
//	    System.out.println("\nAfter Sorting shellsort: ");
//		System.out.println(Arrays.toString(a2));
//	//-------------------------------------------
//		System.out.println("\nBefore Sorting selectionsort: ");
//		System.out.println(Arrays.toString(a3));
//		selectionSort(a3);
//		System.out.println("\nAfter Sorting selectionsort: ");
//		System.out.println(Arrays.toString(a3));
//	//---------------------------------------
//		System.out.println("\nBefore Sorting bubblesort: ");
//		System.out.println(Arrays.toString(a4));
//		bubbleSort(a4);
//		System.out.println("\nAfter Sorting bubblesort: ");
//		System.out.println(Arrays.toString(a4));		
//	//---------------------------------------
//		System.out.println("\nBefore Sorting quicksort: ");
//		System.out.println(Arrays.toString(a5));
//		quickSort(a5);
//		System.out.println("\nAfter Sorting quicksort: ");
//		System.out.println(Arrays.toString(a5));
//    //-----------------------------------------------
//		System.out.println("\nBefore Sorting mergesort: ");
//		System.out.println(Arrays.toString(a6));
//		a6 = mergeSort(a6);
//		System.out.println("\nAfter Sorting mergesort: ");
////		System.out.print("[");
////		for (int i = 0; i < a6.length; i++)
////		System.out.print(a6[i] + " ");
////		System.out.println("]");
////		System.out.println("\n ");
//		System.out.println(Arrays.toString(a6));
//		System.out.println("\n");
//    //;================================
//		//Insertion Sort
//		
////		Stopwatch stopwatch = new Stopwatch();
////		SortComparison.insertionSort(a1);
////		double time1 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of insertionSort(10 numbers): " + time1*1000);
////		SortComparison.insertionSort(a2);
////		double time2 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of insertionSort(100 numbers): " + time2*1000);
////		SortComparison.insertionSort(a3);
////		double time3 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of insertionSort(1000 numbers): " + time3*1000);
////		SortComparison.insertionSort(a4);
////		double time4 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of insertionSort(1000 duplicate numbers): " + time4*1000);
////		SortComparison.insertionSort(a5);
////		double time5 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of insertionSort(1000 nearly ordered numbers): " + time5*1000);
////		SortComparison.insertionSort(a6);
////		double time6 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of insertionSort(1000 reversed numbers): " + time6*1000);
////		SortComparison.insertionSort(a7);
////		double time7 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of insertionSort(1000 sorted numbers): " + time7*1000);
////	//;==================================================================================
//		//Quick Sort
//		
////		Stopwatch stopwatch = new Stopwatch();
////		SortComparison.quickSort(a1);
////		double time1 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of quickSort(10 numbers): " + time1*1000);
////		SortComparison.quickSort(a2);
////		double time2 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of quickSort(100 numbers): " + time2*1000);
////		SortComparison.quickSort(a3);
////		double time3 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of quickSort(1000 numbers): " + time3*1000);
////		SortComparison.quickSort(a4);
////		double time4 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of quickSort(1000 duplicate numbers): " + time4*1000);
////		SortComparison.quickSort(a5);
////		double time5 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of quickSort(1000 nearly ordered numbers): " + time5*1000);
////		SortComparison.quickSort(a6);
////		double time6 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of quickSort(1000 reversed numbers): " + time6*1000);
////		SortComparison.quickSort(a7);
////		double time7 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of quickSort(1000 sorted numbers): " + time7*1000);
////	//;=================================================================================
//		//MergeSort
//		
////		Stopwatch stopwatch = new Stopwatch();
////		SortComparison.mergeSort(a1);
////		double time1 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of mergeSort(10 numbers): " + time1*1000);
////		SortComparison.mergeSort(a2);
////		double time2 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of mergeSort(100 numbers): " + time2*1000);
////		SortComparison.mergeSort(a3);
////		double time3 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of mergeSort(1000 numbers): " + time3*1000);
////		SortComparison.mergeSort(a4);
////		double time4 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of mergeSort(1000 duplicate numbers): " + time4*1000);
////		SortComparison.mergeSort(a5);
////		double time5 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of mergeSort(1000 nearly ordered numbers): " + time5*1000);
////		SortComparison.mergeSort(a6);
////		double time6 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of mergeSort(1000 reversed numbers): " + time6*1000);
////		SortComparison.mergeSort(a7);
////		double time7 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of mergeSort(1000 sorted numbers): " + time7*1000);
////	//;====================================================================================
//		//Shell Sort
//		
////		Stopwatch stopwatch = new Stopwatch();
////		SortComparison.shellSort(a1);
////		double time1 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of shellSort(10 numbers): " + time1*1000);
////		SortComparison.shellSort(a2);
////		double time2 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of shellSort(100 numbers): " + time2*1000);
////		SortComparison.shellSort(a3);
////		double time3 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of shellSort(1000 numbers): " + time3*1000);
////		SortComparison.shellSort(a4);
////		double time4 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of shellSort(1000 duplicate numbers): " + time4*1000);
////		SortComparison.shellSort(a5);
////		double time5 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of shellSort(1000 nearly ordered numbers): " + time5*1000);
////		SortComparison.shellSort(a6);
////		double time6 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of shellSort(1000 reversed numbers): " + time6*1000);
////		SortComparison.shellSort(a7);
////		double time7 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of shellSort(1000 sorted numbers): " + time7*1000);
////	//;===========================================================================
//		//Selection Sort
//		
////		Stopwatch stopwatch = new Stopwatch();
////		SortComparison.selectionSort(a1);
////		double time1 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of selectionSort(10 numbers): " + time1*1000);
////		SortComparison.selectionSort(a2);
////		double time2 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of selectionSort(100 numbers): " + time2*1000);
////		SortComparison.selectionSort(a3);
////		double time3 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of selectionSort(1000 numbers): " + time3*1000);
////		SortComparison.selectionSort(a4);
////		double time4 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of selectionSort(1000 duplicate numbers): " + time4*1000);
////		SortComparison.selectionSort(a5);
////		double time5 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of selectionSort(1000 nearly ordered numbers): " + time5*1000);
////		SortComparison.selectionSort(a6);
////		double time6 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of selectionSort(1000 reversed numbers): " + time6*1000);
////		SortComparison.selectionSort(a7);
////		double time7 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of selectionSort(1000 sorted numbers): " + time7*1000);
////	//;====================================================================================
//		//Bubble Sort
//		
////		Stopwatch stopwatch = new Stopwatch();
////		//.currentTimeMillis();
////		SortComparison.bubbleSort(a1);
////		double time1 = stopwatch.elapsedTime();
////		time1 = time1 * 1000;
////		StdOut.println("Elapsed time of bubbleSort(10 numbers): " + time1);
////		SortComparison.bubbleSort(a2);
////		double time2 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of bubbleSort(100 numbers): " + time2*1000);
////		SortComparison.bubbleSort(a3);
////		double time3 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of bubbleSort(1000 numbers): " + time3*1000);
////		SortComparison.bubbleSort(a4);
////		double time4 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of bubbleSort(1000 duplicate numbers): " + time4*1000);
////		SortComparison.bubbleSort(a5);
////		double time5 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of bubbleSort(1000 nearly ordered numbers): " + time5*1000);
////		SortComparison.bubbleSort(a6);
////		double time6 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of bubbleSort(1000 reversed numbers): " + time6*1000);
////		SortComparison.bubbleSort(a7);
////		double time7 = stopwatch.elapsedTime();
////		StdOut.println("Elapsed time of bubbleSort(1000 sorted numbers): " + time7*1000);
    }

 }//end class
