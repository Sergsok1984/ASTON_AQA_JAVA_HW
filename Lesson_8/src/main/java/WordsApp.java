import java.util.*;

public class WordsApp {
    private static Map<String, Integer> getWordsWithCount() {
        List<String> words = new ArrayList<>(Arrays.asList("white", "blue", "red", "green", "yellow", "orange", "purple", "pink", "brown", "black", "grey", "white", "blue", "red"));

        Map<String, Integer> wordsWithCount = new HashMap<>();
        for (String word : words) {
            wordsWithCount.put(word, wordsWithCount.getOrDefault(word, 0) + 1);
        }
        return wordsWithCount;
    }

    public static void main(String[] args) {
        List<String> uniqueWords = new ArrayList<>(getWordsWithCount().keySet());
        System.out.println("Список всех слов с количеством повторений: " + getWordsWithCount());
        System.out.println("Список уникальных слов: " + uniqueWords);
    }
}
