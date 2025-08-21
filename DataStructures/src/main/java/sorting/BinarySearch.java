package sorting;

public class BinarySearch<T extends Comparable<T>> {
    
    public T binarySearch(T[] array, T x) {
        return binarySearchRecursive(array, x, 0, array.length - 1, null);
    }

    private T binarySearchRecursive(T[] array, T x, int leftIndex, int rightIndex, T result) {
        if (leftIndex > rightIndex) {
            return result;
        }

        int middle = (leftIndex + rightIndex) / 2;

        if (array[middle].compareTo(x) == 0) {
            result = array[middle];
        }

        if (array[middle].compareTo(x) > 0) {
            result = binarySearchRecursive(array, x, leftIndex, middle - 1, result);
        }
        else{
            result = binarySearchRecursive(array, x, middle + 1, rightIndex, result);
        }
        return result;
    }
}

