public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(3));
    }

    public static long getFactorial(long num) {
        if (num == 0 || num == 1) return 1;
        else if (num > 1) return num * getFactorial(num - 1);
        else throw new IllegalArgumentException("Число не может быть отрицательным");
    }
}
