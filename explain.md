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

## Practical 5: Constructor Passing Using Address, Student, and Employee

This program demonstrates constructor passing in Java.

### What constructor passing means

Constructor passing means passing one object as an argument to the constructor of another class.

In this practical:
- an `Address` object is created first
- that `Address` object is passed to the constructor of `Student`
- another `Address` object is passed to the constructor of `Employee`

This shows object-to-object relationship in OOP.

### Classes used in the program

The program uses four classes:
- `Address`
- `Student`
- `Employee`
- `Practical5`

### Address class

The `Address` class stores:
- `city`
- `state`
- `country`

```java
public Address(String city, String state, String country) {
    this.city = city;
    this.state = state;
    this.country = country;
}
```

This constructor initializes the address details when the object is created.

```java
public String getFullAddress() {
    return city + ", " + state + ", " + country;
}
```

This method combines all address parts into one formatted string.

### Student class

The `Student` class stores:
- `rollNumber`
- `name`
- `address`

```java
public Student(int rollNumber, String name, Address address) {
    this.rollNumber = rollNumber;
    this.name = name;
    this.address = address;
}
```

This constructor receives an `Address` object as a parameter.
That is the main concept of constructor passing in this practical.

```java
System.out.println("Address: " + address.getFullAddress());
```

This line uses the `Address` object stored inside `Student` and calls its method to print the full address.

### Employee class

The `Employee` class is similar to the `Student` class.
It stores:
- `employeeId`
- `name`
- `address`

```java
public Employee(int employeeId, String name, Address address) {
    this.employeeId = employeeId;
    this.name = name;
    this.address = address;
}
```

Here also, an `Address` object is passed to the constructor.

### Main method flow

The `main()` method works like this:

1. Create an address object for the student.
2. Pass that address object to the `Student` constructor.
3. Create an address object for the employee.
4. Pass that address object to the `Employee` constructor.
5. Display student details.
6. Display employee details.

### Important lines

```java
Address studentAddress = new Address("Pune", "Maharashtra", "India");
Student student = new Student(101, "Amit", studentAddress);
```

These lines create an `Address` object and pass it to the `Student` constructor.

```java
Address employeeAddress = new Address("Mumbai", "Maharashtra", "India");
Employee employee = new Employee(5001, "Sneha", employeeAddress);
```

These lines do the same for the `Employee` object.

### OOP concept used

This program demonstrates:
- constructor passing
- object composition or "has-a" relationship

`Student` has an `Address`

`Employee` has an `Address`

So instead of storing city, state, and country separately in every class, the program reuses the `Address` class.

### Why this approach is useful

- It avoids repeating the same address fields in multiple classes.
- It makes the code cleaner and easier to manage.
- It improves reusability because the same `Address` class can be used by many other classes.

### Example output

- Student roll number: `101`
- Student name: `Amit`
- Student address: `Pune, Maharashtra, India`
- Employee ID: `5001`
- Employee name: `Sneha`
- Employee address: `Mumbai, Maharashtra, India`

## Practical 6: Abstraction Using Shape, Circle, and Rectangle

This program demonstrates abstraction in Java using an abstract class named `Shape`.

### What abstraction means

Abstraction means showing only the essential behavior and hiding the internal implementation details.

In this practical:
- `Shape` tells that every shape must have `area()` and `perimeter()`
- but it does not define how they are calculated
- `Circle` and `Rectangle` provide their own implementations

### Classes used in the program

The program uses four main parts:
- `Shape` abstract class
- `Circle` class
- `Rectangle` class
- `Practical6` class with `main()`

### Shape abstract class

```java
abstract class Shape {
    public abstract double area();

    public abstract double perimeter();
}
```

This class is declared as `abstract`, so its object cannot be created directly.

It contains two abstract methods:
- `area()`
- `perimeter()`

These methods do not have a body here.
They only define a rule that every derived shape must implement them.

### Circle class

`Circle` extends `Shape`, so it must define both abstract methods.

```java
class Circle extends Shape {
    private final double radius;
```

