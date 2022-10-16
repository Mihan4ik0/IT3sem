import java.util.Scanner;

public class sumOfCubes {
  public static void main(String args[]){
      String numbers;

      Scanner in = new Scanner(System.in);
      numbers = in.nextLine();
      String arraystring[] = numbers.split(",");
      Integer array[] = new Integer[arraystring.length];
      for (Integer i=0; i<arraystring.length; i++) {
          array[i] = Integer.parseInt(arraystring[i]);
      }
      System.out.printf("Sum of numbers cubes: %d \n", sumOfCubes(array));
  }
    public static int sumOfCubes(Integer[] array){
      int sum_cub = 0;
      for (int i = 0; i < array.length; i++){
          sum_cub += Math.pow(array[i], 3);
      }
        return sum_cub;
  }
}