public class FruitApp {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        System.out.println("Вес первой коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками: " + appleBox2.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес первой коробки с яблоками равен весу коробки с апельсинами?: " + appleBox1.compare(orangeBox));
        appleBox1.transfer(appleBox2);
        System.out.println("Вес первой коробки с яблоками после пересыпания во вторую коробку : " + appleBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками после пересыпания из первой коробки: " + appleBox2.getWeight());
    }
}
