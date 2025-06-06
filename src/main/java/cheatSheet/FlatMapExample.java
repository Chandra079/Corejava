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


        System.out.println("By Using Map ");
        List<String[]> collected = listOfStrings.stream().map(sentence -> sentence.split(" ")).collect(Collectors.toList());
        collected.forEach(s -> {
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);

            }
        } );

        List<List<Integer>> listOfList= Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(7,8,9));

        List<List<Integer>> collect = listOfList.stream().map(list -> list).collect(Collectors.toList());
        System.out.println("----------Map----------");
        collect.forEach(s -> {s.forEach(System.out::println);});

        List<Integer> collect1 = listOfList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());

        System.out.println("------------By sing flatMap-------------");

        collect1.forEach(System.out::println);
    }
}
