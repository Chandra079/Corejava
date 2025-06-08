package cheatSheet;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println("Started...");

        String input = "I Love Jova Programming";

        String processed = input.replaceAll(" ", "").toLowerCase();

        LinkedHashMap<Character, Long> collect = processed.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(
                Function.identity(), LinkedHashMap::new, Collectors.counting()));

        collect.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey()).findFirst();

    }
}
