package Assignment3;

import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MathOperations math = new MathOperations();

        int choice;
        do {
            // Display menu
            System.out.println("\n=== Math Utility Menu ===");
            System.out.println("1. Print Table");
            System.out.println("2. Calculate Factorial");
            System.out.println("3. Check Prime");
            System.out.println("4. Print Fibonacci");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int num;
            switch (choice) {
                case 1:
                    System.out.print("Enter number to print table: ");
                    num = sc.nextInt();
                    math.printTable(num);
                    break;

                case 2:
                    System.out.print("Enter number to calculate factorial: ");
                    num = sc.nextInt();
                    math.calculateFactorial(num);
                    break;

                case 3:
                    System.out.print("Enter number to check prime: ");
                    num = sc.nextInt();
                    math.checkPrime(num);
                    break;

                case 4:
                    System.out.print("Enter number of terms for Fibonacci: ");
                    num = sc.nextInt();
                    math.printFibonacci(num);
                    break;

                case 5:
                    System.out.println("Thank you for using Math Utility App!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
