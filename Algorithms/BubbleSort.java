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
