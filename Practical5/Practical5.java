/*
Aim:
Write a Java program to demonstrate constructor passing using
Address, Student and Employee classes.
*/

class Address {
    private final String city;
    private final String state;
    private final String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getFullAddress() {
        return city + ", " + state + ", " + country;
    }
}

class Student {
    private final int rollNumber;
    private final String name;
    private final Address address;

    public Student(int rollNumber, String name, Address address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
    }

    public void displayStudent() {
        System.out.println("Student Details");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address.getFullAddress());
    }
}

class Employee {
    private final int employeeId;
    private final String name;
    private final Address address;

    public Employee(int employeeId, String name, Address address) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
    }

    public void displayEmployee() {
        System.out.println("Employee Details");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address.getFullAddress());
    }
}

public class Practical5 {
    public static void main(String[] args) {
        Address studentAddress = new Address("Pune", "Maharashtra", "India");
        Student student = new Student(101, "Amit", studentAddress);

        Address employeeAddress = new Address("Mumbai", "Maharashtra", "India");
        Employee employee = new Employee(5001, "Sneha", employeeAddress);

        student.displayStudent();
        System.out.println();
        employee.displayEmployee();
    }
}

/*
Sample Output:
Student Details
Roll Number: 101
Name: Amit
Address: Pune, Maharashtra, India

Employee Details
Employee ID: 5001
Name: Sneha
Address: Mumbai, Maharashtra, India
*/
