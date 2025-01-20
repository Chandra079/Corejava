package dsa;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountPair {
    public static void main(String[] args) {
        System.out.println("Started");
        int k = 6;
        int[] arr = {1, 5, 7, -1, 5};
    new CountPair().countNumberOfPairsOldWay(arr,k);

    }

    public int countNumberOfPairsOldWay(int[] inputArray, int sum) {
        int noOfPairs = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i+1; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == sum) {

                    System.out.println(i +" and "+j );

                    System.out.println(inputArray[i] + inputArray[j]);
                    noOfPairs++;
                }
            }
        }
        System.out.println("No Of Pairs: "+noOfPairs);
        return noOfPairs;
    }
}
