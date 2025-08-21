package sorting;

public class InsertionSort<T extends Comparable<T>> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
        for(int i = leftIndex + 1; i <= rightIndex; i++){
            T key = array[i];
            int j = i - 1;

            while(j >= leftIndex && array[j].compareTo(key) > 0) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
	}

}
