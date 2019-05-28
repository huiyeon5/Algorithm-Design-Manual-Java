package chapter1;

public class IntegerDivision {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        
        System.out.println(divide(10, 5));
    }

    public static int divide(int n1, int n2) {
        while(n1 >= n2) {
            n1 = n1 - n2;
        }

        return n1;
    }
}