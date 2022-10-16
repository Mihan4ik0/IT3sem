import java.util.Scanner;

public class addUpTo {
    public static void main(String args[]){
        Integer n1;
        Integer n;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter number: \n");
        n1 = in.nextInt();
        System.out.printf("The sum a series of numbers: %d", addUpTo(n1));
        in.close();
    }
    public static Integer addUpTo(Integer n1){
        Integer n = 0;

        for (int i = 0; i <= n1; i++){
            n += i;
        }
        return n;
    }
}