import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.function.*;

// The main method must be in a class named "Main".
class Employee {
    String name;
    List<String> skills;

    Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }
    @Override
    public String toString() {
        return "Employee{name='" + name + "',  skills=" + skills + "}";
    
    }
}

class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
    new Employee("John", Arrays.asList("Java", "Spring")),
    new Employee("David", Arrays.asList("Java", "Kafka")),
    new Employee("Kiran", Arrays.asList("Docker", "Azure")));


        List<String> skills = employees.stream()
    .flatMap(e -> e.skills.stream())
    .distinct()
    .toList();

    System.out.println(skills);

        Employee topEmployee = employees.stream()
    .max(Comparator.comparingInt(e -> e.skills.size()))
    .orElse(null);

        System.out.println(topEmployee);
    }
}
