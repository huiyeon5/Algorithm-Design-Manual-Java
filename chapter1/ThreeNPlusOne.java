package chapter1;

public class ThreeNPlusOne {
    public static void main(String[] args) {
        int low = 1;
        int high = 10;

        System.out.println(findMaxCycle(low, high));
    }

    public static int findMaxCycle(int low, int high) {
        if(high < low) return Integer.MIN_VALUE;

        return Math.max(cycle(high), findMaxCycle(low, high - 1));
    }

    public static int cycle(int num) {
        int count = 1;
        while(num != 1) {
            if(num % 2 == 0) {
                num = num / 2;
            } else {
                num = 3*num + 1;
            }
            count++;
        }

        return count;
    }
}