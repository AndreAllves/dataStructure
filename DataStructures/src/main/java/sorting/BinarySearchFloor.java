package sorting;

public class BinarySearchFloor <T extends Comparable<T>> {
    
    public int binarySearchFloor(T[] array, T x){
        return binarysearchFloorRecusive(array, x, 0, array.length-1, -1);
    }

    private int binarysearchFloorRecusive(T[] array, T x, int leftIndex, int rightIndex, int floorIndex) {
        int mid = leftIndex + (rightIndex  - leftIndex) / 2; 

        if(leftIndex > rightIndex) {
            return floorIndex;
        }
        
        if (array[mid].compareTo(x) == 0) {
            return mid;
        }

        int out = 0;
        if (array[mid].compareTo(x) < 0) {
            floorIndex = mid;
            out = binarysearchFloorRecusive(array, x, mid+1, rightIndex, floorIndex);
            
        } else {
            out = binarysearchFloorRecusive(array, x, leftIndex, mid-1, floorIndex);
        }

        return out;
    }
}