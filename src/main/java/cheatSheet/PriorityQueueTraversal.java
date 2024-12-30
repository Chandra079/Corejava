package cheatSheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Node {
    char character; // Character for the leaf node
    int frequency;  // Frequency of the character
    Node left;      // Left child
    Node right;     // Right child
    Node(char character, Integer frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }



    // Constructor for an internal node
    Node(int frequency, Node left, Node right) {
        this.character = '\0'; // Internal nodes don't have a character
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}
public class PriorityQueueTraversal {

   public  static  Comparator<Node> comparator =(node1,node2)-> node1.frequency- node2.frequency;

    public static HashMap<Character,String> huffmenCodes= new HashMap<>();

    public static void main(String[] args) {
        String text = "AAABCBDABCD";

        char[] charArray = text.toCharArray();
        Map<Character, Integer> frequencyMap = IntStream.range(0, charArray.length - 1).
                filter(c -> !Character.isWhitespace(c)).mapToObj(i -> charArray[i]).
                collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c->1)));

        Node huffmanRootNode = PriorityQueueTraversal.buildHuffmanTree(frequencyMap);

        PriorityQueueTraversal.generateHuffmanCoding(huffmanRootNode,"",huffmenCodes);

        huffmenCodes.forEach((character,code)-> System.out.println(character+"   "+code));
       StringBuilder encodedString= encode(text,huffmenCodes);
         StringBuilder deCodedData=  decode(encodedString.toString(),huffmenCodes);
        System.out.println(deCodedData);

    }
    public static HashMap<Character,String> generateHuffmanCoding(Node rootNode,String code,HashMap<Character,String> huffmenCodes){

        if(rootNode==null){
            return null;
        }

        if(rootNode.left==null && rootNode.right==null){
            huffmenCodes.put(rootNode.character,code);
        }
        generateHuffmanCoding(rootNode.left,code+"0",huffmenCodes);
        generateHuffmanCoding(rootNode.right,code+"1",huffmenCodes);
        return huffmenCodes;
    }
    public static  Node buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparator);


    frequencyMap.forEach((key,value)->priorityQueue.add(new Node(key,value)));


    priorityQueue.forEach(node-> System.out.println(node.toString()));

   while(priorityQueue.size()>1){
        Node leftNode = priorityQueue.poll();
        Node rightNode = priorityQueue.poll();

       assert rightNode != null;
       Node newNode = new Node(leftNode.frequency+rightNode.frequency,leftNode,rightNode);
        priorityQueue.add(newNode);
    };
        System.out.println("After Adding new Nodes ");
        priorityQueue.forEach(node-> System.out.println(node.toString()));

        return priorityQueue.poll();
    }

    public static StringBuilder encode(String string, HashMap<Character,String> huffmenCodes){
        StringBuilder encodedString = new StringBuilder();

        IntStream.range(0,string.toCharArray().length-1).
                mapToObj(i->string.toCharArray()[i]).forEach(c->encodedString.append(huffmenCodes.get(c)));
        System.out.println(encodedString);
        return encodedString;
    }

    public static StringBuilder decode(String encodedString, HashMap<Character,String> huffmenCodes){

        StringBuilder decodedString = new StringBuilder();
        HashMap<String, Character> invertedCodes = new HashMap<>();

        huffmenCodes.forEach((key,value)->{
            System.out.println(" In  : "+key+" "+value);
            invertedCodes.put(value,key);
        });

        invertedCodes.forEach((key,value)-> {
                    System.out.println(" In Invert : " + key + " " + value);
                });

        StringBuilder decodeString = new StringBuilder();
        StringBuilder tempCode = new StringBuilder();
        char[] encodedStringCharArray = encodedString.toCharArray();
        IntStream.range(0,encodedStringCharArray.length-1).mapToObj(i->encodedStringCharArray[i]).forEach(bit->{
            tempCode.append(bit);
            if (invertedCodes.containsKey(tempCode.toString())){
                decodeString.append(invertedCodes.get(tempCode.toString() ));
                tempCode.setLength(0);
            }
        });

        return  decodeString;
    }



}
