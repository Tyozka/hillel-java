package HomeWork2;

import java.util.Scanner;
/**
 * Created by Velev Vlad on 15.05.2017.
 * Новое требование от заказчика калькулятора - переделать калькулятор,
 * чтобы при неправильном вводе чисел программа запрашивала число заново и пользователь сам вводил операцию (+-* /)
 */
public class CalcNew {
    public static void main(String[] args) {
        int first;
        int second;
        Scanner scanner = new Scanner(System.in);
        String operation;

        System.out.print("Please input first number:");
        first = enterNumber(scanner);
        System.out.println("Your input " + first + " as a first number.");

        System.out.print("Please input second number:");
        second = enterNumber(scanner);
        System.out.println("Your input " + second + " as a first number.");


        System.out.println("Please input operations (+ - * /)");

        do {
            operation = scanner.next();

            switch (operation){
                case "+" :
                    System.out.println("Sum is " + (first + second));
                    break;
                case "-" :
                    System.out.println("Difference is " + (first - second));
                    break;
                case "*" :
                    System.out.println("Multiplication is " + (first * second));
                    break;
                case "/" :
                    System.out.println("Division " + ((double) first / (double) second));
                    break;

                default:
                    System.out.println("You input NOT correct operation");
                    System.out.println("Please input correct operation");
                    continue;



            }

            break;
        } while (true);
    }



    private static int enterNumber(Scanner scanner) {

        StringBuilder inputString = new StringBuilder("");
        int number;

        do {
            try {
                inputString.append(scanner.next());
                number = Integer.parseInt(inputString.toString());
                break;
            } catch (NumberFormatException e) {

                System.out.println("You input NOT correct integer number!");
                System.out.println("You input: " + inputString);
                System.out.println("Please input correct number:");
                inputString.delete(0, inputString.length());
            }
        } while (true);

        return number;
    }
}