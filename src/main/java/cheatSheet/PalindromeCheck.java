package cheatSheet;

public class PalindromeCheck {
    public static void main(String[] args) {

        int[] input = new int[]{121,33,44,24,89,88,443};
        PalindromeCheck palindromeCheck = new PalindromeCheck();

        for (int i = 0; i < input.length ;i++) {
            System.out.println(input[i]+" is Palindrome By Using StringBuilder:  "+ palindromeCheck.isPalindromeByArithmaticOpertatos(input[i]));
            //System.out.println(input[i]+" is Palindrome By Using StringBuilder:  "+ palindromeCheck.isPalindrome(input[i]));
        }

    }
    public boolean isPalindrome(int input){
        boolean isPalindrome=false;
        String originalString = String.valueOf(input);
        String reverseString =new StringBuilder(originalString).reverse().toString();
        return (originalString.equals(reverseString));
    }

    public boolean isPalindromeByArithmaticOpertatos(int input){
        boolean isPalindrome=false;

        int originalNumber = input;
        int reversedNumber = 0;

        while (input > 0) {
            int digit = input % 10; // Extract the last digit
            reversedNumber = reversedNumber * 10 + digit; // Build the reversed number
            input /= 10; // Remove the last digit
        }

        return originalNumber == reversedNumber;
    }

}
