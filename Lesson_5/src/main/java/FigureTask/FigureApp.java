package FigureTask;

public class FigureApp {
    public static void main(String[] args) {
        Circle circle = new Circle(4, "Зеленый", "Черный");
        Rectangle rectangle = new Rectangle(2, 8, "Красный", "Желтый");
        Triangle triangle = new Triangle(8, 9, 10, "Синий", "Оранжевый");

        circle.info();
        rectangle.info();
        triangle.info();
    }
}
