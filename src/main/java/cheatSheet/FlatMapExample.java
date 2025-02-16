package cheatSheet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        System.out.println("Started");
        List<String> listOfStrings = Arrays.asList("Hello Good Morning","Chandrasheker");

        System.out.println(listOfStrings.size());
        listOfStrings.forEach(s-> System.out.println(s));

        List<String> stringList = listOfStrings.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList());
        System.out.println(stringList);

        List<Stream<String>> streamList = listOfStrings.stream().map(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList());
       streamList.forEach(s -> System.out.println(s));
    }
}
