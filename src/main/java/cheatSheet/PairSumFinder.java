package cheatSheet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PairSumFinder {

    public static void main(String[] args) {
        System.out.println("Start");

        List<Integer> numberList = List.of(2, 4, 5, 1, 8, 3, 6);

        Set<Integer> seen = new HashSet<>();

        int sumNumber=9;
        List<int[]> collect = numberList.stream().filter(num ->
        {
            boolean hasPair = seen.contains(9 - num);
            seen.add(num);
            return hasPair;
        }) // THis FILTER WILL GIVE  5 8 6
           // SET contains   2, 4, 5, 1, 8, 3, 6
        .map (num -> new int[]{num, 9 - num}).collect(Collectors.toList());


    }
}

