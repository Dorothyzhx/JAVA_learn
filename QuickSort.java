package algorithm.section1;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2) return;
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int L, int R){
        if (L < R){
            int fl = L - 1;
            int fr = R;
            int pivot = (int)(Math.random() * (R - L + 1) + L);
            change(arr, R, pivot);
            for (int i = L; i < fr; i++){
                if (arr[i] < arr[R]) change(arr, i, ++fl);
                else if (arr[i] == arr[R]) continue;
                else change(arr, i--, --fr);
            }
            change(arr, fr, R);  // 记得将用作比较的最后一个值与big区的第一个数交换
            sort(arr, L, fl);
            sort(arr, fr, R);
        }
    }

    public static void change(int[] arr, int a, int b){
        int f = arr[a];
        arr[a] = arr[b];
        arr[b] = f;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }
}
