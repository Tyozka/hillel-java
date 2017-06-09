package HomeWork6;

import java.util.Scanner;

public class expandNumber{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        char[]arr =a.toCharArray();

        for(int i=arr.length-1; i>=0; i--){
            System.out.printf("%s", arr[i]);
        }
        System.out.println();
    }
}
