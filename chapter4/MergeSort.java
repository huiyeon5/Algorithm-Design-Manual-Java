package chapter4;

public class MergeSort {
    public static void main(String[] args) {
        int[] numToSort = {9,8,7,6,5,4,3,2,1};
        int[] aux = new int[numToSort.length];
        for(int i : numToSort) {
            System.out.print(i + " ");
        }
        System.out.println();

        mergeSort(numToSort, aux, 0, numToSort.length - 1);

        for(int i : numToSort) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] nums, int[] aux, int low, int high) {
        int mid = (low + high) / 2; 
        if(low < high) {
            mergeSort(nums, aux, low, mid);
            mergeSort(nums, aux, mid + 1, high);
            merge(nums, aux, low, mid, high);
        }
    }

    public static void merge(int[] nums, int[] aux, int low, int mid, int high) {
        for(int i = low; i <= high; i++) {
            aux[i] = nums[i];
        }

        int i = low;
        int j = mid + 1; 
        int k = low;
        while(i <= mid && j <= high) {
            if(aux[i] > aux[j]) {
                nums[k++] = aux[j++];
            } else {
                nums[k++] = aux[i++];
            }
        }

        while(i <= mid) {
            nums[k++] = aux[i++];
        }
        while(j <= high) {
            nums[k++] = aux[j++];
        }
    }
}