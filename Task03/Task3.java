import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    public static void main(String[] args) {
        System.out.println("----------1----------");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));
        System.out.println("----------2----------");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));
        System.out.println("----------3----------");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));
        System.out.println("----------4----------");
        System.out.println(flipEndChars("Cat, dog and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));
        System.out.println("----------5----------");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println("----------6----------");
        System.out.println(same(new Integer[]{1,3,4,4,4},new Integer[]{2,5,7}));
        System.out.println(same(new Integer[]{9,8,7,6},new Integer[]{4,4,3,1}));
        System.out.println(same(new Integer[]{2},new Integer[]{3,3,3,3,3}));
        System.out.println("----------7----------");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));
        System.out.println("----------8----------");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));
        System.out.println("----------9----------");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));
        System.out.println("----------10----------");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }


    /*
    1. Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1, либо 2 различных
    решения для действительных значений x. учитывая a, b и c, вы должны вернуть
    число решений в уравнение.
    Пример:
    solutions(1, 0, -1) ➞ 2
    // x² - 1 = 0 has two solutions (x = 1 and x = -1).
    solutions(1, 0, 0) ➞ 1
    // x² = 0 has one solution (x = 0).
    solutions(1, 0, 1) ➞ 0
    // x² + 1 = 0 has no solutions.
     */
    private static int solutions(int a, int b, int c) {
        // используем формулу дискриминанта и его свойства
        int d = b ^ 2 - 4 * a * c;
        if (d == 0) {
            return 1;
        } else if (d > 1) {
            return 2;
        } else {
            return 0;
        }
    }

    /*
    2. Напишите функцию, которая возвращает позицию второго вхождения " zip " в
    строку, или -1, если оно не происходит по крайней мере дважды. Ваш код должен
    быть достаточно общим, чтобы передать все возможные случаи, когда "zip" может
    произойти в строке.
    Пример:
    findZip("all zip files are zipped") ➞ 18
    findZip("all zip files are compressed") ➞ -1
    Примечание:
    Верхний регистр " Zip "- это не то же самое, что нижний регистр "zip".
    */
    public static int findZip(String string){
        int n = 0;
        for (int i = 0; i<string.length()-2; i++){
            if ((n == 0) && (string.charAt(i) == 'z') && (string.charAt(i+1) == 'i') && (string.charAt(i+2) == 'p')){
                n+=1;
            } else if ((n == 1) && (string.charAt(i) == 'z') && (string.charAt(i+1) == 'i') && (string.charAt(i+2) == 'p')) {
                return i;
            }
        }
        return -1;
    }

    /*
    3. Создайте функцию, которая проверяет, является ли целое число совершенным
    числом или нет. Совершенное число - это число, которое можно записать как
    сумму его множителей, исключая само число.
    Например, 6-это идеальное число, так как 1 + 2 + 3 = 6, где 1, 2 и 3-Все коэффициенты 6.
    Точно так же 28-это совершенное число, так как 1 + 2 + 4 + 7 + 14 = 28.
    Пример:
    checkPerfect(6) ➞ true
    checkPerfect(28) ➞ true
    checkPerfect(496) ➞ true
    checkPerfect(12) ➞ false
    checkPerfect(97) ➞ false
    */
    private static boolean checkPerfect(int number) {
        int sum = 1;
        // у каждого множителя есть пара.
        // Первый множитель находится до корня числа. Второй - после.
        // Поэтому можно перебрать все множители до корня
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum+=i;
                // если множитель не является корнем - то добавляем в сумму его пару
                if (i*i != number) {
                    sum+= number/i;
                }
            }
        }
        return sum == number;
    }

    /*
    4. Создайте функцию, которая принимает строку и возвращает новую строку с
    заменой ее первого и последнего символов, за исключением трех условий:
    – Если длина строки меньше двух, верните "несовместимо".".
    – Если первый и последний символы совпадают, верните "два-это пара.".
    Пример:
    flipEndChars("Cat, dog, and mouse.") ➞ ".at, dog, and mouseC"
    flipEndChars("ada") ➞ "Two's a pair."
    flipEndChars("Ada") ➞ "adA"
    flipEndChars("z") ➞ "Incompatible."
    */
    private static String flipEndChars(String s) {
        if (s.length() < 2) {
            return "incompatible";
        } else if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return "Two's a pair";
        } else {
            return s.charAt(s.length() - 1) +
                    s.substring(1, s.length() - 2) +
                    s.charAt(0);
        }
    }

    /*
    5. Создайте функцию, которая определяет, является ли строка допустимым
    шестнадцатеричным кодом.
    Шестнадцатеричный код должен начинаться с фунтового ключа # и иметь длину ровно 6
    символов. Каждый символ должен быть цифрой от 0-9 или буквенным символом от A-F.
    все буквенные символы могут быть прописными или строчными.
    Пример:
    isValidHexCode("#CD5C5C") ➞ true
    isValidHexCode("#EAECEE") ➞ true
    isValidHexCode("#eaecee") ➞ true
    isValidHexCode("#CD5C58C") ➞ false
    // Length exceeds 6
    isValidHexCode("#CD5C5Z") ➞ false
    // Not all alphabetic characters in A-F
    isValidHexCode("#CD5C&C") ➞ false
    // Contains unacceptable character
    isValidHexCode("CD5C5C") ➞ false
    // Missing #
    */
    public static boolean isValidHexCode(String string){
        if (string.charAt(0) != '#') return false;
        if (string.length() != 7) return false;
        for(int i = 1; i<string.length()-1; i++){
            char character = string.charAt(i);
            int ascii_c = (int) character;
            if (!((ascii_c >= 48 && ascii_c <= 57) || (ascii_c >= 65 && ascii_c <= 70) || (ascii_c >= 96 && ascii_c <= 102))){
                return false;

            }
        }
        return true;
    }

    /*
    6.Напишите функцию, которая возвращает true, если два массива имеют одинаковое
    количество уникальных элементов, и false в противном случае.
    Для примера:
    arr1 = [1, 3, 4, 4, 4]
    arr2 = [2, 5, 7]
    В arr1 число 4 появляется трижды, что означает, что оно содержит три уникальных
    элемента: [1, 3, 4]. Поскольку arr1 и arr2 содержат одинаковое количество уникальных
    элементов, этот пример вернет значение true.
    Пример:
    same([1, 3, 4, 4, 4], [2, 5, 7]) ➞ true
    same([9, 8, 7, 6], [4, 4, 3, 1]) ➞ false
    same([2], [3, 3, 3, 3, 3]) ➞ true
    */
    public static boolean same(Integer[] arr1, Integer[] arr2){
        List<Integer> arr1_edit = new ArrayList<Integer>(Arrays.asList(arr1));
        List<Integer> arr2_edit = new ArrayList<Integer>(Arrays.asList(arr2));

        arr1_edit = supportSort(arr1_edit);
        arr2_edit = supportSort(arr2_edit);
        return arr1_edit.size() == arr2_edit.size();
    }
    public static List<Integer> supportSort(List<Integer> list){
        List<Integer> list_edit = list;
        for (int i = 0; i < list_edit.size(); i++){
            for(int k = i+1; k < list.size(); k++){
                if(list_edit.get(i) == list_edit.get(k)){
                    list_edit.remove(k);
                    k -= 1;
                }
            }

        }
        return list_edit;
    }

    /**
    Число Капрекара-это положительное целое число, которое после возведения в
    квадрат и разбиения на две лексикографические части равно сумме двух
    полученных новых чисел:
    – Если количество цифр квадратного числа четное, то левая и правая части будут иметь
    одинаковую длину.
    – Если количество цифр квадратного числа нечетно, то правая часть будет самой длинной
    половиной, а левая-самой маленькой или равной нулю, если количество цифр равно 1.
    – Учитывая положительное целое число n, реализуйте функцию, которая возвращает true,
    если это число Капрекара, и false, если это не так.
    Пример:
    isKaprekar(3) ➞ false
    // n² = "9"
    // Left + Right = 0 + 9 = 9 ➞ 9 !== 3
    isKaprekar(5) ➞ false
    // n² = "25"
    // Left + Right = 2 + 5 = 7 ➞ 7 !== 5
    isKaprekar(297) ➞ true
    // n² = "88209"
    // Left + Right = 88 + 209 = 297 ➞ 297 === 297
    Примечание:
    Тривиально, 0 и 1-Это числа Капрекара, являющиеся единственными двумя числами,
    равными их квадрату.
     */
    private static boolean isKaprekar(int a) {
        // возмодим число в квадрат
        String aStr = "" + a*a;
        // разделитель нового числа надвое
        int indexOfSecond = aStr.length() / 2;
        // правое число
        int right = Integer.parseInt(aStr.substring(indexOfSecond));
        // если число состоит из 1 символа, то в левой стороне числа не будет.
        // в этом случае запишем 0
        int left;
        try {
            left = Integer.parseInt(aStr.substring(0, indexOfSecond));
        } catch (NumberFormatException e) {
            left = 0;
        }
        // если сумма левой и правой частей квадрата числа равна самому числу - то это число капрекара
        return right + left == a;
    }

    /*
    8. Напишите функцию, которая возвращает самую длинную последовательность
    последовательных нулей в двоичной строке.
    Пример:
    longestZero("01100001011000") ➞ "0000"
    longestZero("100100100") ➞ "00"
    longestZero("11111") ➞ ""
    */
    private static String longestZero(String s) {
        // максимальная найденная последовательность нулей
        int maxLength = 0;
        // текущая последовательность нулей
        int currentLength = 0;
        for (char c: s.toCharArray()) {
            // если сейчас не 0, то сбрасываем найденное количество нулей
            if (c != '0') {
                currentLength = 0;
            } else {
                currentLength+=1;
            }
            // если текущее количество нулей больше максимального - перезаписываем
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        // возвращаем 0 повторенное найденное количество раз
        return "0".repeat(maxLength);
    }

    /*
    9. Если задано целое число, создайте функцию, которая возвращает следующее
    простое число. Если число простое, верните само число.
    Пример:
    nextPrime(12) ➞ 13
    nextPrime(24) ➞ 29
    nextPrime(11) ➞ 11
    // 11 is a prime, so we return the number itself.
    */
    public static int nextPrime(int num){
        for (int i = num; i < num + 1000; i++){
            if(isPrime(i)) return i;
        }
        return num;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
    10. Учитывая три числа, x, y и z, определите, являются ли они ребрами
    прямоугольного треугольника.
    Пример:
    rightTriangle(3, 4, 5) ➞ true
    // This is the classic example of a "nice" right angled triangle.
    rightTriangle(145, 105, 100) ➞ true
    // This is a less famous example.
    rightTriangle(70, 130, 110) ➞ false
    // This isn't a right angled triangle.
    */
    private static boolean rightTriangle(int a, int b, int c) {
        // закидываем в массив все стороны
        ArrayList<Integer> array = new ArrayList<>();
        array.add(a);
        array.add(b);
        array.add(c);
        Collections.sort(array);
        // сортируем стороны. Самая большая = гипотенуза. Проверяем что выполняется теорема пифагора
        return Math.pow(array.get(0), 2) + Math.pow(array.get(1), 2) == Math.pow(array.get(2), 2);
    }

}
