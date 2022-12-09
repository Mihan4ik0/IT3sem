import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Locale;

public class main {
    public static void main(String[] args) {
        System.out.println("----1----");
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(new int[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        System.out.println(Arrays.toString(encrypt("Sunshine")));
        System.out.println("----2----");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));
        System.out.println("----3----");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println("----4----");
        System.out.println(sumDigProd(new int[]{16, 28}));
        System.out.println(sumDigProd(new int[]{0}));
        System.out.println(sumDigProd(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println("----5----");
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"})));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"})));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"})));
        System.out.println("----6----");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));
        System.out.println("----7----");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(126));
        System.out.println(numToEng(909));
        System.out.println("----8----");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));
        System.out.println("----9----");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println("----10----");
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));
    }

    /**
    * 1 задание:
    * @return шифр последовательности
    * 1 число - символьный код первой буквы
    * Следующие элементы-это различия между символами
    * */
    private static int[] encrypt(String s){
        char lastAscii = 0;
        int[] cryphre = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            cryphre[i] = chars[i] - lastAscii;
            lastAscii = chars[i];
        }
        return cryphre;
    }
    /**
    * 1 задание:
    * @return расшифровать последовательность, полученную с помощью encrypt
    * */
    private static String decrypt(int[] s) {
        char lastAscii = 0;
        char[] chars = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            chars[i] = (char) (lastAscii + s[i]);
            lastAscii = chars[i];
        }
        return new String(chars);
    }
    /**
    * 2 задание:
    * @return true если для данной фигуры есть возможность переместиться с позиции from на позицию to
    * не учитываем возможность для пешки пойти сразу на 2 со стартовой позиции, потому что у нас нет инфы о том, чья она
    * так же не рассматриваем для пешки возможность пойти по диагонали для атаки
    */
    private static boolean canMove(String figure, String from, String to) {
        // константы фигур
        final String HORSE = "Horse";
        final String BISHOP = "Bishop";
        final String QUEEN = "Queen";
        final String ROOK = "Rook";
        final String PAWN = "Pawn";
        final String KING = "King";

        // выделяем координаты перемещений по осям
        char fromX = from.charAt(0);
        int fromY = Integer.parseInt(String.valueOf(from.charAt(1)));
        char toX = to.charAt(0);
        int toY = Integer.parseInt(String.valueOf(to.charAt(1)));

        // Проверка на ход вперёд
        if ((fromY == toY && fromX != toX) || (fromY != toY && fromX == toX)) {
            if (figure.equals(QUEEN) || figure.equals(ROOK)) { // Проверка на королеву или ладью
                return true;
            }
            // проход строго на 1 клетку куда угодно
            if ((fromY == toY && Math.abs(fromX - toX) == 1) || (fromX == toX && Math.abs(fromY - toY) == 1)) {
                if (figure.equals(KING)) { // проверка на короля
                    return true;
                }
            }
            // если прошли вперед на 1 клетку
            if (fromX == toX && toY - fromY == 1) {
                return figure.equals(PAWN); // проверка на пешку
            }
        }
        // проверка диагонали
        else if (Math.abs(fromX - toX) == Math.abs(fromY - toY)) {
            if (figure.equals(QUEEN) || figure.equals(BISHOP)) { // проверка на королеву и слона
                return true;
            }
            // если прошли строго на 1 шаг
            if (Math.abs(fromX - toX) == 1) {
                return figure.equals(KING); // проверка на короля
            }
        }
        // если это конь
        else if ((Math.abs(fromX - toX) == 1 && Math.abs(fromY - toY) == 2)
                 || (Math.abs(fromY - toY) == 1 && Math.abs(fromX - toX) == 2)) {
            return figure.equals(HORSE);
        }
        return false;
    }
    /**
    * 3 задание:
    * @return true если посредством добавления в 1 строку символов можно получить 2 строку
    * */
    private static boolean canComplete(String s1, String s2) {
        // делаем проход по второй строке с поиском соответствия символа первой строки
        // на позиции счётчика совпадений(итераций)
        // в случае совпадения переходим к поиску соответствия следующего символа
        int s1It = 0;
        for (int s2It = 0; s2It < s2.length(); s2It++) {
            if (s1.charAt(s1It) == s2.charAt(s2It)) {
                s1It++;
                if (s1It == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
    * 4 задание:
    * @return цифру образованную при произведении всех цифр суммы чисел (и всех цифр получившегося произведения и тд если необходимо)
    * */
    private static Integer sumDigProd(int[] int_list){
        Integer sum_num = 0;
        for (int i = 0; i < int_list.length; i++){
            sum_num += int_list[i];
        }
        Integer final_number = sum_num;
        while (final_number > 9){
            String snumber = String.valueOf(final_number);
            final_number =  Integer.parseInt(String.valueOf(snumber.charAt(0))) * Integer.parseInt(String.valueOf(snumber.charAt(1)));
        }
        return final_number;
    }
    /**
    * 5 задание:
    * @return массив слов, в котором есть все слова, включая первое, в котором есть те же гласные, что и в первом слове
    * */
    private static String[] sameVowelGroup(String[] words){
        String vowels = "";
        String first = words[0].replaceAll("[qwrtiopsdfghjklzxcvbnm]", ""); // регуляркой убираем согласные
        ArrayList<String> othervowels = new ArrayList<String>(); // список для вывода
        for (int i = 0; i < first.length(); i++){ // loop для сохранения всех гласных первого слова
            vowels += first.charAt(i);
        }
        othervowels.add(words[0]); // добавления первого слова в список вывода
        boolean match = true;
        for (int i = 1; i < words.length; i++){ // loop проверка всех слов
            String wordvowels = words[i].replaceAll("[qwrtiopsdfghjklzxcvbnm]", ""); // регуляркой убираем согласные
            for (int w = 0; w < wordvowels.length(); w++){ // loop проверка каждой гласной
                for (int r = 0; r < vowels.length(); r++){ // loop сравнение гласных
                    if (vowels.charAt(r) == wordvowels.charAt(w)){
                        match = true;
                    } else {
                        match = false;
                    }
                }
            }
            if (match == true) {
                othervowels.add(words[i]); // добавление слова в вывод
            }
        }
        String[] array = othervowels.toArray(new String[othervowels.size()]); // преобразование списка в массив String
        return array;
    }
    /**
    * 6 задание:
    * @return true если номер удовлетворяет условиям:
    * * в нем от 14 до 19 цифр
    * * проходит тест луна:
    * – Удалите последнюю цифру (это"контрольная цифра").
    * – Переверните число.
    * – Удвойте значение каждой цифры в нечетных позициях. Если удвоенное значение имеет
    * более 1 цифры, сложите цифры вместе (например, 8 x 2 = 16 ➞ 1 + 6 = 7).
    * – Добавьте все цифры.
    * – Вычтите последнюю цифру суммы (из шага 4) из 10. Результат должен быть равен
    * контрольной цифре из Шага 1.
    * */
    private static boolean validateCard(Long number){
        String numb = String.valueOf(number);
        String reverse_numb = "";
        Integer control = 0;
        boolean match = false;
        String doubled = "";
        if (numb.length() >= 14 && numb.length() <= 19){
            control = Integer.parseInt(String.valueOf(numb.charAt(numb.length()-1))); // задаём контрольное число
            for (int i=0; i < numb.length() - 1; i++){ // loop реверс строки
                reverse_numb += numb.charAt((numb.length()-2-i));
        }
        for (int r = 0; r < reverse_numb.length(); r++){ // loop перепись строки
            if (r % 2 == 0 || r == 0) {
                Integer numbsqrt = Integer.parseInt(String.valueOf(reverse_numb.charAt(r))) * 2; // удвоенние числа
                String numbsqrt1 = String.valueOf(numbsqrt);
                if (numbsqrt1.length() == 2) { // проверка на больше 9
                    doubled += String.valueOf(Integer.parseInt(String.valueOf(numbsqrt1.charAt(0)))+Integer.parseInt(String.valueOf(numbsqrt1.charAt(1))));
                    // перемножение цифр числа
                } else {
                    doubled += String.valueOf(Integer.parseInt(String.valueOf(numbsqrt1)));
                }
            } else {
                doubled += reverse_numb.charAt(r);
            }
        }
        Integer sum = 0;
        for (int r = 0; r < doubled.length(); r++){ // loop суммирование цифр числа
            sum += Integer.parseInt(String.valueOf(doubled.charAt(r)));
        }
            Integer itog = 10 - Integer.parseInt(String.valueOf(String.valueOf(sum).charAt(String.valueOf(sum).length()-1))); // подсчёт для сравнение с контрольным числом
        if (itog == control) {
            match = true;
        }
            else {
                match = false;
            }
        }
        return match;
    }
    /**
    * 7 задание:
    * @return перевод цифры в ее строковой эквивалент на английском
    * */
    private static String numToEng(int num) {
        String returnString = "";
        int iter = 0; // счётчик итераций
        if (num == 0) return "zero";
        if (num == 10) return "ten";
        if (num == 11) return "eleven";
        if (num == 12) return "twelve";
        String one = "one", two = "two", three = "three", four = "four", five = "five", six = "six",
        seven = "seven", eight = "eight", nine = "nine", fift = "fift", thirt = "thirt", twent = "twent";
        if (num > 99 && num < 1000) {
            switch (num / 100) { // проверка какая сотня
                case (1) -> returnString += one;
                case (2) -> returnString += two;
                case (3) -> returnString += three;
                case (4) -> returnString += four;
                case (5) -> returnString += five;
                case (6) -> returnString += six;
                case (7) -> returnString += seven;
                case (8) -> returnString += eight;
                case (9) -> returnString += nine;
            }
            returnString += " hundred ";
            num = num - (num / 100 * 100);
        }
        if (num > 19 && num < 100) { // проверка на десятки
            switch (num / 10) {
                case (2) -> returnString += twent;
                case (3) -> returnString += thirt;
                case (4) -> returnString += four;
                case (5) -> returnString += fift;
                case (6) -> returnString += six;
                case (7) -> returnString += seven;
                case (8) -> returnString += eight;
                case (9) -> returnString += nine;
            }
            if (returnString.charAt(returnString.length() - 1) == 't') returnString += "y ";
            else returnString += "ty ";
            num = num - (num / 10 * 10);
        }
        if (num > 10 && num < 19) {
            switch (num % 10) {
                case (3) -> returnString += thirt;
                case (4) -> returnString += four;
                case (5) -> returnString += fift;
                case (6) -> returnString += six;
                case (7) -> returnString += seven;
                case (8) -> returnString += eight;
                case (9) -> returnString += nine;
            }
            if (returnString.charAt(returnString.length() - 1) == 't') returnString += "een";
            else returnString += "teen";
            num = 0;
        }
        if (num > 0 && num < 10) {
            switch (num) {
                case (1) -> returnString += one;
                case (2) -> returnString += two;
                case (3) -> returnString += three;
                case (4) -> returnString += four;
                case (5) -> returnString += five;
                case (6) -> returnString += six;
                case (7) -> returnString += seven;
                case (8) -> returnString += eight;
                case (9) -> returnString += nine;

            }
        }
        return returnString;
    }
    /**
    * 8 задание:
    * @return отформатированный в виде шестнадцатеричной цифры хеш SHA-256 для строки
    * */
    private static String getSha256Hash(String s) {
        try {
            // шифруем в байты строку через MessageDigest
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); // создания экземпляра криптографической хеш-функции
            byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8)); // добавление блока данных для расчёта дайджеста
            StringBuilder hexString = new StringBuilder(); // переводим байты в хеш
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b); // Возвращает строковое представление аргумента integer в виде целого числа без знака в базе 16.
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }
    /**
    * 9 задание:
    * @return строка, в которой все слова кроме of, in, and, the - капитализированы
    * */
    private static String correctTitle(String s) {
        // делим строку на слова
        String[] words = s.toLowerCase(Locale.ROOT).split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for (String word: words) {
            // капитализуем все слова, не являющиеся служебными
            if (!word.equals("of") && !word.equals("in") && !word.equals("and") && !word.equals("the")) {
                word = word.substring(0,1).toUpperCase(Locale.ROOT) + word.substring(1);
            }
            joiner.add(word);
        }
        return joiner.toString();
    }
    /**
    * 10 задание:
    * @return вывести на экран гексагональную решетку для центрированного шестиугольного числа
    * */
    private static String hexLattice(int n) {
        // объявим циклы - это количество кругов решетки. Типо для 7 - 2 цикла. для 37 - 4 цикла
        int hexCycle = 1;
        int currentElements = 1;
        // пытаемся подобрать цикл для данного числа элементов.
        // Если цикл не удается подобрать - значит число не центрированное шестиугольное
        while (currentElements < n) {
            // число элементов для данного цикла = 1 + 6* сумма(k)по k от 2 до n, где n - цикл.
            currentElements+= 6*hexCycle;
            hexCycle+=1;
        }
        if (currentElements != n) {
            return "invalid";
        }
        // размер - количество строк = количество точек
        final int hexSize = hexCycle* 2 - 1;
        final int hexSizeWithSpaces = hexSize* 2 - 1;
        // массив строк
        String[] hex = new String[hexSize];
        // цикл с середины фигуры до ее начала. Можно рисовать только половину так как фигура зеркальная.
        for (int i = hexCycle - 1; i >= 0; i--) {
            // находим сколько будет символов для этой строки вместе с пробелами
            int rowSizeWithSpaces = (hexCycle + i)*2 - 1;
            // находим какой отступ нужно будет сделать слева и справа для этой строки
            int spaceInLeft = (hexSizeWithSpaces - rowSizeWithSpaces)/2;
            // рисуем строку - повторяем точки определенное количество раз, и ставим между ними пробелы. добавляем слева и срава отступы.
            hex[i] = " ".repeat(spaceInLeft) + "o".repeat(hexCycle + i).replaceAll(".(?=.)", "$0 ") + " ".repeat(spaceInLeft);
            // если строка не на середине, то рисуем зеркальную строку
            if (i <= hexCycle - 1) {
                hex[hexSize - i - 1] = hex[i];
            }
        }
        // преобразуем массив в строку
        StringJoiner joiner = new StringJoiner("\n");
        for (String h: hex) {
            joiner.add(h);
        }
        return joiner.toString();
    }
}