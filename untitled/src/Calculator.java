//Требования:
//      Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
// a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотри пример)!
//      Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
//      Калькулятор умеет работать как с арабскими (1,2,3,4,5...), так и с римскими (I,II,III,IV,V...) числами.
//      Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по
// величине и могут быть любыми.
//      Калькулятор умеет работать только с целыми числами.
//      Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки
// вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
//      При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ
// ожидается арабскими.
//      При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
//      При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение
// выбрасывает исключение и завершает свою работу.
//      Результатом операции деления является целое число, остаток отбрасывается.
//      Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль. Результатом работы
// калькулятора с римскими числами могут быть только положительные числа, если результат работы меньше единицы,
// выбрасывается исключение

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {


        int num1 = 0;
        int num2 = 0;
        int result = 0;
        int resultArab = 0;

        Scanner string = new Scanner(System.in); //сканер строки
        System.out.println("Input: ");
        String vvod = string.nextLine();
        System.out.print("Output: " + vvod);

        //поиск и присваивание символа математического действия
        String operStr = " ";
        char[] symbol = new char[10];
        char oper = '+';
        for (int i=1; i < vvod.length(); i++) {
            symbol[i] = vvod.charAt(i);
            if ( symbol[i] == '+'){
                oper = '+'; operStr = "\\+";
            }
            if ( symbol[i] == '-'){
                oper = '-'; operStr = "-";
            }
            if ( symbol[i] == '*'){
                oper = '*'; operStr = "\\*";
            }
            if ( symbol[i] == '/'){
                oper = '/'; operStr = "/";
            }
        }



        String[] numbers = vvod.split(operStr);
        if (numbers.length > 2) {
            System.out.println(" throws Exception ");  //При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
            System.exit(0);
        }
        try{
            num1 = romanNumeral(numbers[0]);
            num2 = romanNumeral(numbers[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" throws Exception "); //Нет символа для выполнения операции или отсутствует вторая переменная.
            System.exit(0);
        }
        if (num1 == 0 | num2 == 0) {
            result = 0;
            try {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);
                if (num1 > 10 | num2 > 10 | num1 < 0 | num2 <0) {
                    System.out.println(" throws Exception "); //Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
                    System.exit(0);
                }
                resultArab = calculate(num1, num2, oper);
                System.out.println("=" + resultArab);
            } catch (NumberFormatException e) {
                System.out.println(" throws Exception "); //Калькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10.
            } catch (ArithmeticException e) {
                System.out.println(" throws Exception "); //На ноль делить нельзя!
            }
        } else {
            try {
                result = calculate(num1, num2, oper);
                if (result == 0) {
                    System.out.println(" throws Exception "); //Результатом работы калькулятора с римскими числами могут быть только положительные числа.
                    System.exit(0);
                }
                String resultRom = romanSolution(result);
                System.out.println("=" + resultRom + " (" + result + ")");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(" throws Exception "); //Результатом работы калькулятора с римскими числами могут быть только положительные числа.
            }
        }
    }

    public static int calculate(int x1, int x2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }

    public static int romanNumeral(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }

    public static String romanSolution(int arabNumeral) {
        String[] romanAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "*****", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String q = romanAll[arabNumeral];
        return q;

    }
}