package chapter2;

import java.util.Scanner;

public class PrimaryArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            while(true) {
                String[] values = sc.nextLine().split(" ");

                if(values[0].equals("0") && values[0].equals("0")) break;

                int totalCarry = 0;
                int lastCarry = 0;

                int shorter = values[0].length() > values[1].length() ? values[1].length() : values[0].length();

                for(int i = shorter - 1; i >= 0; i--) {
                    int currVal = Integer.valueOf("" + values[0].charAt(i)) + Integer.valueOf("" + values[1].charAt(i)) + lastCarry;

                    int currCarry = currVal / 10;
                    lastCarry = currCarry;
                    totalCarry = currCarry > 0 ? totalCarry + 1 : totalCarry;
                }

                System.out.println("Carried " + totalCarry +" times.");
            }
        } catch(Exception e) {
            // DO NOTHING
        }
    }
}