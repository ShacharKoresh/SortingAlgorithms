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
