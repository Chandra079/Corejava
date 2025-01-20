package cheatSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMax3Numbers {
    public static void main(String[] args) {
        System.out.println("Started");

        int[] arr = new int[]{ 4,5,6,7,2,7,8,20};


        List<Integer> number = Arrays.asList(4,5,6,7,2,7,8,20);

        List<Integer> collect = number.stream().sorted((a,b)-> b-a).limit(3).collect(Collectors.toList());

        collect.forEach(i-> System.out.println(i));
    }
}
