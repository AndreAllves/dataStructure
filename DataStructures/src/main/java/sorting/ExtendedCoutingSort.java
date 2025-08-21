package sorting;

public class ExtendedCoutingSort {
    public void coutingSort(Integer[] array, int leftIndex, int rightIndex) {
        if (array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex) {
             
            int maxValue = max(array, leftIndex, rightIndex); 
            int minValue = min(array, leftIndex, rightIndex);
    
            int range = maxValue - minValue + 1; 
            int[] counter = new int[range];
    
            for (int i = leftIndex; i <= rightIndex; i++) {
                counter[array[i] - minValue]++;
            }
    
            for (int j = 1; j < range; j++) {
                counter[j] += counter[j - 1];
            }
    
            int[] out = new int[rightIndex - leftIndex + 1];
            for (int k = rightIndex; k >= leftIndex; k--) {
                out[counter[array[k] - minValue] - 1] = array[k];
                counter[array[k] - minValue]--;
            }
    
            for (int q = 0; q < out.length; q++) {
                array[leftIndex + q] = out[q];
            }
        }
        }

    public int max(Integer[] array, int leftIndex, int rightIndex) {
        int max = array[leftIndex];
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int min(Integer[] array, int leftIndex, int rightIndex) {
        int min = array[leftIndex];
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
