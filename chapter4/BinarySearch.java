package chapter4;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,12,13,14,15};
        int toSearch = 15;
        int position = binSearch(nums, toSearch, 0, nums.length);
        System.out.println(position);
    }

    public static int binSearch(int[] nums, int toSearch, int low, int high) {
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if(nums[mid] == toSearch) return mid;
        if(toSearch > nums[mid]) return binSearch(nums, toSearch, mid + 1, high);
        else return binSearch(nums, toSearch, low, mid);
    }
}