package chapter1;

import java.util.Scanner;

public class TheTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            while(true) {
                int numStudents = sc.nextInt();
                if(numStudents == 0) break;

                double[] payments = new double[numStudents];
                double total = 0;
                for(int i = 0; i < numStudents; i++) {
                    payments[i] = sc.nextDouble();
                    total += payments[i];
                }

                double avg = total / (double) numStudents;
                avg = Math.round(avg * 100.0) / 100.0;

                double high = 0;
                double low = 0;
                for(int i = 0; i < numStudents; i++) {
                    double diff = payments[i] - avg;
                    if(diff < 0) {
                        low -= diff;
                    } else {
                        high += diff;
                    }
                }

                double result;
                if(low > high) {
                    result = low;
                } else {
                    result = high;
                }

                System.out.println(result);

            }
        } catch(Exception e) {
            // Do NOTHING
        }
    }
}