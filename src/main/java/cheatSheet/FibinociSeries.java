package cheatSheet;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibinociSeries {
    public static void main(String[] args) {

        List<Integer> fibbinociList = Stream.iterate(new int[]{0, 1},
                        arr -> new int[]{arr[1], arr[0] + arr[1]}).limit(10).
                map(arr -> arr[0]).collect(Collectors.toList());
        fibbinociList.forEach(i-> System.out.println(i));

    }
}
