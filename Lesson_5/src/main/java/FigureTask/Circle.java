package FigureTask;

class Circle implements FigureInt {
    private final double radius;
    private final String fillColor;
    private final String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void info() {
        System.out.println("Круг: Периметр - " + getPerimeter() + ", Площадь - " + getArea() +
                ", Цвет фона - " + getFillColor() + ", Цвет границы - " + getBorderColor());
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
