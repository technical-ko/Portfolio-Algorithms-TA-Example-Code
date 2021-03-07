
public class MergeDriver{
	/*
	Andrew Dolge
	Prof. Miracle, CISC 480
	Example code
	*/
	
	public static void main(String[] args){
	//tests the MergeSort class with various int[] inputs
	
	//tests an array that is already sorted
	System.out.println("Case 2: tests a sorted array of length 15");
	int[] sorted = {-1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	test(sorted);
	
	//tests an array that is reverse sorted (worst case)
	System.out.println("Case 3: tests a reverse sorted array of length 15");
	int[] reversed = {15,14,13,12,11,10,9,8,7,6,5,4,3,2,-1};
	test(reversed);
	
	//Tests an array of size 16, a power of two above 10
	//When the length is a power of two, the even length case will always trigger in mergeSort
	System.out.println("Case 4: tests an array of length 16 (power of an even)");
	int[] powerTwo = {16,14,12,10,8,6,4,2,15,13,11,9,7,5,3,1};
	test(powerTwo);
	
	//tests an array of size 27, a power of three above 10
	//when the length is a power of three, the odd length case will always trigger(except for length 2) in mergeSort
	System.out.println("Case 5: tests an array of length 27 (power of an odd) ");
	int[] powerThree = {27,25,23,21,19,17,15,13,11,9,7,5,3,1,26,24,22,20,18,16,14,12,10,8,6,4,2};
	test(powerThree);
	
	}//main
	
	public static void test(int[] arr){
	//tests the mergeSort method on a given array arr, formatting the output to look presentable
	
	System.out.println("Elements before sort: " + prettyStr(arr));
	
	MergeSort.mergeSort(arr);
	
	System.out.println("Elements after sort: " + prettyStr(arr) +"\n");
	
	}//test
	
	public static String prettyStr(int[] arr){
	//returns a string representation of all elements within the given element arr
	
		if(arr == null){return "null";}
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ ");
		
		for(int i = 0; i < arr.length;i++){
			sb.append(arr[i] + "");
			if(i != arr.length - 1){sb.append(", ");}
		}//for
		sb.append(" ]");
		return sb.toString();
	
	}//print
	
}//class