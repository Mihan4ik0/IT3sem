public class Point2d {

    private double xCoord;
    private double yCoord;

    // Инициализация
    public Point2d(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    // Конструктор по умолчанию
    public Point2d() {
        this(0, 0);
    }

    // Возрвращение координаты X
    public double getX() {
        return xCoord;
    }

    // Возрвращение координаты Y
    public double getY() {
        return yCoord;
    }

    // Установка значения координаты X
    public void setX(double val) {
        xCoord = val;
    }

    // Установка значения координаты Y
    public void setY(double val) {
        yCoord = val;
    }
}