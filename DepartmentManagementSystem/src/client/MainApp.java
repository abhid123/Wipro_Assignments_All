package client;

import model.Department;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import exception.DepartmentNotFoundException;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentService service = new DepartmentServiceImpl();

        while (true) {
            System.out.println("\n---- Department Management System ----");
            System.out.println("1. Add Department");
            System.out.println("2. Get Department by ID");
            System.out.println("3. Get All Departments");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Department");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Location: ");
                    service.addDepartment(new Department(sc.nextInt(), sc.next(), sc.next()));
                    System.out.println("Department added.");
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    try {
                        Department d = service.getDepartmentById(sc.nextInt());
                        System.out.println(d);
                    } catch (DepartmentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    for (Department d : service.getAllDepartments()) {
                        System.out.println(d);
                    }
                    break;
                case 4:
                    System.out.print("Enter ID, New Name, New Location: ");
                    try {
                        service.updateDepartment(new Department(sc.nextInt(), sc.next(), sc.next()));
                        System.out.println("Department updated.");
                    } catch (DepartmentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    try {
                        service.deleteDepartment(sc.nextInt());
                        System.out.println("Department deleted.");
                    } catch (DepartmentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
