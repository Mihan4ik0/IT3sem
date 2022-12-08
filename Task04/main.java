import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class main {

    public static void main(String[] args) {
        System.out.println("-----1-----");
        System.out.println(essay(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println("-----2-----");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));
        System.out.println("-----3-----");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));
        System.out.println("-----4-----");
        System.out.println(overtime(9, 17, 30, 1.5));
        System.out.println(overtime(16, 18, 30, 1.8));
        System.out.println(overtime(13.25, 15, 30, 1.5));
        System.out.println("-----5-----");
        System.out.println(bmi("205 pounds", "73 inches"));
        System.out.println(bmi("55 kilos", "1.63 meters"));
        System.out.println(bmi("154 pounds", "2 meters"));
        System.out.println("----6------");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        System.out.println("----7------");
        System.out.println(toStartShorthand("abbccc"));
        System.out.println(toStartShorthand("77777geff"));
        System.out.println(toStartShorthand("abc"));
        System.out.println(toStartShorthand(""));
        System.out.println("----8------");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        System.out.println("----9------");
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));
        System.out.println("----10------");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));

    }

    /**
     * 1 задание
     * @return отформатированную строку в список строк так, чтобы в каждой строке было не больше символов чем k
     * параметр n в условии задачи есть но ни на что не влияет.
     */
    private static String essay(int n, int k, String initialString) {
        Integer stringlength = 0; // Переменная для понимания размера текущей строки
        String[] initString = initialString.split(" "); // Строка в массив
        String finalString = ""; // Вывод
        for (int i=0; i<initString.length;i++){ // Loop для всего массива
            String momentString = initString[i]; // Временная переменная для данного слова
            if (momentString.length() + stringlength <= k){ // проверка на количество символов в строке
                finalString += momentString + " "; // прибавление к строке без переноса
                stringlength += momentString.length(); // изменение длины текущей строки
            }
            else if (momentString.length() + stringlength > k){
                finalString += "\n" + momentString + " "; // добавление слова с переносом строки
                stringlength += momentString.length(); // изменение длины текущей строки
            }
        }
        return finalString;
    }

    /**
     * 2 задание:
     * @return из строки со скобками выделяются кластеры скобок и возвращаются в массиве
     * */
    private static List split(String s) {
        Integer numBrackets = 0; // переменная для счёта открытых скобок
        ArrayList<String> returnBrackets = new ArrayList<String>(); // список для вывода
        String returnString = "";
        String editString = "";
        for (int i=0; i < s.length(); i++){ // loop перебор
            if (s.charAt(i) == '('){ // проверка на открытие (открыта +1 к состоянию скобок и наоборот)
                numBrackets += 1;
            }
            else if (s.charAt(i) == ')'){
                numBrackets -= 1;
            }
            editString += s.charAt(i);
            if (numBrackets == 0 ){ // в случае уравнивания нулю добавление в список и очистка состояния изменяемой строки
                returnBrackets.add(editString);
                returnString += editString + " ";
                editString = "";
            }
        }
        List stringList = Arrays.asList(returnString); // превращение строки в список
        return stringList;
    }

    /**
     * 3 задание:
     * @return модифицированная строка переведенная из snake_case в camel_case.
     * */
    private static String toCamelCase(String s) {
        String returnString = "";
        for (int i=0; i<s.length(); i++){
         if (s.charAt(i) == '_'){
             returnString += Character.toString(s.charAt(i+1)).toUpperCase();
             i+=1;
         }
         else {
             returnString += s.charAt(i);
         }
        }
        return returnString;
    }

    /**
     * 3 задание:
     * @return модифицированная строка переведенная из camel_case в snake_case.
     * */
    private static String toSnakeCase(String s) {
        String returnString = "";
        for(int i = 0; i < s.length(); i++){
            if ((int) s.charAt(i) <= 90 && ((int) s.charAt(i) >= 65)){ // сверка символов с ascii
                returnString += '_';
                int ascii = (int) s.charAt(i) + 32; // понижение регистра(разница между верхним и нижним 32 позиции)
                returnString += (char) ascii;
            } else {
                returnString += s.charAt(i);
            }
        }
        return returnString;
    }

    /**
     * 4 задание
     * @return оплата работнику в соответствии с отработанными часами
     * */
    private static String overtime(double start, double end, double payment, double multiplier) {
        final double workEnd = 17;
        final double workStart = 9;
        double overtime = 0;
        double trutime = 0;
        if (start < workStart) {
            overtime += workStart - start;
        }
        if (end > workEnd) {
            overtime += end - workEnd;
        }
        trutime += end - start - overtime;
        double money = trutime*payment + overtime*payment*multiplier;
        return String.format("$ %.2f", money);
    }

  // 5 задание
    private static String bmi(String weight_str, String height_str){
            String[] arr_weight = weight_str.split(" ");
            double weight_db = Double.parseDouble(arr_weight[0]);
            String type_of_weight = arr_weight[1];

            String[] arr_height = height_str.split(" ");
            double height_db = Double.parseDouble(arr_height[0]);
            String type_of_height = arr_height[1];

            if (type_of_weight == "pounds") weight_db /= 2.205;
            if (type_of_height == "inches") height_db/= 39.37;

            double bmi = weight_db/ (height_db*height_db);

            if(bmi >= 25) return (Math.round(bmi*10d)/10d + " Overweight");
            else if (bmi < 18.5) return (Math.round(bmi*10d)/10d + " Underweight");
            else return (Math.round(bmi*10d)/10d + " Normal weight");
        }
    /**
    * 6 задание
    * @return мультипликативное постоянство (количество раз, которое нужно умножить цифры числа чтобы получить 1 цифру
    * */
    private static int bugger(int start){

        if (start<= 9) return  0; // не является ли одной цифрой

        int next = 1;
        int digit = (int) Math.ceil(Math.log10(start + 0.5)); // рассчёт количества разрядов
        while (digit != 0){
            next *= start % 10; // умножаем на каждый разряд
            start = start / 10 ;
            digit -= 1;
        }
        return 1 + bugger(next);
    }
    /**
    * 7 задание
    * @return модифицированная строка, в которой повторения символов заменяются на фрагменты вида "a*n"
    * */
    private static String toStartShorthand(String String){
        String returnString = "";
        int n = 1;
        String += "&";
        for (int i = 0; i < String.length()-1; i++){
            if (String.charAt(i) == String.charAt(i+1)){
                n += 1;
            }
            else {
                returnString += String.charAt(i);
                if (n != 1) returnString += "*" + String.valueOf(n);
                n = 1;
            }
        }
        return returnString;
    }
    /**
    * 8 задание:
    * @return true если гласные в последнем слова предложений одинаковые и идут в одинаковом порядке
    * */
    private static Boolean doesRhyme(String s1, String s2) {
        // регулярное выражение, котораое находит в строке последнее слово и заменяет только его
        String s1LastWord = s1.replaceAll("^.*?(\\w+)\\W*$", "$1").toLowerCase(Locale.ROOT);
        String s2LastWord = s2.replaceAll("^.*?(\\w+)\\W*$", "$1").toLowerCase(Locale.ROOT);
        // удаляем все согласные из последних слов
        String s1CharsToRhyme = s1LastWord.replaceAll("[qwrtiopsdfghjklzxcvbnm]", "");
        String s2CharsToRhyme = s2LastWord.replaceAll("[qwrtiopsdfghjklzxcvbnm]", "");
        return s2CharsToRhyme.equals(s1CharsToRhyme);
    }
    /**
    * 9 задание:
    * @return true если есть такая цифра, которая ровно 3 раза повторяется в d1 и 2 раза повторяется в d2
    * */
    private static boolean trouble(long num1, long num2){
        String num1_str = String.valueOf(num1);
        String num2_str = String.valueOf(num2);
        List<Character> list_rep_int = new ArrayList<>();
        int q = 1;
        for (int i = 0; i < num1_str.length()-1; i++){
            if (num1_str.charAt(i) == num1_str.charAt(i+1)){
                q+=1;
            }else if(q==3){
                list_rep_int.add(num1_str.charAt(i));
                q = 1;
            }else q = 1;
        }

        for(Character num : list_rep_int){
            String str = "" + num + num;
            return num2_str.contains(str);
        }
        return false;
    }
    /**
    * 10 задание:
    * @return количество уникальных символов, встречающихся в открытых книгах
    * */
    private static int countUniqueBooks(String stringSequnce, char bookEnd){
        boolean bookCondition = false;
        List<Character> list_char = new ArrayList<Character>();
        for (int i = 0; i < stringSequnce.length()-1; i++){
            if (stringSequnce.charAt(i) == bookEnd) bookCondition = !bookCondition;
            if (bookCondition){
                if(!list_char.contains(stringSequnce.charAt(i)) && stringSequnce.charAt(i) != bookEnd){
                    list_char.add(stringSequnce.charAt(i));
                }
            }
        }
        return list_char.size();
    }
}