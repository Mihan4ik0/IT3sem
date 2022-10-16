import java.util.Scanner;

public class triArea {
    public static void main(String args[]){
        Integer base;
        Integer height;
        double n;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the base of the triangle: \n");
        base = in.nextInt();
        System.out.print("Please enter the height of the triangle: \n");
        height = in.nextInt();
        System.out.printf("The area of this triangle: %.2f", triArea(base, height));
        in.close();
    }
    public static double triArea(Integer base, Integer height){
        double n;

        area = base * height * 0.5;
        return area;
    }

}