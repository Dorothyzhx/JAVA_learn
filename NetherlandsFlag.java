package algorithm.section1;

public class NetherlandsFlag {
    public static void netherlandsFlag(int[] arr, int num){
        if (arr == null || arr.length < 2) return;
        int fl = -1;
        int fr = arr.length;
        for (int i = 0; i < fr; i++ ){
            if (arr[i] < num) change(arr, ++fl, i);
            else if (arr[i] == num) continue;
            else change(arr, --fr, i--);
        }
    }

    public static void change(int[] arr, int a, int b){
        int f = arr[a];
        arr[a] = arr[b];
        arr[b] = f;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
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

    public static void main(String[] args) {
        int[] test = generateArray();
        printArray(test);
        int num = (int) (Math.random() * 10);
        System.out.println("num: " + num);
        netherlandsFlag(test, num);
        printArray(test);
    }
}
