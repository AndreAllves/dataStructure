package sorting;

public class InsertionSortRecusivo<T extends Comparable<T>> {
    public void sort(T[] array, int leftIndex, int rightIndex){
        if(leftIndex < rightIndex){
            sort(array, leftIndex, rightIndex - 1);
            insertionSortRecursivo(array, rightIndex - 1);
        }    
    }
    
    private void insertionSortRecursivo(T[] array, int index){
        if(index >= 0 && array[index].compareTo(array[index + 1]) > 0){
            swap(array, index, index + 1);
            insertionSortRecursivo(array, index - 1);
        }  
    }


    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
