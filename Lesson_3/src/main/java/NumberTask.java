public class NumberTask {
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        if ((sum >= 10) && (sum <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkNum(int num) {
        if (num >= 0) {
            System.out.println(num + " - число положительное");
        } else {
            System.out.println(num + " - число отрицательное");
        }
    }

    public static boolean checkNumBool(int num) {
        if (num < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printStr(String str, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        System.out.println(checkSum(3, 3));
        checkNum(-7);
        System.out.println(checkNumBool(-7));
        printStr("Hello world", 5);
    }
}
