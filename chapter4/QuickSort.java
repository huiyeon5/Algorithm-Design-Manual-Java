package chapter4;

public class QuickSort {
    public static void main(String[] args) {
        int[] numToSort = {9,6,1,4,3,5,2,8,7};
        for(int i : numToSort) {
            System.out.print(i + " ");
        }
        System.out.println();

        quickSort(numToSort, 0, numToSort.length - 1);

        for(int i : numToSort) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] nums, int low, int high) {
        int p;
        if(high - low > 0) {
            p = partition(nums, low, high);
            quickSort(nums, low, p - 1);
            quickSort(nums, p + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int p = high;

        int firstHigh = low;
        for(int i = low; i < high; i++) {
            if(nums[i] < nums[p]) {
                swap(nums, i, firstHigh);
                firstHigh++;
            }
        }
        swap(nums, firstHigh, p);
        return firstHigh;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}