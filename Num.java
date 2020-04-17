package algorithm.section1;

import java.util.Arrays;

public class Num {
    public static void num(int[] arr, int num){
        if (arr == null || arr.length < 2) return;
        int flag = -1;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > num) continue;
            change(arr, flag+1, i);
            flag++;
        }
    }

    public static void change(int[] arr, int flag, int i){
        int f = arr[flag];
        arr[flag] = arr[i];
        arr[i] = f;
    }

    public static void main(String[] args){
        int[] arr = {6, 4, 1, 6, 7, 9, 23, 41, 7, 64};
        int n = 3;
        num(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