This class stores the radius of the circle.

```java
public double area() {
    return Math.PI * radius * radius;
}
```

Formula used:
- Area of circle = `pi * r * r`

```java
public double perimeter() {
    return 2 * Math.PI * radius;
}
```

Formula used:
- Perimeter of circle = `2 * pi * r`

### Rectangle class

`Rectangle` also extends `Shape`.

```java
class Rectangle extends Shape {
    private final double length;
    private final double breadth;
}
```

This class stores length and breadth.

```java
public double area() {
    return length * breadth;
}
```

Formula used:
- Area of rectangle = `length * breadth`

```java
public double perimeter() {
    return 2 * (length + breadth);
}
```

Formula used:
- Perimeter of rectangle = `2 * (length + breadth)`

### Use of `@Override`

```java
@Override
public double area() { ... }
```

`@Override` tells that the method is overriding a method from the parent class.
It improves readability and helps the compiler detect mistakes.

### Main method flow

The `main()` method works like this:

1. Create a `Scanner` object to read input.
2. Read the radius of the circle.
3. Create a `Circle` object.
4. Read the length and breadth of the rectangle.
5. Create a `Rectangle` object.
6. Call `area()` and `perimeter()` for both objects.
7. Print the results using `printf`.

### Important lines

```java
Circle circle = new Circle(radius);
Rectangle rectangle = new Rectangle(length, breadth);
```

These lines create objects of the derived classes.

```java
System.out.printf("Circle Area: %.2f%n", circle.area());
```

`%.2f` prints the result in decimal format with 2 digits after the decimal point.

### OOP concept used

This program mainly demonstrates:
- abstraction
- inheritance
- method overriding

`Circle` is a `Shape`

`Rectangle` is a `Shape`

Both classes inherit from the abstract parent class and provide their own implementation for the same methods.

### Why abstraction is useful

- It defines a common structure for related classes.
- It ensures every shape implements required methods.
- It makes the code easier to extend in future.

For example, a `Triangle` class can also extend `Shape` and define its own `area()` and `perimeter()`.

### Example

If the input is:
- radius = `7`
- length = `10`
- breadth = `5`

Then:
- Circle area = `153.94`
- Circle perimeter = `43.98`
- Rectangle area = `50.00`
- Rectangle perimeter = `30.00`

## Practical 7: Swing Division Program with Exception Handling

This program creates a Java Swing GUI that divides two numbers and handles possible errors using exception handling.

### What the program does

The program:
- takes a numerator from the user
- takes a denominator from the user
- divides the numerator by the denominator when the button is clicked
- shows the result in a text field
- shows error messages if the input is invalid or division by zero is attempted

### Main concepts used

This practical demonstrates:
- Java Swing for GUI
- event handling
- exception handling

### Class declaration

```java
public class Practical7 extends JFrame implements ActionListener
```

This means:
- `extends JFrame` makes the class a window
- `implements ActionListener` allows the class to respond to button click events

### Components used in the GUI

The program uses:
- `JLabel` for labels
- `JTextField` for input and output
- `JButton` for the divide button
- `JPanel` for arranging components
- `JOptionPane` for error dialog boxes

### Instance variables

```java
private final JTextField numeratorField;
private final JTextField denominatorField;
private final JTextField resultField;
private final JButton divideButton;
```

These variables store references to the GUI components so they can be used throughout the class.

### Constructor

The constructor `Practical7()` builds the window and places the components.

```java
setTitle("Division Calculator");
setSize(400, 180);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
```

These lines:
- set the window title
- set the window size
- close the program when the window is closed
- place the window at the center of the screen

### Layout

```java
JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
```

This creates a panel with:
- 3 rows
- 2 columns
- 10 pixels horizontal gap
- 10 pixels vertical gap

The components are added in label-field pairs:
- Numerator label and text field
- Denominator label and text field
- Result label and text field

```java
resultField.setEditable(false);
```

This makes the result field read-only so the user cannot type into it.

### Button event registration

