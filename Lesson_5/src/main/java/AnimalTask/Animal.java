package AnimalTask;

public class Animal {
    private static int count;
    public String name;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
    }

    public void swim(int distance) {
    }
}
