package org.ems;

public abstract class Employee {
    private int id;
    private String name;
    private String typeOfEmployee;

    protected Double hours;
    Address address;

    public Employee(int id, String name, String typeOfEmployee, Double hours, Address address) {
        this.id = id;
        this.name = name;
        this.typeOfEmployee = typeOfEmployee;
        this.hours = hours;
        this.address = address;
    }

    public abstract Double calculateSalary();
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public Double getHours() {
        return hours;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