```java
divideButton = new JButton("Divide");
divideButton.addActionListener(this);
```

This creates the button and connects it to the current object so that `actionPerformed()` runs when the button is clicked.

### actionPerformed method

```java
public void actionPerformed(ActionEvent event)
```

This method is automatically called when the user clicks the Divide button.

Inside this method:

```java
double numerator = Double.parseDouble(numeratorField.getText().trim());
double denominator = Double.parseDouble(denominatorField.getText().trim());
```

These lines:
- read the text from the input fields
- remove extra spaces using `trim()`
- convert the text into `double`

### Division by zero check

```java
if (denominator == 0) {
    throw new ArithmeticException("Cannot divide by zero.");
}
```

This checks whether the denominator is zero.
If it is zero, the program manually throws an `ArithmeticException`.

### Division

```java
double result = numerator / denominator;
resultField.setText(String.valueOf(result));
```

If there is no error, the program performs the division and shows the result in the result field.

### Exception handling

The program uses three catch blocks.

#### NumberFormatException

```java
catch (NumberFormatException exception)
```

This handles invalid input such as letters or empty values instead of numbers.

It shows the message:
- `Please enter valid numeric values.`

#### ArithmeticException

```java
catch (ArithmeticException exception)
```

This handles division by zero.

It shows the message stored in the exception:
- `Cannot divide by zero.`

#### General Exception

```java
catch (Exception exception)
```

This is a general safety block for any unexpected error.

### JOptionPane

```java
JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error",
        JOptionPane.ERROR_MESSAGE);
```

This displays an error dialog box with:
- parent window
- message
- title
- error icon

### Main method

```java
SwingUtilities.invokeLater(() -> {
    Practical7 frame = new Practical7();
    frame.setVisible(true);
});
```

This creates and shows the GUI on the Swing event-dispatch thread, which is the correct way to start a Swing application.

### Program flow

1. The window is created.
2. The user enters numerator and denominator.
3. The user clicks the Divide button.
4. `actionPerformed()` runs.
5. Inputs are converted into numbers.
6. If input is invalid, an error message is shown.
7. If denominator is zero, an error message is shown.
8. Otherwise, the division result is displayed.

### Example

If the user enters:
- numerator = `20`
- denominator = `4`

Then the result field shows:
- `5.0`

If the user enters:
- numerator = `20`
- denominator = `0`

Then the program shows:
- `Cannot divide by zero.`

## Practical 8: Multithreading with Random Numbers, Square, and Cube

This program demonstrates multithreading in Java.

It generates random numbers one by one.
If the generated number is even, a new thread prints its square.
If the generated number is odd, a new thread prints its cube.

### Main concepts used

This practical demonstrates:
- multithreading
- random number generation
- thread creation using `Thread` class
- thread synchronization using `join()`

### Classes used in the program

The program uses four classes:
- `SquareThread`
- `CubeThread`
- `NumberGenerator`
- `Practical8`

### SquareThread class

```java
class SquareThread extends Thread {
    private final int number;
```

This class extends `Thread`, so it represents a separate thread of execution.
It stores one integer value.

```java
public void run() {
    System.out.println("Square of " + number + " = " + (number * number));
}
```

The `run()` method contains the work of the thread.
When this thread starts, it prints the square of the given number.

### CubeThread class

`CubeThread` is similar to `SquareThread`.

```java
public void run() {
    System.out.println("Cube of " + number + " = " + (number * number * number));
}
```

When this thread starts, it prints the cube of the given number.

### NumberGenerator class

```java
class NumberGenerator extends Thread {
    private final Random random = new Random();
}
```

This class also extends `Thread`.
Its job is to generate random numbers.

### Random number generation

```java
int number = random.nextInt(100);
```

This generates a random integer from `0` to `99`.

### Loop in NumberGenerator

```java
for (int i = 1; i <= 5; i++) {
```

This loop runs 5 times, so the program generates 5 random numbers.

For each number, the program prints:

```java
System.out.println("Generated number " + i + ": " + number);
```

