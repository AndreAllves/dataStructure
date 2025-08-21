package sorting;

public class ProvaLeda3<T extends Comparable<T>> {
    public T bitonicPoint(T[] array) {
        if(array == null || array.length == 0){
            return null;
        }
        return recursiveBitonicPoint(array, 0, array.length-1);
    }

    private T recursiveBitonicPoint(T[] array, int leftIndex, int rightIndex){
        if(leftIndex == rightIndex){
            return array[leftIndex];
        }

        if(leftIndex < rightIndex && array[leftIndex].compareTo(array[leftIndex+1]) > 0){
            return array[leftIndex];
        }

        return recursiveBitonicPoint(array, leftIndex+1, rightIndex);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,4, 20, 7,6,5,};
        ProvaLeda3<Integer> s = new ProvaLeda3<>();
        System.out.println(s.bitonicPoint(a));
    }
}
