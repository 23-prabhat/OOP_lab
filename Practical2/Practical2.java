/*
Aim:
Write a Java program to rearrange an array so that all even numbers come first,
followed by all odd numbers.
*/

import java.util.Scanner;

public class Practical2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Array size must be positive.");
                return;
            }

            int[] array = new int[n];
            int[] result = new int[n];
            int index = 0;

            System.out.println("Enter the array elements:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            for (int value : array) {
                if (value % 2 == 0) {
                    result[index++] = value;
                }
            }

            for (int value : array) {
                if (value % 2 != 0) {
                    result[index++] = value;
                }
            }

            System.out.println("Rearranged array:");
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

/*
Sample Input:
6
1 2 3 4 5 6

Sample Output:
Enter the number of elements: 6
Enter the array elements:
1 2 3 4 5 6
Rearranged array:
2 4 6 1 3 5
*/
