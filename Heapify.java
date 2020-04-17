package algorithm.section1;

import java.util.Arrays;

public class Heapify {
    public static void heapify(int[] arr, int index, int heapSize){
        if (heapSize < 2) return;
        int L = 2 * index + 1;
        while (L < heapSize) {
            int large = arr[L] < arr[L + 1] && L + 1 < heapSize ? L + 1 : L;
            if (arr[large] > arr[index]) {
                swap(arr, index, large);
                index = large;
                L = 2 * index + 1;
            }
            else break;
        }
    }

    public static void swap(int[] arr, int a, int b){
        int f = arr[a];
        arr[a] = arr[b];
        arr[b] = f;
    }

    public static void main(String[] args){
        int[] arr = {0, 3, 5, 0, 2, 1, 4}; // 原{6, 3, 5, 0, 2, 1, 4}
        heapify(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }
}
