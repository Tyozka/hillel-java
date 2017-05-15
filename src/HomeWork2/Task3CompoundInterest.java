package HomeWork2;

import java.util.Scanner;

/**
 * Created by Влад on 15.05.2017.
 * Программу, которая предлагает пользователю ввести сумму денежного вклада в гривнах, процент годовых, которые выплачивает банк, длительность вклада (лет).
 * Вывести накопленную сумму денег за каждый год и начисленные проценты.
 */
public class Task3CompoundInterest {


    public static void main(String[] args) {
        double deposit; // депозит в грн
        double percent; // процент
        int years; // количество лет
        Scanner scanner = new Scanner(System.in);

        System.out.println("Программа подсчета процентов по взносу с ежемесячной капитализацией процентов");
        System.out.println("Введите сумму деннежного вклада");
        deposit = enterNumberD(scanner);
        System.out.println("Введите процент годовых");
        percent = enterNumberD(scanner);
        System.out.println("Введите длительность вклада  (лет)");
        years = enterNumberI(scanner);

        System.out.println("Через " + years + " лет(года) Ваш доход будет составлять: - " + depositPercent(deposit, percent, years) + " грн" );
        System.out.println("Всего на Вашем счету будет: - " + (deposit + depositPercent(deposit, percent, years)) + " грн" );


        System.out.println("Подробный расчет за каждый год");
        System.out.println("____________________________________________________________________________________________");
        System.out.println("| Начальная сумма | Год | Доход с депозита |  Денег на счету  | Процент от начальной суммы |");
        System.out.println("|-----------------|-----|------------------|------------------|----------------------------|");
        for (int i = 1; i <= years ; i++ ){
            double deposTemp = depositPercent(deposit, percent, i);
            System.out.print( formatOut(deposit, 17, " грн"));
            System.out.print( formatOut(i, 5));
            System.out.print( formatOut(deposTemp, 18, " грн", true));
            System.out.print( formatOut(Math.rint(100* (deposit + deposTemp))/100, 18, " грн",true));
            System.out.print( formatOut(Math.rint(100* (deposTemp*100/deposit)  )/100, 28, " %"));
            System.out.println( "|");
        }

        System.out.println("|------------------------------------------------------------------------------------------|");





    }

    private static String formatOut(double number, int chars, String simbol , boolean leftFormat) {
        StringBuilder str = new StringBuilder();
        String num = new Double(number).toString() + simbol;
        str.append("|");

        if( (chars - num.length()) % 2 >= 1 ){
            StringBuilder str1 = new StringBuilder();
            for(int i = 0, len = (chars - num.length()) / 2 ; i < len; i++ ){
                str1.append(" ");
            }

            if (leftFormat){
                str.append(str1)
                        .append(num)
                        .append(str1)
                        .append(" ");
            } else {
                str.append(" ").append(str1)
                        .append(num)
                        .append(str1);

            }
            return str.toString();
        } else {
            StringBuilder str1 = new StringBuilder();
            for(int i = 0, len = (chars - num.length()) / 2 ; i < len; i++ ){
                str1.append(" ");
            }
            str.append(str1)
                    .append(num)
                    .append(str1);
            return str.toString();
        }
    }

    private static String formatOut(double number, int chars, String simbol) {
        StringBuilder str = new StringBuilder();
        String num = new Double(number).toString() + simbol;
        str.append("|");

        if( (chars - num.length()) % 2 >= 1 ){
            StringBuilder str1 = new StringBuilder();
            for(int i = 0, len = (chars - num.length()) / 2 ; i < len; i++ ){
                str1.append(" ");
            }
            str.append(" ")
                    .append(str1)
                    .append(num)
                    .append(str1);
            return str.toString();
        } else {
            StringBuilder str1 = new StringBuilder();
            for(int i = 0, len = (chars - num.length()) / 2 ; i < len; i++ ){
                str1.append(" ");
            }
            str.append(str1)
                    .append(num)
                    .append(str1);
            return str.toString();
        }




    }

    private static String formatOut(double number, int chars) {
        StringBuilder str = new StringBuilder();
        String num = new Double(number).toString() ;
        str.append("|");

        if( (chars - num.length()) % 2 >= 1 ){
            StringBuilder str1 = new StringBuilder();
            for(int i = 0, len = (chars - num.length()) / 2 ; i < len; i++ ){
                str1.append(" ");
            }
            str.append(" ")
                    .append(str1)
                    .append(num)
                    .append(str1);
            return str.toString();
        } else {
            StringBuilder str1 = new StringBuilder();
            for(int i = 0, len = (chars - num.length()) / 2 ; i < len; i++ ){
                str1.append(" ");
            }
            str.append(str1)
                    .append(num)
                    .append(str1);
            return str.toString();
        }
    }


    private static double depositPercent(double deposit, double percent, int years ){
        // = Deposit*(1+ %/100/12)^Years*12 - D)
        return Math.rint(100*(deposit * Math.pow( 1+ percent/1200, years * 12)  - deposit) )/100;
    }

    private static int enterNumberI(Scanner scanner) {


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

    private static double enterNumberD(Scanner scanner) {

        StringBuilder inputString = new StringBuilder("");
        double number;

        do {
            try {
                inputString.append(scanner.next());
                number = Double.parseDouble(inputString.toString());
                break;
            } catch (NumberFormatException e) {

                System.out.println("You input NOT correct Double number!");
                System.out.println("You input: " + inputString);
                System.out.println("Please input correct number:");
                inputString.delete(0, inputString.length());
            }
        } while (true);

        return number;
    }
}

