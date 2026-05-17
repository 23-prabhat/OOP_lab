/*
Aim:
Write a Java program for Student Record Management using file handling.
The program should create the file automatically if it does not exist.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practical9 {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File(FILE_NAME);

        try {
            if (file.createNewFile()) {
                System.out.println("Student record file created: " + file.getAbsolutePath());
            }
        } catch (IOException exception) {
            System.out.println("Unable to create file: " + exception.getMessage());
            return;
        }

        while (true) {
            System.out.println("\nStudent Record Management");
            System.out.println("1. Add Student Record");
            System.out.println("2. View Student Records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudentRecord(scanner, file);
                case 2 -> viewStudentRecords(file);
                case 3 -> {
                    System.out.println("Program exited.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudentRecord(Scanner scanner, File file) {
        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student marks: ");
        String marks = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(rollNumber + "," + name + "," + marks);
            writer.newLine();
            System.out.println("Student record added successfully.");
        } catch (IOException exception) {
            System.out.println("Error writing to file: " + exception.getMessage());
        }
    }

    private static void viewStudentRecords(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean hasRecords = false;

            System.out.println("\nStored Student Records:");
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                if (record.length == 3) {
                    System.out.println("Roll Number: " + record[0]
                            + ", Name: " + record[1]
                            + ", Marks: " + record[2]);
                    hasRecords = true;
                }
            }

            if (!hasRecords) {
                System.out.println("No records found.");
            }
        } catch (IOException exception) {
            System.out.println("Error reading file: " + exception.getMessage());
        }
    }
}

/*
Sample Input:
1
101
Riya
89
2
3

Sample Output:
Student Record Management
1. Add Student Record
2. View Student Records
3. Exit
Enter your choice: 1
Enter student roll number: 101
Enter student name: Riya
Enter student marks: 89
Student record added successfully.
*/
