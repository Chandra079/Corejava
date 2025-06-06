package cheatSheet;

import java.util.Arrays;

public class AnagramCheck {

    public static void main(String[] args) {


        System.out.println(new AnagramCheck().checkAnagram("ABC","CAB"));
    }
    public boolean checkAnagram(String s1, String s2){
        boolean isAnagram=false;


        char[] charArray = s1.toCharArray();
        //ABC ABC

        char[] charArray1 = s2.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray1);
        System.out.println(charArray);
        System.out.println(charArray1);

        System.out.println( Arrays.equals(charArray,charArray1));

        if(Arrays.toString(charArray1).equals(Arrays.toString(charArray))){
            isAnagram=true;
        }



        return  isAnagram;

    }
}
