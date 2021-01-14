package Sorting;

import java.util.Random;

import Plotter.Plotter;

public class Sorting {


	final static int BUBBLE_VS_QUICK_LENGTH = 12;
	final static int MERGE_VS_QUICK_LENGTH = 15;
	final static int BUBBLE_VS_QUICK_SORTED_LENGTH = 12;
	final static int ARBITRARY_VS_MEDIAN_LENGTH = 16;
	final static double T = 600.0;
		
	
	/**
	 * Sorts a given array using the quick sort algorithm.
	 * At each stage the pivot is chosen to be the rightmost element of the subarray.
	 * 
	 * Should run in average complexity of O(nlog(n)), and worst case complexity of O(n^2)
	 * 
	 * @param arr - the array to be sorted
	 */
	public static void quickSortArbitraryPivot(double[] arr){
		quickSortArbitraryPivot(arr, 0, arr.length - 1);
	}
	
	
	/**
	 * An auxiliary function for quickSortArbitraryPivot.
	 * Sorts a given array using the quick sort algorithm.
	 * At each stage the pivot is chosen to be the rightmost element of the subarray.
	 * 
	 * @param arr - the array to be sorted
	 * @param leftIndex - first Index of the subArray
	 * @param rightIndex - last Index of the subArray
	 */
	public static void quickSortArbitraryPivot(double[] arr, int leftIndex, int rightIndex){
		int pivotIndex;
		if(leftIndex + 2 < rightIndex) {
			pivotIndex = partitionArbitrary(arr, leftIndex, rightIndex);
			quickSortArbitraryPivot(arr, leftIndex, pivotIndex - 1);
			quickSortArbitraryPivot(arr, pivotIndex + 1, rightIndex);
		} 
		else {
			bubbleSort(arr, leftIndex, rightIndex);
		}
	}
	
	
	/**
	 * The function receives an array, first Index and last Index of the array.
	 * It chooses the pivot to be the most right element, and compares it to all the element
	 * in the array.
	 * It rearranges the array such that all the elements that are bigger than the pivot are placed
	 * to its right, and all the elements that are smaller than the pivot are placed to its left.
	 * 
	 * After arranging the array, it returns the current Index of the pivot.
	 * 
	 * @param arr - the array to be sorted
	 * @param leftIndex - first Index of the subArray
	 * @param rightIndex - last Index of the subArray
	 * @return the correct Index of the pivot
	 */
	public static int partitionArbitrary(double[] arr, int leftIndex, int rightIndex) {
		//chooses the pivot to be the most right element in the current subArray
		double pivot = arr[rightIndex];
		//start comparison
		int i = leftIndex;
		int j = rightIndex;
		while (i < j) {
			//while the current element is bigger or equals to the Pivot - move left 
			while((arr[j] >= pivot) && (j > leftIndex)){
				j--;
			}
			//while the current element is smaller than the Pivot - move right
			while(arr[i] < pivot) {
				i++;
			}
			//if we haven't compare all the elements in the array
			//and found 2 elements that are not sorted - switch between them
			if(i < j) {
				double temp2 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp2;
			}
			//if we checked all elements in the array - we found the correct place for the Pivot
			else {
				double temp = arr[i];
				arr[i]=arr[rightIndex];
				arr[rightIndex]= temp;
			}
		}
		return i;
	}
	
		
	/**
	 * Sorts a given array using the quick sort algorithm.
	 * At each stage the pivot is chosen in the following way:
	 * Choose 3 random elements from the array, the pivot is the median of the 3 elements.
	 * 
	 * Should run in average complexity of O(nlog(n)), and worst case complexity of O(n^2)
	 * 
	 * @param arr - the array to be sorted
	 */
	public static void quickSortMedianPivot(double[] arr){
			quickSortMedianPivot(arr, 0, arr.length - 1);
		}
	
	
	/**
	 * An auxiliary function for quickSortMedianPivot.
	 * Sorts a given array using the quick sort algorithm.
	 * At each stage the pivot is chosen in the following way:
	 * Choose 3 random elements from the array, the pivot is the median of the 3 elements.
	 * 
	 * @param arr - the array to be sorted
	 * @param leftIndex - first Index of the subArray
	 * @param rightIndex - last Index of the subArray
	 */
	public static void quickSortMedianPivot(double[] arr, int leftIndex, int rightIndex){
		if(leftIndex + 2 < rightIndex) {
			int index1 = leftIndex;
			int index2 = (rightIndex - leftIndex) / 2;
			int index3 = rightIndex;
			chooseMedian(arr, index1, index2, index3);
			int pivotIndex = partition(arr, leftIndex, rightIndex);
			quickSortMedianPivot(arr, leftIndex, pivotIndex - 1);
			quickSortMedianPivot(arr, pivotIndex + 1, rightIndex);
		}
		else {
			bubbleSort(arr, leftIndex, rightIndex);
		}
	}
	
	
	/**
	 * An auxiliary function that gets 3 Array Indexes (most right Index, most left Index and middle Index),
	 * and chooses the pivot to be the median between the 3 elements in those Indexes.
	 * After finding the Median, It rearranges the subArray and swaps between the Median and the most right
	 * element, such that the Median is now at the most-right Index.
	 * 
	 * @param arr - the given array
	 * @param index1 - array Index that represents first element for comparison
	 * @param index2 - array Index that represents second element for comparison
	 * @param index3 - array Index that represents third element for comparison
	 */
	public static void chooseMedian(double[] arr, int index1, int index2 , int index3) {
		//chooses the median value between 3 elements and puts the pivot one index before most right
		double myMedian = 0;
		int myPivotIndex = 0;
		double element1 = arr[index1];
		double element2 = arr[index2];
		double element3 = arr[index3];
		//if the element in Index1 is the Median
		if(((element1 >= element2) && (element1 <= element3)) || ((element1 <= element2) && (element1 >= element3))) {
			myPivotIndex = index1;
			myMedian = element1;
		}
		//if the element in Index2 is the Median
		if(((element2 >= element1) && (element2 <= element3)) || ((element2 <= element1) && (element2 >= element3))) {
			myPivotIndex = index2;
			myMedian = element2;
		}
		//if the element in Index3 is the Median
		if(((element3 >= element2) && (element3 <= element1)) || ((element3 <= element2) && (element3 >= element1))) {
			myPivotIndex = index3;
			myMedian = element3;
		}
		//puts the pivot in the Most Right Index inside arr 
		double temp = arr[index3];
		arr[index3] = myMedian;
		arr[myPivotIndex] = temp;
	}
	
	
	/**
	 * The function receives an array, first Index and last Index of the array.
	 * It chooses the pivot to be the most right element, and compares it to all the element
	 * in the array.
	 * It rearranges the array such that all the elements that are bigger than the pivot are placed
	 * to its right, and all the elements that are smaller than the pivot are placed to its left.
	 * 
	 * After arranging the array, it returns the current Index of the pivot - which is also the correct
	 * Index where it should be placed in the array.
	 * 
	 * @param arr - the array to be sorted
	 * @param leftIndex - first Index of the subArray
	 * @param rightIndex - last Index of the subArray
	 * @return the correct Index of the pivot
	 */
	public static int partition(double[] arr, int leftIndex, int rightIndex) {
		double pivot = arr[rightIndex];	
		int i = leftIndex;
		int j = rightIndex;
		while (i < j) {
			//while the current element is bigger or equals to the Pivot - move left 
			while((arr[j] >= pivot) && (j > leftIndex)) {
				j--;
			}
			//while the current element is smaller than the Pivot - move right
			while(arr[i] < pivot) {
				i++;
			}
			//if we haven't compare all the elements in the array
			//and found 2 elements that are not sorted - switch between them
			if(i < j) {
				double temp2 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp2;
			}
			//if we checked all elements in the array - we found the correct place for the Pivot
			else 
			{
				double temp3 = arr[i];
				arr[i] = arr[rightIndex];
				arr[rightIndex] = temp3;
				return (i);
			}
		}
		return i;
	}


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


