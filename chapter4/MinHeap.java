package chapter4;

public class MinHeap {
    private int[] heap;
    private int currPos;

    public MinHeap(int maxSize) {
        heap = new int[maxSize + 1];
        currPos = 0;
    }

    public MinHeap(int[] arr) {
        heap = new int[arr.length + 1];
        currPos = 0;
        for(int i: arr) {
            insert(i);
        }
    }

    private int getParent(int pos) {
        if(pos == 1) return -1;
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    public void insert(int num) {
        if(currPos >= heap.length - 1)  return;

        heap[++currPos] = num;
        bubbleUp(currPos); 
    }

    public int getMin() {
        if(currPos == 0) return Integer.MIN_VALUE;
        
        int result = heap[1];
        heap[1] = heap[currPos];
        currPos--;
        bubbleDown(1);
        return result;
    }

    private void bubbleDown(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);

        int smallest = pos;
        if(left <= currPos && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if(right <= currPos && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if(smallest != pos) {
            swap(pos, smallest);
            bubbleDown(smallest);
        }
    }

    private void bubbleUp(int pos) {
        if(getParent(pos) == -1) return;

        if(heap[getParent(pos)] > heap[pos]) {
            swap(getParent(pos), pos);
            pos = getParent(pos);
            bubbleUp(pos);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}