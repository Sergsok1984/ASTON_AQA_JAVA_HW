import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));
        lst.addAll(lst.stream().sorted(Comparator.comparingInt(e -> Integer.parseInt(e.substring(1)))).collect(Collectors.toList()));
        System.out.println(lst);
    }
}
