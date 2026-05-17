/*
Aim:
Write a Java program to demonstrate abstraction using an abstract Shape class
and derived classes Circle and Rectangle.
*/

import java.util.Scanner;

abstract class Shape {
    public abstract double area();

    public abstract double perimeter();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return length * breadth;
    }

    @Override
    public double perimeter() {
        return 2 * (length + breadth);
    }
}

public class Practical6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);

        System.out.print("Enter length of rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter breadth of rectangle: ");
        double breadth = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(length, breadth);

        System.out.printf("Circle Area: %.2f%n", circle.area());
        System.out.printf("Circle Perimeter: %.2f%n", circle.perimeter());
        System.out.printf("Rectangle Area: %.2f%n", rectangle.area());
        System.out.printf("Rectangle Perimeter: %.2f%n", rectangle.perimeter());
    }
}

/*
Sample Input:
7
10
5

Sample Output:
Enter radius of circle: 7
Enter length of rectangle: 10
Enter breadth of rectangle: 5
Circle Area: 153.94
Circle Perimeter: 43.98
Rectangle Area: 50.00
Rectangle Perimeter: 30.00
*/
