package cheatSheet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthWordFrequencies {
    static final String filePath = "F:/Practice/practice/corejava/core/Files";
    public static void main(String[] args) throws IOException {

        new NthWordFrequencies().findNthOccurance(2);
    }

    public List<String> findNthOccurance(int rank) throws IOException {
        Map<String, Long> wordMap  = new HashMap<>();
        //Get All the files
        List<Path> files = Files.walk(Paths.get(filePath)).
                filter(Files::isRegularFile).
                collect(Collectors.toList());

        files.forEach(file-> System.out.println(file));


        // Read All the Files

        for (Path file : files) {
            Files.lines(file).flatMap(line-> Arrays.stream(line.split("\\s+"))).
                    forEach(word-> wordMap.merge(word,1l,Long::sum));
        }


//  Group the Result By Freuesncy
        Map<Long, List<String>> collect = wordMap.entrySet().stream().
                collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        wordMap.forEach((k,v)->System.out.println(k+" "+v));

        collect.forEach((k,v)->System.out.println(k+" "+v));
        return null;

    }
}
