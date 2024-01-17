public class YearTask {
    public static boolean leapYear(int year) {
        if ((year % 4 != 0) || ((year % 100 == 0) && (year % 400 != 0))) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(leapYear(2400));
    }
}
