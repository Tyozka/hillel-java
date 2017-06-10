package HomeWork3;

import java.util.Scanner;

public class sumInNumber{

    public static void main(String[] args) {
        int n;
        int result = 0;
        System.out.println("Enter Number");
        n = enterNumber();
        do{

            result = result + (n - (n/10)*10);
            n = n/10;
        }while(n > 0);

        System.out.println("Сумма цыфр в числе равна - " + result);
    }

    private static int enterNumber() {
        Scanner scanner = new Scanner(System.in);
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
