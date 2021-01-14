/**
	 * Sorts a given array using the merge sort algorithm.
	 * 
	 * Should run in complexity O(nlog(n)) in the worst case.
	 * 
	 * @param arr - the array to be sorted
	 */
	public static void mergeSort(double[] arr){
		mergeSort(arr, 0, arr.length - 1);
	}
	
	
	/**
	 * An auxiliary function for mergeSort.
	 * Sorts a given array using the merge sort algorithm.
	 * Sorts a given array from the most left Index up to the most right Index, 
	 * using another auxiliary function - merge. 
	 * 
	 * @param arr - the array to be sorted
	 * @param leftIndex - the most left Index in the subArray
	 * @param rightIndex - the most right Index in the subArray
	 */
	public static void mergeSort(double[] arr, int leftIndex, int rightIndex) {
		//if there are at lease 2 elements
		if(leftIndex < rightIndex) {
			int midIndex = (leftIndex + rightIndex) / 2;
			//mergeSort on the Left subArray
			mergeSort(arr, leftIndex, midIndex);
			//mergeSort on the right subArray
			mergeSort(arr, midIndex + 1, rightIndex);
			merge(arr, leftIndex, midIndex, rightIndex);
		}
	}
	
	
	/**
	 * An auxiliary function that gets an array and 3 Indexes - left, middle, right.
	 * Creates two new subArrays and Copies the element in the given array into the new subArrays. 
	 * Compares between the elements in the subArrays, and inserts them back into the original given array
	 * in a sorted order - from the smallest to the biggest. 
	 * 
	 * @param arr - the given array to be sorted
	 * @param leftIndex - the most left Index in the subArray
	 * @param midIndex - the middle Index in the SubArray
	 * @param rightIndex - the most right Index in the subArray
	 */
	public static void merge(double[] arr, int leftIndex, int midIndex, int rightIndex) {
		double maxNum = Double.POSITIVE_INFINITY;
		
		//create 2 new subArrays
		double[] Larr = new double[(midIndex - leftIndex + 1) + 1];
		Larr[Larr.length - 1] = maxNum; 
		double[] Rarr = new double[(rightIndex - midIndex) + 1];
		Rarr[Rarr.length - 1] = maxNum;
		
		//copy the Left subArray to the new 'Larr' array
		for(int i = 0 ; i < Larr.length - 1 ; i++) {
			Larr[i] = arr[leftIndex + i];
		}
		//copy the Right subArray to the new 'Rarr' array
		for(int j = 0 ; j < Rarr.length - 1 ; j++) {
			Rarr[j] = arr[midIndex + 1 + j];
		}	
		//Compares between the elements in the subArrays and inserts them back into
		//the original given array in a sorted order
		int l = 0;
		int r = 0;
		for (int k = leftIndex; k <= rightIndex; k++) {
			if(Larr[l] <= Rarr[r]) {
				arr[k] = Larr[l];
				l = l + 1;
			}
			else {
				arr[k] = Rarr[r];
				r = r + 1;
			}
		}		
	}
