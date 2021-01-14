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
    		else {
			double temp3 = arr[i];
			arr[i] = arr[rightIndex];
			arr[rightIndex] = temp3;
			return (i);
		}
	}
	return i;
}
