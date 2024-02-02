import java.util.*;

public class PhoneBookApp {
    private static final Map<String, String> phoneBook = new HashMap<>();

    public static void get(String surname) {
        List<String> result = new ArrayList<>();
        for (Map.Entry contact : phoneBook.entrySet()) {
            if (surname.equalsIgnoreCase((String) contact.getValue())) {
                result.add((String) contact.getKey());
            }
        }
        if (result.isEmpty()) {
            result.add("В списке контактов нет человека с фамилией " + surname);
        }
        System.out.println(surname + ": " + Arrays.toString(result.toArray()).replaceAll("^\\[|]$", ""));
    }

    public void add(String number, String surname) {
        phoneBook.put(number, surname);
    }

    public static void main(String[] args) {
        PhoneBookApp phoneBook = new PhoneBookApp();
        phoneBook.add("1111111111", "Соколов");
        phoneBook.add("2222222222", "Скачков");
        phoneBook.add("3333333333", "Федоров");
        phoneBook.add("4444444444", "Чижиков");
        phoneBook.add("5555555555", "Соколов");

        get("Соколов");
        get("Скачков");
        get("Федоров");
        get("Чижиков");
        get("Кошкин");
    }
}
