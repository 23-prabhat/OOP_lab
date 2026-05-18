/*
Aim:
Write a Java program to check whether three given non-negative integers
have the same rightmost digit.
*/

import java.util.Scanner;

public class Practical3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter three non-negative integers: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if (a < 0 || b < 0 || c < 0) {
                System.out.println("Please enter only non-negative integers.");
                return;
            }

            int lastDigitA = a % 10;
            int lastDigitB = b % 10;
            int lastDigitC = c % 10;

            if (lastDigitA == lastDigitB && lastDigitB == lastDigitC) {
                System.out.println("All three numbers have the same rightmost digit.");
            } else {
                System.out.println("The numbers do not have the same rightmost digit.");
            }
        }
    }
}

/*
Sample Input:
27 57 97

Sample Output:
Enter three non-negative integers: 27 57 97
All three numbers have the same rightmost digit.
*/
