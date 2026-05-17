/*
Aim:
Write a Java program using multithreading to generate random numbers.
If the number is even, print its square in a new thread.
If the number is odd, print its cube in a new thread.
*/

import java.util.Random;

class SquareThread extends Thread {
    private final int number;

    public SquareThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Square of " + number + " = " + (number * number));
    }
}

class CubeThread extends Thread {
    private final int number;

    public CubeThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Cube of " + number + " = " + (number * number * number));
    }
}

class NumberGenerator extends Thread {
    private final Random random = new Random();

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            int number = random.nextInt(100);
            System.out.println("Generated number " + i + ": " + number);

            Thread workerThread;
            if (number % 2 == 0) {
                workerThread = new SquareThread(number);
            } else {
                workerThread = new CubeThread(number);
            }

            workerThread.start();

            try {
                workerThread.join();
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted.");
                return;
            }
        }
    }
}

public class Practical8 {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        generator.start();

        try {
            generator.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }
    }
}

/*
Sample Output:
Generated number 1: 12
Square of 12 = 144
Generated number 2: 17
Cube of 17 = 4913
...
*/
