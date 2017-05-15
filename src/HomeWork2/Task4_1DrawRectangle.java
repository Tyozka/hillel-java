package HomeWork2;

import java.util.Scanner;

/**
 * Created by Velev Vlad on 15.05.2017.
 * Вывести на консоль графику (ширину и высоту задает пользователь) вида:
 а. Обычный прямоугольник
 **************
 *            *
 *            *
 *            *
 *            *
 **************
 */
public class Task4_1DrawRectangle {
    public static void main(String[] args) {
        int width, height, tempW, tempH;
        Scanner scaner = new Scanner(System.in);


        System.out.println("Программа рисования прямоугольника");

        System.out.println("Введите ширину прямоугольника");
        width = enterNumber(scaner);

        System.out.println("Введите высоту прямоугольника");
        height = enterNumber(scaner);

        String rectangle ="";

        for(int i = 0; i < height; i++){
            if (i == 0 || i == height-1){
                rectangle += createLine(width, true) +"\r\n";
            } else {
                rectangle += createLine(width, false) +"\r\n";
            }
        }
        System.out.println(rectangle);
    }

    private static String createLine(int width, boolean all){
        String str = "";
        if(width == 1){
            str="*";
            return str;
        }
        if(width == 2){
            str="**";
            return str;
        }
        if(all){
            for(int i = 0; i < width; i++) str+="*";
        } else {
            str = "*";
            for(int i = 0; i < width-2; i++) str+=" ";
            str += "*";
        }
        return str;
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
