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
        StringBuilder firstS = new StringBuilder("");
        int second;
        StringBuilder secondS = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input first number:");
        do {
            try {
                firstS.append( scanner.next());
                first = Integer.parseInt(firstS.toString());
                break;
            } catch ( NumberFormatException e) {

                System.out.println("You input NOT integer number!");
                System.out.println("You input: " + firstS );
                System.out.println("Please input first number:");
                firstS.delete(0,firstS.length());
            }
        } while (true) ;


        System.out.println("Your input " + first + " as a first number.");

        System.out.print("Please input second number:");
        do {
            try {
                secondS.append( scanner.next());
                second = Integer.parseInt(secondS.toString());
                break;
            } catch ( NumberFormatException e) {

                System.out.println("You input NOT integer number!");
                System.out.println("You input: " + secondS );
                System.out.println("Please input second number:");
                secondS.delete(0 , secondS.length());
            }
        } while (true) ;


        System.out.println("Your input " + second + " as a first number.");

        System.out.println("Sum is " + (first + second));
        System.out.println("Difference is " + (first - second));
        System.out.println("Multiplication is " + (first * second));
        System.out.println("Division " + ((double)first / (double) second));


    }
}
