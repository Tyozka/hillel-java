package HomeWork2;

import java.util.Scanner;

/**
 * Created by Velev Vlad on 15.05.2017.
 */
public class AverageOfTwo {
    public static void main(String[] args) {
        int first;
        int second;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input first number:");
        first = enterNumber(scanner);


        System.out.print("Please input second number:");
        second = enterNumber(scanner);

        System.out.println("Average of " + first + " and "+ second + " is " + (double)(first +second)/2 );
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
