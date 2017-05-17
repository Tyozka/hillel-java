package HomeWork2;

import java.util.Scanner;

/**
 * Created by Velev Vlad on 15.05.2017.
 * Вывести на консоль графику (ширину и высоту задает пользователь) вида:
 б. Конверт (рекомендую сначала нарисовать одну диагональ, а потом вторую)
 *******
 **   **
 * * * *
 *  *  *
 * * * *
 **   **
 *******
 */
public class Task4_2DrawEnvelope {
    public static void main(String[] args) {
        int width, height;
        int center;
        Scanner scaner = new Scanner(System.in);


        System.out.println("Программа рисования конверта");

        System.out.println("Введите ширину конверта");
        width = enterNumber(scaner);

        System.out.println("Введите высоту конверта");
        height = enterNumber(scaner);

        String rectangle ="";
        for(int i = 0; i < height; i++){
            rectangle +=  createLine(i, width, height ) + "\r\n";
        }

        System.out.println(rectangle);

    }


    private static String createLine(int row, int width, int height){
        String line="";
        if(row == 0 || row ==  height - 1){
            for(int t = 0; t < width; t++){
                line+="*";
            }
            return line;
        }
        line+="*";
        for (int i = 1 ; i < width - 1 ; i++ ){
            if( i == row | width - i - 1 == row){
                line+="*";
            } else{
                line+=" ";
            }

        }
        line+="*";






        return line;


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
