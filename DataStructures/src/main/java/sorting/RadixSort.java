package sorting;

public class RadixSort {

    public void sort(Integer[] array, int leftIndex, int rightIndex){
        if(array != null && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex){
            int maxValue = max(array, leftIndex, rightIndex);
            for(int exp = 1; maxValue / exp > 0; exp *=10){
                coutingSortToRadix(array, leftIndex, rightIndex, exp);
            }
        }
    }

    private int max(Integer[] array, int leftIndex, int rightIndex){
        int max = array[leftIndex];
        for(int i = leftIndex+1; i <= rightIndex; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    private void coutingSortToRadix(Integer[] array, int leftIndex, int rightIndex, int exp){
        int[] counter = new int[10];
        
        for(int i = leftIndex; i <= rightIndex; i++){
            int dig = (array[i]/exp) % 10;
            counter[dig]++;
        }
        
        for(int j = 1; j < counter.length; j++){
            counter[j] += counter[j-1];
        }
        
        Integer[] out = new Integer[rightIndex - leftIndex + 1];
        for(int k = rightIndex; k >= leftIndex; k--){
            int dig = (array[k]/exp) % 10;
            out[counter[dig]-1] = array[k];
            counter[dig]--;
        }
        
        for(int q = 0; q < out.length; q++){
            array[leftIndex+q] = out[q];
        }
    }
}
