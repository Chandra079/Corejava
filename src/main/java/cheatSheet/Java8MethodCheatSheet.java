package cheatSheet;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Java8MethodCheatSheet {
    public static void main(String[] args) {
        System.out.println("Started ");

        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        employees.forEach(employee -> System.out.println(employee.getName()+"    "+employee.getSalary()));
//AscendingOrder Salary
        List<Employee> ascendigSalariedEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());


        //DescendingOrder
        ascendigSalariedEmployee.forEach(System.out::println);
        List<Employee> discendingSalry = employees.stream().sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary))).
                collect(Collectors.toList());

        discendingSalry.forEach(System.out::println);

        //Max Salary:

        Optional<Employee> maxPaidEmployee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println( " Max Salry: "+maxPaidEmployee);

        System.out.println(employees.stream().max(Comparator.comparing(Employee::getSalary)).get().toString());

        //GGrouping By

        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

        System.out.println("--------------Count of EMployesss");
        collect.forEach((key,value)-> System.out.println(key+" "+ value));

        Map<String, List<String>> collectNames = employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName,Collectors.toList())));

        collectNames.forEach((key,value)-> System.out.println(key+" "+ value));


        //Limit i want to see Highest top 3 paid Employess Details
        System.out.println("Top  3 Paid Employess:");
        AtomicInteger rank = new AtomicInteger(1);
        discendingSalry.stream().limit(3).forEach(c-> System.out.println(" Top "+rank.getAndIncrement()+" Paid Emmploye:"+c.getName()+" "+c.getSalary() ));



    }
}
