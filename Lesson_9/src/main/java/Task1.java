import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int size = 10;
        Random random = new Random();
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbersList.add(random.nextInt(1000));
        }
        System.out.println("Сгенерированные числа: " + numbersList + "\n" +
                "Из них четных чисел: " + (int) numbersList.stream().filter(i -> i % 2 == 0).count());
    }
}
