import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Seth Grace Banaga - used Ivana's notes and sample codes from the slides
 *  @version HT 2018
 */
//in milliseconds
//-----------------------------------------------------------------------------------------------
/*  					| Insertion	| Quick 	| Merge 	| Shell 	| Selection |  Bubble 	|
 * 10 random			|	  0 	|	  0		|	  0		|	  0		|	  0		|	  0		|
 * 100 random			|	  1		|	  1		|	  1		|	  1		|	  1		|	  2		|
 * 1000 random			|	  3		|	  1		|	  1		|	  2		|	  2		|	  7		|	
 * 1000 few unique		|	  3		|	  1		|	  1		|	  2		|	  3		|	  8		|
 * 1000 nearly ordered	|	  4		|	  1		|	  2		|	  3		|	  5		|	  9		|
 * 1000 reverse order	|	  5		|	  1		|	  2		|	  3		|	  5		|	  10	|
 * 1000 sorted			|	  6		|	  1		|	  2		|	  3		|	  6		|	  10	|
 * ----------------------------------------------------------------------------------------------
 * 1. Which of the sorting algorithms does the order of input have an impact on? Why? 
 *    -> InsertionSort, BubbleSort, SelectionSort
 * 2. Which algorithm has the biggest difference between the best and worst performance, based
 *    on the type of input, for the input of size 1000? Why?
 *    -> BubbleSort
 * 3. Which algorithm has the best/worst scalability, ie, the difference in performance time based
 *    on the input size? Please consider only input files with random order for this answer. 
 *    -> best scalability: QuickSort
 *    -> worst scalability: BubbleSort
 * 4. Which algorithm is the fastest for each of the 7 input files? 
 *    -> QuickSort   
*/
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] values = {0.0};
 
        SortComparison.insertionSort(values);
        assertEquals("[0.0]", Arrays.toString(values));
       
        SortComparison.quickSort(values);
        assertEquals("Quick Sort with an empty array", "[0.0]", Arrays.toString(values));				
        
        SortComparison.mergeSort(values);
        assertEquals("Merge Sort with an empty array", "[0.0]", Arrays.toString(values));				
    
        SortComparison.shellSort(values);
        assertEquals("Shell Sort with an empty array", "[0.0]", Arrays.toString(values));				
    
        SortComparison.selectionSort(values);
        assertEquals("Selection Sort with an empty array", "[0.0]", Arrays.toString(values));				
        
        SortComparison.bubbleSort(values);
        assertEquals("Bubble Sort with an empty array", "[0.0]", Arrays.toString(values));				
    }
    
    @Test
    public void shouldSortValues() {
        double[] values = {9.0, -3.0, 5.0, 0.0, 1.0};
 
        SortComparison.insertionSort(values); 
        assertEquals("[-3.0, 0.0, 1.0, 5.0, 9.0]", Arrays.toString(values));
        
        SortComparison.quickSort(values); 
        assertEquals("[-3.0, 0.0, 1.0, 5.0, 9.0]", Arrays.toString(values));
        
        SortComparison.mergeSort(values); 
        assertEquals("[-3.0, 0.0, 1.0, 5.0, 9.0]", Arrays.toString(values));
        
        SortComparison.shellSort(values); 
        assertEquals("[-3.0, 0.0, 1.0, 5.0, 9.0]", Arrays.toString(values));
        
        SortComparison.selectionSort(values); 
        assertEquals("[-3.0, 0.0, 1.0, 5.0, 9.0]", Arrays.toString(values));
        
        SortComparison.bubbleSort(values); 
        assertEquals("[-3.0, 0.0, 1.0, 5.0, 9.0]", Arrays.toString(values)); 
    }
    @Test
    public void reversedValues() {
        double[] values = {4.0, 3.0, 2.0, 1.0};
      
        SortComparison.insertionSort(values); 
        assertEquals("[1.0, 2.0, 3.0, 4.0]", Arrays.toString(values));
 
        SortComparison.quickSort(values); 
        assertEquals("quick sort", "[1.0, 2.0, 3.0, 4.0]", Arrays.toString(values));
        
        SortComparison.mergeSort(values); 
        assertEquals("merge sort", "[1.0, 2.0, 3.0, 4.0]", Arrays.toString(values));
        
        SortComparison.shellSort(values); 
        assertEquals("[1.0, 2.0, 3.0, 4.0]", Arrays.toString(values));
        
        SortComparison.selectionSort(values); 
        assertEquals("[1.0, 2.0, 3.0, 4.0]", Arrays.toString(values));
        
        SortComparison.bubbleSort(values); 
        assertEquals("[1.0, 2.0, 3.0, 4.0]", Arrays.toString(values));
    }
    
    @Test
    public void nearlyOrderedValues(){
    	double[] values = {0.0, 1.0, 2.0, 3.0, 5.0, 4.0};
        
        SortComparison.insertionSort(values); 
        assertEquals("insertion sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
   
        SortComparison.quickSort(values); 
        assertEquals("quick sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
          
        SortComparison.mergeSort(values); 
        assertEquals("merge sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
          
        SortComparison.shellSort(values); 
        assertEquals("shell sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
          
        SortComparison.selectionSort(values); 
        assertEquals("selection sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
          
        SortComparison.bubbleSort(values); 
        assertEquals("bubble sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
    }
    
    @Test
    public void sortedValues() {
    	double[] values = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        
        SortComparison.insertionSort(values); 
        assertEquals("insertion sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
 
        SortComparison.quickSort(values); 
        assertEquals("quick sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
        
        SortComparison.mergeSort(values); 
        assertEquals("merge sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
        
        SortComparison.shellSort(values); 
        assertEquals("shell sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
        
        SortComparison.selectionSort(values); 
        assertEquals("selection sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
        
        SortComparison.bubbleSort(values); 
        assertEquals("bubble sort", "[0.0, 1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(values));
    }
    
    @Test
    public void duplicateValues() {
    	double[] values = {0.0, 2.0, 2.0, 1.0, 0.0, 2.0};
        
        SortComparison.insertionSort(values); 
        assertEquals("insertion sort", "[0.0, 0.0, 1.0, 2.0, 2.0, 2.0]", Arrays.toString(values));
 
        SortComparison.quickSort(values); 
        assertEquals("quick sort", "[0.0, 0.0, 1.0, 2.0, 2.0, 2.0]", Arrays.toString(values));
        
        SortComparison.mergeSort(values); 
        assertEquals("merge sort", "[0.0, 0.0, 1.0, 2.0, 2.0, 2.0]", Arrays.toString(values));
        
        SortComparison.shellSort(values); 
        assertEquals("shell sort", "[0.0, 0.0, 1.0, 2.0, 2.0, 2.0]", Arrays.toString(values));
        
        SortComparison.selectionSort(values); 
        assertEquals("selection sort", "[0.0, 0.0, 1.0, 2.0, 2.0, 2.0]", Arrays.toString(values));
        
        SortComparison.bubbleSort(values); 
        assertEquals("bubble sort", "[0.0, 0.0, 1.0, 2.0, 2.0, 2.0]", Arrays.toString(values));
    }
    
    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
//    public static void main(String[] args){
    //}
}
