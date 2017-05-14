package HomeWork2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Velev Vlad on 15.05.2017.
 */
public class AverageAnyNumbers {
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>() ;
        Scanner scanner = new Scanner(System.in);
        String input;
        int tempNum;

        System.out.println("This program Calc Average of any numbers that you input");
        System.out.println("Please input number. To the End input E.");

        do {
            input = scanner.next();
            if( input.toLowerCase().equals("e")){
                if(list.isEmpty()){
                    System.out.println("You didn't input numbers");
                    continue;
                }
                if (list.size() < 2) {
                    System.out.println("Please input min 2 numbers");
                    continue;
                }

            } else {
                try {
                    tempNum = Integer.parseInt(input);
                    list.add(tempNum);
                    continue;
                } catch (NumberFormatException e) {

                    System.out.println("You input NOT correct integer number!");
                    System.out.println("You input: " + input);
                    System.out.println("Please input correct number:");
                    continue;
                }
            }
            break;
        } while(true);

        int sum = 0;

        for (Integer num : list){
            sum += num;
        }

        System.out.println(" Average for input numbers is " + (double)sum / list.size() );
    }
}
