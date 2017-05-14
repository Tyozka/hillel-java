package HomeWork1;

import java.util.Scanner;

/**
 * Created by Velev Vlad on 11.05.2017.
 * Создать простой (очень) калькулятор. Взаимодействие с пользователем по следующему сценарию:
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
 */
public class HomeWork1{
    public static void main(String[] args) {
        int first;
        int second;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input first number:");
        first = scanner.nextInt();
        System.out.println("Your input " + first + " as a first number.");

        System.out.print("Please input second number:");
        second = scanner.nextInt();
        System.out.println("Your input " + second + " as a first number.");

        System.out.println("Sum is " + (first + second));
        System.out.println("Difference is " + (first - second));
        System.out.println("Multiplication is " + (first * second));
        System.out.println("Division " + (first / second));


    }

}