### Even and odd check

```java
if (number % 2 == 0) {
    workerThread = new SquareThread(number);
} else {
    workerThread = new CubeThread(number);
}
```

This checks whether the number is even or odd:
- if even, create a `SquareThread`
- if odd, create a `CubeThread`

### Starting the worker thread

```java
workerThread.start();
```

This starts the selected thread.
If the number is even, the square thread runs.
If the number is odd, the cube thread runs.

### Use of `join()`

```java
workerThread.join();
```

`join()` makes the current thread wait until the worker thread finishes.

This means:
- first the number is generated
- then its square or cube is printed
- only after that, the next number is generated

So the output appears in an ordered way.

### Use of `sleep()`

```java
Thread.sleep(1000);
```

This pauses the `NumberGenerator` thread for 1000 milliseconds, which is 1 second.

This creates a small delay between two generated numbers.

### InterruptedException handling

```java
catch (InterruptedException exception) {
    Thread.currentThread().interrupt();
    System.out.println("Thread interrupted.");
    return;
}
```

This handles interruption while waiting or sleeping.

`Thread.currentThread().interrupt();` restores the interrupted status of the thread.

### Main class

```java
public class Practical8 {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        generator.start();
```

The `main()` method creates and starts the `NumberGenerator` thread.

### Main thread waiting

```java
generator.join();
```

This makes the main thread wait until the `NumberGenerator` thread completes all 5 iterations.

### Program flow

1. Main method creates a `NumberGenerator` thread.
2. The generator thread starts running.
3. It generates a random number.
4. It checks whether the number is even or odd.
5. It creates either `SquareThread` or `CubeThread`.
6. The worker thread prints the square or cube.
7. The generator waits for the worker thread to finish.
8. The generator sleeps for 1 second.
9. Steps repeat 5 times.
10. Main thread waits until the generator finishes.

### OOP and thread concept used

This program demonstrates:
- inheritance because all custom thread classes extend `Thread`
- runtime behavior through separate threads
- coordination between threads using `join()`

### Example

If the generated number is:
- `12`, output becomes `Square of 12 = 144`
- `17`, output becomes `Cube of 17 = 4913`

Since numbers are random, the output will be different each time the program runs.

## Practical 9: Student Record Management Using File Handling

This program demonstrates file handling in Java by storing and reading student records from a file.

### What the program does

The program:
- creates a file automatically if it does not exist
- shows a menu to the user
- allows adding student records
- allows viewing saved student records
- stores the records in a text file

### Main concepts used

This practical demonstrates:
- file creation
- file writing
- file reading
- menu-driven programming
- exception handling

### File name constant

```java
private static final String FILE_NAME = "students.txt";
```

This line stores the file name in a constant variable.
The file used by the program is `students.txt`.

### Creating the file

```java
File file = new File(FILE_NAME);
```

This creates a `File` object representing `students.txt`.

```java
if (file.createNewFile()) {
    System.out.println("Student record file created: " + file.getAbsolutePath());
}
```

`createNewFile()` creates the file only if it does not already exist.

If the file is newly created, the program prints its full path.

### Exception while creating file

```java
catch (IOException exception) {
    System.out.println("Unable to create file: " + exception.getMessage());
    return;
}
```

If file creation fails, the program prints an error and stops.

### Menu-driven loop

```java
while (true) {
```

This loop keeps the program running until the user chooses Exit.

The menu displayed is:
- `1. Add Student Record`
- `2. View Student Records`
- `3. Exit`

### Reading user choice

```java
int choice = scanner.nextInt();
scanner.nextLine();
```

`nextInt()` reads the menu choice.

`scanner.nextLine()` is used after `nextInt()` to clear the leftover newline character from the input buffer.

### Switch statement

```java
switch (choice) {
    case 1 -> addStudentRecord(scanner, file);
    case 2 -> viewStudentRecords(file);
    case 3 -> {
        System.out.println("Program exited.");
        return;
    }
    default -> System.out.println("Invalid choice. Try again.");
}
```

