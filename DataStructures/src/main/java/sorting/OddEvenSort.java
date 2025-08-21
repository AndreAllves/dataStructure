package sorting;

public class OddEvenSort<T extends Comparable<T>> {

    public  void sort(T[] array){
        int n = array.length;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for(int i = 1; i < n - 1; i += 2){
                if(array[i].compareTo(array[i + 1]) > 0){
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }

            for(int j = 0; j < n - 1; j += 2){
               if (array[j].compareTo(array[j + 1]) > 0){
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
        }
    }

    private  void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    } 
}