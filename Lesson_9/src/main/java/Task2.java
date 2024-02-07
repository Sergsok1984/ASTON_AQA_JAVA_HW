import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task2 {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload"));
        System.out.println("Объект «High» встречается в коллекции: " + lst.stream().filter(e -> e.equals("High")).count() + " раз");
        System.out.println("На первом месте находится элемент: " + (lst.stream().findFirst().orElse("0")));
        System.out.println("На последнем месте находится элемент: " + (Optional.of(lst).flatMap(e -> e.stream().reduce((a, b) -> b)).orElse("0")));
    }
}