This handles the menu options:
- option 1 calls `addStudentRecord()`
- option 2 calls `viewStudentRecords()`
- option 3 exits the program
- any other number shows an invalid choice message

### addStudentRecord method

```java
private static void addStudentRecord(Scanner scanner, File file)
```

This method takes student details from the user and saves them into the file.

It asks for:
- roll number
- name
- marks

### Writing to the file

```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
```

This opens the file in append mode because of `true`.
So new records are added at the end without deleting old records.

```java
writer.write(rollNumber + "," + name + "," + marks);
writer.newLine();
```

This writes one student record in comma-separated format, for example:

`101,Riya,89`

Each record is stored on a new line.

### Why BufferedWriter is used

`BufferedWriter` improves writing efficiency and provides `newLine()` for moving to the next line.

### viewStudentRecords method

```java
private static void viewStudentRecords(File file)
```

This method reads records from the file and displays them.

### Reading the file

```java
try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
```

This opens the file for reading.

```java
while ((line = reader.readLine()) != null) {
```

This loop reads the file one line at a time until the end of the file.

### Splitting each record

```java
String[] record = line.split(",");
```

This splits the line into parts using the comma as separator.

For example:

`101,Riya,89`

becomes:
- `record[0] = 101`
- `record[1] = Riya`
- `record[2] = 89`

### Printing records

```java
if (record.length == 3) {
    System.out.println("Roll Number: " + record[0]
            + ", Name: " + record[1]
            + ", Marks: " + record[2]);
}
```

This checks that the record has exactly three parts and then prints them in a readable format.

### No records check

```java
boolean hasRecords = false;
```

This variable is used to check whether any valid record was found.

If no records are present, the program prints:
- `No records found.`

### Use of try-with-resources

Both reading and writing use try-with-resources:

```java
try (BufferedWriter writer = ...)
try (BufferedReader reader = ...)
```

This automatically closes the file after use.
It is safer and cleaner than closing files manually.

### Program flow

1. Create a `File` object for `students.txt`.
2. Create the file if it does not exist.
3. Show the menu in a loop.
4. If user selects `1`, read student details and save them.
5. If user selects `2`, read all stored records and display them.
6. If user selects `3`, exit the program.

### Example

If the user chooses:
- `1`
- roll number = `101`
- name = `Riya`
- marks = `89`

Then the program stores:

`101,Riya,89`

If the user later chooses `2`, the program displays:

- `Roll Number: 101, Name: Riya, Marks: 89`

## Practical 10: Doubly Linked List Operations

This program demonstrates insertion, deletion, and display operations on a doubly linked list in Java.

### What a doubly linked list is

A doubly linked list is a linear data structure in which each node contains:
- data
- a reference to the previous node
- a reference to the next node

This allows movement in both forward and backward directions.

### Main concepts used

This practical demonstrates:
- linked list data structure
- dynamic memory usage through objects
- insertion
- deletion
- traversal
- menu-driven programming

### Node class

```java
class Node {
    int data;
    Node previous;
    Node next;
}
```

Each node stores:
- `data` for the value
- `previous` for the previous node
- `next` for the next node

### Node constructor

```java
Node(int data) {
    this.data = data;
}
```

This constructor creates a node and stores the given value in it.

### DoublyLinkedList class

```java
class DoublyLinkedList {
    private Node head;
}
```

This class manages the linked list.
`head` points to the first node of the list.

### insertAtEnd method

```java
public void insertAtEnd(int data) {
    Node newNode = new Node(data);
```

This method creates a new node with the given value.

```java
if (head == null) {
    head = newNode;
    return;
}
```

If the list is empty, the new node becomes the head node.

```java
Node temp = head;
while (temp.next != null) {
    temp = temp.next;
}
```

This loop moves `temp` to the last node of the list.

```java
temp.next = newNode;
newNode.previous = temp;
```

These lines connect the new node at the end:
- last node's `next` points to the new node
- new node's `previous` points to the last node

### deleteByValue method

