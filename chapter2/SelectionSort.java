package chapter2;

public class SelectionSort {
    public static void main(String[] args) {
        int[] toSort = {1,4,3,2,6,4,9,20,31,3};

        printArray(toSort);
        selectionSort(toSort);
        printArray(toSort);
    }

    public static void selectionSort(int[] nums) {
        int i, j;
        int min;

        for(i = 0; i < nums.length; i++) {
            min = i;
            for(j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[min]) min = j;
            }

            swap(nums, i, min);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(int[] nums) {
        for(int i: nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}