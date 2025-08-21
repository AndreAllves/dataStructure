package sorting;

public class SelectionSort<T extends Comparable<T>> {
    
    public void sort(T[] array, int leftIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= rightIndex; j++) {
                if ((array[j]).compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
