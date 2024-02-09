package org.ems;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(int id, String name) {
        super(id, name);


    }

    public PartTimeEmployee(int id, String name, String typeOfEmployee, Double salary, Address address) {
        super(id, name, typeOfEmployee, salary, address);
    }

    @Override
    public void calculateSalary() {

    }
}
