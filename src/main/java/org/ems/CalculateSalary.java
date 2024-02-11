package org.ems;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CalculateSalary {
    public static void main(String[] args) {
        String json = null;
        Employee empp;

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

            System.out.println("Enter the typeOfEmployee ");
            String employeeType  = myObj.nextLine();  // Read user input
            System.out.println("employeeType is: " + employeeType);

            System.out.println("Enter the working hours of employee ");
            String workingHours  = myObj.nextLine();  // Read user input
            System.out.println("employeeworkinghour is: " + workingHours);

            System.out.println("Enter the house no of employee ");
            String houseNo  = myObj.nextLine();  // Read user input
            System.out.println("HOUSE NO IS: " + houseNo);

            System.out.println("Enter the zipcode of employee ");
            String zipCode  = myObj.nextLine();  // Read user input
            System.out.println("ZIPCODE IS: " + zipCode);

            System.out.println("Enter the state of employee ");
            String state  = myObj.nextLine();  // Read user input
            System.out.println("STATE OF EMPLOYEE IS: " + state);

            System.out.println("Enter the country of employee ");
            String country  = myObj.nextLine();  // Read user input
            System.out.println("COUNTRY  IS: " + country);

            Address address=new Address(houseNo,zipCode,state,country);

         json=new Gson().toJson(address);
            
             empp = new PartTimeEmployee(Integer.valueOf(idOfEmployee), nameOfEmployee,typeOfEmployee,Double.valueOf(workingHours),address);
            System.out.println(empp);
        }
        else {
            Scanner employeeName = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the  fullTimeEmployeeName");
            String nameOfEmployee = employeeName.nextLine();  // Read user input
            System.out.println("Username is: " + nameOfEmployee);


            Scanner empId = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the fullTimeEmployee Id");
            String idOfEmployee = empId.nextLine();  // Read user input
            System.out.println("ID is: " + idOfEmployee);

             empp = new FullTimeEmployee(Integer.valueOf(idOfEmployee), nameOfEmployee);
            System.out.println(empp);
        }
            try (Connection connection = dbConnection.getConnection()) {
            //  String createQuery="CREATE TABLE employee (id INT NOT NULL, name VARCHAR(50) NOT NULL)";
                Statement statement=connection.createStatement();
            //  statement.execute(createQuery);
                String query="INSERT INTO employee (id, name,typeOfEmployee,salary,address)"
                        + "values('" + empp.getId() + "','" + empp.getName()+ "','"+empp.getTypeOfEmployee()+ "','"+empp.calculateSalary()+ "','"+json
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