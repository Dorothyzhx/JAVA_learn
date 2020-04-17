package algorithm.section1;

public class HeapReduction {
    public static int heapReduction(int[] arr, int heapSize){
        swap(arr, 0, heapSize-1);
        return heapSize - 1;
    }

    public static void swap(int[] arr, int a, int b){
        int f = arr[a];
        arr[a] = arr[b];
        arr[b] = f;
    }

    public static void heapify(int[] arr, int index, int heapSize){
        int L = 2 * index + 1;
        while (L < heapSize){
            int large = L + 1 < heapSize && arr[L + 1] > arr[L] ? L + 1 : L;
            if (arr[large] > arr[index]) {
                swap(arr, index, large);
                index = large;
                L = 2 * index + 1;
            }
            else break;
        }
    }

    public static void main(String[] args){
        int[] arr = {6, 5, 4, 3, 1};
        int heapSize = heapReduction(arr, arr.length);
        heapify(arr, 0, heapSize);
        for (int i = 0; i < heapSize; i++)
            System.out.print(arr[i] + " ");
    }
}
