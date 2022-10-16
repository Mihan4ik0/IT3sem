import java.util.Scanner;

public class ctoa {
    public static void main(String args[]){
        String n;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter symbol: \n");
        n = in.nextLine();
        System.out.printf("The ASCII of the symbol: %d", ctoa(n));
        in.close();
    }
    public static Integer ctoa(String n){
        Integer s;
        char c = n.charAt(0);

        s = (int) c;
        return s;
    }
}