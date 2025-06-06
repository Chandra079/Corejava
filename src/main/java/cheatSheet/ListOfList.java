package cheatSheet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfList {
    public static void main(String[] args) {
        System.out.println("List of List Started");

        List<Employee> employeeList = EmployeeDataBase.getAllEmployees();


        // List oF List And match with Inner List Objects Variables Names
        List<Employee> gammaProjectEmployees = employeeList.stream().filter(employee -> employee.getProjects().stream().
                anyMatch(project -> project.getName().equalsIgnoreCase("Gamma"))).collect(Collectors.toList());


        System.out.println("List of List Ended");
        Map<String, String> collectMap = employeeList.stream().collect(
                Collectors.groupingBy(employee -> employee.getSalary() > 60000 ? "Above 50000" : "Below 50K",
                        Collectors.mapping(Employee::getName, Collectors.joining(","))));

        collectMap.forEach((s, employees) ->
                System.out.println(s + ": " + employees));


    }
}
