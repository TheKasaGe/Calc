
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение через пробел");
        String input = in.nextLine();
        String result = calc(input);
        System.out.println(result);
    }
   public static String calc(String input) throws IndexOutOfBoundsException{
       String[] p = input.split(" ");
       String op = new String();
       int a = 0; int b = 0;

       try {op = p[1];}
       catch (IndexOutOfBoundsException e){
           System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
           System.exit(1);
       }
       if (isRomeOrArab(input) == 2){
           return RomeToArab(p);}
       else if(isRomeOrArab(input) == 0){
           try {
           a = Integer.parseInt(p[0].trim());
           b = Integer.parseInt(p[2].trim());}
           catch (NumberFormatException e){
               System.out.println("Неверный формат данных");
               System.exit(1);
           }
           if (a<11 && a>0 && b<11 && b>0){
           return String.valueOf(calcul(a, b, op));}
           else {System.out.println("Числа должны быть от 1 до 10 включительно");
                System.exit(1);
           }
       }
       System.out.println("Неверный формат данных");
       System.exit(1);
       return "Error";
   }
   private static int calcul (int a, int b, String op){
       int result = 0;
       switch (op) {
           case "+" -> result = a + b;
           case "-" -> result = a - b;
           case "*" -> result = a * b;
           case "/" -> result = a / b;
           default -> throwException();
       }
       return result;
   }
   private static int isRomeOrArab(String input) throws ArrayIndexOutOfBoundsException{
        String[] p = input.split(" ");
        String[] RN = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int i1 = 0;
        int i2 = 0;
        if(p.length>3){
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(1);
        }
        for (String s : RN) {
            if (p[0].equals(s)) {
                i1 = 1;
                break;}
        }
        for (String s : RN) {
            try {if (p[2].equals(s)) {
                i2 = 1;
                break;}}
            catch (IndexOutOfBoundsException e){
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, * )");
                System.exit(1);
            }
        }
        return i1+i2;
   }
  private static String RomeToArab(String[] input){
      String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
              "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
              "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
              "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
              "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
              "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
              "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
      int a = 0; int b = 0; String op = input[1];

      for (int i = 0; i<=roman.length; i++) {
          if (input[0].equals(roman[i])) {
              a = i;
              break;}}
      for (int i = 0; i<=roman.length; i++) {
          if (input[2].equals(roman[i])) {
              b = i;
              break;}}

      int c = calcul(a, b, op);
      try {return roman[c];}
      catch (ArrayIndexOutOfBoundsException e){
          System.out.println("В римской системе нет отрицательных чисел");
          System.exit(1);}

      return roman[c];
  }
        private static void throwException() throws RuntimeException {
            System.out.println("Неправильный формат ввода. Необходимо ввести один из знаков (+, -, /, *)");
            System.exit(1);
        }
  }