```java
public void deleteByValue(int value)
```

This method deletes the first node whose value matches the given input.

```java
if (head == null) {
    System.out.println("List is empty.");
    return;
}
```

If the list is empty, deletion is not possible.

```java
Node temp = head;
while (temp != null && temp.data != value) {
    temp = temp.next;
}
```

This loop searches for the node containing the required value.

```java
if (temp == null) {
    System.out.println("Element not found.");
    return;
}
```

If the value is not present in the list, the program prints a message and stops the deletion.

### Updating links during deletion

```java
if (temp.previous != null) {
    temp.previous.next = temp.next;
} else {
    head = temp.next;
}
```

This part handles the left-side connection:
- if the node is not the first node, previous node skips the current node
- if the node is the first node, `head` moves to the next node

```java
if (temp.next != null) {
    temp.next.previous = temp.previous;
}
```

This part handles the right-side connection:
- if there is a next node, its `previous` is updated

This is what actually removes the node from the list.

### displayForward method

```java
public void displayForward()
```

This method prints the list from left to right.

```java
if (head == null) {
    System.out.println("List is empty.");
    return;
}
```

If the list has no nodes, it prints that the list is empty.

```java
Node temp = head;
while (temp != null) {
    System.out.print(temp.data + " ");
    temp = temp.next;
}
```

This loop starts from the head and moves through each node using `next`.

### Main method

In `main()`, the program creates:

```java
Scanner scanner = new Scanner(System.in);
DoublyLinkedList list = new DoublyLinkedList();
```

Then it shows a menu inside an infinite loop.

Options are:
- `1. Insert`
- `2. Delete`
- `3. Display`
- `4. Exit`

### Switch statement

The `switch` statement performs actions based on user choice:
- insert a value at the end
- delete a value from the list
- display the list
- exit the program

### Program flow

1. Create an empty doubly linked list.
2. Show the menu repeatedly.
3. If the user chooses insert, create a node and add it at the end.
4. If the user chooses delete, search for the value and remove it.
5. If the user chooses display, print all elements from the beginning.
6. If the user chooses exit, stop the program.

### Example

If the user enters:
- insert `10`
- insert `20`
- display

Then output is:

- `Doubly Linked List: 10 20`

If the user then deletes `10`, the list becomes:

- `Doubly Linked List: 20`

## Practical 11: Traffic Light Simulation Using Java Swing

This program simulates a traffic light using Java Swing.

It shows three lights:
- red
- yellow
- green

When the user clicks the Start button, the lights change automatically after every 2 seconds.
When the user clicks the Stop button, the simulation pauses.

### Main concepts used

This practical demonstrates:
- Java Swing GUI
- custom painting using `JPanel`
- event handling
- timer-based animation

### Classes used in the program

The program uses two classes:
- `LightPanel`
- `Practical11`

### LightPanel class

`LightPanel` extends `JPanel`.
Its job is to draw the traffic lights.

```java
class LightPanel extends JPanel {
    private Color activeColor = Color.RED;
}
```

`activeColor` stores which light should currently glow.
Initially it is set to `Color.RED`, so the red light is shown first.

### setActiveColor method

```java
public void setActiveColor(Color activeColor) {
    this.activeColor = activeColor;
    repaint();
}
```

This method updates the current active light and calls `repaint()`.

`repaint()` tells Swing to draw the panel again with the new color.

### paintComponent method

```java
protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
```

This method is automatically called whenever the panel needs to be drawn.

`super.paintComponent(graphics);` clears the old drawing before drawing again.

The panel draws three circles using `fillOval()`:

```java
graphics.setColor(activeColor.equals(Color.RED) ? Color.RED : Color.LIGHT_GRAY);
graphics.fillOval(50, 20, 80, 80);
```

This draws the top light.
- if the active color is red, the circle becomes red
- otherwise it becomes light gray

The same logic is used for yellow and green lights.

So at any time:
- one light is active
- the other two appear inactive in gray color

### getPreferredSize method

