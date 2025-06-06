package cheatSheet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeesNamesWithCommaSeperatedKeyasDeptName {
    public static void main(String[] args) {

        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        Map<String, List<String>> collect = employees.stream().collect(Collectors.groupingBy(
                Employee::getDept,Collectors.mapping(Employee::getName,Collectors.toList())
        ));

        collect.forEach((k,v)-> System.out.println(k+":- "+v));
        System.out.println("------------------------------------");

        Map<String, String> employeesNameswithComma = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                Collectors.mapping(Employee::getName, Collectors.joining(","))));

        employeesNameswithComma.forEach((k,v)-> System.out.println(k+":- "+v));


    }
}