	/**
	 * Sorts a given array using bubble sort.
	 * If at any time the algorithm recognizes no more inversions are needed it should stop.
	 * 
	 * The algorithm should run in complexity O(n^2) in the worst case.
	 * The algorithm should run in complexity O(n) in the best case.
	 * 
	 * @param arr - the array to be sorted
	 */
	public static void bubbleSort(double[] arr){
		bubbleSort(arr, 0, arr.length - 1);
	}
	
	
	/**
	 * An auxiliary function for bubbleSort.
	 * Sorts a given array using bubble sort algorithm.
	 * If at any time the algorithm recognizes no more inversions are needed it should stop.
	 * 
	 * @param arr - the array to be sorted
	 * @param leftIndex - the most left Index in the subArray
	 * @param rightIndex - the most right Index in the subArray
	 */
	public static void bubbleSort(double[] arr, int leftIndex, int rightIndex){
		//if there is at least 1 element
		if ((rightIndex - leftIndex) >= 1) {
			double temp = 0;
			boolean swap = true;
			for (int i = leftIndex ; i < rightIndex ; i++) {
				for (int j = leftIndex + 1; j <= rightIndex ; j++) {
					//if 2 elements are not sorted - swap between them
					if (arr[j - 1] > arr[j]) {
						temp = arr[j - 1];
						arr[j - 1] = arr[j];
						arr[j] = temp;
						swap = false;
					}
				}
				//if no inversions were made, it means that the array is sorted - function stops.
				if(swap == true) {
					break;
				}
				else {
					swap = true;
				}
			}
		}
	}

	
	public static void main(String[] args) {

		bubbleVsQuick();
		mergeVsQuick();         
		bubbleVsQuickOnSortedArray();
		arbitraryPivotVsMedianPivot();
	}
	
	
	/**
	 * Compares the selection sort algorithm against quick sort on random arrays
	 */
	public static void bubbleVsQuick(){
		double[] quickTimes = new double[BUBBLE_VS_QUICK_LENGTH];
		double[] bubbleTimes = new double[BUBBLE_VS_QUICK_LENGTH];
		long startTime, endTime;
		Random r = new Random();
		for (int i = 0; i < BUBBLE_VS_QUICK_LENGTH; i++) {
			long sumQuick = 0;
			long sumSelection = 0;
			for(int k = 0; k < T; k++){
				int size = (int)Math.pow(2, i);
				double[] a = new double[size];
				double[] b = new double[size];
				for (int j = 0; j < a.length; j++) {
					a[j] = r.nextGaussian() * 5000;
					b[j] = a[j];
				}
				startTime = System.currentTimeMillis();
				quickSortArbitraryPivot(a);
				endTime = System.currentTimeMillis();
				sumQuick += endTime - startTime;
				startTime = System.currentTimeMillis();
				bubbleSort(b);
				endTime = System.currentTimeMillis();
				sumSelection += endTime - startTime;
			}
			quickTimes[i] = sumQuick/T;
			bubbleTimes[i] = sumSelection/T;
		}
		Plotter.plot("quick sort on random array", quickTimes, "bubble sort on random array", bubbleTimes);
	}
	

