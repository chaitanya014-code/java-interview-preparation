import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

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

        List<Employee> itEmp = employees.stream()
            .filter(n -> "IT".equals(n.department))
            .toList();
        
List<Employee> salaryGreater = employees.stream()
    .filter(n -> "IT".equals(n.department))
            .filter(n -> (n.salary)>75000)
            .toList();

        
        List<String> empNames = employees.stream()
            .map(n -> n.name)
            .toList();

        Optional<Employee> highestSalary= employees.stream()
            .max(Comparator.comparing(n ->n.salary));

        Map<String, List<Employee>> employeesByDept = employees.stream()
           .collect(Collectors.groupingBy(emp -> emp.department));

        
        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });

        Map<String, Double> avgSalaryByDept =
        employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingInt(e -> e.salary)
                ));

        Map<String, String> highestSalaryByDept = employees.stream()
    .collect(Collectors.groupingBy(
        emp -> emp.department,
        Collectors.collectingAndThen(
            Collectors.maxBy(Comparator.comparingInt(emp -> emp.salary)),
            opt -> opt.map(emp -> emp.name).orElse("N/A")
        )
    ));

        List<String> sortedNames = employees.stream()
    .sorted(Comparator.comparingInt((Employee emp) -> emp.salary).reversed())
        .map(emp -> emp.name)
    .collect(Collectors.toList());

        
Optional<Integer> secondHighestSalary = employees.stream()
    .map(emp -> emp.salary)
    .distinct()
    .sorted(Comparator.reverseOrder())
    .skip(1)
    .findFirst();

        // Step 1: Calculate the average salary
double avgSalary = employees.stream()
    .mapToInt(emp -> emp.salary)
    .average()
    .orElse(0.0);

// Step 2: Filter employees above average and extract their names
List<String> aboveAverageEmpNames = employees.stream()
    .filter(emp -> emp.salary > avgSalary)
    .map(emp -> emp.name)
    .collect(Collectors.toList());

System.out.println("Average Salary: " + avgSalary);
System.out.println("Employees earning above average: " + aboveAverageEmpNames);



        System.out.println(secondHighestSalary);

        System.out.println(sortedNames);

        System.out.println(highestSalaryByDept);
        

        System.out.println(itEmp);
        System.out.println(empNames);
        System.out.println(salaryGreater);
        System.out.println(highestSalary);
        System.out.println(avgSalaryByDept);
    }
}
