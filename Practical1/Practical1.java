/*
Aim:
Write a Java program to perform time conversion and display the result in HH:MM:SS format.
*/

import java.util.Scanner;

public class Practical1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter total number of seconds: ");
            int totalSeconds = scanner.nextInt();

            if (totalSeconds < 0) {
                System.out.println("Time cannot be negative.");
                return;
            }

            int hours = totalSeconds / 3600;
            int minutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;

            System.out.printf("Time in HH:MM:SS = %02d:%02d:%02d%n", hours, minutes, seconds);
        }
    }
}

/*
Sample Input:
3665

Sample Output:
Enter total number of seconds: 3665
Time in HH:MM:SS = 01:01:05
*/
