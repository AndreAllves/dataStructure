package sorting;

public class SelectionSortRecursivo<T extends Comparable<T>> {
    public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int minIndex = leftIndex;
			if(leftIndex - 1 <= rightIndex){
				if(array[leftIndex].compareTo(array[leftIndex+1]) > 0){
					minIndex = leftIndex + 1;
				}
				swap(array, minIndex, leftIndex);
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