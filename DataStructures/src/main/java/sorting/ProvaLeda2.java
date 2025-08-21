package sorting;

import java.util.Arrays;

public class ProvaLeda2<T extends Comparable<T>> {

    public T quickSelect(T[] array, int k){
        if(array == null || array.length == 0 || k < 0 || k > array.length){
            return null;
        }
        return recursiveQuickSelect(array, k, 0, array.length-1);
    }

    private T recursiveQuickSelect(T[] array, int k, int leftIndex, int rightIndex){
        if(leftIndex <= rightIndex){

            int indexPivot = partition(array, leftIndex, rightIndex);

            if(k - 1 == indexPivot){
                return array[indexPivot];
            }

            if(k - 1 < indexPivot){
                return recursiveQuickSelect(array, k, leftIndex, indexPivot-1);
            }
            else{
                return recursiveQuickSelect(array, k, indexPivot+1, rightIndex);
            }
        }
        return null;
    }

    private int partition(T[] array, int leftIndex, int rightIndex){
        T pivot = array[rightIndex];
        int i = leftIndex - 1;

        for(int j = leftIndex; j < rightIndex; j++){
            if(array[j].compareTo(pivot) < 0){
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
        Integer[] array = new Integer[]{8, 3, 7, 6, 5, 4, 2};
        ProvaLeda2<Integer> quickSelect = new ProvaLeda2<>();
        int k = 5;
        System.out.println("K-esima = " + quickSelect.quickSelect(array, k));

    }  
}
