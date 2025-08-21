package sorting;

public class BubbleSortRecursivo<T extends Comparable<T>> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			if (leftIndex <= rightIndex - 1) {
				if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
					swap(array, leftIndex, leftIndex + 1);
				}
				sort(array, leftIndex + 1, rightIndex);
			} 
			sort(array, leftIndex, rightIndex - 1);
		}

	}

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

