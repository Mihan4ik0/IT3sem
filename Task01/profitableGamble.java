import java.util.Scanner;

public class profitableGamble {
    public static void main(String args[]){
        double prob;
        double prize;
        double pay;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter prob: \n");
        prob = in.nextDouble();
        System.out.print("Please enter prize: \n");
        prize = in.nextDouble();
        System.out.print("Please enter pay: \n");
        pay = in.nextDouble();
        System.out.printf("Total result:: %s", profitableGamble(prob, prize, pay));
        in.close();
    }
    public static boolean profitableGamble(double prob, double prize, double pay){
        boolean n;

        n = prob * prize > pay;
        return n;
    }
}