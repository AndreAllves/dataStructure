package sorting;

public class CoutingSort {
    public void coutingSort(Integer[] array, int leftIndex, int rightIndex){
        if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){

            int maxValue = max(array, leftIndex, rightIndex);
    
            int[] counter = new int[maxValue+1];
    
            for (int i = leftIndex; i <= rightIndex; i++){
                counter[array[i]]++;
            }
    
            for(int j = 1; j <= maxValue; j++){
                counter[j] += counter[j-1];
            }
    
            int[] out = new int[rightIndex - leftIndex + 1];
            for(int k = rightIndex; k >= leftIndex; k--){
                out[counter[array[k]]-1] = array[k];
                counter[array[k]]--;
            }
    
            for(int q = 0; q < out.length; q++){
                array[leftIndex+q] = out[q];
            }
        }
    }


    public int max(Integer[] array, int leftIndex, int rightIndex){
        int max = array[leftIndex];
        for(int i = leftIndex; i <= rightIndex; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
}
