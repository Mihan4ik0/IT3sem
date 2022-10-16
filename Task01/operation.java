import java.util.Scanner;

public class operation {
    public static void main(String args[]){
        Integer a;
        Integer b;
        Integer N;
        Integer n;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter first number: \n");
        N = in.nextInt();
        System.out.print("Please enter second number: \n");
        a = in.nextInt();
        System.out.print("Please enter third number: \n");
        b = in.nextInt();
        System.out.println(operation(a, b, N));
        in.close();
    }
    public static String operation(Integer a, Integer b, Integer N){
        String s;

        if ((a + b) == N) s = "Added";
        else if ((a - b) == N) s = "Substracted";
        else if (a/b == N) s = "divide";
        else s = "none";
        return s;
    }
}