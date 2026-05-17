/*
Aim:
Write a Java program to sort an array using Quick Sort.
*/

import java.util.Scanner;

public class Practical12 {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Array size must be positive.");
            return;
        }

        int[] array = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        quickSort(array, 0, n - 1);

        System.out.println("Sorted array:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

/*
Sample Input:
5
34 12 5 66 1

Sample Output:
Enter the number of elements: 5
Enter the elements:
34 12 5 66 1
Sorted array:
1 5 12 34 66
*/