```java
public Dimension getPreferredSize() {
    return new Dimension(180, 330);
}
```

This tells Swing the preferred size of the drawing panel.

### Practical11 class

```java
public class Practical11 extends JFrame implements ActionListener
```

This means:
- `extends JFrame` makes the class a window
- `implements ActionListener` allows the class to respond to timer events

### Instance variables

```java
private final LightPanel lightPanel;
private final JLabel statusLabel;
private final Timer timer;
private int state = 0;
```

These variables are used as follows:
- `lightPanel` displays the traffic lights
- `statusLabel` displays text like `STOP`, `READY`, or `GO`
- `timer` changes the light automatically after fixed time intervals
- `state` stores the current light number

### Constructor

The constructor builds the GUI window.

```java
setTitle("Traffic Light Simulation");
setSize(250, 430);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
```

These lines:
- set the window title
- set the window size
- close the program when the window is closed
- place the window at the center of the screen

### Creating components

```java
lightPanel = new LightPanel();
statusLabel = new JLabel("STOP", SwingConstants.CENTER);
timer = new Timer(2000, this);
```

- `lightPanel` creates the drawing area
- `statusLabel` starts with the text `STOP`
- `new Timer(2000, this)` creates a Swing timer that triggers every 2000 milliseconds, which is 2 seconds

### Buttons

```java
JButton startButton = new JButton("Start Simulation");
startButton.addActionListener(event -> timer.start());
```

When the Start button is clicked, the timer starts.

```java
JButton stopButton = new JButton("Stop Simulation");
stopButton.addActionListener(event -> timer.stop());
```

When the Stop button is clicked, the timer stops.

### Button panel

```java
JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
```

This creates a panel with:
- 1 row
- 2 columns
- 10 pixel horizontal gap
- 10 pixel vertical gap

The Start and Stop buttons are added to this panel.

### Adding components to the frame

```java
add(lightPanel, BorderLayout.CENTER);
add(statusLabel, BorderLayout.NORTH);
add(buttonPanel, BorderLayout.SOUTH);
```

This places:
- the traffic light panel in the center
- the status label at the top
- the buttons at the bottom

### actionPerformed method

```java
public void actionPerformed(ActionEvent event) {
    state = (state + 1) % 3;
```

This method runs every time the timer fires.

`state = (state + 1) % 3` changes the state in a cycle:
- `0`
- `1`
- `2`
- back to `0`

### Changing lights

```java
if (state == 0) {
    lightPanel.setActiveColor(Color.RED);
    statusLabel.setText("STOP");
} else if (state == 1) {
    lightPanel.setActiveColor(Color.YELLOW);
    statusLabel.setText("READY");
} else {
    lightPanel.setActiveColor(Color.GREEN);
    statusLabel.setText("GO");
}
```

This controls the light sequence:
- `0` means red light and `STOP`
- `1` means yellow light and `READY`
- `2` means green light and `GO`

Every 2 seconds the next state is selected.

### Main method

```java
SwingUtilities.invokeLater(() -> {
    Practical11 frame = new Practical11();
    frame.setVisible(true);
});
```

This creates and shows the GUI on the Swing event-dispatch thread, which is the correct way to start a Swing application.

### Program flow

1. The window opens with the red light active and status `STOP`.
2. The user clicks Start Simulation.
3. The timer starts.
4. Every 2 seconds, `actionPerformed()` runs.
5. The light changes in the order red -> yellow -> green -> red.
6. The label changes with the light as `STOP`, `READY`, and `GO`.
7. If the user clicks Stop Simulation, the timer stops and the current light remains visible.

### Important correction made

The program originally had a constructor error because the button listeners used `timer` before it was initialized.

It was fixed by creating the timer before attaching the Start and Stop button listeners:

```java
timer = new Timer(2000, this);
```

### Example behavior

When the program starts:
- red light is active
- label shows `STOP`

After clicking Start:
- after 2 seconds, yellow light appears with `READY`
- after the next 2 seconds, green light appears with `GO`
- after the next 2 seconds, red light appears again with `STOP`

