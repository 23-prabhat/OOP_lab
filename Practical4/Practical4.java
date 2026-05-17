/*
Aim:
Write a Java program to perform addition, subtraction and multiplication
of two complex numbers.
*/

import java.util.Scanner;

class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = (real * other.real) - (imaginary * other.imaginary);
        double newImaginary = (real * other.imaginary) + (imaginary * other.real);
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        }
        return real + " - " + Math.abs(imaginary) + "i";
    }
}

public class Practical4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first complex number:");
        System.out.print("Real part: ");
        double real1 = scanner.nextDouble();
        System.out.print("Imaginary part: ");
        double imaginary1 = scanner.nextDouble();

        System.out.println("Enter second complex number:");
        System.out.print("Real part: ");
        double real2 = scanner.nextDouble();
        System.out.print("Imaginary part: ");
        double imaginary2 = scanner.nextDouble();

        ComplexNumber first = new ComplexNumber(real1, imaginary1);
        ComplexNumber second = new ComplexNumber(real2, imaginary2);

        System.out.println("First complex number: " + first);
        System.out.println("Second complex number: " + second);
        System.out.println("Addition: " + first.add(second));
        System.out.println("Subtraction: " + first.subtract(second));
        System.out.println("Multiplication: " + first.multiply(second));
    }
}

/*
Sample Input:
2
3
4
5

Sample Output:
Enter first complex number:
Real part: 2
Imaginary part: 3
Enter second complex number:
Real part: 4
Imaginary part: 5
First complex number: 2.0 + 3.0i
Second complex number: 4.0 + 5.0i
Addition: 6.0 + 8.0i
Subtraction: -2.0 - 2.0i
Multiplication: -7.0 + 22.0i
*/
