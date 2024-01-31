package org.ems;

import java.util.Scanner;

public class CalculateSalary {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the type of Employee");
        String typeOfEmployee = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + typeOfEmployee);

        if (typeOfEmployee.contains("Part")){
            Scanner employeeName = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the  partTimeEmployeeName");
            String nameOfEmployee = employeeName.nextLine();  // Read user input
            System.out.println("Username is: " + nameOfEmployee);


            Scanner empId = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the partTimeEmployee Id");
            String idOfEmployee = empId.nextLine();  // Read user input
            System.out.println("ID is: " + idOfEmployee);

           Employee empp = new PartTimeEmployee(Integer.valueOf(idOfEmployee), nameOfEmployee);
            System.out.println(empp);
        }
        else{
            Scanner employeeName = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the  fullTimeEmployeeName");
            String nameOfEmployee = employeeName.nextLine();  // Read user input
            System.out.println("Username is: " + nameOfEmployee);


            Scanner empId = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the fullTimeEmployee Id");
            String idOfEmployee = empId.nextLine();  // Read user input
            System.out.println("ID is: " + idOfEmployee);

            Employee empp = new FullTimeEmployee(Integer.valueOf(idOfEmployee), nameOfEmployee);
            System.out.println(empp);

        }
    }
}
