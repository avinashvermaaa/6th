java 3.1


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        String longestPalindrome = findLongestPalindrome(input);
        System.out.println("Longest palindrome: " + longestPalindrome);
    }

    public static String findLongestPalindrome(String input) {
        String palindrome = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = input.length() - 1; j > i; j--) {
                if (input.charAt(j) == c) {
                    String newPalindrome = c + findLongestPalindrome(input.substring(i + 1, j)) + c;
                    if (newPalindrome.length() > palindrome.length()) {
                        palindrome = newPalindrome;
                    }
                }
            }
        }
        if (palindrome.length() == 0 && input.length() > 0) {
            palindrome += input.charAt(0); // Handle the case where the only palindrome possible is a single character
        }
        return palindrome;
    }
}
