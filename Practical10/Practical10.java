/*
Aim:
Write a Java program to perform insertion, deletion and display
operations on a doubly linked list.
*/

import java.util.Scanner;

class Node {
    int data;
    Node previous;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    private Node head;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.previous = temp;
    }

    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element not found.");
            return;
        }

        if (temp.previous != null) {
            temp.previous.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.previous = temp.previous;
        }

        System.out.println("Element deleted: " + value);
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.print("Doubly Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Practical10 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DoublyLinkedList list = new DoublyLinkedList();

            while (true) {
                System.out.println("\nDoubly Linked List Operations");
                System.out.println("1. Insert");
                System.out.println("2. Delete");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter element to insert: ");
                        int value = scanner.nextInt();
                        list.insertAtEnd(value);
                    }
                    case 2 -> {
                        System.out.print("Enter element to delete: ");
                        int value = scanner.nextInt();
                        list.deleteByValue(value);
                    }
                    case 3 -> list.displayForward();
                    case 4 -> {
                        System.out.println("Program exited.");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}

/*
Sample Input:
1
10
1
20
3
2
10
3
4

Sample Output:
Doubly Linked List: 10 20
Element deleted: 10
Doubly Linked List: 20
*/