	/**
	 * Compares the merge sort algorithm against quick sort on random arrays
	 */
	public static void mergeVsQuick(){
		double[] quickTimes = new double[MERGE_VS_QUICK_LENGTH];
		double[] mergeTimes = new double[MERGE_VS_QUICK_LENGTH];
		long startTime, endTime;
		Random r = new Random();
		for (int i = 0; i < MERGE_VS_QUICK_LENGTH; i++) {
			long sumQuick = 0;
			long sumMerge = 0;
			for (int k = 0; k < T; k++) {
				int size = (int)Math.pow(2, i);
				double[] a = new double[size];
				double[] b = new double[size];
				for (int j = 0; j < a.length; j++) {
					a[j] = r.nextGaussian() * 5000;
					b[j] = a[j];
				}
				startTime = System.currentTimeMillis();
				quickSortArbitraryPivot(a);
				endTime = System.currentTimeMillis();
				sumQuick += endTime - startTime;
				startTime = System.currentTimeMillis();
				mergeSort(b);
				endTime = System.currentTimeMillis();
				sumMerge += endTime - startTime;
			}
			quickTimes[i] = sumQuick/T;
			mergeTimes[i] = sumMerge/T;
		}
		Plotter.plot("quick sort on random array", quickTimes, "merge sort on random array", mergeTimes);
	}

	
	/**
	 * Compares the merge sort algorithm against quick sort on pre-sorted arrays
	 */
	public static void bubbleVsQuickOnSortedArray(){
		double[] quickTimes = new double[BUBBLE_VS_QUICK_SORTED_LENGTH];
		double[] bubbleTimes = new double[BUBBLE_VS_QUICK_SORTED_LENGTH];
		long startTime, endTime;
		for (int i = 0; i < BUBBLE_VS_QUICK_SORTED_LENGTH; i++) {
			long sumQuick = 0;
			long sumBubble = 0;
			for (int k = 0; k < T; k++) {
				int size = (int)Math.pow(2, i);
				double[] a = new double[size];
				double[] b = new double[size];
				for (int j = 0; j < a.length; j++) {
					a[j] = j;
					b[j] = j;
				}
				startTime = System.currentTimeMillis();
				quickSortArbitraryPivot(a);
				endTime = System.currentTimeMillis();
				sumQuick += endTime - startTime;
				startTime = System.currentTimeMillis();
				bubbleSort(b);
				endTime = System.currentTimeMillis();
				sumBubble += endTime - startTime;
			}
			quickTimes[i] = sumQuick/T;
			bubbleTimes[i] = sumBubble/T;
		}
		Plotter.plot("quick sort on sorted array", quickTimes, "bubble sort on sorted array", bubbleTimes);
	}

	
	/**
	 * Compares the quick sort algorithm once with a choice of an arbitrary pivot and once with a choice of a median pivot
	 */
	public static void arbitraryPivotVsMedianPivot(){
		double[] arbitraryTimes = new double[ARBITRARY_VS_MEDIAN_LENGTH];
		double[] medianTimes = new double[ARBITRARY_VS_MEDIAN_LENGTH];
		long startTime, endTime;
		Random r = new Random();
		for (int i = 0; i < ARBITRARY_VS_MEDIAN_LENGTH; i++) {
			long sumArbitrary = 0;
			long sumMedian = 0;
			for (int k = 0; k < T; k++) {
				int size = (int)Math.pow(2, i);
				double[] a = new double[size];
				double[] b = new double[size];
				for (int j = 0; j < a.length; j++) {
					a[j] = r.nextGaussian() * 5000;
					b[j] = a[j];
				}
				startTime = System.currentTimeMillis();
				quickSortArbitraryPivot(a);
				endTime = System.currentTimeMillis();
				sumArbitrary += endTime - startTime;
				startTime = System.currentTimeMillis();
				quickSortMedianPivot(b);
				endTime = System.currentTimeMillis();
				sumMedian += endTime - startTime;
			}
			arbitraryTimes[i] = sumArbitrary/T;
			medianTimes[i] = sumMedian/T;
		}
		Plotter.plot("quick sort with an arbitrary pivot", arbitraryTimes, "quick sort with a median pivot", medianTimes);
	}
}
