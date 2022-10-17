import java.util.Scanner;

public class remainder {
  public static void main(String args[]){
      Integer number1;
      Integer number2;
      Integer result;

      Scanner in = new Scanner(System.in);
      System.out.print("Please enter first number: \n");
      number1 = in.nextInt();
      System.out.print("Please enter second number: \n");
      number2 = in.nextInt();
      System.out.printf("The remainder of the division of the first number by the second: %d", remainder(number1, number2));
      in.close();
  }
    public static Integer remainder(Integer number1, Integer number2){
      Integer result;

      result = number1 % number2;
      return result;
  }
}