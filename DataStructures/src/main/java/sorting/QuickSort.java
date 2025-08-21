package sorting;


public class QuickSort<T extends Comparable<T>> {
    public void sort(T[] array, int leftIndex, int rightIndex){
        if(leftIndex < rightIndex){
            int indexPivot = partition(array, leftIndex, rightIndex);
            sort(array, leftIndex, indexPivot-1);
            sort(array, indexPivot+1, rightIndex);
        }
    }

    private int partition(T[] array, int leftIndex, int rightIndex) {

        T pivot = array[leftIndex];
        int i = leftIndex;

        for (int j = leftIndex + 1; j <= rightIndex; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i += 1;
                swap(array, i, j);
            }
        }

        swap(array, leftIndex, i);

        return i;
    
    }

    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    } 
}
