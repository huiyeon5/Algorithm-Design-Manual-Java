package chapter4;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,6,3,9,8,7,10};

        printArr(arr);

        MinHeap heap = new MinHeap(arr);

        for(int i = 0; i < arr.length; i++) {
            arr[i] = heap.getMin();
        }

        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}