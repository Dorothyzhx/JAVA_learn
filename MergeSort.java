package algorithm.section1;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort1(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergerSort2(arr, 0, arr.length - 1);
    }

    public static void mergerSort2(int[] arr, int L, int R){
        if (L == R) return;
        int mid = (L + R) / 2;
        mergerSort2(arr, L, mid);
        mergerSort2(arr, mid + 1, R);
        merge(arr, L, R, mid);
    }

    public static void merge(int[] arr, int L, int R, int mid){
        int[] flag = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R){
            flag[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            flag[i++] = arr[p1++];
        }
        while (p2 <= R){
            flag[i++] = arr[p2++];
        }
        for (int j = 0; j < flag.length; j++){
            arr[L + j] = flag[j];
        }
    }

    /* test */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /* test */
    public static int[] copyArray(int[] arr){
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            array[i] = arr[i];
        }
        return array;
    }

    /* test */
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    /* test */
    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) return false;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    /* test */
    public static void printArray(int[] arr){
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /* test */
    public static void main(String[] args){
        int maxSize = 100;
        int maxValue = 100;
        int testTime = 500000;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            mergeSort1(arr1);
            comparator(arr2);

            if (!isEqual(arr1, arr2)){
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "succeed!" : "False");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort1(arr);
        printArray(arr);
    }
}
