package cheatSheet;

import java.util.List;

public class Java8MethodCheatSheet {
    public static void main(String[] args) {
        System.out.println("Started ");

        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        employees.forEach(employee -> System.out.println(employee.getName()+"    "+employee.getSalary()));


    }
}
