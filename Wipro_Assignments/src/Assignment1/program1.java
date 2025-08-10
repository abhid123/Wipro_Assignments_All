package Assignment1;

import java.util.Scanner;

public class program1 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in); 
	        char continueChoice; 

	        do {
	            System.out.println("\n MENU ");
	            System.out.println("1. Print Table of a Number");
	            System.out.println("2. Calculate Factorial");
	            System.out.println("3. Check Prime Number");
	            System.out.println("4. Print Fibonacci Series");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            switch(choice) {
	            case 1:
	            	System.out.println("Enter  the Number Which you want table");
	            	int Tablechoice = sc.nextInt();
	            	for(int i=1 ;i<=10;i++) {
	            		int table = Tablechoice*i;
	            		System.out.println(Tablechoice + "X" + i  +"=" + table);
	            	}
	            	break;
	            case 2: 
	            	System.out.println("Enter the Number ");
	            	int num =sc.nextInt();
	            	int fact =1;
	            	for(int i=1;i<=num;i++) {
	            		fact=fact*i;
	            	}
	            	System.out.println(fact);
	            	break;
	            case 3:
	            	System.out.println("Enter the Number ");
	            	int number =sc.nextInt();
	            	if(number<=1) {
	            		System.out.println("The number is not prime ");
	            	}
	            	else {
	            		int i=2;
	            		while(i<=number/2) {
	            			if (number % i == 0) {
	                           
	                            System.out.println(number + " is NOT a Prime Number.");
	                            return;  
	                        }
	                        i++; 
	                    }
	                    System.out.println(number + " is a Prime Number.");
	            		}
	            		break;
	            case 4:
	            	
	            	System.out.println("enter the number");
	            	int n = sc.nextInt();
	            	int a =0 ;
	            	int b=1;
	            	for(int i=1;i<=n;i++) {
	            		 System.out.print(a + " ");
	            		 int next = a+b;
	            		 a=b;
	            		 b=next;	 
	            	}
	            	System.out.println();
                   break;
	            	
	            case 5:
                   
                   System.out.println("Exiting... Thank you!");
                   sc.close();
                   return; 

               default:
                   System.out.println("Invalid choice. Please select 1 to 5.");
	            	}
	            
	            System.out.print("\nBack to Menu? (Y/N): ");
	            sc.nextLine();
	            continueChoice = sc.next().charAt(0);
	            
	       	
	            	} while (continueChoice == 'Y' || continueChoice == 'y');
	            }
}
