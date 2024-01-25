package AnimalTask;

public class Dog extends Animal {
    public static final int LIMIT_RUN = 500;
    public static final int LIMIT_SWIM = 10;
    private static int count = 0;

    public Dog(String name) {
        super();
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int distance) {
        if (distance <= LIMIT_RUN && distance > 0) {
            System.out.printf("Собака %s пробежала %d м.", name, distance);
        } else if (distance <= 0) {
            System.out.printf("Для собаки %s некорректно введена длина дистанции.", name);
        } else {
            System.out.printf("Собака %s может пробежать максимум %d м.", name, LIMIT_RUN);
        }
        System.out.println();
    }

    @Override
    public void swim(int distance) {
        if (distance <= LIMIT_SWIM && distance > 0) {
            System.out.printf("Собака %s проплыла %d м.", name, distance);
        } else if (distance <= 0) {
            System.out.printf("Для собаки %s некорректно введена длина дистанции.", name);
        } else {
            System.out.printf("Собака %s может проплыть максимум %d м.", name, LIMIT_SWIM);
        }
        System.out.println();
    }
}