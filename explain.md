# Practical Explanations

## Practical 1: Time Conversion (HH:MM:SS)

This program converts a total number of seconds into hours, minutes, and seconds.

### How it works

- It reads the total number of seconds from the user.
- It checks whether the value is negative. If it is negative, the program prints an error message and stops.
- It calculates hours by dividing total seconds by `3600`.
- It calculates remaining minutes by first finding the leftover seconds after hours using `% 3600`, then dividing by `60`.
- It calculates the final remaining seconds using `% 60`.
- It prints the result using `printf` in `HH:MM:SS` format.

### Important lines

```java
int hours = totalSeconds / 3600;
int minutes = (totalSeconds % 3600) / 60;
int seconds = totalSeconds % 60;
```

- `/` gives quotient.
- `%` gives remainder.

Example: `3665` seconds becomes `01:01:05`.

## Practical 2: Odd-Even Array Rearrangement

This program rearranges the array so that all even numbers come first and all odd numbers come after them.

### How it works

- It asks the user for the number of elements in the array.
- It checks whether the size is valid. If `n <= 0`, the program stops with an error message.
- It creates two arrays:
  - `array` to store the original input values
  - `result` to store the rearranged values
- It reads all array elements from the user.
- It loops through the original array two times:
  - First loop stores all even numbers in `result`
  - Second loop stores all odd numbers in `result`
- Finally, it prints the rearranged array.

### Important lines

```java
for (int value : array) {
    if (value % 2 == 0) {
        result[index++] = value;
    }
}
```

This loop checks each value:
- `value % 2 == 0` means the number is even.
- `result[index++] = value` stores the number in the `result` array and then increases `index`.

```java
for (int value : array) {
    if (value % 2 != 0) {
        result[index++] = value;
    }
}
```

This second loop adds all odd numbers after the even numbers.

### Why two loops are used

Two loops make the logic simple and beginner-friendly:
- first collect even numbers
- then collect odd numbers

Example:
- Input: `1 2 3 4 5 6`
- Output: `2 4 6 1 3 5`

## Practical 3: Same Rightmost Digit Checker

This program checks whether three non-negative integers have the same rightmost digit.

### How it works

- It takes three integers from the user.
- It checks whether any number is negative. If yes, the program prints an error message and stops.
- It finds the last digit of each number using the modulus operator `% 10`.
- It compares the last digits of all three numbers.
- If all last digits are equal, it prints that they have the same rightmost digit.
- Otherwise, it prints that they do not have the same rightmost digit.

### Important lines

```java
int lastDigitA = a % 10;
int lastDigitB = b % 10;
int lastDigitC = c % 10;
```

These statements find the last digit of each number.

Examples:
- `27 % 10 = 7`
- `57 % 10 = 7`
- `97 % 10 = 7`

```java
if (lastDigitA == lastDigitB && lastDigitB == lastDigitC) {
    System.out.println("All three numbers have the same rightmost digit.");
}
```

This condition checks whether:
- first digit equals second digit
- second digit equals third digit

If both are true, then all three last digits are the same.

### Example

- Input: `27 57 97`
- Last digits: `7, 7, 7`
- Output: `All three numbers have the same rightmost digit.`

## Practical 4: Complex Number Operations

This program performs addition, subtraction, and multiplication of two complex numbers.

### What is a complex number

A complex number is written in the form:

`a + bi`

where:
- `a` is the real part
- `b` is the imaginary part

Example: `2 + 3i`

### How the program is organized

The program uses two classes:
- `ComplexNumber`
- `Practical4`

`ComplexNumber` stores the real and imaginary parts and provides methods for operations.
`Practical4` contains the `main()` method and handles user input and output.

### Constructor

```java
public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
}
```

This constructor is used to create a complex number object with a real part and an imaginary part.

### Addition

```java
public ComplexNumber add(ComplexNumber other) {
    return new ComplexNumber(real + other.real, imaginary + other.imaginary);
}
```

Formula:
- `(a + bi) + (c + di) = (a + c) + (b + d)i`

### Subtraction

```java
public ComplexNumber subtract(ComplexNumber other) {
    return new ComplexNumber(real - other.real, imaginary - other.imaginary);
}
```

Formula:
- `(a + bi) - (c + di) = (a - c) + (b - d)i`

### Multiplication

```java
public ComplexNumber multiply(ComplexNumber other) {
    double newReal = (real * other.real) - (imaginary * other.imaginary);
    double newImaginary = (real * other.imaginary) + (imaginary * other.real);
    return new ComplexNumber(newReal, newImaginary);
}
```

Formula:
- `(a + bi)(c + di) = (ac - bd) + (ad + bc)i`

### Displaying the complex number

```java
public String toString() {
    if (imaginary >= 0) {
        return real + " + " + imaginary + "i";
    }
    return real + " - " + Math.abs(imaginary) + "i";
}
```

This method converts the object into a readable form like `2.0 + 3.0i`.
If the imaginary part is negative, it prints properly as subtraction.

### Main method flow

- Read the real and imaginary parts of the first complex number.
- Read the real and imaginary parts of the second complex number.
- Create two `ComplexNumber` objects.
- Call `add()`, `subtract()`, and `multiply()`.
- Print the results.

### Example

For:
- First number = `2 + 3i`
- Second number = `4 + 5i`

Results:
- Addition = `6 + 8i`
- Subtraction = `-2 - 2i`
- Multiplication = `-7 + 22i`
