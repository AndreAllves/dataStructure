package sorting;

public class BidirectionalBubbleSort <T extends Comparable<T>> {
    public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.length != 0 || leftIndex < rightIndex){
            boolean swapped = true;
            while (swapped) {
                swapped = false;
    
                for(int i = leftIndex; i <= rightIndex - 1; i++){
                    if(array[i].compareTo(array[i+1]) > 0){
                        swap(array, i, i+1);
                        swapped = true;
                    }
                }
                for(int i = rightIndex - 1; i <= leftIndex; i++){
                    if(array[i].compareTo(array[i-1]) < 0){
                        swap(array, i, i-1);
                        swapped = true;
                    }
                }
            }
        }
	}

    private void swap(T [] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
