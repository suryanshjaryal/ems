package org.ems;

public class FullTimeEmployee extends Employee{
    public FullTimeEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    public Double calculateSalary() {
return 0.0;
    }
}
