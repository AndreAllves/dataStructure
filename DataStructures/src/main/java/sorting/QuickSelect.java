package sorting;

import java.util.Arrays;

public class QuickSelect<T extends Comparable<T>> {
    public T quickSelect(T[] array, int k){
        if(array != null && array.length > 0 && k >= 0 && k <= array.length) {
            return quickSelectRecursivo(array, k, 0, array.length-1);
        }
        return null;

    }
 
    public T quickSelectRecursivo(T[] array, int k, int leftIndex, int rightIndex){
        if(leftIndex <= rightIndex){
            int pivotIndex = partition(array, leftIndex, rightIndex);
            if(k < pivotIndex + 1){
                return quickSelectRecursivo(array, k, leftIndex, pivotIndex-1);
            }
            else if(k > pivotIndex + 1){
                return quickSelectRecursivo(array, k, pivotIndex+1, rightIndex);
            }
            return array[pivotIndex];
        }
        return null;
    }

    private int partition(T[] array, int leftIndex, int rightIndex){
        T pivot = array[rightIndex];
        int i = leftIndex - 1;
        
        for(int j = leftIndex; j < rightIndex; j++){
            if(array[j].compareTo(pivot) > 0){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, rightIndex);
        return i+1;
    }

    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    } 

    public static void main(String[] args) {
       QuickSelect <Integer> quickSelect = new QuickSelect<>();
        Integer[] array = new Integer[]{8, 3, 7, 6, 5, 4, 2, 1};
        int k = 3;
        System.out.println("Array original: " + Arrays.toString(array));
        System.out.println("K-esima = " + quickSelect.quickSelect(array, k));
        System.out.println(Arrays.toString(array));

    }   
}