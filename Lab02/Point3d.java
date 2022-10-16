public class Point3d extends Point2d{

    // Координата Z
    private double zCoord;

    // Конструктор инициализации
    public Point3d(double x, double y, double z) {
        super(x,y);
        zCoord = z;
    }

    // Конструктор по умолчанию
    public Point3d() {
        this(0, 0, 0);
    }

    // Возрвращение координаты Z
    public double getZ() {
        return zCoord;
    }

    // Установка значения координат Z
    public void setZ(double val) {
        zCoord = val;
    }


    //Метод isEquals проверяет координаты на совпадение
    public static boolean isEquals(Point3d obj1, Point3d obj2) {
        if ((obj1.getX() == obj2.getX()) && (obj1.getY() == obj2.getY()) && ((obj1.zCoord == obj2.zCoord))) {
           return true;
        }
        return false;
    }
    
    // Метод distanceTo ищет расстояние между точками
    public static double distanceTo(Point3d obj1, Point3d obj2){
        return  Math.pow(Math.pow(obj2.getX() - obj1.getX(), 2) + Math.pow(obj2.getY() - obj1.getY(), 2)
                + Math.pow(obj2.zCoord - obj1.zCoord, 2),0.5);
    }
}

