package org.ems;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(int id, String name) {
        super(id, name);


    }

    public PartTimeEmployee(int id, String name, String typeOfEmployee, Double hours, Address address) {
        super(id, name, typeOfEmployee, hours, address);
    }

    @Override
    public Double calculateSalary() {
return hours*100;
    }
}
