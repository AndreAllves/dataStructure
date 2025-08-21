package sorting;

public class Revisao<T extends Comparable<T>> {

    public void quickSort(T[] array, int leftIndex, int rightIndex){
        if(leftIndex < rightIndex){
            int pivot = partition(array, leftIndex, rightIndex);
            quickSort(array, leftIndex, pivot-1);
            quickSort(array, pivot+1, rightIndex);
        }
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

    public T binarySearch(T[] array, T element){
        if(array.length == 0 || element == null){
            return null;
        }
        return recursiveBinarySearch(array, element, 0, array.length-1, null);
    }

    private T recursiveBinarySearch(T[] array, T element, int leftIndex, int rightIndex, T result){
        if(leftIndex > rightIndex){
            return result;
        }

        int middle = (leftIndex+rightIndex)/2;

        if(array[middle].compareTo(element) == 0){
            result = array[middle];
        }

        if(array[middle].compareTo(element) > 0){
            result = recursiveBinarySearch(array, element, leftIndex, middle-1, result);
        }
        else{
            result = recursiveBinarySearch(array, element, middle+1, rightIndex, result);
        }
        return result;
    }

    
}
