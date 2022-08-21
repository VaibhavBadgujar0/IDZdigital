package com.example.idzdigital;

public class EmployeeDetailsClass {

    String name;
    String age;
    String salary;

    public EmployeeDetailsClass(String name, String age, String salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public EmployeeDetailsClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
