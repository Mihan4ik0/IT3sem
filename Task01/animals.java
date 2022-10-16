import java.util.Scanner;

public class animals {
    public static void main(String args[]){
        Integer chickens;
        Integer cows;
        Integer pigs;
        Integer count;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter number of chickens: \n");
        chickens = in.nextInt();
        System.out.print("Please enter number of cows: \n");
        cows = in.nextInt();
        System.out.print("Please enter number of pigs: \n");
        pigs = in.nextInt();
        System.out.printf("Total animals on the farm:: %d", animals(chickens, cows, pigs));
        in.close();
    }
    public static Integer animals(Integer chickens, Integer cows, Integer pigs){
        Integer count;

        count = chickens + cows + pigs;
        return count;
    }
}