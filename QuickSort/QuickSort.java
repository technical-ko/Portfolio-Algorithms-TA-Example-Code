
public class QuickSort {
	private QuickSort() {}

    
        /**
     * A Public wrapper method for the quickSort function.
     * @param a the array to be sorted.
     */
	public static void quickSort(int[] a){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
    
        quickSort(a, sb, 0, a.length-1);
        //removes the last two characters from the end of the string.
        sb.setLength(sb.length()-2);
        sb.append("]");
        System.out.println(sb.toString());
        }
    
    
        /**
         * Prints the contents of an array in sorted order.
         * @param a an unsorted list of integers
         * @param start the beginning of the array to be sorted
         * @param end the end of the array to be sorted
         */
        private static void quickSort(int[] a, StringBuilder sb, int start, int end){
            if(end - start < 2)
            {
                //if subarray is size 3 or less, call inPlaceInsertion to sort the rest
                inPlaceInsertionSort(a, start, end - start + 1);
                for(int i = start; i <= end; i++)
                {
                    sb.append(a[i] + ", ");
                }
            }
            else
            {
                int pivotIdx = partition(a, start, end);
                quickSort(a, sb, start, pivotIdx - 1);

                //store elements equal to the pivot in sb and find start of right partition
                int rightStart = pivotIdx;
                while(a[pivotIdx] == a[rightStart] && rightStart < end)
                {
                    sb.append(a[rightStart] + ", ");
                    rightStart++;
                }
                quickSort(a, sb, rightStart, end);
            }
        }
    
        /**
     * Selects the index within the range of the subarray beginning at start and ending at end (inclusive) of the 
     * input array and uses its value as a pivot, and partitioning the array so that values less than the pivot are
     * placed to the left, values equal to the pivot are in the middle, and values greater than the pivot are on the 
     * right of the subarray. After partitioning, returns the index at the start of the middle partition.
     * A private helper method for the QuickSort class.
     * Runs in linear time.
     * @param a the array to be partitioned.
     * @param start The start of the subarray to be partitioned (inclusive).
     * @param end The end of the subarray to be partitioned (inclusive).
     * @return The index at the start of the middle partition.
     */
    private static int partition(int[] a, int start, int end){
        int pivotIdx = end;
        int i = start;
        
        while(i < pivotIdx)
        {
            if(a[i] < a[pivotIdx])
            {
                i++;
            }
            else if( a[i] == a[pivotIdx])
            {
                swap(a, pivotIdx - 1, i);
                pivotIdx--;
                i++;
            }
            else
            {
                swap(a, pivotIdx, pivotIdx - 1);
                pivotIdx--;
                if(pivotIdx != i)
                {
                    swap(a, i, pivotIdx + 1);
                }
            }
        }
         return pivotIdx;
    }

        /**
     * Swaps the values in a at the given indices.
     * A private helper method for the Quicksort class.
     * Runs in constant time.
     * @param a the array to be modified.
     * @param idx1 the index to have its value swapped with idx2.
     * @param idx2 the index to have its value swapped with idx1.
     */
    private static void swap(int[] a, int idx1, int idx2){
        int hold;
        hold = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = hold;
    }



    private static void inPlaceInsertionSort(int[] a, int startIdx, int length){
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


    }
