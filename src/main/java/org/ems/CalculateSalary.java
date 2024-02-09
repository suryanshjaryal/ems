package org.ems;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CalculateSalary {
    public static void main(String[] args) {

    DbConnection dbConnection=new DbConnection();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the type of Employee");
        String typeOfEmployee = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + typeOfEmployee);

        if (typeOfEmployee.contains("Part")){
       //   Scanner employeeName = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the  partTimeEmployeeName");
            String nameOfEmployee =myObj.nextLine();  // Read user input
            System.out.println("Username is: " + nameOfEmployee);


         // Scanner empId = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the partTimeEmployee Id");
            String idOfEmployee = myObj.nextLine();  // Read user input
            System.out.println("ID is: " + idOfEmployee);

            System.out.println("Enter the typeOfEmployee Id");
            String employeeType  = myObj.nextLine();  // Read user input
            System.out.println("employeeType is: " + employeeType);


            Employee empp = new PartTimeEmployee(Integer.valueOf(idOfEmployee), nameOfEmployee,typeOfEmployee,null,null);
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

            try (Connection connection = dbConnection.getConnection()) {
            //  String createQuery="CREATE TABLE employee (id INT NOT NULL, name VARCHAR(50) NOT NULL)";
                Statement statement=connection.createStatement();
            //  statement.execute(createQuery);
                String query="INSERT INTO employee (id, name,typeOfEmployee,salary,address)"
                        + "values('" + empp.getId() + "','" + empp.getName()+ "','"+empp.getTypeOfEmployee()+ "','"+empp.getSalary()+ "','"+empp.getAddress()
                        + "')";

                statement.executeUpdate(query);
                System.out.println("Successfully connected to the H2 database.");

                String selectQuery="Select * from employee";
            //  ResultSet result= statement.executeQuery(selectQuery);
              //System.out.println(result);
        } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
}