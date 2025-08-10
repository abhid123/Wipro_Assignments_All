package com.client;

import java.util.Scanner;

import com.service.Services;

public class client {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		Services sobj = new Services();
		
		int choice = 0;
		
		do
		{
			System.out.println("---Department Management System---");
			System.out.println("~: SELECT ONE OF THE BELOW :~");
			System.out.println("1. Adding New Department");
			System.out.println("2. Get Department by ID");
			System.out.println("3. Get All Departments");
			System.out.println("4. Update Department");
			System.out.println("5. Delete Department by ID");
			System.out.println("6. Exit");
			
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					sobj.addNewDepartment();
					break;
				case 2:
					sobj.getSingleDepartment();
					break;
				case 3:
					sobj.getAllDepartment();
					break;
				case 4:
					sobj.updateDepartment();
					break;
				case 5:
					sobj.deleteDepartment();
					break;
				case 6:
					System.out.println("---Thank you for Visiting---");
					break;
				default:
					System.out.println("You Entered Wrong Choice");
				
			}
		}
		while(choice !=6);
		
	}

}
