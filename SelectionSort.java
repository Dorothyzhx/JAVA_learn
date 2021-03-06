package algorithm.section1;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min])  min = j;
            }

            change(arr, i, min);
        }
    }

    public static void change(int[] arr, int f1, int f2){
        int flag;
        flag = arr[f1];
        arr[f1] = arr[f2];
        arr[f2] = flag;
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

            selectionSort(arr1);
            comparator(arr2);

            if (!isEqual(arr1, arr2)){
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "succeed!" : "False");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
