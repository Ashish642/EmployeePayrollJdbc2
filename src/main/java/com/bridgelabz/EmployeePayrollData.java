package com.bridgelabz;
import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("EqualsBetweenInconvertibleTypes")
public class EmployeePayrollData {
    public int id;
    public String name;
    public double salary;
    public LocalDate start;


    public EmployeePayrollData(int id, String name,double salary, LocalDate start) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.start = start;

    }
    @Override
    public String toString() {
        return "EmployeePayData{" + "id=" +id + ", name='" + name + '\'' +", salary=" + salary + ", start=" +start+ '}';

    }
    @Override
    public boolean equals(Objects o) {
        if(this == o)
            return true;
        if(o==null|| getClass() !=o.getClass())
            return false;
        EmployeePayrollData that  = (EmployeePayrollData) o;
        return id == that.id&& Double.compare(that.salary, salary) ==o && Objects.equals(name, that.name
        && Objects.equals(start,that.start));
    }
}
