package HomeWork1;

import java.util.Scanner;

/**
 * Created by Velev Vlad on 11.05.2017.
 * Создать простой (очень) калькулятор. Взаимодействие с пользователем по следующему сценарию:
 * “
 *  Please input first number:
 *  Your input <inputted number> as a first number.
 *  Please input second number:
 *  Your input <inputted number> as a second number.
 *
 *  Sum is <sum>
 *  Difference is <difference>
 *  Multiplication is <multiplication>
 *  Division is <division>
 *  “ *
 * Протестировать это приложение (найти слабые места, попробовать исправить).
 */
public class HomeWork1CorrMistakes {
    public static void main(String[] args) {
        int first;
        int second;

        System.out.print("Please input first number:");
        first = enterNumber();
        System.out.println("Your input " + first + " as a first number.");

        System.out.print("Please input second number:");
        second = enterNumber();
        System.out.println("Your input " + second + " as a first number.");

        System.out.println("Sum is " + (first + second));
        System.out.println("Difference is " + (first - second));
        System.out.println("Multiplication is " + (first * second));
        System.out.println("Division " + ((double)first / (double) second));


    }

     static int enterNumber(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputString = new StringBuilder("");
        int number;

        do {
            try {
                inputString.append( scanner.next());
                number = Integer.parseInt(inputString.toString());
                break;
            } catch ( NumberFormatException e) {

                System.out.println("You input NOT integer number!");
                System.out.println("You input: " + inputString );
                System.out.println("Please input first number:");
                inputString.delete(0,inputString.length());
            }
        } while (true) ;
        return number;
    }

}
