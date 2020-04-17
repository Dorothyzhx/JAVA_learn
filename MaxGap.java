package algorithm.section2;

import java.util.Arrays;

public class MaxGap {
    public static int maxGap(int[] arr){
        if (arr == null || arr.length < 2) return 0;

        int[] maxs = new int[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        boolean[] hasNum = new boolean[arr.length + 1];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        if (max == min) return 0;

//        double gap = (double) ((max - min) / arr.length);

        for (int i = 0; i < arr.length; i++){
            int index = (int) ((arr[i] - min) * arr.length / (max - min));
            maxs[index] = hasNum[index] ? Math.max(maxs[index], arr[i]) : arr[i];
            mins[index] = hasNum[index] ? Math.min(mins[index], arr[i]) : arr[i];
            hasNum[index] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= arr.length; i++){
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
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
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
