package sorting;

public class MergeSort<T extends Comparable<T>> {
    public void  sort(T[] array, int start, int end){
        if(start < end){
            int middle = (start+end)/2;
            sort(array, start, middle);
            sort(array, middle+1, end);
            merge(array, start, end);
        }
    }

    private void merge(T[] array, int start, int end){
        int middle = (start + end)/2;
        T[] aux = (T[]) new Comparable[array.length];

        for(int i = start; i <= end; i++){
            aux[i] = array[i];
        }

        int i = start;
        int j = middle+1;
        int k = start;

        while(i <= middle && j <= end){
            if(aux[i].compareTo(array[j]) > 0)
                array[k++] = aux[j++];
            else
                array[k++] = aux[i++];

        }

        while(i <= middle){
            array[k++] = aux[i++];
        }

        while(j <= end){
            array[k++] = aux[j++];
        }
    }
}