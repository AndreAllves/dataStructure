package sorting;

public class BinarySearchCeil<T extends Comparable<T>>  {
	
	public  int binarySearchCeil(T[] array, T x){
		return binarySearchCeilRecursive(array, x, 0, array.length-1, -1);
	}

	private int binarySearchCeilRecursive(T[] array, T x, int leftIndex, int rightIndex, int ceilIndex) {
		int middle = leftIndex + (rightIndex - leftIndex) / 2;
		
		if (leftIndex > rightIndex) {
			return ceilIndex;
		}
		
		if (array[middle].compareTo(x) == 0) {
			return middle;
		}
		
		int out = 0;
		if (array[middle].compareTo(x) > 0) {
			ceilIndex = middle;
			out = binarySearchCeilRecursive(array, x, leftIndex, middle-1, ceilIndex);
		}
		else {
			out = binarySearchCeilRecursive(array, x, middle+1, rightIndex, ceilIndex);
		}
		return out;
	}
}
