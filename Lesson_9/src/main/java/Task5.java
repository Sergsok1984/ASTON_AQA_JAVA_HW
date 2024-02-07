import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Введите логин: ");
        Scanner scanner = new Scanner(System.in);
        String login;
        List<String> loginList = new ArrayList<>();
        while (!(login = scanner.nextLine().trim()).isEmpty()) {
            loginList.add(login);
        }
        System.out.println("Логины, начинающиеся на букву f: ");
        loginList.stream().filter(l -> l.startsWith("f")).collect(Collectors.toList()).forEach(System.out::println);
    }
}
