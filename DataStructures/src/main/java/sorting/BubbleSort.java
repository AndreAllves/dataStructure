package sorting;

public class BubbleSort<T extends Comparable<T>> {
    public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean swapped = true;
        while (swapped) {
            swapped = false;
            for(int i = leftIndex; i < rightIndex; i++){
                if(array[i].compareTo(array[i+1]) > 0){
                    swap(array, i, i+1);
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
	}

    private void swap(T [] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
