package AnimalTask;

public class Cat extends Animal {
    public static final int LIMIT_DISTANCE = 200;
    private static final int CAT_EAT_VALUE = 10;
    private static int count = 0;
    private String name;
    private boolean satiety;

    public Cat(String name) {
        super();
        this.name = name;
        count++;
        satiety = false;
    }

    public static int getCount() {
        return count;
    }

    public static void decreaseFood(int CAT_EAT_VALUE) {
        if (CAT_EAT_VALUE <= Bowl.getVolume()) {
            Bowl.setVolume(Bowl.getVolume() - CAT_EAT_VALUE);
        }
    }

    public static void increaseFood(int foodValue) {
        Bowl.setVolume(foodValue + Bowl.getVolume());
        System.out.printf("В миску положили %d еды.\n", foodValue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    @Override
    public void run(int distance) {
        if (distance <= LIMIT_DISTANCE && distance > 0) {
            System.out.printf("Кот %s пробежал %d м.", name, distance);
        } else if (distance <= 0) {
            System.out.printf("Для кота %s некорректно введена длина дистанции.", name);
        } else {
            System.out.printf("Кот %s может пробежать максимум %d м.", name, LIMIT_DISTANCE);
        }
        System.out.println();
    }

    @Override
    public void swim(int distance) {
        System.out.printf("Коты %s не умеет плавать.\n", name);
    }

    public void eat() {
        if (CAT_EAT_VALUE < Bowl.getVolume()) {
            decreaseFood(CAT_EAT_VALUE);
            setSatiety(!satiety);
            System.out.printf("Кот %s успешно поел, теперь он сытый, осталось еды " + Bowl.getVolume() + "\n", name);
        } else {
            System.out.println("Недостаточно еды, наполните миску");
            Cat.increaseFood(30);
        }
    }
}
