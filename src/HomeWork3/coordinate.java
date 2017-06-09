package HomeWork3;

import java.util.Scanner;

public class coordinate {

    public static void main(String[] args) {
        int x1, y1, x2, y2, x3, y3;
        System.out.println("Введите координаты x верхнего левого угла прямоугольника");
        x1 = enterNumber();
        System.out.println("Введите координаты y верхнего левого угла прямоугольника");
        y1 = enterNumber();
        System.out.println("Введите координаты x нижнего правого угла прямоугольника");
        x2 = enterNumber();
        System.out.println("Введите координаты y нижнего правого угла прямоугольника");
        y2 = enterNumber();

        System.out.println("Введите координаты x точки для поиска");
        x3 = enterNumber();
        System.out.println("Введите координаты y точки для поиска");
        y3 = enterNumber();

        if( (x3 <= x2)&&(x3 >= x1)&&(y3 <= y1)&&(y3 >= y2)){
            System.out.println("Точка лежит в прямоугольнике");
        } else {
            System.out.println("Точка находиться вне прямоугольника");
        }

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
