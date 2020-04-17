package algorithm.section1;

import java.util.Arrays;

public class HeapInsert2 {
    public static void heapInsert(int[] arr){
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++)
            insert(arr, i);
    }

    public static void insert(int[] arr, int index){
        while (arr[index] < arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int a, int b){
        int f = arr[a];
        arr[a] = arr[b];
        arr[b] = f;
    }

    public static void main(String[] args){
        int[] arr = {3, 2, 1, 4, 6, 5};
        heapInsert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
