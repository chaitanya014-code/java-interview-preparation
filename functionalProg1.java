import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.function.*;

// The main method must be in a class named "Main".
class Employee {
    int id;
    String name;
    String department;
    int salary;

    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
     @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
    new Employee(1, "John", "IT", 70000),
    new Employee(2, "Ravi", "HR", 50000),
    new Employee(3, "David", "IT", 90000),
    new Employee(4, "Smith", "Finance", 60000),
    new Employee(5, "Kiran", "IT", 80000)
);

        Predicate<Employee> itEmp = e -> "IT".equals(e.department);
Predicate<Employee> salary = e -> e.salary > 75000;
Predicate<Employee> itEmpSalary =itEmp.and(salary);

        Function<Employee, String> getName = e -> e.name;
Function<String, String> uppercase = String::toUpperCase;
Function<Employee, String> empName =getName.andThen(uppercase);

List<String> result = employees.stream()
    .filter(itEmpSalary)
    .map(empName)
    .toList();

        System.out.println(result);

List<List<String>> names = Arrays.asList(
    Arrays.asList("John", "David"),
    Arrays.asList("Ravi", "Kiran"),
    Arrays.asList("Smith")
);

        List<String> result1 = names.stream()
    .flatMap(list -> list.stream())
    .toList();

System.out.println(result1);
    }
}
