package Assignment2;

import java.util.Scanner;

public class StringAssignmentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringUtility utility = new StringUtility();
        String inputStr;
        int choice;

        System.out.print("Enter a string: ");
        inputStr = sc.nextLine();

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Count Vowels and Consonants");
            System.out.println("2. Check if Palindrome");
            System.out.println("3. Reverse String");
            System.out.println("4. Convert to Uppercase");
            System.out.println("5. Convert to Lowercase");
            System.out.println("6. Replace Word");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Vowels: " + utility.countVowels(inputStr));
                    System.out.println("Consonants: " + utility.countConsonants(inputStr));
                    break;

                case 2:
                    if (utility.isPalindrome(inputStr))
                        System.out.println("It is a palindrome.");
                    else
                        System.out.println("It is not a palindrome.");
                    break;

                case 3:
                    System.out.println("Reversed String: " + utility.reverseString(inputStr));
                    break;

                case 4:
                    System.out.println("Uppercase: " + utility.toUpperCase(inputStr));
                    break;

                case 5:
                    System.out.println("Lowercase: " + utility.toLowerCase(inputStr));
                    break;

                case 6:
                    System.out.print("Enter word to replace: ");
                    String oldWord = sc.nextLine();
                    System.out.print("Enter new word: ");
                    String newWord = sc.nextLine();
                    inputStr = utility.replaceWord(inputStr, oldWord, newWord);
                    System.out.println("Updated String: " + inputStr);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
