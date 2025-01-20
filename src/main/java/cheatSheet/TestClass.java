package cheatSheet;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TestClass {



    public static void main(String[] args) {



        List<Product> prodList = new ArrayList<Product>();

        prodList.add(new Product(1, "tarun", 1.1f));
        prodList.add(new Product(3, "Varun", 3.1f));
        prodList.add(new Product(2, "Arun", 2.1f));
        prodList.add(new Product(4, "ABC", 4.1f));
        prodList.add(new Product(5, "ABC", 4.1f));
        prodList.add(new Product(6, "ABC", 4.1f));
        prodList.add(new Product(6, "tarun", 4.1f));
        prodList.add(new Product(1, "Arun", 4.1f));


        List<Product> arunProduct = prodList.stream().filter(product -> (product.getName().equals("ABC") && product.getPrice() > 3)).
                collect(Collectors.toList());

        for (Product product : arunProduct) {
            System.out.println(product);
        }
        //Print out IDs in Asscending Order

        List<Product> asscendingOrder = prodList.stream().sorted(Comparator.comparing(Product::getId)).collect(Collectors.toList());
        System.out.println("Printing Products in Asccending Order ");
        asscendingOrder.forEach(System.out::println);

        //Print in Descending Order

        List<Product> desecendingProductList = prodList.stream().sorted(Collections.reverseOrder(Comparator.comparingInt(Product::getId))).
                collect(Collectors.toList());
        System.out.println("desecendingProductList:   ");
        desecendingProductList.forEach(System.out::println);


        System.out.println("Vowels and consonants Count ");

        String inputString="ilovejavatechie ";
        char[] charArray = inputString.toCharArray();

        Map<Character, Long> collect = IntStream.range(0, inputString.length() - 1).mapToObj(i -> charArray[i]).filter(c->!Character.isWhitespace(c)).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect.forEach((k,v)-> System.out.println(k+" "+v));

        System.out.println("Vowels and consonants Count ");

        String inputVowels="ilovejavatechie";

        String vowelString ="AEIOUaeiou";

        Map<String, Long> vowelMap = inputVowels.chars().mapToObj(c -> (char) c).
                collect(Collectors.groupingBy(c -> vowelString.indexOf(c) != -1 ? "Vowel" : "Consent", Collectors.counting()));

        vowelMap.forEach((k,v)-> System.out.println(k+" "+v));

        Set<String> vowelSet = Set.of("A", "E", "I", "O", "U", "a", "e", "i", "o", "u");

        String inputText="ilovejavatechiee 123%^&*";

         inputText.chars().mapToObj(c -> (char) c).filter(Character::isLetter).
                collect(Collectors.groupingBy(character -> vowelSet.contains(character) ? "Vowel " : "Consonent", Collectors.counting())).
                 forEach((k,v)->System.out.println(k+" "+v));


    }



}