## Practical 12: Quick Sort on an Array

This program sorts an array using the Quick Sort algorithm.

Quick Sort is a divide-and-conquer sorting technique.
It selects one element as a pivot, places that pivot in its correct sorted position, and then sorts the left and right parts recursively.

### Main concepts used

This practical demonstrates:
- arrays
- recursion
- partitioning
- sorting algorithm

### Methods used in the program

The program mainly uses three methods:
- `quickSort()`
- `partition()`
- `main()`

### quickSort method

```java
public static void quickSort(int[] array, int low, int high) {
    if (low < high) {
        int partitionIndex = partition(array, low, high);
        quickSort(array, low, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, high);
    }
}
```

This is the main recursive sorting method.

It works like this:
- check whether the current part of the array has more than one element
- find the correct position of the pivot using `partition()`
- sort the left side of the pivot
- sort the right side of the pivot

### Meaning of `low` and `high`

- `low` is the starting index of the current part of the array
- `high` is the ending index of the current part of the array

If `low < high` is false, it means the part has zero or one element, so it is already sorted.

### partition method

```java
public static int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;
```

This method selects the last element as the pivot.

`pivot = array[high]` means:
- the element at index `high` is used as the pivot

`i = low - 1` keeps track of the position where the next smaller element should go.

### Loop inside partition

```java
for (int j = low; j < high; j++) {
    if (array[j] <= pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
```

This loop checks each element from `low` to `high - 1`.

If `array[j] <= pivot`:
- increase `i`
- swap `array[i]` and `array[j]`

This ensures that:
- all elements less than or equal to pivot move to the left side
- larger elements stay on the right side

### Final pivot swap

```java
int temp = array[i + 1];
array[i + 1] = array[high];
array[high] = temp;
```

After the loop ends, the pivot is swapped into its correct position.

So:
- all smaller elements are on the left
- pivot is in the middle
- all larger elements are on the right

```java
return i + 1;
```

This returns the final index of the pivot.

### main method

The `main()` method handles input, sorting, and output.

```java
try (Scanner scanner = new Scanner(System.in)) {
```

This creates a `Scanner` object using try-with-resources, so it is automatically closed after use.

### Reading array size

```java
System.out.print("Enter the number of elements: ");
int n = scanner.nextInt();
```

This reads the number of elements.

```java
if (n <= 0) {
    System.out.println("Array size must be positive.");
    return;
}
```

This checks whether the array size is valid.
If the size is zero or negative, the program prints an error and stops.

### Reading array elements

```java
int[] array = new int[n];
System.out.println("Enter the elements:");
for (int i = 0; i < n; i++) {
    array[i] = scanner.nextInt();
}
```

This creates the array and reads each element from the user.

### Calling Quick Sort

```java
quickSort(array, 0, n - 1);
```

This sorts the full array.

Why `0` and `n - 1`:
- `0` is the first index
- `n - 1` is the last index

### Printing the sorted array

```java
for (int value : array) {
    System.out.print(value + " ");
}
```

This loop prints the sorted values one by one.

### How Quick Sort works on an example

Suppose the input array is:

`34 12 5 66 1`

First partition:
- pivot = `1`
- after partition, `1` moves to the beginning

Then the remaining right part is sorted again using the same logic.

Finally the array becomes:

`1 5 12 34 66`

### Program flow

1. Read the number of elements.
2. Check whether the size is valid.
3. Read all array elements.
4. Call `quickSort()` on the entire array.
5. `quickSort()` calls `partition()` to place the pivot correctly.
6. The left and right parts are sorted recursively.
7. Print the final sorted array.

### Important idea of recursion

Quick Sort uses recursion because the same sorting logic is applied repeatedly on smaller parts of the array.

For example:
- first sort the whole array
- then sort the left half
- then sort the right half
- then continue dividing until only single elements remain

### Example

If the input is:
- `5`
- `34 12 5 66 1`

Then the output is:
- `1 5 12 34 66`
