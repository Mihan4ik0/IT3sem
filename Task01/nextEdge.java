import java.util.Scanner;

public class nextEdge {
    public static void main(String args[]){
        Integer n1;
        Integer n2;
        Integer n;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter first number: \n");
        n1 = in.nextInt();
        System.out.print("Please enter second number: \n");
        n2 = in.nextInt();
        System.out.printf("The third number: %d", nextEdge(n1, n2));
        in.close();
    }
    public static Integer nextEdge(Integer n1, Integer n2){
        Integer n;

        n = n1 + n2 - 1;
        return n;
    }
}