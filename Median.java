package algorithm.section1;

public class Median {
    public static float median(int[] arr){
        if (arr == null) return -1;
        if (arr.length == 1) {
            return arr[0];
        }

        int[] bigHeap = new int[arr.length / 2 + 1];
        int[] smallHeap = new int[arr.length / 2 + 1];

        bigHeap[0] = arr[0];

        int numOfBigHeap = 1;
        int numOfSmallHeap = 0;

        for (int i = 1; i < arr.length; i++){
            if (arr[i] <= bigHeap[0]) {
                heapInsert(bigHeap, numOfBigHeap, arr[i], 0);
                numOfBigHeap++;
            }
            else {
                heapInsert(smallHeap, numOfSmallHeap, arr[i], 1);
                numOfSmallHeap++;
            }
            if (numOfBigHeap - numOfSmallHeap > 1) {
                heapInsert(smallHeap, numOfSmallHeap, bigHeap[0], 1);
                numOfSmallHeap++;
                swap(bigHeap, 0, numOfBigHeap - 1);
                numOfBigHeap--;
                heapIfy(bigHeap, 0, numOfBigHeap ,0);
            }
            else if (numOfSmallHeap - numOfBigHeap > 1) {
                heapInsert(bigHeap, numOfBigHeap, smallHeap[0], 0);
                numOfBigHeap++;
                swap(smallHeap, 0, numOfSmallHeap - 1);
                numOfSmallHeap--;
                heapIfy(smallHeap, 0, numOfSmallHeap, 1);
            }
        }
        if (numOfBigHeap > numOfSmallHeap) return bigHeap[0];
        else if (numOfBigHeap < numOfSmallHeap) return smallHeap[0];
        else return  ((float) bigHeap[0] + (float) smallHeap[0]) / 2;
    }

    public static void heapInsert(int[] heap, int index, int num, int flag){
        heap[index] = num;
        if (flag == 0){
            while (heap[(index - 1) / 2] < heap[index]){
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) /2;
            }
        }
        if (flag == 1){
            while (heap[(index - 1) / 2] > heap[index]){
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) /2;
            }
        }
    }

    public static void heapIfy(int[] heap, int index, int heapSize, int flag){
        int L = 2 * index + 1;
        while (L < heapSize){
            if (flag == 0){
                int large = L + 1 < heapSize && heap[L + 1] > heap[L] ? L + 1 : L;
                if (heap[large] > heap[index]) {
                    swap(heap, index, large);
                    index = large;
                    L = 2 * index + 1;
                }
                else break;
            }
            if (flag == 1){
                int small = L + 1 < heapSize && heap[L + 1] < heap[L] ? L + 1 : L;
                if (heap[small] < heap[index]){
                    swap(heap, index, small);
                    index = small;
                    L = 2 * index + 1;
                }
                else break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int f = arr[a];
        arr[a] = arr[b];
        arr[b] = f;
    }

    public static void main(String[] args){
        int[] arr = {6, 5, 4, 3, 2, 1};
        System.out.println("media is: " + median(arr));
    }
}
