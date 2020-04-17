package algorithm.section1;

import java.util.Arrays;

public class HeapInsert1 {
    public static void heapInsert1(int[] arr){
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++)
            insert(arr, i);
    }

    public static void insert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1)/2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int a, int b){
        int f = arr[a];
        arr[a] = arr[b];
        arr[b] = f;
    }

    public static void main(String[] args){
        int[] arr =  {0, 1, 2, 3, 4, 5, 6};
        heapInsert1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
