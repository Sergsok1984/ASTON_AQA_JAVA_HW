import java.util.Arrays;

public class ArrayTask {
    public static void changeNumber() {
        int[] arr = new int[]{1, 0, 0, 1, 1, 0, 0, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void createArray() {
        int len = 5;
        int[][] arr = new int[len][len];
        for (int i = 0; i < len; i++) {
            arr[i][i] = 1;
            arr[i][len - 1 - i] = 1;
        }
        for (int[] num : arr) {
            System.out.println(Arrays.toString(num));
        }
    }

    public static int[] getArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void main(String[] args) {
        changeNumber();
        fillArray();
        changeArray();
        createArray();
        System.out.println(Arrays.toString(getArray(7, 5)));
    }
}

