import java.util.Arrays;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        System.out.println("----------First----------");
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));

        System.out.println("----------Second----------");
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));


        System.out.println("----------Third----------");
        System.out.println(isAvgWhole(new int[]{1,3}));
        System.out.println(isAvgWhole(new int[]{1,2,3,4}));
        System.out.println(isAvgWhole(new int[]{1,5,6}));

        System.out.println("----------Fourth----------");
        System.out.println(cumulativeSum(new int[]{1,2,3}));
        System.out.println(cumulativeSum(new int[]{1,-2,3}));
        System.out.println(cumulativeSum(new int[]{3,3,-2,408,3,3}));

        System.out.println("----------Fifth----------");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));

        System.out.println("----------Sixth----------");
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(12));

        System.out.println("----------Seventh----------");
        System.out.println(isValid("59001"));
        System.out.println(isValid("9393939"));
        System.out.println(isValid("590 01"));
        System.out.println(isValid("590a01"));

        System.out.println("----------Eighth----------");
        System.out.println(isStrangePair("ratio","orator"));
        System.out.println(isStrangePair("bush","hubris"));
        System.out.println(isStrangePair("",""));

        System.out.println("----------Nine----------");
        System.out.println(isPrefix("automation","auto-"));
        System.out.println(isSuffix("arachnophobia","-phobia"));
        System.out.println(isPrefix("retrospect","sub-"));
        System.out.println(isSuffix("vocation","-logy"));

        System.out.println("----------Tenth----------");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
        System.out.println(boxSeq(6));
        System.out.println(boxSeq(7));



    }

    /*
    1. Создайте функцию, которая повторяет каждый символ в строке n раз.
    Пример:
    repeat("mice", 5) ➞ "mmmmmiiiiiccccceeeee"
    repeat("hello", 3) ➞ "hhheeellllllooo"
    repeat("stop", 1) ➞ "stop"
    */

    public static String repeat(String string, int repeats){
        String newstring = "";
        for (int i = 0; i < string.length(); i++){
            int k = repeats;
            while (k != 0) {
                newstring += string.charAt(i);
                k -= 1;
            }
        }
        return newstring;
    }

    /*
    2. Создайте функцию, которая принимает массив и возвращает разницу между
    самыми большими и самыми маленькими числами.
    Пример:
    differenceMaxMin([10, 4, 1, 4, -10, -50, 32, 21]) ➞ 82
    */

    public static int differenceMaxMin(int[] int_list){
        int min_n = int_list[0];
        int max_n = int_list[0];
        for(int num: int_list){
            if(num < min_n){
                min_n = num;
            }
            if(num > max_n){
                max_n = num;
            }
        }
        return max_n - min_n;
    }

    /*3. Создайте функцию, которая принимает массив в качестве аргумента и возвращает
    true или false в зависимости от того, является ли среднее значение всех элементов
    массива целым числом или нет.
    Пример:
    isAvgWhole([1, 3]) ➞ true
    isAvgWhole([1, 2, 3, 4]) ➞ false
    isAvgWhole([1, 5, 6]) ➞ true
    */
    public static boolean isAvgWhole(int[] ints){
        int n = ints.length;
        double sum_num = 0;
        for(int num: ints){
            sum_num += num;
        }
        if(sum_num%n == 0){
            return true;
        }
        return false;
    }

    /*
    4. Создайте метод, который берет массив целых чисел и возвращает массив, в
    котором каждое целое число является суммой самого себя + всех предыдущих
    чисел в массиве.
    Пример:
    cumulativeSum([1, 2, 3]) ➞ [1, 3, 6]
    cumulativeSum([1, -2, 3]) ➞ [1, -1, 2]
    cumulativeSum([3, 3, -2, 408, 3, 3]) ➞ [3, 6, 4, 412, 415, 418]
    */
    public static String cumulativeSum(int[] ints){
        int orig_num = 0;
        for (int i = 0; i < ints.length; i++){
            if (i > 0){
                orig_num = ints[i-1];
            }
            ints[i] = ints[i] + orig_num;

        }
        return Arrays.toString(ints);
    }

    /*
    5. Создайте функцию, которая возвращает число десятичных знаков, которое имеет
    число (заданное в виде строки). Любые нули после десятичной точки
    отсчитываются в сторону количества десятичных знаков.
    Пример:
    getDecimalPlaces("43.20") ➞ 2
    getDecimalPlaces("400") ➞ 0
    getDecimalPlaces("3.1") ➞ 1
    */

    public static Integer getDecimalPlaces(String string){
        String number = string;
        String fin = "";
        for (int val = number.indexOf('.') + 1; val < number.length(); val++){
            fin += number.charAt(val);
        }
        Integer chislo = fin.length() + 1;
        return chislo;

    }

    /*
    Создайте функцию, которая при заданном числе возвращает соответствующее
    число Фибоначчи.
    Пример:
    Fibonacci(3) ➞ 3
    Fibonacci(7) ➞ 21
    Fibonacci(12) ➞ 233
    */
    public static int fibonacci(int num){
        int num_1 = 0;
        int num_2 = 1;
        int sum_num = 0;
        for(int i = 0; i < num; i++){
            sum_num = num_1 + num_2;
            num_1 = num_2;
            num_2 = sum_num;
        }
        return sum_num;
    }

    /*
    7. Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку,
    напишите функцию, чтобы определить, является ли вход действительным
    почтовым индексом. Действительный почтовый индекс выглядит следующим
    образом:
    – Должно содержать только цифры (не допускается использование нецифровых цифр).
    – Не должно содержать никаких пробелов.
    – Длина не должна превышать 5 цифр.
    Пример:
    isValid("59001") ➞ true
    isValid("853a7") ➞ false
    isValid("732 32") ➞ false
    isValid("393939") ➞ false
    */

    public static boolean isValid(String string){
        if (string.length() > 5) return false;
        for(int i = 0; i < string.length(); i++){
            char letter = string.charAt(i);
            if(!Character.isDigit(letter)){
                return false;
            }
        }
        return true;
    }

    /*
    8. Пара строк образует странную пару, если оба из следующих условий истинны:
    – Первая буква 1-й строки = последняя буква 2-й строки.
    – Последняя буква 1-й строки = первая буква 2-й строки.
    – Создайте функцию, которая возвращает true, если пара строк представляет собой
    странную пару, и false в противном случае.
    Пример:
    isStrangePair("ratio", "orator") ➞ true
    // "ratio" ends with "o" and "orator" starts with "o".
    // "ratio" starts with "r" and "orator" ends with "r".
    isStrangePair("sparkling", "groups") ➞ true
    isStrangePair("bush", "hubris") ➞ false
    isStrangePair("", "") ➞ true
    */

    public static boolean isStrangePair(String a, String b){
        if(a == "" && b == "") return true;
        if((a.charAt(a.length()-1) == b.charAt(0)) && (a.charAt(0) == b.charAt(b.length()-1))){
            return true;
        }
        return false;
    }

    /*
    9. Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
    – isPrefix должен возвращать true, если он начинается с префиксного аргумента.
    – isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
    – В противном случае верните false.
    Пример:
    isPrefix("automation", "auto-") ➞ true
    isSuffix("arachnophobia", "-phobia") ➞ true
    isPrefix("retrospect", "sub-") ➞ false
    isSuffix("vocation", "-logy") ➞ false
    Примечание:
    Аргументы префикса и суффикса имеют тире - в них.
    */

    public static boolean isPrefix (String word, String prefix){
        for(int i = 0; i < prefix.length()-1;i++){
            if(word.charAt(i) != prefix.charAt(i)) return false;
        }
        return true;
    }

    public static boolean isSuffix (String word, String suffix){
        for(int i = 1; i < suffix.length();i++){
            int dif = i + (word.length()-suffix.length());
            if(word.charAt(dif) != suffix.charAt(i)) return false;
        }
        return true;
    }

    /*
    10. Создайте функцию, которая принимает число (шаг) в качестве аргумента и
    возвращает количество полей на этом шаге последовательности.
    Пример:
    boxSeq(0) ➞ 0
    boxSeq(1) ➞ 3
    boxSeq(2) ➞ 2
    */

    public static int boxSeq(int step){
        if (step == 0){
            return 0;
        }else if(step%2 == 0){
            return step;
        }else return step+2;
    }
}
