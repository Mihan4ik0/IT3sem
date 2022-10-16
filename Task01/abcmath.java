import java.util.Scanner;

public class abcmath {
    public static void main(String args[]){
        Integer A;
        Integer B;
        Integer C;
        Integer n;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the first number: \n");
        A = in.nextInt();
        System.out.print("Please enter the second number: \n");
        B = in.nextInt();
        System.out.print("Please enter third number: \n");
        C = in.nextInt();
        System.out.printf("Total result:: %s", abcmath(A, B, C));
        in.close();
    }

    public static boolean abcmath(Integer A, Integer B, Integer C){
        for (int i = 0; i < B; i++) {
            A += A;
         }
        if (A % C == 0) {
                return true;
        } else return false;
    }
}