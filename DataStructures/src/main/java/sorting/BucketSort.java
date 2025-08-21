package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort<T extends Comparable<T>> {
    
    public void sort(List<T> list, int leftIndex, int rightIndex, int size){
        if(list != null && list.size() > 1 && leftIndex >= 0 && rightIndex < list.size() && leftIndex < rightIndex && size > 0){
            List<List<T>> bucketS = buckets(list, leftIndex, rightIndex, size);
            mergeBuckets(list, bucketS, leftIndex);
        }
    }

    public List<List<T>> buckets(List<T> list, int leftIndex, int rightIndex, int size){
        T min = list.get(leftIndex);
        T max = list.get(leftIndex);

        for(int i = 0; i <= rightIndex; i++){
            if(list.get(i).compareTo(min) < 0){
                min = list.get(i);
            }
            else if(list.get(i).compareTo(max) > 0){
                max = list.get(i);
            }
        }

        int range = (max.hashCode() - min.hashCode()) / size;

        List<List<T>> bucketS = new ArrayList<>();
        for(int j = 0; j < size; j++) {
            bucketS.add(new ArrayList<>());
        }

        for(int k = leftIndex; k <= rightIndex; k++){
            T thing = list.get(k);
            int indexBucket = (thing.hashCode() - min.hashCode()) / range;
            if(indexBucket >= size){
                indexBucket = size-1;
            }
            bucketS.get(indexBucket).add(thing);
        }
        return bucketS;
    }

    private void mergeBuckets(List<T> list, List<List<T>> buckets, int leftIndex){
        int i = leftIndex;

        for(List<T> bucket : buckets){
            Collections.sort(bucket);

            for(T thing : bucket){
                list.set(i++, thing);
            }
        }
    }
}
