package chapter1;

public class InsertionSort {
    public static void main(String args[]) {
        Integer[] items = {5,4,3,6,7,1,2};

        printArr(items);
        insertionSortFlexible(items, items.length);
        printArr(items);
    }

    public static void printArr(Comparable[] items) {
        for(Comparable i : items) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Flexible
    public static void insertionSortFlexible(Comparable[] items, int n) {
        int i = 0;
        int j = 0;

        for(i = 1; i < n; i++) {
            j = i;
            while((j > 0) && (items[j].compareTo(items[j - 1]) < 0)) {
                swap(items, j, j - 1);
                j--;
            }
        }
    }

    public static void swap(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}