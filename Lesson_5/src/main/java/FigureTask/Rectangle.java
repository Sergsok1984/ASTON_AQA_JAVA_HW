package FigureTask;

class Rectangle implements FigureInt {
    private final double width;
    private final double height;
    private final String fillColor;
    private final String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void info() {
        System.out.println("Прямоугольник: Периметр - " + getPerimeter() + ", Площадь - " + getArea() + ", Цвет фона - " + getFillColor() + ", Цвет границы - " + getBorderColor());
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
