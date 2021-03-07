
/**
 * @author Keith O'Neal
 * A java implementation of the MergeSort algorithm.
 * This is example code that I wrote for our CISC380 Algorithms class.
 */

public class MergeSort {
	private MergeSort() {}
	public static void mergeSort(int[] a){
		int[] scratch = new int[a.length];
		mergeSort(a, scratch, 0, a.length);
	}
	
	public static void inPlaceInsertionSort(int[] a, int startIdx, int length){
	//sorts the array with insertion sort in place
		if(length == 0){return;}
	
		int j;
		int temp;
	
		//for every spot in the array
		for(int i = startIdx; i < startIdx + length; i++){
			j = i;
			
			while( j !=startIdx && (a[j] < a[j-1])){ //while not at end and while the index to be sorted is smaller
				//swap them
				temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;	
				//decrement j
				j--;
			}//while
		
		}//for
	
	}//inPlaceInsertionSort
		


	/**
	 * A recursive method for sorting the subarray beginning at startIdx through startIdx + length.
	 * Runs in O(nlogn).
	 * @param a The array containing elements to be sorted
	 * @param scratch the array in which output is stored
	 * @param startIdx The start of the subarray to be sorted
	 * @param length The length of the subarray to be sorted
	 */
	private static void mergeSort(int[] a, int[] scratch, int startIdx, int length){
		int leftLen, rightLen;
	    //Base Case
	    if (length < 10){
			 inPlaceInsertionSort(a,startIdx,length);
	        return;
	    }

	    //Compute the length of the 2 different lists
	    if (length % 2 == 1){
	        //If the original list has odd length, make right list 1 longer than the left
	        leftLen = length/2 ;
	        rightLen = length/2+1;
	    }else{
			//If the original list has even length, make the two lists the same length
			leftLen = length/2;
	        rightLen = length/2;
	    }

	    //Recursive Step: Perform MergeSort on the left half
	    mergeSort(a, scratch, startIdx, leftLen);

	    //Recursive Step: Perform MergeSort on the right half
	    mergeSort(a, scratch, startIdx+leftLen, rightLen);


	    //Merge the result of the 2 recursions
		merge(a, scratch, 0, startIdx, startIdx, startIdx + (length/2), length);
		
		//replace the elements in the array with the now ordered output array
	    for (int i = 0; i < length; i++){
	        a[i + startIdx] = scratch[i];
	    }
	}

	/**
	 * 	The goal of this method is to take two 'lists' of integers of equal size 
	 *	and put them together so that their elements are in sorted ascending order.
	 *	Runs in O(n)
	 *	In this implementation, both 'lists' are within the array a, 
	 *	with the first list starting at startIdx, and the second starting at the midIdx
	 *	This method 'outputs' by sorting the elements in a from a[startIdx] to a[startIdx+length]
	 *	The inputs assume that:
	 *		- the elements of the 'lists' are already in ascending order.
	 *		- a and scratch are not null.
	 *		- startIdx is a valid index and the start of the first list.
	 *		- startIdx + length / 2 is the start of second list.
	 *
	 * @param a The array with elements to be sorted
	 * @param scratch the array in which output is stored
	 * @param outputIdx  current index to receive output
	 * @param startIdx The beginning of the first list
	 * @param i An index pointer for the first list
	 * @param j An index pointer for the second list
	 * @param length the combined length of the two lists to be merged
	 */
private static void merge(int[] a, int[] scratch, int outputIdx, int startIdx, int i, int j, int length){

		//midIdx - the index halfway between the start and length, 
		//outputIdx -
		int midIdx = startIdx + length/2;

		//base cases
		if(i == midIdx)
		{	//The left half is empty, add what remains of the right half
			while(outputIdx < startIdx+length)
			{
				scratch[outputIdx] = a[j];
				outputIdx++;
				j++;
			}
			return;
		}
		if(j == startIdx + length)
		{//The right half is empty, add what remains of the left half
			while(i < startIdx+(length/2))
			{
				scratch[outputIdx] = a[i];
				outputIdx++;
				i++;
			}
			return;
		}
		//general case
		if(a[i] < a[j])
		{
			scratch[outputIdx] = a[i];
			outputIdx++;
			merge(a, scratch, outputIdx, startIdx, i+1, j, length);
		}
		else
		{
			scratch[outputIdx] = a[j];
			outputIdx++;
			merge(a, scratch, outputIdx, startIdx, i, j+1, length);
		}
		return;
	}
}
