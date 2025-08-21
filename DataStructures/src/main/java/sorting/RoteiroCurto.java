package sorting;

import java.util.Arrays;

public class RoteiroCurto<T extends Comparable<T>> {
    
    public void selectionSort(T[] array, int l, int r){
        for(int i = l; i <= r - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j <= r; j++) {
                if ((array[j]).compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public void recursiveSelectionSort(T[] array, int l, int r){
        if(l < r){
            int iMin = l;
            if(l - 1 <= r){
                if(array[l+1].compareTo(array[iMin]) < 0){
                    iMin = l + 1;
                }
                swap(array, iMin, l);
                recursiveSelectionSort(array, l+1, r);
            }
            recursiveSelectionSort(array, l, r-1);
        }
    }

    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{9,8,0,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(a));
        System.out.println("Após a ordenção:");
        RoteiroCurto sort = new RoteiroCurto<>();
        sort.recursiveSelectionSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
