import java.util.Scanner; // импорт библиотеки для взаимодействия с консолью

// Создание базового класса Palindrome
public class Palindrome {
    public static void main(String[] args){  // Объявление основного метода нашего класса
        for (int i=0; i<args.length; i++){
            String s = args[i];
        }
        String s;
        Scanner in = new Scanner(System.in); // объявление сканера
        System.out.print("Please enter string: \n");
        s = in.nextLine();
        System.out.printf("IsPalindrome: %b \n", isPalindrome(s));
        in.close(); // Выключение терминала
    }
    public static String reverseString(String s){ // Метод реверса строки
        String reverse = "";
        for (int i = 0; i < s.length(); i++){
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }
    public static boolean isPalindrome(String s){ // Метод проверки на Палиндром
        String s2 = reverseString(s).toLowerCase();
        return s.toLowerCase().equals(s2);
    }
}
