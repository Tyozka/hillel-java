package HomeWork2;

import java.util.Scanner;

/**
 * Created by Влад on 17.05.2017.
 * Программа проверки числа на четность
 */
public class Task5EvenNumber {
        public static void main(String[] args) {
            int num;
            Scanner scaner = new Scanner(System.in);
            System.out.println("Программа проверки числа на четность");
            System.out.println("Введите число");
            num = enterNumber(scaner);

            if(num % 2 == 1){
                System.out.println("Вы ввели нечетное число");
            } else
                System.out.println("Вы ввели четное число");

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

