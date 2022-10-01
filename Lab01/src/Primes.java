/*Класс для нахождения простых чисел*/
public class Primes {
    /*Основная функция класса*/
    public static void main(String[] args) {
        isPrime(100);
    }
    /*Метод определения простых чисел*/
    public static boolean isPrime(int n) {
        for (int i=2; i < n; i++) {
            if (i == 2)
                System.out.println(i);
            if (i == 3)
                System.out.println(i);
            if (i%2 != 0 && i%3 != 0)
                System.out.println(i);
        }
        return false;
    }
}
