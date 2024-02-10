import java.util.ArrayList;

public class Box<T extends Fruit> {
    final ArrayList<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if (fruits.isEmpty()) return 0;
        return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transfer(Box<T> box) {
        if (this == box) {
            throw new RuntimeException("Нельзя пересыпать в ту же коробку");
        } else if (fruits.isEmpty()) {
            throw new RuntimeException("Нельзя пересыпать из пустой коробки");
        } else box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
