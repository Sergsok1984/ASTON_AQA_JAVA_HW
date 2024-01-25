package AnimalTask;

public class AnimalApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Martin");
        Cat cat2 = new Cat("Tom");
        Cat cat3 = new Cat("Pushok");
        Cat cat4 = new Cat("Boris");
        Cat cat5 = new Cat("Vasya");
        Cat[] cats = new Cat[]{cat1, cat2, cat3, cat4, cat5};
        cat1.run(17);
        cat3.run(0);
        cat4.swim(15);
        for (Cat c : cats) {
            while (!c.getSatiety()) {
                System.out.printf("Кот %s голодный\n", c.getName());
                c.eat();
            }
        }

        Dog dog1 = new Dog("Archi");
        Dog dog2 = new Dog("Black");
        dog1.run(170);
        dog2.run(501);
        dog1.swim(10);
        dog2.swim(15);

        System.out.printf("Cоздано животных - %d, из них: Котов - %d, Собак - %d\n", Animal.getCount(), Cat.getCount(), Dog.getCount());
    }
}
