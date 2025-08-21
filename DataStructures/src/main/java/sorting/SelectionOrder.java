package sorting;

public class SelectionOrder<T extends Comparable<T>> {

    public T selectionEstatisca(T[] array, int k){
        if(k < 1 || k > array.length || array == null){
            return null;
        }
        return selection(array, k, 0, array.length);
    }

    private T selection(T[] array, int k, int left, int right){
        int min = findMinIndex(array, left, right);
        for(int i = 1; i < k; i++){
            min = selectMinGreater(array, left, right, min);
        }
        T out = array[min];
        return out;
    }


    private int findMinIndex(T[] array, int left, int right){
        int iMin = left;
        for(int i = left + 1; i < right; i++){
            if(array[i].compareTo(array[iMin]) < 0){
                iMin = i;
            }
        }
        return iMin;
    }

    private  int selectMinGreater(T[] array, int left, int right, int previuos){
        int iMin = left;
        int candidate = left;
        for(int i = left + 1; i < right; i++){
            if(array[i].compareTo(array[previuos]) > 0){
                candidate = i;
            }
            if(array[candidate].compareTo(array[iMin]) < 0){
                iMin = candidate;
            }
        }
        return iMin;

    }

    
    public static void main(String[] args) {
        Integer[] a = new Integer[]{9,6,8,4,2,1};
        SelectionOrder<Integer> sorter = new SelectionOrder<>();
        for(int i = 1; i < a.length; i++){
            System.out.println("k-esima = " + sorter.selectionEstatisca(a, i));
        }
    }
}