package HomeWork2;

import java.util.Scanner;

/**
 * Created by Влад on 17.05.2017.
 * Ввести число, определить простое ли оно.
 */
public class Task6SimpleNumber {
    public static void main(String[] args) {
        int num;
        Scanner scaner = new Scanner(System.in);
        System.out.println("Программа проверки числа. Является ли число простым");
        System.out.println("Введите число");
        num = enterNumber(scaner);

        for (int i = 2; i<Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println("Число не простое, оно делиться на:  " + i );
                return;
            }
        }
        System.out.println("Выше число: "+ num +" простое" );

    }

    private static int enterNumber(Scanner scanner) {

        StringBuilder inputString = new StringBuilder("");
        int number;

        do {
            try {
                inputString.append(scanner.next());
                number = Integer.parseInt(inputString.toString());
                if( number == 0 || number < 0 ){
                    System.out.println(" Число должно быть больше 0 ");
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {

                System.out.println("Вы ввели неправильное число!");
                System.out.println("Вы ввели: " + inputString);
                System.out.println("Пожалуйста, введите корректное число");
                inputString.delete(0, inputString.length());
            }
        } while (true);

        return number;
    }
}
